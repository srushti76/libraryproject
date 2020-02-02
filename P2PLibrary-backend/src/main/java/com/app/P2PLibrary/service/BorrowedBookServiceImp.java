package com.app.P2PLibrary.service;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.P2PLibrary.dao.IBorrowedBookDao;
import com.app.P2PLibrary.pojos.BorrowedBook;
import com.app.P2PLibrary.pojos.UploadedBook;
import com.app.P2PLibrary.pojos.User;

@Service
public class BorrowedBookServiceImp implements IBorrowedBookService {
	@PersistenceContext
	private EntityManager mgr;
	@Autowired
	private IBorrowedBookDao dao;
	
	@Override
	public boolean addBorrowed(UploadedBook uploadedbook,Integer id,User owner) {
		User borrower=null;
		BorrowedBook book=new BorrowedBook();
		try {
			borrower=mgr.unwrap(Session.class).get(User.class, id);
			book.setBorrower(borrower);
			book.setBook(uploadedbook);
			book.setOwner(owner);
			dao.save(book);
			return true;
		}catch (Exception e) {
		}
		return false;
	}
	@Override
	public BorrowedBook getBookByBookid(Integer id) {
		UploadedBook ubook=new UploadedBook();
		ubook.setBookid(id);
		try{
			BorrowedBook book=dao.findByBook(ubook);
			return book;
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	@Override
	public boolean removeBook(BorrowedBook book) {		
		dao.delete(book);
		return true;
	}
	@Override
	public List<UploadedBook> getBorrowedBooksByborrower(Integer userid) {
		User user=new User();
		user.setUserId(userid);
		List<UploadedBook> books=new ArrayList<UploadedBook>();
		try{
			List<BorrowedBook> bbooks=dao.findByBorrower(user);
			for(BorrowedBook b:bbooks) {
				if(b.isConfirmed()==true)
				books.add(b.getBook());
			}
			return books;
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;					
		
	}
	@Override
	public boolean confirmRequestBook(BorrowedBook book) {
		try {
			dao.save(book);
			return true;
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	@Override
	public List<UploadedBook> getBorrowedBooksByOwner(Integer userid) {
		User owner=new User();
		owner.setUserId(userid);
		List<UploadedBook> books=new ArrayList<UploadedBook>();
		try{
			List<BorrowedBook> bbooks=dao.findByOwner(owner);
			for(BorrowedBook b:bbooks) {
				books.add(b.getBook());
			}
			return books;
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	@Override
	public List<UploadedBook> getRequestSent(Integer userid) {
		User user=new User();
		user.setUserId(userid);
		List<UploadedBook> books=new ArrayList<UploadedBook>();
		try{
			List<BorrowedBook> bbooks=dao.findByBorrower(user);
			for(BorrowedBook b:bbooks) {
				if(b.isConfirmed()==false) {
					books.add(b.getBook());
				}		
			}
			return books;
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}	

	public List<UploadedBook> getRequestReceived(Integer userid) {
		User user=new User();
		user.setUserId(userid);
		List<UploadedBook> books=new ArrayList<UploadedBook>();
		try{
			List<BorrowedBook> bbooks=dao.findByOwner(user);
			for(BorrowedBook b:bbooks) {
				if(b.isConfirmed()==false) {
					books.add(b.getBook());
				}		
			}
			return books;
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@Override
	public User getOwnerDetails(Integer bookid) {
		UploadedBook ubook=new UploadedBook();
		ubook.setBookid(bookid);
		try{
			BorrowedBook book=dao.findByBook(ubook);
			return book.getOwner();
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	@Override
	public User getBorrowerDetails(Integer bookid) {
		UploadedBook ubook=new UploadedBook();
		ubook.setBookid(bookid);
		try{
			BorrowedBook book=dao.findByBook(ubook);
			return book.getBorrower();
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
