import { Component, OnInit, ChangeDetectorRef } from '@angular/core';

import { User } from '../_models/index';
import { UserService } from '../_services/index';
import { CartService } from '../cart.service';
import { Subscription } from 'rxjs/Subscription';

@Component({
    moduleId: module.id.toString(),
    templateUrl: 'payment.component.html',
    styles: [ require('../shared/bootstrap.css'), require('./payment.component.css') ],
})

export class PaymentComponent implements OnInit {
    
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
    ];

    selectedDeliveryMethod: any;
    
    model:any = this.deliveryMethods[0]

    changeDetectorRef: ChangeDetectorRef

    constructor(private cartService: CartService, private userService: UserService,  changeDetectorRef: ChangeDetectorRef) {
        this.changeDetectorRef = changeDetectorRef
    }

    ngOnInit() {
        this.products = this.cartService.getProducts();
        this.changeDetectorRef.detectChanges()
        
  }

  getTotalPrice() {
      let sum = 0;
      this.products.forEach(element => {
          sum += element.product.price * element.quantity
      });
      //sum + this.selectedDeliveryMethod.price
        return sum;
  }

  deleteProduct(product){
    this.cartService.deleteProductFromCart(product)
  }

  saveMethod(method){
      this.cartService.saveMethod(method)
      console.debug("ZAPISUJE METODE");
  }

}