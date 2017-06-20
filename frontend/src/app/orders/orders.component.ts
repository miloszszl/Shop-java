import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { User } from '../_models/index';
import { UserService, ProductService } from '../_services/index';
import { CartService } from '../cart.service';
import { Subscription } from 'rxjs/Subscription';

@Component({
    moduleId: module.id.toString(),
    templateUrl: 'orders.component.html',
    styles: [ require('../shared/bootstrap.css'), require('./orders.component.css') ],
})

export class OrdersComponent implements OnInit {

    orders:any;
    detailsView: boolean = false;
    currentOrder: any = null;
    currentProducts: any = null;
    
    constructor(private cartService: CartService, private productService: ProductService,         private route: ActivatedRoute,
        private router: Router,) {
    }

    ngOnInit() {
        this.orders = this.productService.getAllOrders().subscribe(orders => {
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

    changeStatus(){
        console.debug("ZMIANA STATUSU");
        console.debug(this.currentOrder)
        this.productService.switchStatus(this.currentOrder.idOrder).subscribe( data => {
            this.orders = this.productService.getAllOrders().subscribe(orders => {
            this.orders = orders;
            this.router.navigate(['/orders']);
            console.debug("MAKIN BAKIN");
        })
            }
        );
    }
}