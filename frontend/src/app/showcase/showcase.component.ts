import { Component, OnInit, Input } from '@angular/core';
import { Product } from '../shared/product.model'
import { CartService } from '../cart.service';
import { ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'showcase',
  templateUrl: './showcase.component.html',
  //styleUrls: ['./showcase.component.scss'],
  styles: [ require('./showcase.component.scss') ],
  //encapsulation: ViewEncapsulation.None
})
export class ShowcaseComponent implements OnInit {

  @Input() products: Product[]

  //detailViewActive: boolean

  constructor(private cartService: CartService) {

    
    
  }
  ngOnInit() {
    //this.detailViewActive = false
    console.debug("working")
    this.products.forEach(element => {
      element.active=false;
    });
  }

  onProductClick(product){
    product.active=!product.active
    //this.detailViewActive = !this.detailViewActive
  }

  onAddToCart(product){
    this.cartService.addProductToCart(product) // blad here
  }
}
