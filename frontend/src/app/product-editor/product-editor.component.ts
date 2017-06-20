import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { User, Product } from '../_models/index';
import { UserService, ProductService } from '../_services/index';
import { CartService } from '../cart.service';
import { Subscription } from 'rxjs/Subscription';
import { AlertService } from '../_services/index';

@Component({
    moduleId: module.id.toString(),
    templateUrl: 'product-editor.component.html',
    styles: [ require('../shared/bootstrap.css'), require('./product-editor.component.css') ],
})

export class ProductEditorComponent implements OnInit {
    model:any = {};
    categories:any;
    editing:boolean = false;
    currentlyEditedProduct:any;
    products:any;


    constructor(private productsService: ProductService, private cartService: CartService, private userService: UserService,  changeDetectorRef: ChangeDetectorRef,
        private route: ActivatedRoute,
        private router: Router,
        private alertService: AlertService   ) {

    }

    ngOnInit() {
        this.productsService.getCategories().subscribe(categories => {
          this.categories = categories
        })

        this.productsService.getAll().subscribe(products => {
          this.products = products
          console.debug("PUF")
          console.debug(this.products);
        })
        
    }

    edit(product){
        this.editing = true;
        this.model = product;
    }

    onSubmit(){
        this.productsService.addProduct(this.model).subscribe(
            data => {
                console.debug("A")
                this.alertService.success('Dodano produkt', true);
                this.router.navigate(['/product-editor']);
            },
            error => {
                console.debug("B")
                this.alertService.error(error, false);
                //this.router.navigate(['/']);
            });
        console.debug("ONSUBMIT")
        console.debug(this.model)
    }

}