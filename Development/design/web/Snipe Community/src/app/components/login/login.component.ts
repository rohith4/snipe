import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from './../../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: FormGroup;                    // {1}
  private formSubmitAttempt: boolean; // {2}
  data:object = {};

  constructor(
    private fb: FormBuilder,         // {3}
    private authService: UserService,
    private router : Router // {4}
  ) {}

  ngOnInit() {
    this.form = this.fb.group({     // {5}
      userName: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  isFieldInvalid(field: string) { // {6}
    return (
      (!this.form.get(field).valid && this.form.get(field).touched) ||
      (this.form.get(field).untouched && this.formSubmitAttempt)
    );
  }

  onSubmit() {
                // {8}
  }
login(data){
  if (this.form.valid) {
    this.authService.login(data); // {7}
  }
  this.formSubmitAttempt = true; 
  this.authService.login(data)
  .subscribe(
    (data) => { console.log(data)
  this.router.navigate(['/home']);  
   },
    (error) => console.log(error),
    () => console.log("success")
  );
}
}

