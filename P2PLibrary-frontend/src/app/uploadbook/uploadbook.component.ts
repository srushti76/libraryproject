import { Component, OnInit } from '@angular/core';
// import { HardAuthenticationService } from '../service/hard-authentication.service';
import { UserService } from '../service/user.service';
import { Book } from '../list-of-books/list-of-books.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-uploadbook',
  templateUrl: './uploadbook.component.html',
  styleUrls: ['./uploadbook.component.css']
})
export class UploadbookComponent implements OnInit {

  message:string="";
  // bookName = "";
  // author = "";
  // subject = "";
  // upbooks = [];

  constructor(private bservice:UserService,private router: Router) { }

  ngOnInit() {

  }
  
  handlebook(Book)
    {
         this.bservice.uploadbook(Book.value).then(response=>{
        console.log(response);
         this.message ="Book Uploaded";
         alert(response);
         this.router.navigate(['/welcome'])
         }).catch(error=>{
           this.message="Could not uploaded "
       console.log(error);
        

       } )
       
    }
  }

























  // handlebook() {
  //   var object = {
  //     "bookName": this.bookName,
  //     "author": this.author,
  //     "subject": this.subject
  //   };

  //   this.upbooks = this._hardAuthentication.doUpload(object);
  //   console.log(this.upbooks);
  // }



