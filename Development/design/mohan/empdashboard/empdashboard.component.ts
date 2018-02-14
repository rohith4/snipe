import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import { UserserviceService } from '../../userservice.service';



@Component({
  selector: 'app-empdashboard',
  templateUrl: './empdashboard.component.html',
  styleUrls: ['./empdashboard.component.css']
})
export class EmpdashboardComponent implements OnInit {
  submitted: boolean = false;
  questionsQ = [
    {q_id : '', question: '', answer: '' },
        ];
data: any = {};
ques: any= {};

  constructor(private userService: UserserviceService) { }

  ngOnInit() { this.userService.getEmp()
    .subscribe(
     data => this.questionsQ = data
    );
}

  Empsubmit(data, ques) {
    this.data.q_id = ques.q_id;
    // this.submitted = true;

    console.log(data);
    console.log(ques);
    this.userService.Empsubmit(this.data)
    .subscribe(
      (model) =>  console.log(data),
      (error) => console.log(error),
    );
  }
}
