import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { EmpService } from './services/emp.service';


import { FormGroup, FormControl } from '@angular/forms';
import { AppComponent } from './app.component';
import { EmpAnsComponent } from './components/emp-ans/emp-ans.component';
import { EmpdashboardComponent } from './components/empdashboard/empdashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    EmpAnsComponent,
    EmpdashboardComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    ReactiveFormsModule,

  ],
  providers: [EmpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
