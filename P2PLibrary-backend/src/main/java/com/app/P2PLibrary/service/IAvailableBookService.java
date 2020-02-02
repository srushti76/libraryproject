package com.app.P2PLibrary.service;

import java.util.List;

import com.app.P2PLibrary.pojos.AvailableBook;
import com.app.P2PLibrary.pojos.UploadedBook;
import com.app.P2PLibrary.pojos.User;

public interface IAvailableBookService {
	
	List<UploadedBook> getAllAvailableBooks(Integer userid);
	List<UploadedBook> getAvailableBooksByUserid(Integer userid);
	List<UploadedBook> getAvailableBooksByCategory(String category,Integer userid);
	List<UploadedBook> getAvailableBooksByTitle(String title,Integer userid);
	List<UploadedBook> getAvailableBooksByLanguage(String language,Integer userid);
	List<UploadedBook> getAvailableBooksByAuthor(String author,Integer userid);
	
	public boolean addAvailableBook(UploadedBook uploadedbook,int id);
	public boolean returnAvailableBook(UploadedBook uploadedBook,User user);
	public boolean removeBook(AvailableBook book);
	public AvailableBook findBookByBookid(Integer id);
}
