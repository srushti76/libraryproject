import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  firstname:any =''
  constructor(private route:ActivatedRoute,private uservice: UserService) { }

  ngOnInit() {
    this.firstname = sessionStorage.getItem("userAuth")
  }

 

}
