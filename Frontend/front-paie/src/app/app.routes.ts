import { Routes } from '@angular/router';
import { EmployesComponent } from './employes/employes/employes.component';
import { AddEmployeComponent } from './employes/add-employe/add-employe.component';

export const routes: Routes = [
    { path: "employes", component: EmployesComponent },
    { path: "addemploye", component: AddEmployeComponent }
];
