import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';
import { userdetails } from './module/userdeatils';

export class Book{
  constructor(
    public id:number,
    public bookName: string,
    public author: string,
    public subject: string
  ){

  }
}

@Component({
  selector: 'app-borrowedbooks',
  templateUrl: './borrowedbooks.component.html',
  styleUrls: ['./borrowedbooks.component.css']
})
export class BorrowedbooksComponent implements OnInit {

  books: any;
  details:any;

  constructor( private uservice:UserService,private router: Router) { }

  ngOnInit() {
    this.getavailablebooksborrowed();
  }

  
  getavailablebooksborrowed(){
    this.uservice.getborrowedbooks().subscribe(
      response => {
        console.log(response);
        this.books = response;
      }
    )
  }

  getownerdetails(book)
  {
    this.uservice.getuserdetails(book.bookid).subscribe(
      res => {
        console.log(res);
       this.details= res;
        alert("name :"+this.details.firstName+" "+"Phone number: "+this.details.phone);
      },err =>(
        console.log(err)
      )
    )
  }

  returnthebook(book)
  {
    this.uservice.returnbook(book.bookid).subscribe(
      res => {
        console.log(res);
        alert(res);
        this.router.navigate(['/welcome']);
      },err =>(
        console.log(err)
      )
    )
  }


}

