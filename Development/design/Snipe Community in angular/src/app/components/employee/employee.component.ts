import { Component, OnInit } from '@angular/core';
import { UserService } from './../../services/user.service';
import { Http, Response, Headers } from '@angular/http'; 

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  employees=[];

  constructor(private http:Http, private adminService: UserService) { }

  ngOnInit() {
  }
  model:any={};
  model2:any={};
  msg:any="";
  addEmployee(model){
    //this.employees.push(this.model);
    this.adminService.addEmployee(this.model)
    .subscribe(
      (data) => { console.log(data)
     },
      (error) => console.log(error),
      () => console.log("success")
    );
    this.model ={};
  this.msg="Record is successfully added.....";

  } 

  deleteEmployee(i)
  {
    this.employees.splice(i,1);
    
  this.msg="Record is successfully deleted.....";
  
  }
myValue;
  editEmployee(k){
    this.model2.name=this.employees[k].fname;
    this.model2.lname=this.employees[k].lname;
    this.model2.jyear=this.employees[k].jyear;
    this.model2.Qualification=this.employees[k].Qualification;
    this.model2.EmailId=this.employees[k].emailId;
    this.model2.password=this.employees[k].pwd;
    this.model2.mobileNumber=this.employees[k].mobileNo;
    this.model2.male=this.employees[k].gender;    
    this.myValue = k;
    
  }
  updateEmployee(model2){
let k =this.myValue;
for(let i=0; i< this.employees.length; i++){
if(i==k){
  this.employees[i]=this.model2;
  this.model2={}; 
  this.msg="Record is successfully updated.....";
  
}
}
  } 
  clickme(){
this.msg=""; 
  }
}
