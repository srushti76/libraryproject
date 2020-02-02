package com.app.P2PLibrary.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.P2PLibrary.pojos.BorrowedBook;
import com.app.P2PLibrary.pojos.UploadedBook;
import com.app.P2PLibrary.pojos.User;

@Repository
public interface IBorrowedBookDao extends JpaRepository<BorrowedBook, Integer> {
	BorrowedBook findByBook(UploadedBook book);
	
	List<BorrowedBook> findByOwner(User owner);
	List<BorrowedBook> findByBorrower(User borrower);
}
