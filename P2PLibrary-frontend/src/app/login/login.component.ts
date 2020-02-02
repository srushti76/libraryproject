import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  message:string ="";
  
  constructor(private uservice:UserService, private router:Router) {}

  ngOnInit() {
  }

  login(formdata:NgForm)
  {
    let login={
      "email" : formdata.value.email,
      "password": formdata.value.password  
    }
    console.log(login["password"])
    this.uservice.login(login).subscribe(
        (res:Response)=>{        
          if(res)  
          {
            this.uservice.setloggedIn(true)
              console.log(res["email"])  
              this.message="success";

              this.router.navigate(['welcome']).then(() => {
                window.location.reload();
          });
        }
          },
      (error)=>{
          console.log(error)
          this.message="invalid credential";
          this.loginErrorHandler(error);
          })
  }

  //server error handler 
  loginErrorHandler(error: any) {
    this.message = error.errpr.message;
  }
}


// login(User){
//   this.uservice.signIn(User).then(response=>{
//       localStorage.setItem('loggedInUser',User.email);
//       this.message= "login successful";
//       this.router.navigate(['/welcome']);
  
//   }).catch(error=>{
//     console.log(error);
//     this.message="Invalid email or password..."
   
//   });










// login(User){
//     this.service.signIn(User).then(response=>{
//         localStorage.setItem('loggedInUser',User.email);
//         this.message= "login successful";
//         this.router.navigate(['/welcome']);
    
//     }).catch(error=>{
//       console.log(error);
//       this.message="Invalid email or password..."
     
//     });
    


































//   username="Shubham"
//   password=""
//   errorMessage="Invalid credential"
//   invalidLogin = false

  
//   constructor(private router: Router, private HardAuthenticationService: HardAuthenticationService) { }

//   ngOnInit() {
//   }

//   handleLogin(){
//     // console.log(this.username)
//     if(this.HardAuthenticationService.authenticate(this.username,this.password)){
//       this.router.navigate(['welcome',this.username])
//       this.invalidLogin = false
//     }
//     else{
//       this.invalidLogin = true
//     }
  
//   }

// }

