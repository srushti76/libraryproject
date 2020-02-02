package com.app.P2PLibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.P2PLibrary.pojos.AvailableBook;
import com.app.P2PLibrary.pojos.BorrowedBook;
import com.app.P2PLibrary.pojos.UploadedBook;
import com.app.P2PLibrary.pojos.User;
import com.app.P2PLibrary.service.IAvailableBookService;
import com.app.P2PLibrary.service.IBorrowedBookService;
import com.app.P2PLibrary.service.IUploadedBookService;

@RestController
@CrossOrigin(allowedHeaders = "*",origins="*")
public class BookController {
	@Autowired
	private IAvailableBookService aservice;
	
	@Autowired
	private IUploadedBookService uservice;
	
	@Autowired
	private IBorrowedBookService bservice;
	 	
	@RequestMapping(value = "/uploadbook",method = RequestMethod.POST)
	public ResponseEntity<?> uploadBook(@RequestBody UploadedBook book,@RequestParam Integer id){
		System.out.println(book);
		try {
			if(uservice.addToUploadedBook(book, id)) {
				if(aservice.addAvailableBook(book, id)) {			
					return new ResponseEntity<String>("Books uploaded!!",HttpStatus.OK);
				}
				else {
					return new ResponseEntity<String>("failed in availablebooks",HttpStatus.OK);
				}
				
			}else {
				return new ResponseEntity<String>("failed in uploadedbooks",HttpStatus.OK);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<String>("failed!!!",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/withdrawBook",method = RequestMethod.DELETE)
	public ResponseEntity<String> withdrawBook(@RequestParam Integer bookid){
		AvailableBook abook = aservice.findBookByBookid(bookid);
		UploadedBook ubook = abook.getBook();
		try{
			aservice.removeBook(abook);
			uservice.removeBook(ubook);
			return new ResponseEntity<String>("Book withdrawn!",HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e);
		}			
		return new ResponseEntity<String>("Book could not be withdrawn",HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/requestBook",method = RequestMethod.GET)
	public ResponseEntity<?> requestBook(@RequestParam Integer bookid, @RequestParam Integer userid){
		try {
			AvailableBook book=aservice.findBookByBookid(bookid);
			bservice.addBorrowed(book.getBook(), userid, book.getOwner());
			aservice.removeBook(book);
			return new ResponseEntity<String>("Request Sent!!",HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<String>("Request failed!!",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/confirmRequestBook",method = RequestMethod.PUT)
	public ResponseEntity<String> confirmRequestBook(@RequestParam Integer bookid){
		try{
			BorrowedBook book=bservice.getBookByBookid(bookid);
			book.setConfirmed(true);
			if(bservice.confirmRequestBook(book))
				return new ResponseEntity<String>("Confirmed!!",HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<String>("Confirmation failed!",HttpStatus.OK);
	}
			
	@RequestMapping(value = "/rejectRequest",method = RequestMethod.GET)
	public ResponseEntity<?> rejectRequest(@RequestParam Integer bookid){
		try {
			
			BorrowedBook book=bservice.getBookByBookid(bookid);
			UploadedBook ubook=book.getBook();
			aservice.returnAvailableBook(ubook, ubook.getOwner());
			bservice.removeBook(book);
			return new ResponseEntity<String>("Book returned!!",HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<String>("Book returning failed",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cancelRequest",method = RequestMethod.GET)
	public ResponseEntity<?> cancelRequest(@RequestParam Integer bookid){
		try {
			
			BorrowedBook book=bservice.getBookByBookid(bookid);
			aservice.returnAvailableBook(book.getBook(), book.getOwner());
			bservice.removeBook(book);
			return new ResponseEntity<String>("Request cancelled!!",HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<String>("Request cancelling failed!",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/returnbook",method = RequestMethod.GET)
	public ResponseEntity<?> returnBook(@RequestParam Integer bookid,@RequestParam Integer userid){
		try {
			
			BorrowedBook book=bservice.getBookByBookid(bookid);
			UploadedBook ubook=book.getBook();
			User user=ubook.getOwner();
			aservice.returnAvailableBook(ubook, user);
			bservice.removeBook(book);
			return new ResponseEntity<String>("Book returned!!",HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<String>("Book returning failed",HttpStatus.OK);
	}

	
}


