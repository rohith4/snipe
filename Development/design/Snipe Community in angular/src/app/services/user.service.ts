import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import 'rxjs/add/observable/throw';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { Router } from '@angular/router';

@Injectable()
export class UserService {
  private loggedIn = new BehaviorSubject<boolean>(false);

  get isLoggedIn() {
    return this.loggedIn.asObservable(); // {2}
  }

  constructor(private http: Http, private router: Router) {}

   signUpUser(data:any){
   var body = JSON.stringify(data);
   var headers = new Headers();
   headers.append('Content-Type', 'application/json');
   return this.http.post('http://192.168.1.101:8081/DemoAPI/rest/registerUser', body,
    { headers: headers }).map((data: Response) => data.json());
}
login(data) {
  console.log(data);
  return this.http.post('http://192.168.1.101:8081/DemoAPI/rest/loginUser', data
    ).map(res => res.json());
}

headerUser(data) {
  console.log(data);
  return this.http.post('http://192.168.1.101:8081/DemoAPI/rest/askq', data
    ).map(res => res.json());
}

 // signUpUser(form) {
// return this.http.post('http://localhost:8081/DemoAPI/rest/registerUser', {form}).map(res => res.json())
//   }

  // login(userdata: any) {
  //   if (userdata.userName === 'najeerbjp@gmail.com' && userdata.password === '123' ) { // {3}
  //     this.loggedIn.next(true);
  //     this.router.navigate(['/']);
  //   }
  // }

  logout() {                            // {4}
    this.loggedIn.next(false);
    this.router.navigate(['/login']);
  }

  // Get a list of all events
  getUsers(): Observable <any[]> {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    return this.http.get('/api/users', options)
      .map(response => response.json().data)
      .catch(this.handleErrors);
  
    }
  
  

  // Error handling
  private handleErrors (error: Response | any) {
    return Observable.throw(error.json().message || 'backend server error');
  }
}

