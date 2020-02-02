package com.app.P2PLibrary.service;

import java.util.List;


import com.app.P2PLibrary.pojos.BorrowedBook;
import com.app.P2PLibrary.pojos.UploadedBook;
import com.app.P2PLibrary.pojos.User;

public interface IBorrowedBookService {
	public boolean addBorrowed(UploadedBook uploadedbook,Integer id,User o);
	public BorrowedBook getBookByBookid(Integer id);
	public boolean removeBook(BorrowedBook book);
	public List<UploadedBook> getBorrowedBooksByborrower(Integer userid);
	public boolean confirmRequestBook(BorrowedBook book);
	public List<UploadedBook> getBorrowedBooksByOwner(Integer userid);
	public List<UploadedBook> getRequestSent(Integer userid);
	public List<UploadedBook> getRequestReceived(Integer userid);
	public User getOwnerDetails(Integer bookid);
	public User getBorrowerDetails(Integer bookid);
}
