import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { Product } from '../_models/index';
import { ProductService } from '../_services/index';

@Component({
    moduleId: module.id.toString(),
    templateUrl: 'front.component.html'
})

export class FrontComponent{
    //currentUser: User;
    products: Product[] = [];

    constructor(private productService: ProductService) {
        //this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    }

    ngOnInit() {
        this.loadAllProducts();
    }

    private loadAllProducts() {
        console.debug("WOWOWW");
        this.productService.getAll().subscribe(products => { this.products = products; });
    }
}
