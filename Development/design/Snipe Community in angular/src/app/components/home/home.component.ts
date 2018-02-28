import { Component, OnInit } from '@angular/core';
import { UserService } from './../../services/user.service';
import { Http } from '@angular/http/src/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
dataa: any[] ;
  constructor(private userService: UserService) {}
    
  ngOnInit() {
      this.userService.Getrecent().subscribe(daya => {this.dataa = daya; } );
  }
}
