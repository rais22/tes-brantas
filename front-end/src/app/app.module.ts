import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import {routing} from "./app.routing";
import {AuthenticationService} from "./service/auth.service";
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { AddUserComponent } from './add-user/add-user.component';
import { EditUserComponent } from './edit-user/edit-user.component';
import {ListUserComponent} from "./list-user/list-user.component";
import {UserService} from "./service/user.service";
import { AddDivisiComponent } from './add-divisi/add-divisi.component';
import { EditDivisiComponent } from './edit-divisi/edit-divisi.component';
import { ListDivisiComponent } from './list-divisi/list-divisi.component';
import {DivisiService} from "./service/divisi.service";
import { AddJabatanComponent } from './add-jabatan/add-jabatan.component';
import { ListJabatanComponent } from './list-jabatan/list-jabatan.component';
import {JabatanService} from "./service/jabatan.service";
import { EditJabatanComponent } from './edit-jabatan/edit-jabatan.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ListUserComponent,
    AddUserComponent,
    EditUserComponent,
    AddDivisiComponent,
    EditDivisiComponent,
    ListDivisiComponent,
    AddJabatanComponent,
    ListJabatanComponent,
    EditJabatanComponent
  ],
  imports: [
    BrowserModule,
    routing,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [AuthenticationService, UserService, DivisiService, JabatanService],
  bootstrap: [AppComponent]
})
export class AppModule { }
