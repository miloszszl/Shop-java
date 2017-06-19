import { Component, OnInit, ChangeDetectorRef,  } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { User } from '../_models/index';
import { UserService } from '../_services/index';
import { CartService } from '../cart.service';
import { ProductService } from '../_services/index';
import { Subscription } from 'rxjs/Subscription';
import { AlertService } from '../_services/index';

@Component({
    moduleId: module.id.toString(),
    templateUrl: 'billing.component.html',
    styles: [ require('../shared/bootstrap.css'), require('./billing.component.css') ],
})

export class BillingComponent implements OnInit {

    submitted = false;
    products:any;
    method:any;
    whatTime:any;
    user:any;
    model: User
    order: any = {};
    returnUrl: String;
    msg:any;
    
    constructor(private productService: ProductService, private cartService: CartService, private userService: UserService,  changeDetectorRef: ChangeDetectorRef,
        private route: ActivatedRoute,
        private router: Router,
        private alertService: AlertService   
    ) {
        
    }

    ngOnInit() {
        this.products = this.cartService.getProducts();
        this.method = this.cartService.getMethod();
        this.user = JSON.parse(localStorage.getItem("currentUser"));
        console.debug(this.user);
        this.userService.getByLogin(this.user.username).subscribe(user => {

            this.model = user;
            this.model.country = "Poland"
        });
        this.returnUrl = '/'; //this.route.snapshot.queryParams['returnUrl'] || '/';
    }

    getTotalPrice() {
        let sum = 0;
        this.products.forEach(element => {
            sum += element.product.price * element.quantity
        });
        return sum;
    }

    onSubmit() { 
        this.submitted = true; 
        console.debug(this.model)
    }

    makeOrder() {
        console.debug("make order")
        console.debug(this.model)
        console.debug(this.model.idUser)
        this.order.userId = this.model.idUser;
        this.order.methodId = this.method.id;
        this.order.products = this.products;
        this.productService.placeOrder(this.order).subscribe(
            data => {
                console.debug("A")
                this.alertService.success('Przyjęto zamówienie', true);
                this.router.navigate([this.returnUrl]);
            },
            error => {
                console.debug("B")
                this.alertService.error(error, true);
                this.router.navigate([this.returnUrl]);
            });
        console.debug(this.order)
    }
}