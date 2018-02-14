import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { UserserviceService } from './userservice.service';
import { HttpClientModule } from '@angular/common/http';

import { FormGroup, FormControl } from '@angular/forms';
import { AppComponent } from './app.component';
import { EmpdashboardComponent } from './components/empdashboard/empdashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    EmpdashboardComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    ReactiveFormsModule,
    HttpClientModule

  ],
  providers: [UserserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
