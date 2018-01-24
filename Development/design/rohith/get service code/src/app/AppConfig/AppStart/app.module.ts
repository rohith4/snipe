import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import { HomeComponent }  from '../../Views/Home/home.component';
import { BasicService } from '../../Service/Basic.service';

@NgModule({
  imports:      [ BrowserModule, HttpModule, FormsModule ],
  declarations: [ HomeComponent ],
  bootstrap:    [ HomeComponent ],
  providers: [BasicService]
})
export class AppModule { }
