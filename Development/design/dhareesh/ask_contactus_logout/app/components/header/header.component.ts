import { Component, OnInit,Inject  } from '@angular/core';
import { NgForm } from '@angular/forms';
import {Observable} from 'rxjs/Observable';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from './../../services/user.service';
import 'rxjs/Rx';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  form: FormGroup;                    // {1}

  constructor(private auth: UserService, private router: Router) {
   // this.isLogged = this.auth.isLogged();
  }
ngOnInit(){}
  logout() {
    sessionStorage.removeItem('User');
    this.router.navigate(['/home']);
  }



  // onSubmit(form) {
  //   this.userService.headerUser(this.form.value)
  //   .subscribe(
  //     (data) => console.log(data);
  //     this.router.navigate(['/home']);
  //     (error) => console.log(error);
  //     () => console.log('success');
  //   )
  // }
}