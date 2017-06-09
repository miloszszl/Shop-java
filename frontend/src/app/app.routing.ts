import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/index';
import { LoginComponent } from './login/index';
import { RegisterComponent } from './register/index';
import { FrontComponent } from './front/index';
import { PaymentComponent } from './payment/index';
import { ProductManagerComponent } from './product-manager/index'
import { AuthGuard } from './_guards/index';

// canActivate: [AuthGuard]

const appRoutes: Routes = [
    { path: '', component: HomeComponent, },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'storeFront', component: FrontComponent },
    { path: 'payment', component: PaymentComponent },
    { path: 'products', component: ProductManagerComponent, canActivate: [AuthGuard] },

    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);