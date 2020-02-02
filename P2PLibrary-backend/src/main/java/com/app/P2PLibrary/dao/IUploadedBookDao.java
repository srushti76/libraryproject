package com.app.P2PLibrary.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.P2PLibrary.pojos.UploadedBook;

@Repository
public interface IUploadedBookDao extends JpaRepository<UploadedBook, Integer> {

}
