import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
  providers: [UserService]
})

export class SignupComponent implements OnInit {
  register(form: FormGroup) {
    form.reset();
   }
  form: FormGroup;
  successMessage:string = '';
  errorMessage:string = '';
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
   this.successMessage = '';  
   this.errorMessage = '';
    this.userService.signUpUser(this.form.value)
    .subscribe( 
      (data) => { console.log(data);
    this.successMessage ='Click Here go HomePage.';
    // this.router.navigate(['/home']); 
    
      },       
    
      (error) => {console.log(error)
        this.errorMessage = 'user could not be updated';
      },
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

