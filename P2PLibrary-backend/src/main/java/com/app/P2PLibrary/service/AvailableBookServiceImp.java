package com.app.P2PLibrary.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.app.P2PLibrary.dao.IAvailableBookDao;
import com.app.P2PLibrary.pojos.AvailableBook;
import com.app.P2PLibrary.pojos.UploadedBook;
import com.app.P2PLibrary.pojos.User;

@Service
public class AvailableBookServiceImp implements IAvailableBookService {
	@PersistenceContext
	private EntityManager mgr;
	@Autowired
	private IAvailableBookDao dao;
	
	@Override
	public List<UploadedBook> getAllAvailableBooks(Integer userid) {
		List<UploadedBook> books=new ArrayList<UploadedBook>();
			User owner=new User();
			owner.setUserId(userid);
		try{
			List<AvailableBook> abooks= dao.findByOwnerNot(owner);
			for(AvailableBook l:abooks) {
				books.add(l.getBook());
			}
			return books;
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@Override
	public List<UploadedBook> getAvailableBooksByUserid(Integer userid) {
		User user=new User();
		user.setUserId(userid);
		List<AvailableBook> abooks=dao.findByOwner(user);
		List<UploadedBook> books=new ArrayList<UploadedBook>();
		try {
			
			for(AvailableBook b:abooks) {
				books.add(b.getBook());
			}			
			return books;
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	
	/*public List<UploadedBook> getAvailableBooksByCategory(String category){
		UploadedBook ubook=new UploadedBook();
		ubook.setCategory(category);
		AvailableBook book = new AvailableBook();
		List<UploadedBook> ulist=new ArrayList<UploadedBook>();
		book.setBook(ubook);
		Example<AvailableBook> exbook=Example.of(book);
		try {
			List<AvailableBook> alist=dao.findAll(exbook);
			
			for(AvailableBook l:alist) {
				ulist.add(l.getBook());
			}
			if(ulist!=null)
				return ulist;
		
		}catch (Exception e) {
			System.out.println(e);
		}	
		return null;
	}*/
	
	public List<UploadedBook> getAvailableBooksByCategory(String category, Integer userid){
	User owner=new User();
	owner.setUserId(userid);
	List<UploadedBook> ulist=new ArrayList<UploadedBook>();
	try {
		List<AvailableBook> alist=dao.findByOwnerNot(owner);
		for(AvailableBook l:alist) {
			if(l.equalsByCategory(category)) {
				ulist.add(l.getBook());
			}			
		}
		if(ulist!=null)
			return ulist;
	
	}catch (Exception e) {
		System.out.println(e);
	}	
	return null;
}
			
	@Override
	public List<UploadedBook> getAvailableBooksByTitle(String title, Integer userid){
		User owner=new User();
		owner.setUserId(userid);
		List<UploadedBook> ulist=new ArrayList<UploadedBook>();
		try {
			List<AvailableBook> alist=dao.findByOwnerNot(owner);
			for(AvailableBook l:alist) {
				if(l.equalsByTitle(title)) {
					ulist.add(l.getBook());
				}			
			}
			if(ulist!=null)
				return ulist;
		
		}catch (Exception e) {
			System.out.println(e);
		}	
		return null;
	}

	@Override
	public List<UploadedBook> getAvailableBooksByLanguage(String language, Integer userid){
		User owner=new User();
		owner.setUserId(userid);
		List<UploadedBook> ulist=new ArrayList<UploadedBook>();
		try {
			List<AvailableBook> alist=dao.findByOwnerNot(owner);
			for(AvailableBook l:alist) {
				if(l.equalsByTitle(language)) {
					ulist.add(l.getBook());
				}			
			}
			if(ulist!=null)
				return ulist;
		
		}catch (Exception e) {
			System.out.println(e);
		}	
		return null;
	}
	
	@Override
	public List<UploadedBook> getAvailableBooksByAuthor(String author, Integer userid){
		User owner=new User();
		owner.setUserId(userid);
		List<UploadedBook> ulist=new ArrayList<UploadedBook>();
		try {
			List<AvailableBook> alist=dao.findByOwnerNot(owner);
			for(AvailableBook l:alist) {
				if(l.equalsByTitle(author)) {
					ulist.add(l.getBook());
				}			
			}
			if(ulist!=null)
				return ulist;
		
		}catch (Exception e) {
			System.out.println(e);
		}	
		return null;
	}
	
	@Override
	public boolean addAvailableBook(UploadedBook uploadedBook,int id) {
		User owner=null;
		AvailableBook book=new AvailableBook();
		
		try {
			owner=mgr.unwrap(Session.class).get(User.class, id);
			book.setOwner(owner);
			book.setBook(uploadedBook);
			dao.save(book);
			return true;
		}catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean removeBook(AvailableBook book) {
		dao.delete(book);
		return true;
	}

	@Override
	public AvailableBook findBookByBookid(Integer id) {
		
		/*
		 * String jpql="select a from AvailableBook a where a.book=:boo"; UploadedBook
		 * book=null; try { book=mgr.unwrap(Session.class).createQuery(jpql,
		 * UploadedBook.class).setParameter("boo", book).getSingleResult();
		 * System.out.println(book); return book; }catch (Exception e) {
		 * System.out.println(e); } return book;
		 */
		AvailableBook temp=new AvailableBook();
		UploadedBook ubook=new UploadedBook(id);
		temp.setBook(ubook);
		System.out.println(temp);
		Example<AvailableBook> exbook =Example.of(temp);
		Optional<AvailableBook> opt=dao.findOne(exbook);
		if(opt.isPresent()) {
			return opt.get();
		}
		
		return null; 
	}

	@Override
	public boolean returnAvailableBook(UploadedBook uploadedBook,User user) {
		AvailableBook book = new AvailableBook();
		book.setBook(uploadedBook);
		book.setOwner(user);
		try{
			dao.save(book);
			return true;
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}

	
	

}
