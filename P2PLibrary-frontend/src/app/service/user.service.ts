import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {map} from "rxjs/operators";
import { uploadedbooks } from '../uploaded-books/module/notebook';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  loginStatus:boolean=false;

  constructor(private http:HttpClient) { 
    console.log(this.loginStatus)
  }

  login(User)
  {
    console.log(User.email)
    console.log(User.password)
    return this.http.post<any>('http://localhost:8080/login',User)
           .pipe(
             map(
               (data)=>{
                 sessionStorage.setItem("userAuth",data.firstName);
                 console.log(data);
                 sessionStorage.setItem("userId",data.userId);
                 return data; 
               })
           );
  }


  public signUp(User)
  {
    return this.http.post('http://localhost:8080/register',User,{responseType: 'text'}).toPromise();
  }

  public uploadbook(Book)
  {
    let id=sessionStorage.getItem('userId');
    return this.http.post('http://localhost:8080/uploadbook?id='+id,Book,{responseType:"text" as "json"}).toPromise();
  }

  getalluploadedbooks()
  {
    let id=sessionStorage.getItem('userId');
    return this.http.get<uploadedbooks[]>('http://localhost:8080/getAvailableBooksByUserid?userid='+id)
  }

  deleteuploadedbook(id:number)
  {
    
    return this.http.delete('http://localhost:8080/withdrawBook?bookid='+id,{responseType:"text" as "json"})
  }

  requestavailablebook(ida:number)
  {
    let id=sessionStorage.getItem('userId');
    return this.http.get('http://localhost:8080/requestBook?bookid='+ida+'&userid='+id,{responseType: 'text'})
  }

  setloggedIn(loginStatus:boolean){
    this.loginStatus = loginStatus;
  }

  getLoggedIn(){
    return this.loginStatus;
  }

  logout(){
    sessionStorage.removeItem("userAuth");
    sessionStorage.removeItem("userId");
    
  }
  
  getallAvailablebooks()
  {
    let id=sessionStorage.getItem('userId');
    return this.http.get<uploadedbooks[]>('http://localhost:8080/getallavailablebooks?userid='+id)
  }

  
  getreqsent()
  {
    let id=sessionStorage.getItem('userId');
    return this.http.get<uploadedbooks[]>('http://localhost:8080/getRequestSent?userid='+id)
  }

  getborrowedbooks()
  {
    let id=sessionStorage.getItem('userId');
    return this.http.get<uploadedbooks[]>('http://localhost:8080/getBorrowedBooksByBorrower?userid='+id)
  }

  
  cancelreq(id:number)
  {
    
    return this.http.get('http://localhost:8080/cancelRequest?bookid='+id,{responseType: 'text'})
  }

  getreqrecieved()
  {
    let id=sessionStorage.getItem('userId');
    return this.http.get<uploadedbooks[]>('http://localhost:8080/getRequestReceived?userid='+id)
  }

   
  confirmRequestBook(id:number)
  {
    
    return this.http.put('http://localhost:8080/confirmRequestBook?bookid='+id,{responseType: 'text' as 'json'})
  }

   
  rejectRequest(id:number)
  {
    
    return this.http.get('http://localhost:8080/rejectRequest?bookid='+id,{responseType: 'text'})
  }

  getuserdetails(id:number)
  {
    
    return this.http.post('http://localhost:8080/getOwnerDetails?bookid='+id,{responseType: 'text'})
  }

  
  returnbook(ida:number)
  {
    let id=sessionStorage.getItem('userId');
    return this.http.get('http://localhost:8080/returnbook?bookid='+ida+'&userid='+id,{responseType: 'text'})
  }

}
