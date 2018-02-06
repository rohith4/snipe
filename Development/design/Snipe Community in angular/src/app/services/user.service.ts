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
 isLogged(): Promise<boolean> {
   if (typeof(Storage) !== 'undefined') {
     if (sessionStorage.getItem('User')) {
       return Promise.resolve(true);
     }
   }
   return Promise.resolve(false);
 }
  constructor(private http: Http, private router: Router) {
  }

   signUpUser(data: any) {
   const body = JSON.stringify(data);
   const headers = new Headers();
   headers.append('Content-Type', 'application/json');
   return this.http.post('http://192.168.1.111:8082/DemoAPI/rest/registerUser', body,
    { headers: headers }).map((res: Response) => res.json());
  }



  login(data): Observable<boolean> {
    console.log(data);
    return this.http.post('http://192.168.1.111:8082/DemoAPI/rest/loginUser', data
      ).map(res => res.json());
    
    }
    
    askEmp(data: any) {
      const body = JSON.stringify(data);
      const headers = new Headers();
      headers.append('Content-Type', 'application/json');
      return this.http.post('http://192.168.1.111:8082/DemoAPI/rest/askq', body,
       { headers: headers }).map((data: Response) => data.json());
   }
   addEmployee(model) {
    console.log(model);
    return this.http.post('http://192.168.1.111:8082/DemoAPI/rest/registerEmployee', model
      ).map(res => res.json());
  }
  
  deleteEmployee(emailId) {
    console.log(emailId);
    return this.http.post('http://192.168.1.111:8082/DemoAPI/rest/registerEmployee', emailId
      ).map(res => res.json());
  }
    headerUser(data) {
      console.log(data);
      return this.http.post('http://192.168.1.111:8082/DemoAPI/rest/askq', data
      ).map(res => res.json());
    }

    askUser(data:any){
      var body = JSON.stringify(data);
      var headers = new Headers();
      headers.append('Content-Type', 'application/json');
      return this.http.post('http://192.168.1.111:8082/DemoAPI/rest/askq'	, body,
       { headers: headers }).map((data: Response) => data.json());
   }


  // logout() {                            // {4}
  //   this.isLogged.next(false); 
  //   this.router.navigate(['/login']);
  //   localStorage.removeItem('profile');
  //   localStorage.removeItem('id_token');
  //   this.userProfile = undefined;
  // }

  // Get a list of all events
  getUsers(): Observable <any[]> {
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    return this.http.get('/api/users', options)
      .map(response => response.json().data)
      .catch(this.handleErrors);
   }

  // Error handling
  private handleErrors (error: Response | any) {
    return Observable.throw(error.json().message || 'backend server error');
  }
}
