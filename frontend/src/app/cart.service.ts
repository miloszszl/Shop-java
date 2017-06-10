import { Injectable } from '@angular/core';
import { Product } from './shared/product.model';
import { Subject } from 'rxjs/Subject';


@Injectable()
export class CartService {

  products: any[] = []
  cartTotal: number = 0
  method: any = null

  private productAddedSource = new Subject<any>()


  productAdded$ = this.productAddedSource.asObservable()

  constructor() { }

  addProductToCart(product){
    let exists = false
    let parsedPrice = product.price
    this.cartTotal += parsedPrice
    //Search this product on the cart and increment the quantity
    this.products = this.products.map(_product => {
      if(_product.product.id == product.id){
        _product.quantity++
        exists = true
      }
      return _product
    })
    //Add a new product to the cart if it's a new product
    if(!exists){
      product.parsedPrice = parsedPrice
      this.products.push({
        product:product,
        quantity:1,
        
      })
      
    }
    console.debug(this.products)
    this.productAddedSource.next({ products: this.products, cartTotal: this.cartTotal })
  }

  deleteProductFromCart(product){
    this.products = this.products.filter(_product => {
      if(_product.product.id == product.id){
        this.cartTotal -= _product.product.parsedPrice*_product.quantity
        return false
      }
      return true
     })
    this.productAddedSource.next({ products: this.products, cartTotal: this.cartTotal })
  }

  flushCart(){
    this.products = []
    this.cartTotal = 0
    this.productAddedSource.next({ products: this.products, cartTotal: this.cartTotal })
  }

  getProducts(){
    return this.products;
  }

  saveMethod(method){
    this.method = method;
    console.debug(method)
    console.debug(this.method)
  }

  getMethod(){
    console.debug(this.method)
    return this.method;
  }
}