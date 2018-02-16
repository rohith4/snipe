import { Component, OnInit } from '@angular/core';
import { UserService } from './../../services/user.service';
import { modelGroupProvider } from '@angular/forms/src/directives/ng_model_group';


@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  employees = [];

  constructor(private adminService: UserService) { }

  ngOnInit() {
    this.adminService.getEmp()
    .subscribe(
      model => this.employees = model
    );
  }
  model:any={};
  model2:any={};
  msg:any="";

  addEmployee(model){
    // this.employees.push(this.model);
    this.adminService.addEmployee(this.model)
    .subscribe(
      (model) => { console.log(model)
     },
      (error) => console.log(error),
      () => console.log("success")
    );
    this.model ={};
  } 

  deleteEmployee(employee)
  {
    if (confirm("Are you sure you want to delete " + employee.emailId + "?.emailId")) {
      var index = this.employees.indexOf(employee);
      this.employees.splice(index, 1);

      this.adminService.deleteEmp(employee.emailId)
        .subscribe(null,
          err => {
            alert("Could not delete user.");
            // Revert the view back to its original state
            this.employees.splice(index, 0, employee);
          });
        }

  //this.msg="Record is successfully deleted.....";
  
  }
myValue;
  editEmployee(k){
    this.model2.fname=this.employees[k].fname;
    this.model2.lname=this.employees[k].lname;
    this.model2.jyear=this.employees[k].jyear;
    this.model2.Qualification=this.employees[k].Qualification;
    this.model2.EmailId=this.employees[k].emailId;
    this.model2.password=this.employees[k].pwd;
    this.model2.mobileNumber=this.employees[k].mobileNo;
    this.model2.male=this.employees[k].male; 
    this.model2.female=this.employees[k].female;    
       
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
