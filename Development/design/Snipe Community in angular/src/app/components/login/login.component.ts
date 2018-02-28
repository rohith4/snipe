import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from './../../services/user.service';
import {Router} from '@angular/router';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  messageReturn: any;
data: Object = {};


  constructor(
    private authService: UserService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.authService.isLogged().then((result: boolean) => {
      if (result) {
        this.router.navigate(['/home']);
      }
    });
  }

  public login(data): void {
    this.authService.login(data).subscribe((result: any) => {
      console.log(result);
      if (result.returnCode === 1) {
        console.log(result.messageReturn);
        if (typeof (Storage) !== 'undefined') {
          sessionStorage.setItem('User', data.emailId);
        }
        alert('Login Successfully');
        this.router.navigate(['/home']);
      }else if (result.returnCode === 2) {

          if (typeof (Storage) !== 'undefined') {
            sessionStorage.setItem('User', data.emailId);
    }
    this.router.navigate(['/dashboard']);
      }else {
        console.log(result.messageReturn);
        alert('Invalid Credentials');
      }
    });
  }
}