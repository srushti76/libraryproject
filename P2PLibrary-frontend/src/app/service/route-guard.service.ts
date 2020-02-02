import { Injectable } from '@angular/core';
import { CanActivate , ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import { HardAuthenticationService } from './hard-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService implements CanActivate {

  constructor(private  HardAuthenticationService: HardAuthenticationService,
    private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    if(this.HardAuthenticationService.isUserLoggedIn())
      return true;
    
    
    this.router.navigate(['login'])
    return false;
  }
}
