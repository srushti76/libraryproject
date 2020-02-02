package com.app.P2PLibrary.service;

import java.util.List;

import com.app.P2PLibrary.pojos.UploadedBook;

public interface IUploadedBookService {
	
	List<UploadedBook> getAllUploadedBooks();
	List<UploadedBook> getUploadedBooksByUserid(Integer userid);
	public boolean addToUploadedBook(UploadedBook uploadedBook,int id);
	public boolean removeBook(UploadedBook book);
}
