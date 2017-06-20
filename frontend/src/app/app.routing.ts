import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/index';
import { LoginComponent } from './login/index';
import { RegisterComponent } from './register/index';
import { FrontComponent } from './front/index';
import { PaymentComponent } from './payment/index';
import { ProductManagerComponent } from './product-manager/index'
import { ProductEditorComponent } from './product-editor/index'
import { OrderHistoryComponent } from './order-history/index'
import { AccountComponent } from './account/index'
import { OrdersComponent } from './orders/index'
import { BillingComponent } from './billing/index'
import { AuthGuard } from './_guards/index';

// canActivate: [AuthGuard]

const appRoutes: Routes = [
    { path: '', component: HomeComponent, },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'storeFront', component: FrontComponent },
    { path: 'payment', component: PaymentComponent, canActivate: [AuthGuard], data: { role: "ROLE_USER" }},
    { path: 'billing', component: BillingComponent, },  
    { path: 'add-product', component: ProductManagerComponent, canActivate: [AuthGuard], data: { role: "ROLE_ADMIN" } },
    { path: 'edit-product', component: ProductEditorComponent, canActivate: [AuthGuard], data: { role: "ROLE_ADMIN" } },
    //{ path: 'history', component: OrderHistoryComponent, canActivate: [AuthGuard], data: { role: "ROLE_USER" } },
    { path: 'account', component: AccountComponent, canActivate: [AuthGuard] },
    { path: 'orders', component: OrdersComponent, canActivate: [AuthGuard], data: { role: "ROLE_ADMIN" } },

    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);