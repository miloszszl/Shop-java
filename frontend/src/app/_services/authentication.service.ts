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
                let token = response.headers.get("Authorization");
                var user = {
                    token : "",
                    username : "",
                    role : ""
                };

                let decodedToken = this.decodeToken(token)
                user.token = token;
                user.username = decodedToken.sub;
                user.role = decodedToken.role;
                console.debug("WAWAWAWWAW");
                console.debug(user);
                localStorage.setItem('currentUser', JSON.stringify(user));
                //console.debug(localStorage.getItem('currentUser'));
            });
    }

    logout() {
            // remove user from local storage to log user out
            localStorage.removeItem('currentUser');
        }

        decodeToken(token: string): any {
        let parts = token.split('.');

        if (parts.length !== 3) {
        throw new Error('JWT must have 3 parts');
        }

        let decoded = this.urlBase64Decode(parts[1]);
        if (!decoded) {
        throw new Error('Cannot decode the token');
        }

        return JSON.parse(decoded);
    }
    
    public urlBase64Decode(str: string): string {
        let output = str.replace(/-/g, '+').replace(/_/g, '/');
        switch (output.length % 4) {
        case 0: { break; }
        case 2: { output += '=='; break; }
        case 3: { output += '='; break; }
        default: {
            throw 'Illegal base64url string!';
        }
        }
        return this.b64DecodeUnicode(output);
    }

  private b64DecodeUnicode(str: any) {
    return decodeURIComponent(Array.prototype.map.call(this.b64decode(str), (c: any) => {
      return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));
  }

    private b64decode(str: string): string {
    let chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=';
    let output: string = '';

    str = String(str).replace(/=+$/, '');

    if (str.length % 4 == 1) {
      throw new Error("'atob' failed: The string to be decoded is not correctly encoded.");
    }

    for (
      // initialize result and counters
      let bc: number = 0, bs: any, buffer: any, idx: number = 0;
      // get next character
      buffer = str.charAt(idx++);
      // character found in table? initialize bit storage and add its ascii value;
      ~buffer && (bs = bc % 4 ? bs * 64 + buffer : buffer,
        // and if not first of each 4 characters,
        // convert the first 8 bits to one ascii character
        bc++ % 4) ? output += String.fromCharCode(255 & bs >> (-2 * bc & 6)) : 0
    ) {
      // try to find character in table (0-63, not found => -1)
      buffer = chars.indexOf(buffer);
    }
    return output;
}

}