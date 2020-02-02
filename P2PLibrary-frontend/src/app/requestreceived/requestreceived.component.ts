import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-requestreceived',
  templateUrl: './requestreceived.component.html',
  styleUrls: ['./requestreceived.component.css']
})
export class RequestreceivedComponent implements OnInit {

  books: any

  constructor(private uservice:UserService,private router:Router) { }

  ngOnInit() {
    this.getrequestreceived()

  }

  getrequestreceived(){
    this.uservice.getreqrecieved().subscribe(
      res =>{
        console.log(res);
        this.books = res;
      },err =>{
        console.log(err);
      }
    )
  }

  acceptrequest(book)
  {
    this.uservice.confirmRequestBook(book.bookid).subscribe(
      res => {
        console.log(res);
        
      },err =>{
        console.log(err);
        this.router.navigate(['/welcome'])
      }
    )
  }

  rejectrequest(book)
  {
    this.uservice.confirmRequestBook(book.bookid).subscribe(
      res => {
        console.log(res);
        
      },err =>{
        console.log(err);
        this.router.navigate(['/welcome'])
      }
    )
  }
 

}
