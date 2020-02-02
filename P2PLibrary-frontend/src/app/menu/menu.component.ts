import { Component, OnInit } from '@angular/core';
import { HardAuthenticationService } from '../service/hard-authentication.service';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {


  isLoggedIn:boolean=false;
  constructor(private uservice:UserService,public router:Router) { 
    
  }

  ngOnInit() {
    if(sessionStorage.getItem('userId'))
  {
    this.isLoggedIn=true;
  }
    
  }

  loggedOut(){
    this.router.navigate(['logout']).then(() => {
      window.location.reload();
  })
  }
}
