
import { Component, OnInit,Inject  } from '@angular/core';
import { NgForm }    from '@angular/forms';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import {Observable} from 'rxjs/Observable';
import { Router }  from '@angular/router';
import { UserService } from '../../services/user.service'
import 'rxjs/Rx';



@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})

export class ContactComponent implements OnInit {

  form: FormGroup;
 constructor(private fb: FormBuilder,private userService : UserService, private router: Router){}
  ngOnInit() {
     this.form = this.fb.group({    
     
      name: ['', Validators.required],
      emailId: ['', Validators.required],
      message:   ['',Validators.required],
      });
    
  }
    
  contact() {
  this.router.navigate(['./home']);  
	this.userService.contactUser(this.form.value)
  .subscribe(
      (data) => console.log(data),
      (error) => console.log(error),  
      () => console.log('success')  
    
	);
	
  
  
console.log("data in component"+JSON.stringify(this.form.value));
     this.call();
	 }
 call() {
   this.userService.contactUser(JSON.stringify(this.form.value));

  }
}
