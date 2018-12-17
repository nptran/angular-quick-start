import { Injectable, Injector } from "@angular/core";
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpErrorResponse, HttpHeaders, HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { catchError, mergeMap } from "rxjs/operators";
import { Router } from "@angular/router";


@Injectable()
export class HttpListener implements HttpInterceptor {

    constructor(
        private injector: Injector,
        private router: Router
    ) {

    }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        if(localStorage.getItem('techmaster_token') && this.isIncludeToken(req)) {
            return next.handle(this.modifyRequest(req)).pipe(
                catchError(error => {
                    if (error instanceof HttpErrorResponse) {
                        switch (error.status) {
                        
                            case 401: 
                            const reqHeader = new HttpHeaders({ 'Content-type': 'application/x-www-form-urlencoded; charset=utf-8', 'Authorization': 'Basic ' + btoa('techmaster:techmaster_secret') });
                            const params = new URLSearchParams();
                            params.append('refresh_token', localStorage.getItem('techmaster_refresh'));
                            params.append('grant_type', 'refresh_token');
                            return this.injector.get(HttpClient).post(
                                'http://localhost:8080/oauth/token', params.toString(), {
                                    headers: reqHeader
                                }
                            ).pipe(
                                mergeMap(res => {
                                    console.log(res);
                                    // TODO: lưu AT và RT vào localStorage
                                    localStorage.setItem('techmaster_token', res['access_token']);
                                    localStorage.setItem('techmaster_refresh', res['refresh_token'])

                                    return next.handle(this.modifyRequest(req));
                                }),
                                catchError(err => {
                                    this.router.navigate(['/login']);
                                    return Observable.throw(err);
                                })
                            )    
                        }
                    } else {
                        return Observable.throw(error);
                    }
                })
            );
        } else {
            return next.handle(req);
        }  
    }

    private modifyRequest(req) {
        const token = 'Bearer ' + localStorage.getItem('techmaster_token')
        return req.clone({ setHeaders: { 'Authorization': token } });
    }

    // private isIncludeToken(url: string) {
    //     return url.indexOf('/token') < 0;
    // }

    private isIncludeToken(req: HttpRequest<any>) {
        return req.url.indexOf('token') < 0 || (req.url.indexOf('/v1/students') <0 && req.method === 'POST');
    }

}