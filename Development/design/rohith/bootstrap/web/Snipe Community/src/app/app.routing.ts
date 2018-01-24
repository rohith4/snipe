import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { NgModule } from '@angular/core';
import { HeaderComponent } from './components/header/header.component';
import { SignupComponent } from './components/signup/signup.component';
import { AboutusComponent } from './components/aboutus/aboutus.component';
import { TagsComponent } from './components/tags/tags.component';
import { ContactComponent } from './components/contact/contact.component';
import { BlogComponent} from './components/blog/blog.component';
import { HomeComponent } from './components/home/home.component';

const appRoutes: Routes = [
   { path: 'login', component: LoginComponent},
   { path: 'signup', component: SignupComponent},
   { path: '', component: HeaderComponent,
    children: [
      { path: 'home', component: HomeComponent},
      { path: 'about', component: AboutusComponent},
      { path: 'tag', component: TagsComponent},
      { path: 'blog', component: BlogComponent},
      { path: 'contact', component: ContactComponent}
        ]}
  ];

  @NgModule({
    imports: [
      RouterModule.forRoot(appRoutes, { useHash: true })
    ],
    exports: [
      RouterModule
    ]
  })

  export class AppRoutingModule { }