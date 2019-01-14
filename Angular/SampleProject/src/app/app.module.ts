import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SampleComponentComponent } from './sample-component/sample-component.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { SampleDirectiveDirective } from './sample-directive.directive';
import { DepartmentComponentComponent } from './department-component/department-component.component';
import { EmployeeListComponentComponent } from './employee-list-component/employee-list-component.component';
import {SampleServiceService} from './sample-service.service';
import {HttpClientModule} from '@angular/common/http';
import { EmpDetailsComponentComponent } from './emp-details-component/emp-details-component.component';
import { FormComponentComponent } from './form-component/form-component.component';
import { ReactiveFormComponentComponent } from './reactive-form-component/reactive-form-component.component';

@NgModule({
  declarations: [
    AppComponent,
    SampleComponentComponent,
    SampleDirectiveDirective,
    DepartmentComponentComponent,
    EmployeeListComponentComponent,
    EmpDetailsComponentComponent,
    FormComponentComponent,
    ReactiveFormComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [SampleServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
