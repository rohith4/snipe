import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map'

@Injectable()
export class BasicService {
    constructor(private http: Http) {

    }

    GetPosts() {
        return this.http.get('https://jsonplaceholder.typicode.com/posts').map(result => result.json());
    }

    GetPostAsPerId(Id : any){
        return this.http.get('https://jsonplaceholder.typicode.com/posts/' + Id).map(result => result.json());
    }

}