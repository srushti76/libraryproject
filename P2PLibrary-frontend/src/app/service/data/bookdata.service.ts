import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Book } from 'src/app/list-of-books/list-of-books.component';

@Injectable({
  providedIn: 'root'
})
export class BookdataService {

  constructor(
    private http: HttpClient
  ) { }

retrieveAllBooks(username){

  return this.http.get<Book[]>(`http://localhost:8080/users/${username}/books`)


}

deleteBook(username, id){
  return this.http.delete(`http://localhost:8080/users/$(username)/books/${id}`)
}

retrieveBooks(username, id){
  console.log(username+" "+id);
  return this.http.get<Book>(`http://localhost:8080/users/${username}/books/${id}`)
}

updatebook(username, id, book){
  return this.http.put(`http://localhost:8080/users/${username}/books/${id}`, book)
}

createbook(username, book){
  return this.http.post(`http://localhost:8080/users/${username}/books`, book)
}

}
  