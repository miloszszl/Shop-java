import { Component, OnInit, Input, ViewEncapsulation } from '@angular/core';
import { AfterViewInit, ViewChild } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FiltersComponent } from '../filters/filters.component';
import { SearchBarComponent } from '../search-bar/search-bar.component';

/////////////////
//import { Product } from '../_models/index';
import { Product } from '../shared/product.model';
//
//import { ProductService } from '../_services/index';
import { DataService } from '../data.service';
import { CartService } from '../cart.service';
import { ProductService } from '../_services/product.service'

require('!!style-loader!css-loader!sass-loader!./home.component.scss');  

@Component({
    moduleId: module.id.toString(),
    templateUrl: 'home.component.html',
    styles: [ require('./home.component.scss') ],
    //encapsulation: ViewEncapsulation.None 
})

export class HomeComponent{
    //currentUser: User;
    products: Product[]

    mainFilter: any

    categories: any

  currentSorting: string

    @ViewChild('filtersComponent')
  filtersComponent: FiltersComponent;

  @ViewChild('searchComponent')
  searchComponent: SearchBarComponent;

    sortFilters: any[] = [
    { name:'Name (A to Z)', value:'name' },
    { name:'Price (low to high)', value:'priceAsc' },
    { name:'Price (high to low)', value:'priceDes' }
  ]

  customFilters: any[] = [
    { name:'All', value:'all', checked:true },
    { name:'Available', value:'available', checked:false },
    { name:'Not Available', value:'unavailable', checked:false },
    { name:'Bestseller', value:'bestseller', checked:false }
  ]

  priceFilters: any[] = [
    { name:'All', value:'all', checked:true },
    { name:'Price > 30.000', value:'more_30000', checked:false },
    { name:'Price < 10.000', value:'less_10000', checked:false }
  ]

  originalData: any = []
  originalProductsData: any = []

    constructor(private dataService: DataService, private productService: ProductService, private cartService: CartService) {
        //this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
        
    }

      ngOnInit(){
        this.productService.getAll().subscribe(products => {
          this.originalProductsData = products
          this.products = products;
          this.sortProducts('name')
        })

        this.productService.getCategories().subscribe(categories => {
          this.categories = categories
          this.mainFilter = {
            search: '',
            categories: categories,
            customFilter: this.customFilters[0],
            priceFilter: this.priceFilters[0]
          }
        })
  }

  onURLChange(url){

    this.dataService.getRemoteData(url).subscribe(data => {
      this.originalData = data
      this.mainFilter = {
        search: '',
        categories: this.originalData.categories.slice(0),
        customFilter: this.customFilters[0],
        priceFilter: this.priceFilters[0]
      }

      //Make a deep copy of the original data to keep it immutable
      this.products = this.originalData.products.slice(0)
      this.sortProducts('name')
      this.filtersComponent.reset(this.customFilters, this.priceFilters)
      this.searchComponent.reset()
      this.cartService.flushCart()
    })
  }



  onSearchChange(search){
    this.mainFilter.search = search.search
    this.updateProducts({
      type:'search',
      change:search.change
    })
  }

  onFilterChange(data){
    if(data.type == 'category'){
      if(data.isChecked){
        this.mainFilter.categories.push(data.filter)
      }else{
        this.mainFilter.categories = this.mainFilter.categories.filter(category => { return category.id != data.filter.id })
      }
    }else if(data.type == 'custom'){
      this.mainFilter.customFilter = data.filter
    }else if(data.type == 'price'){
      this.mainFilter.priceFilter = data.filter
    }
    this.updateProducts({
      type:data.type,
      change: data.change
    })
  }

  updateProducts(filter){
    let productsSource = this.originalProductsData
    let prevProducts = this.products
    let filterAllData = true
    if((filter.type=='search' && filter.change == 1) || (filter.type=='category' && filter.change == -1)){
      productsSource = this.products
      filterAllData = false
    }
    //console.log('filtering ' + productsSource.length + ' products')

    this.products = productsSource.filter(product => {
      //Filter by search
      if(filterAllData || filter.type=='search'){
        if (!product.name.match(new RegExp(this.mainFilter.search, 'i'))){
          return false;
        }
      }

      //Filter by categories
      if(filterAllData || filter.type=='category'){
        let passCategoryFilter = false
        let product_category = product.categories.id
        
          if(!passCategoryFilter){
            passCategoryFilter = this.mainFilter.categories.reduce((found, category) => {
                return found || product_category == category.id
            }, false)
          }
        
        if(!passCategoryFilter){
          return false
        }
      }

      //Filter by custom filters
      if(filterAllData || filter.type=='custom'){
        let passCustomFilter = false
        let customFilter = this.mainFilter.customFilter.value
        if(customFilter == 'all'){
          passCustomFilter = true;
        }else if(customFilter == 'available' && product.amount > 0){
          passCustomFilter = true;
        }else if(customFilter == 'unavailable' && !(product.amount > 0)){
          passCustomFilter = true;
        }else if(customFilter == 'bestseller' && product.best_seller){
          passCustomFilter = true;
        }
        if(!passCustomFilter){
          return false
        }
      }

      //Filter by price filters
      if(filterAllData || filter.type=='price'){
        let passPriceFilter = false
        let customFilter = this.mainFilter.priceFilter.value
        let productPrice = product.price
        if(customFilter == 'all'){
          passPriceFilter = true;
        }else if(customFilter == 'more_30000' && productPrice > 30000){
          passPriceFilter = true;
        }else if(customFilter == 'less_10000' && productPrice < 10000){
          passPriceFilter = true;
        }
        if(!passPriceFilter){
          return false
        }
      }

      return true
    })

    //If the number of products increased after the filter has been applied then sort again
    //If the number of products remained equal, there's a high chance that the items have been reordered.
    if(prevProducts.length <= this.products.length && this.products.length>1){
      this.sortProducts(this.currentSorting)
    }

    //These two types of filters usually add new data to the products showcase so a sort is necessary
    if(filter.type == 'custom' || filter.type == 'price'){
      this.sortProducts(this.currentSorting)
    }
  }

  sortProducts(criteria){
    //console.log('sorting ' + this.products.length + ' products')
    this.products.sort((a,b) => {
      let priceComparison = parseFloat(a.price) - parseFloat(b.price)
      if(criteria == 'priceDes'){
        return -priceComparison
      }else if(criteria == 'priceAsc'){
        return  priceComparison
      }else if(criteria == 'name'){
        let nameA=a.name.toLowerCase(), nameB=b.name.toLowerCase()
        if (nameA < nameB)
          return -1;
        if (nameA > nameB)
          return 1;
        return 0;
      }else{
        //Keep the same order in case of any unexpected sort criteria
        return -1
      }
    })
    this.currentSorting = criteria
  }
}