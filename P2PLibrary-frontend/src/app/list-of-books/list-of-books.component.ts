import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';

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
  selector: 'app-list-of-books',
  templateUrl: './list-of-books.component.html',
  styleUrls: ['./list-of-books.component.css']
})
export class ListOfBooksComponent implements OnInit {

    message: string
    books: any
   
  constructor(
    private uservice:UserService,
    private router : Router
  ) { }

  ngOnInit() {
    //this.refreshBooks();
    this.getavailablebooks();
  }

  getavailablebooks(){
    this.uservice.getallAvailablebooks().subscribe(
      response => {
        console.log(response);
        this.books = response;
      }
    )
  }

  requestbook(book){
    this.uservice.requestavailablebook(book.bookid).subscribe(
      response => {
        console.log(response);
        alert(response);
        this.router.navigate(['/welcome'])
      }
    )
  }

}



