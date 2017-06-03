import { NgModule, CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }    from '@angular/forms';
import { HttpModule, JsonpModule } from '@angular/http';

// used to create fake backend
//import { fakeBackendProvider } from './_helpers/index';
import { MockBackend, MockConnection } from '@angular/http/testing';
import { BaseRequestOptions } from '@angular/http';

import { AppComponent }  from './app.component';
import { routing }        from './app.routing';

import { AlertComponent } from './_directives/index';
import { AuthGuard } from './_guards/index';
import { AlertService, AuthenticationService, UserService, ProductService } from './_services/index';
import { HomeComponent } from './home/index';
import { LoginComponent } from './login/index';
import { RegisterComponent } from './register/index';
import { FrontComponent } from './front/index';

//Merged
import { ShowcaseComponent } from './showcase/showcase.component';

import { DataService } from './data.service';
import { CartService } from './cart.service';

import { SearchBarComponent } from './search-bar/search-bar.component';
import { FiltersComponent } from './filters/filters.component';
import { CartComponent } from './cart/cart.component';


@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        JsonpModule,
        routing
    ],
    declarations: [
        AppComponent,
        AlertComponent,
        HomeComponent,
        LoginComponent,
        RegisterComponent,
        CartComponent,
        FrontComponent,
        //Merged
        ShowcaseComponent,
        SearchBarComponent,
        FiltersComponent
    ],
    schemas: [ CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA, ],
    providers: [
        AuthGuard,
        AlertService,
        AuthenticationService,
        UserService,
        ProductService,

        // providers used to create fake backend
        //fakeBackendProvider,
        MockBackend,
        BaseRequestOptions,
        //Merged
        DataService,
        CartService,
    ],
    bootstrap: [AppComponent]
})

export class AppModule { }