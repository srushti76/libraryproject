import { Component, OnInit } from '@angular/core';
// import { HardAuthenticationService } from '../service/hard-authentication.service';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private aservice:UserService,public router:Router) {
    
   }

  ngOnInit() {
    this.aservice.logout();

}

}
