import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { Product } from '../_models/index';

@Injectable()
export class ProductService {
    constructor(private http: Http) { }

    getAll() {
        return this.http.get('/api/products/', this.jwt()).map((response: Response) => response.json());
    }

    getCategories() {
        return this.http.get('/api/products/categories/', this.jwt()).map((response: Response) => response.json());
    }

    private jwt() {
        // create authorization header with jwt token
        let currentUser = JSON.parse(localStorage.getItem('currentUser'));
        
        if (currentUser && currentUser.token) {
            let headers = new Headers({ 'Authorization': currentUser.token });
            return new RequestOptions({ headers: headers });
        }
    }
}