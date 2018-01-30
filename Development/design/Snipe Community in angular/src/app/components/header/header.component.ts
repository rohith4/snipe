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

  constructor(private fb: FormBuilder, private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.form = this.fb.group({     // {5}
      tag: ['', Validators.required],
      que: ['', Validators.required]
    });
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