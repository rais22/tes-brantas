import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {AddUserComponent} from "./add-user/add-user.component";
import {ListUserComponent} from "./list-user/list-user.component";
import {EditUserComponent} from "./edit-user/edit-user.component";

import {AddDivisiComponent} from "./add-divisi/add-divisi.component";
import {ListDivisiComponent} from "./list-divisi/list-divisi.component";
import {EditDivisiComponent} from "./edit-divisi/edit-divisi.component";

import {AddJabatanComponent} from "./add-jabatan/add-jabatan.component";
import {ListJabatanComponent} from "./list-jabatan/list-jabatan.component";
import {EditJabatanComponent} from "./edit-jabatan/edit-jabatan.component";

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'add-user', component: AddUserComponent },
  { path: 'list-user', component: ListUserComponent },
  { path: 'edit-user', component: EditUserComponent },
  { path: 'add-divisi', component: AddDivisiComponent },
  { path: 'list-divisi', component: ListDivisiComponent },
  { path: 'edit-divisi', component: EditDivisiComponent },
  { path: 'add-jabatan', component: AddJabatanComponent },
  { path: 'list-jabatan', component: ListJabatanComponent },
  { path: 'edit-jabatan', component: EditJabatanComponent },

  {path : '', component : LoginComponent}
];

export const routing = RouterModule.forRoot(routes);
