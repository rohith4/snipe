import { Component, OnInit,Inject  } from '@angular/core';
import { NgForm }    from '@angular/forms';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import {Observable} from 'rxjs/Observable';
import { Router }  from '@angular/router';
import { Component }           from '@angular/core';
import { UserService } from '../../services/user.service'
import 'rxjs/Rx';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
  
  })
export class HeaderComponent implements OnInit {

  form: FormGroup;
 constructor(private fb: FormBuilder,private userService : UserService){}
  ngOnInit() {
     this.form = this.fb.group({    
     tag: ['', ],
      que: ['', ],
      });
    
  }
  

  onSubmit() {
    this.userService.headerUser(this.form.value)
    .subscribe(
      (data) => console.log(data),
      (error) => console.log(error),
      () => console.log('success')  
    );
  
  
console.log("data in component"+JSON.stringify(this.form.value));
     this.call();
	 }
 call() {
   this.userService.headerUser(JSON.stringify(this.form.value));

  }
}

