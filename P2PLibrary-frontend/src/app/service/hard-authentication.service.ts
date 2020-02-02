import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HardAuthenticationService {

  users=[];
  upbooks=[];
  constructor(private http:HttpClient) { }

  authenticate(username, password){
    // baseUrl="";

    if(username==="Shubham" && password==="123"){
     sessionStorage.setItem('authenticateUser', username);
      return true;
    }
    return false;
  }

  isUserLoggedIn(){
    let user = sessionStorage.getItem('authenticateUser')
    return !(user ===null)
  }

  logout(){
    sessionStorage.removeItem('authenticateUser');
  }

  // doRegister(data:any)
  // {
  //   //this.users.push(data);
    
  //   return this.http.post(baseUrl,data);
  // }

  doUpload(bookdata:any)
  {
    this.upbooks.push(bookdata);
    return this.upbooks;
  }
}
