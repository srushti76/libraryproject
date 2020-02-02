package com.app.P2PLibrary.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "borrowed_books")
public class BorrowedBook{
	
	@ManyToOne
	@JoinColumn(name = "borrowerid")
	@JsonIgnore
	private User borrower;
	
	@ManyToOne
	@JoinColumn(name = "ownerid")
	@JsonIgnore
	private User owner;
	
	@OneToOne
	@JoinColumn(name = "bookid")
	@JsonIgnore
	private UploadedBook book;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer borrowedbookid;
	
	@Column(nullable = false,columnDefinition = "boolean default false")
	private boolean confirmed;
	
	public BorrowedBook() {
    	System.out.println("in book constr.");
    }

	
	

	public BorrowedBook(User owner, User borrower, UploadedBook book, boolean confirmed) {
		super();
		this.borrower = borrower;
		this.owner = owner;
		this.book = book;
		this.confirmed = confirmed;
	}





	
	
	public User getOwner() {
		return owner;
	}


	public void setOwner(User owner) {
		this.owner = owner;
	}


	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public UploadedBook getBook() {
		return book;
	}

	public void setBook(UploadedBook book) {
		this.book = book;
	}

	public Integer getBorrowedbookid() {
		return borrowedbookid;
	}

	public void setBorrowedbookid(Integer borrowedbookid) {
		this.borrowedbookid = borrowedbookid;
	}


	@Override
	public String toString() {
		return "BorrowedBook [borrower=" + borrower + ", owner=" + owner + ", book=" + book + ", confirmed=" + confirmed
				+ "]";
	}


	public User getBorrower() {
		return borrower;
	}




	public void setBorrower(User borrower) {
		this.borrower = borrower;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + (confirmed ? 1231 : 1237);
		result = prime * result + ((borrower == null) ? 0 : borrower.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BorrowedBook other = (BorrowedBook) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (confirmed != other.confirmed)
			return false;
		if (borrower == null) {
			if (other.borrower != null)
				return false;
		} else if (!borrower.equals(other.borrower))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}

	
	
}
