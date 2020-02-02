package com.app.P2PLibrary.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.P2PLibrary.pojos.AvailableBook;
import com.app.P2PLibrary.pojos.User;

@Repository
public interface IAvailableBookDao extends JpaRepository<AvailableBook, Integer> {
	List<AvailableBook> findByOwner(User owner);
	@Query("select a from AvailableBook a where a.owner!=?1")
	List<AvailableBook> findByOwnerNot(User owner);
	
	/*
	 * @Query("select a from AvailableBook a where a.book=?1 and a.owner!=?2")
	 * List<AvailableBook> findByBookAndOwnerNot(UploadedBook book,User owner);
	 */
}
