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
        //this.model = product;
        console.debug(this.model);
        this.model.id = product.id;
        this.model.name = product.name
        this.model.description = product.description
        this.model.quantity = product.amount
        this.model.category = product.category.categoryName
        this.model.brand = product.brand.brandName
        this.model.price = product.price
        console.debug(this.model);
        //product // Object { id: 4, name: "asd", description: "asdasd", amount: 123, photo: "eb6845e4-402c-40bf-93db-8efc70de3366", category: Object, brand: Object, price: 123, totalRate: 0, comments: Array[0] }
    }

    onSubmit(){
        this.productsService.updateProduct(this.model).subscribe(
            data => {
                console.debug("A")
                this.alertService.success('Zaktualizowano produkt', true);
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