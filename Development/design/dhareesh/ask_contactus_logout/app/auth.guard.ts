import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import { UserService } from './services/user.service';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/take';
import 'rxjs/add/operator/map';
import { OnInit } from '@angular/core/src/metadata/lifecycle_hooks';

@Injectable()
export class AuthGuard implements OnInit {
  constructor(
    private authService: UserService,
    private router: Router
  ) {}

ngOnInit () {}
//   canActivate(
//     next: ActivatedRouteSnapshot,
//     state: RouterStateSnapshot): Observable<boolean> {

//     return this.authService.isLoggedIn       // {1}
//       .take(1)                               // {2}
//       .map((isLoggedIn: boolean) => {        // {3}
//         if (!isLoggedIn) {
//           this.router.navigate(['/login']);  // {4}
//           return false;
//         }
//         return true;
//       });
//   }
}
