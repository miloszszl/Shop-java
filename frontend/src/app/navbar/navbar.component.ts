import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { AlertService, AuthenticationService } from '../_services/index';

@Component({
    selector: 'navbar',
    moduleId: module.id.toString(),
    templateUrl: 'navbar.component.html',
    styles: [ require('../shared/bootstrap.css'), require('./navbar.component.css') ],
})

export class NavbarComponent{

    model: any = {};
    loading = false;
    loggedin:boolean = false;
    returnUrl: string;
    user: {token: string, username: string}


    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService,
        private alertService: AlertService) { }


    ngOnInit() {
        // reset login status
        //this.authenticationService.logout();
        if(this.user = JSON.parse(localStorage.getItem('currentUser'))){
            console.debug("juz bylem zalogowany")
            this.loggedin = true;
        }

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
        
    }

    login() {
        this.loading = true;
        localStorage.removeItem('currentUser');
        this.authenticationService.login(this.model.username, this.model.password)
            .subscribe(
                data => {
                    this.router.navigate([this.returnUrl]);
                    console.debug("zalogowano!")
                    this.loggedin = true;
                    this.loading = false;
                    this.user = JSON.parse(localStorage.getItem('currentUser'));
                    this.router.navigate([this.returnUrl]);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                    this.loggedin = false;
                });
    }

    logout() {
        this.authenticationService.logout();
        this.loggedin = false;
        this.router.navigate([this.returnUrl]);
        console.debug("wylogowano!")
    }
}