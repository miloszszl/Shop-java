import { Component, OnInit, ChangeDetectorRef } from '@angular/core';

import { User } from '../_models/index';
import { UserService } from '../_services/index';
import { CartService } from '../cart.service';
import { Subscription } from 'rxjs/Subscription';

@Component({
    moduleId: module.id.toString(),
    templateUrl: 'order-history.component.html',
    styles: [ require('../shared/bootstrap.css'), require('./order-history.component.css') ],
})

export class OrderHistoryComponent implements OnInit {
    
    currentUser: User;
    users: User[] = [];
    products: any;
    cartTotal: number;
    deliveryMethods: {id: number, name: string, price: number} [] = 
    [
        {
            "id": 1,
            "name": "UPS Kurier",
            "price": 13
        },
        {
            "id": 2,
            "name": "Poczta polska",
            "price": 7
        },
        {
            "id": 3,
            "name": "Odbiór osobisty",
            "price": 0
        }
    ];

    selectedDeliveryMethod: any;

    changeDetectorRef: ChangeDetectorRef

    constructor(private cartService: CartService, private userService: UserService,  changeDetectorRef: ChangeDetectorRef) {
        this.changeDetectorRef = changeDetectorRef
    }

    ngOnInit() {
        this.products = this.cartService.getProducts();
        this.changeDetectorRef.detectChanges()
        
  }


}