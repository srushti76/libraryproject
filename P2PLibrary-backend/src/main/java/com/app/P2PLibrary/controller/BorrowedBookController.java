package com.app.P2PLibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.P2PLibrary.pojos.UploadedBook;
import com.app.P2PLibrary.pojos.User;
import com.app.P2PLibrary.service.IBorrowedBookService;

@RestController
@CrossOrigin(allowedHeaders = "*",origins="*")
public class BorrowedBookController {
	@Autowired
	private IBorrowedBookService bservice;
	
	@RequestMapping(value = "/getBorrowedBooksByBorrower",method = RequestMethod.GET)
	public ResponseEntity<?> getBorrowedBooksByUserid(@RequestParam Integer userid){
		try {
			return new ResponseEntity<List<UploadedBook>>(bservice.getBorrowedBooksByborrower(userid),HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<String>("No Books borrowed!",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getBorrowedBooksByOwner",method = RequestMethod.POST)
	public ResponseEntity<?> getBorrowedBooksByOwner(@RequestParam Integer userid){
		try {
			return new ResponseEntity<List<UploadedBook>>(bservice.getBorrowedBooksByOwner(userid),HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<String>("No Books borrowed!",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getRequestSent",method = RequestMethod.GET)
	public ResponseEntity<?> getRequestSent(@RequestParam Integer userid){
		try {
			return new ResponseEntity<List<UploadedBook>>(bservice.getRequestSent(userid),HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<String>("No Requests Sent!!!",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getRequestReceived",method = RequestMethod.GET)
	public ResponseEntity<?> getRequestReceived(@RequestParam Integer userid){
		try {
			return new ResponseEntity<List<UploadedBook>>(bservice.getRequestReceived(userid),HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<String>("No Requests Sent!!!",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getOwnerDetails",method = RequestMethod.POST)
	public ResponseEntity<?> getOwnerDetails(@RequestParam Integer bookid){
		try {
			User owner=bservice.getBorrowerDetails(bookid);
			owner.setPassword(null);
			return new ResponseEntity<User>(owner,HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e);
		}return new ResponseEntity<String>("Owner details fetch failed",HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/getBorrowerDetails",method = RequestMethod.POST)
	public ResponseEntity<?> getBorrowerDetails(@RequestParam Integer bookid){
		try {
			User borrower=bservice.getBorrowerDetails(bookid);
			borrower.setPassword(null);
			return new ResponseEntity<User>(bservice.getBorrowerDetails(bookid),HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e);
		}return new ResponseEntity<String>("Borrower details fetch failed",HttpStatus.OK); 
	}
}
