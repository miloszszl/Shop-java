import { Component, OnInit, ChangeDetectorRef,  } from '@angular/core';

import { User } from '../_models/index';
import { UserService } from '../_services/index';
import { CartService } from '../cart.service';
import { ProductService } from '../_services/index';
import { Subscription } from 'rxjs/Subscription';

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
    
    constructor(private productService: ProductService, private cartService: CartService, private userService: UserService,  changeDetectorRef: ChangeDetectorRef) {
        
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
        this.order.userId = this.model.id;
        this.order.methodId = this.method.id;
        this.order.products = this.products;
        this.productService.placeOrder(this.order).subscribe();
        console.debug(this.order)
    }
}