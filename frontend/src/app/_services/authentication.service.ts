import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'

@Injectable()
export class AuthenticationService {
    constructor(private http: Http) { }

    login(username: string, password: string) {
        return this.http.post('/api/authenticate', JSON.stringify({ username: username, password: password }))
            .map((response: Response) => {
                console.debug("awdawda");
                let token = response.headers.get("Authorization");
                var user = {
                    token : "",
                    username : ""
                };

                user.token = token;
                user.username = username;
                console.debug(user);
                localStorage.setItem('currentUser', JSON.stringify(user));
                console.debug(localStorage.getItem('currentUser'));
            });
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }
}