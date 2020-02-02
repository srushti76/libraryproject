import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-requestsent',
  templateUrl: './requestsent.component.html',
  styleUrls: ['./requestsent.component.css']
})
export class RequestsentComponent implements OnInit {

  constructor(private uservice:UserService,private router:Router) { }

  books: any

  ngOnInit() {
    this.getrequestsent()
  }

  getrequestsent(){
    this.uservice.getreqsent().subscribe(
      response => {
        console.log(response);
        this.books = response;
      }
    )
  }

  cancelrequest(book)
  {
    this.uservice.cancelreq(book.bookid).subscribe(
      res=>{console.log(res);
        console.log(res);
        this.router.navigate(['/welcome'])
       
      },
      (error)=>{
        console.log(error);
       
      }
    )
    

    }
  }
