import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { uploadedbooks } from './module/notebook';

@Component({
  selector: 'app-uploaded-books',
  templateUrl: './uploaded-books.component.html',
  styleUrls: ['./uploaded-books.component.css']
})
export class UploadedBooksComponent implements OnInit {

  Upbooks:uploadedbooks[]=[];
  constructor(private bservice:UserService) { }

  ngOnInit() {
    this.getuploadedbook();
  }

  public getuploadedbook()
  {
     this.bservice.getalluploadedbooks().subscribe(
       res =>{
         this.Upbooks = res;
         console.log(this.Upbooks);
       },
       err =>{
         alert("An error has occured...")
       }
      )
    
   }
    

       deleteBook(book){
         this.bservice.deleteuploadedbook(book.bookid).subscribe(
           res=>{
             this.Upbooks.splice(this.Upbooks.indexOf(book),1);
             alert(res);
             this.getuploadedbook();
            
           },
           (error)=>{
             console.log(error);
            
           }
         )
       }


  }


