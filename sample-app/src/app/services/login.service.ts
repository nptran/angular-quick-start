import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, Injector } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from '../../environments/environment';
@Injectable()
export class LoginService {

    constructor(private _http: HttpClient) { }

    obtainAccessToken(loginData): Observable<Object> {
        const params = new URLSearchParams();
     
        params.append('username', loginData.value.username);
        params.append('password', loginData.value.password);
        params.append('grant_type', 'password');

        const headers = new HttpHeaders({ 'Content-type': 'application/x-www-form-urlencoded; charset=utf-8', 'Authorization': 'Basic ' + btoa('techmaster:techmaster_secret') });

        return this._http.post(
            'http://localhost:8080/oauth/token',
            params.toString(),
            {
                headers: headers
            }
        );
    }
}
