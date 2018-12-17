import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {

  constructor(private router: Router) {
  }

  canActivate() {
    if (localStorage.getItem('techmaster_token')) {
      // logged in so return true
      return true;
    }

    // not logged in so redirect to login page
    this.router.navigate(['/login']);
    return false;
  }

}
