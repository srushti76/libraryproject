import { Component, OnInit } from '@angular/core';
import { Form, FormGroup, FormControl, Validators } from '@angular/forms';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  message:string ="";
  
  form = new FormGroup({
    firstName:new FormControl('',Validators.required),
    lastName:new FormControl('',Validators.required),
    email:new FormControl('',[Validators.required,Validators.email]),
    phoneNo:new FormControl('',[Validators.required,Validators.minLength(10),Validators.maxLength(10)]),
    password:new FormControl('',[Validators.required,Validators.minLength(6)])
   });

  

  constructor(private service:UserService,private router:Router) { }

  ngOnInit() {
  }

  register(User)
    {
         this.service.signUp(User).then(response=>{
        console.log(response);
         this.message ="Register successful";
         this.router.navigate(['/login'])
         }).catch(error=>{
           this.message="Could not registered "
       console.log(error);
        

       } )
       
    }
    
}

   