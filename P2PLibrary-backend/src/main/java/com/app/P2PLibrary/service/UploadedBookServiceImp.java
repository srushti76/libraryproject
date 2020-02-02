package com.app.P2PLibrary.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.app.P2PLibrary.dao.IUploadedBookDao;
import com.app.P2PLibrary.pojos.UploadedBook;
import com.app.P2PLibrary.pojos.User;

@Service
public class UploadedBookServiceImp implements IUploadedBookService {
	@PersistenceContext
	private EntityManager mgr;
	@Autowired
	private IUploadedBookDao dao;
	@Override
	public List<UploadedBook> getAllUploadedBooks() {
		return dao.findAll();
	}
	

	@Override
	public boolean addToUploadedBook(UploadedBook uploadedBook, int id) {
		User owner=null;
		try {
			owner=mgr.unwrap(Session.class).get(User.class, id);
			uploadedBook.setOwner(owner);
			dao.save(uploadedBook);
			return true;
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}


	@Override
	public List<UploadedBook> getUploadedBooksByUserid(Integer userid) {
		User user=new User();
		List<UploadedBook> books=null;
		user.setUserId(userid);
		UploadedBook book=new UploadedBook();
		book.setOwner(user);
		Example<UploadedBook> exbook=Example.of(book);
		try{
			books=dao.findAll(exbook);
			return books;
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}


	@Override
	public boolean removeBook(UploadedBook book) {
		try{
			dao.delete(book);
			return true;
		}catch (Exception e) {
			System.out.println(e);				
		}
		return false;
	}
}