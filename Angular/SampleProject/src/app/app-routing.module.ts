import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SampleComponentComponent } from './sample-component/sample-component.component';
import { DepartmentComponentComponent } from './department-component/department-component.component';
import { EmployeeListComponentComponent } from './employee-list-component/employee-list-component.component';
import { EmpDetailsComponentComponent } from './emp-details-component/emp-details-component.component';
import { FormComponentComponent } from './form-component/form-component.component';
import { ReactiveFormComponentComponent } from './reactive-form-component/reactive-form-component.component';

const routes: Routes = [
  { path: 'employee', component:SampleComponentComponent},
  { path: 'dept', component:DepartmentComponentComponent},
  {path:'employee/:id',component:EmpDetailsComponentComponent},
  {path:'formtemp',component:FormComponentComponent},
  {path:'formreact',component:ReactiveFormComponentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
