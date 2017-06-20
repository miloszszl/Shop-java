import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { User } from '../_models/index';
import { UserService, ProductService } from '../_services/index';
import { CartService } from '../cart.service';
import { Subscription } from 'rxjs/Subscription';

@Component({
    moduleId: module.id.toString(),
    templateUrl: 'order-history.component.html',
    styles: [ require('../shared/bootstrap.css'), require('./order-history.component.css') ],
})

export class OrderHistoryComponent implements OnInit {

    orders:any;
    detailsView: boolean = false;
    currentOrder: any = null;
    currentProducts: any = null;
    
    constructor(private cartService: CartService, private productService: ProductService, private route: ActivatedRoute,
        private router: Router, private userService: UserService) {
    }

    ngOnInit() {
        let currentUser = JSON.parse(localStorage.getItem('currentUser'));
        let username = currentUser.username;
        console.debug("asdasdasdadasdad")
        console.debug(username)
        this.orders = this.productService.getAllUserOrders(username).subscribe(orders => {
          this.orders = orders
          console.debug(orders);
        })

    }

    showDetails(order){
        console.debug(order);
        this.currentOrder = order;
        this.currentProducts = this.currentOrder.productOrder
        this.detailsView = true;
    }

    showList(){
        this.detailsView = false;
    }

    getTotalPrice(){
        let sum= 0;
        this.currentProducts.forEach(element => {
            sum += element.actualPrice;
        });
        return sum;
    }
}