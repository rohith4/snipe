import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NgModule } from '@angular/core';
import { HeaderComponent } from './components/header/header.component';
import { SignupComponent } from './components/signup/signup.component';
import { AboutusComponent } from './components/aboutus/aboutus.component';
import { BlogComponent } from './components/blog/blog.component';
import { AskComponent } from './components/ask/ask.component';
import { TagsComponent } from './components/tags/tags.component';
import { ContactComponent } from './components/contact/contact.component';
import { AuthGuard } from './auth.guard';

const appRoutes: Routes = [
   { path: 'login', component: LoginComponent},
   { path: 'signup', component: SignupComponent},
   { path: '', component: HeaderComponent,
    children: [
      { path: 'home', component: HomeComponent},
      { path: 'about', component: AboutusComponent},
      { path: 'blog', component: BlogComponent},
      { path: 'tag', component: TagsComponent},
      { path: 'ask', component: AskComponent},
      { path: 'contact', component: ContactComponent},
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

  export class AppRoutingModule {}