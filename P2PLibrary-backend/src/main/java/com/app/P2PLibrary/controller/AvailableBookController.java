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
import com.app.P2PLibrary.service.IAvailableBookService;

@RestController
@CrossOrigin(allowedHeaders = "*",origins="*")
public class AvailableBookController {
	@Autowired
	private IAvailableBookService aservice;
	
	@RequestMapping(value = "/getallavailablebooks",method = RequestMethod.GET)
	public ResponseEntity<?> getAllAvailableBooks(@RequestParam Integer userid){
		List<UploadedBook> books=null;
		try {
			books=aservice.getAllAvailableBooks(userid);
			return new ResponseEntity<List<UploadedBook>>(books, HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<String>("Failed to fetch books!",HttpStatus.OK);
		}
	
	@RequestMapping(value = "/getAvailableBooksByUserid",method = RequestMethod.GET)
	public ResponseEntity<?> getAvailableBooksByUserid(@RequestParam Integer userid){
		try {
			List<UploadedBook> books=null;
			//return new ResponseEntity<List<UploadedBook>>(aservice.getAvailableBooksByUserid(userid),HttpStatus.OK);
			books=aservice.getAvailableBooksByUserid(userid);
			return new ResponseEntity<List<UploadedBook>>(books,HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<String>("No Books uploaded for lending!",HttpStatus.OK);
	}

	
	@RequestMapping(value = "/getAvailableBooksByCategory",method = RequestMethod.POST)	
	public ResponseEntity<?> getAvailableBooksByCategory(@RequestParam String category,@RequestParam Integer userid){
		List<UploadedBook> books=null;
		try {
			books=aservice.getAvailableBooksByCategory(category,userid);
			return new ResponseEntity<List<UploadedBook>>(books,HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<String>("failed to fetch the books!",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAvailableBooksByTitle",method = RequestMethod.POST)
	public ResponseEntity<?> getAvailableBooksByTitle(@RequestParam String title,@RequestParam Integer userid){
		List<UploadedBook> books=null;
		try {
			books=aservice.getAvailableBooksByTitle(title,userid);
			return new ResponseEntity<List<UploadedBook>>(books,HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<String>("failed to fetch the books!",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAvailableBooksByLanguage",method = RequestMethod.POST)
	public ResponseEntity<?> getAvailableBookBysLanguage(@RequestParam String language,@RequestParam Integer userid){
		List<UploadedBook> books=null;
		try {
			books=aservice.getAvailableBooksByLanguage(language,userid);
			return new ResponseEntity<List<UploadedBook>>(books,HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<String>("failed to fetch the books!",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAvailableBooksByAuthor",method = RequestMethod.POST)
	public ResponseEntity<?> getAvailableBooksByAuthor(@RequestParam String author,@RequestParam Integer userid){
		List<UploadedBook> books=null;
		try {
			books=aservice.getAvailableBooksByAuthor(author,userid);
			return new ResponseEntity<List<UploadedBook>>(books,HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<String>("failed to fetch the books!",HttpStatus.OK);
	}
	
}	
