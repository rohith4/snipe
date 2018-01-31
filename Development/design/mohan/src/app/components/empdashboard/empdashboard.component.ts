import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import {Observable} from 'rxjs/Observable';
import { EmpService } from '../../services/emp.service';



@Component({
  selector: 'app-empdashboard',
  templateUrl: './empdashboard.component.html',
  styleUrls: ['./empdashboard.component.css']
})
export class EmpdashboardComponent implements OnInit {
submitted : boolean = false;
  form: FormGroup;
 constructor(private fb: FormBuilder, private empService: EmpService ) {}
  ngOnInit() {
     this.form = this.fb.group({
      eans: ['', ]
      });
  }
  answer() {
    this.submitted = true;
  this.empService.askEmp(this.form.value)
  .subscribe(
      (data) => console.log(data),
      (error) => console.log(error),
      () => console.log('success')
);

console.log("data in component"+JSON.stringify(this.form.value));
     this.call();
}
 call() {
   this.empService.askEmp(JSON.stringify(this.form.value));

  }
}

