import { Component } from '@angular/core';
import { BasicService } from '../../Service/Basic.service';

@Component({
    selector: 'my-app',
    template: `<h1>Hello {{name}}</h1><hr/>
    <div style="height:200px; overflow:auto;">
    
    <table *ngFor="let item of data" >
    <tr><td>Id</td><td>{{item.id}}</td></tr>
    <tr><td>UserId</td><td>{{item.userId}}</td></tr>
    <tr><td>Title</td><td>{{item.title}}</td></tr>
    <tr><td>Body</td><td>{{item.body}}</td></tr>
    </table>
    </div>
     <hr/>
    <input [(ngModel)]="PostId" name="PostId" />
    <button (click)='GetPost()' >Get Post</button>

    <table>
     <tr><td>Id</td><td>{{SinglePost.id}}</td></tr>
    <tr><td>UserId</td><td>{{SinglePost.userId}}</td></tr>
    <tr><td>Title</td><td>{{SinglePost.title}}</td></tr>
    <tr><td>Body</td><td>{{SinglePost.body}}</td></tr>
    </table>

    `,
})
export class HomeComponent {
    name: string;
    data: any;
    PostId: any;
    SinglePost: any;

    constructor(private MyService: BasicService) {
        this.name = "Angular Service";

        this.MyService.GetPosts().subscribe(posts => { this.data = posts });

        this.PostId = "0";

        this.SinglePost = {
            id:'',
            userId:'',
            title:'',
            body :''
        }
    }

    GetPost() {
        this.MyService.GetPostAsPerId(this.PostId).subscribe(post => { this.SinglePost = post; });
    }

}