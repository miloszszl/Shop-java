import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

import { AlertService } from '../_services/index';

@Injectable()
export class AuthGuard implements CanActivate {

    constructor(private router: Router, private alertService: AlertService) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        var user = JSON.parse(localStorage.getItem('currentUser'))
        
        if (user){
            if(route.data["role"]){
                if (route.data["role"] === user.role)
                    return true;
                else{
                    this.router.navigate(['/'], { queryParams: { returnUrl: state.url }});
                    this.alertService.error("Not enough rigths!", true);
                    return false;
                }
            }
            else {
                return true;
            }
        }

        this.router.navigate(['/'], { queryParams: { returnUrl: state.url }});
        this.alertService.error("Halt! You need to be logged in to go there", true);
        return false;
    }
}