import { Injectable } from '@angular/core';
import { Http , Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/throw';
import { Router } from '@angular/router';

@Injectable()
export class UserserviceService {

  constructor(private _http: Http) {}
  Empsubmit(data) {
    console.log(data);
    return this._http.post('http://192.168.1.111:8181/DemoAPI/rest/answered', data)
    .map(res => res.json());
    }
    getEmp() {
      return this._http.get('http://192.168.1.111:8181/DemoAPI/rest/recentQs').map(res => res.json());
    }


  }

