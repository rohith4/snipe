import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from '../../services/user.service'
import { Router } from '@angular/router';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
  providers: [UserService]
})

export class SignupComponent implements OnInit {
  form: FormGroup;
 constructor(private fb: FormBuilder, private router : Router, private userService : UserService){}
  ngOnInit() {
     this.form = this.fb.group({    
     fname: ['', Validators.required],
      lname: ['', Validators.required],
      emailId: ['', Validators.required],
      pwd: ['', Validators.required],
      address: ['', Validators.required],
      mobileNo: ['', Validators.required],
      
     gender:[''],
      dob:[''],
      state:[''],
      country:['']
    });
    
  }

  onSubmit() {
    this.userService.signUpUser(this.form.value)
    .subscribe( 
      (data) => { console.log(data);
    this.router.navigate(['/login']);        
       },
      (error) => console.log(error),
      () => console.log('success')  
    );
  }
}
//     console.log("data in component"+JSON.stringify(this.form.value));
//     this.call();
// }
// call() {
//   this.userService.signUpUser(JSON.stringify(this.form.value));

//   }  

