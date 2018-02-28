import { Component, OnInit,Inject  } from '@angular/core';
import { NgForm }    from '@angular/forms';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import {Observable} from 'rxjs/Observable';
import { Router }  from '@angular/router';
import { UserService } from '../../services/user.service'
import 'rxjs/Rx';

@Component({
  selector: 'app-header',
  templateUrl: './ask.component.html',
  styleUrls: ['./ask.component.css']
  
  })
export class AskComponent implements OnInit {

  form: FormGroup;
 constructor(private fb: FormBuilder,private userService : UserService, private router: Router){}
  ngOnInit() {
     this.form = this.fb.group({    
     tag_name: ['', ],
      question: ['', ],
      });
    
  }
    
  ask() {
  this.router.navigate(['./home']);  
	this.userService.askUser(this.form.value)
  .subscribe(
      (data) => console.log(data),
      (error) => console.log(error),  
      () => console.log('success')  
    
	);
	
  
  
console.log("data in component"+JSON.stringify(this.form.value));
     this.call();
	 }
 call() {
   this.userService.askUser(JSON.stringify(this.form.value));

  }
}

