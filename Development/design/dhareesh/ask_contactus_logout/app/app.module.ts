import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { UserService } from './services/user.service';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routing';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { AboutusComponent } from './components/aboutus/aboutus.component';
import { BlogComponent } from './components/blog/blog.component';
import { TagsComponent } from './components/tags/tags.component';
import { AskComponent } from './components/ask/ask.component';
import { ContactComponent } from './components/contact/contact.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { EmployeeComponent } from './components/employee/employee.component';
import { UsersComponent } from './components/users/users.component';
import { HomeComponent } from './components/home/home.component';
import { FormGroup, FormControl } from '@angular/forms';
import { Auth1Guard } from './auth1.guard';
import { AuthGuard } from './auth.guard';

import { EmpdashboardComponent } from './components/empdashboard/empdashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    HeaderComponent,
    FooterComponent,
    AboutusComponent,
    BlogComponent,
    AskComponent,
    TagsComponent,
    ContactComponent,
    HomeComponent,
    DashboardComponent,
    EmployeeComponent,
    UsersComponent,
    EmpdashboardComponent,
],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    ReactiveFormsModule,
],
  providers: [UserService, AuthGuard, Auth1Guard],
  bootstrap: [AppComponent]
})
export class AppModule { }
