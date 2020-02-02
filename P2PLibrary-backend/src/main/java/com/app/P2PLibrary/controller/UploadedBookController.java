package com.app.P2PLibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.P2PLibrary.pojos.UploadedBook;
import com.app.P2PLibrary.service.IUploadedBookService;

@Controller
@CrossOrigin(allowedHeaders = "*",origins="*")
public class UploadedBookController {
	@Autowired
	private IUploadedBookService uservice;
	
	@RequestMapping(value = "/getalluploadedbooks",method = RequestMethod.GET)
	public ResponseEntity<?> getAllUploadedBooks(){
		List<UploadedBook> books=null;
		try {
			books=uservice.getAllUploadedBooks();
			return new ResponseEntity<List<UploadedBook>>(books, HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<String>("Failed to fetch books!",HttpStatus.OK);
		}
	
	@RequestMapping(value = "/getUploadedBooksByUserid",method = RequestMethod.GET)
	public ResponseEntity<?> getUploadedBooksByUserid(@RequestParam Integer userid){
		List<UploadedBook> books=null;
		try{
			books=uservice.getUploadedBooksByUserid(userid);
			return new ResponseEntity<List<UploadedBook>>(books,HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<String>("No books uploaded!",HttpStatus.OK);
	}
}
