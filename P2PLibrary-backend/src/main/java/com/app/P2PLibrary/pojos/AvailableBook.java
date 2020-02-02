package com.app.P2PLibrary.pojos;

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
@Table(name = "available_books")
public class AvailableBook{
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
	private Integer availablebookid;
	
	public AvailableBook() {
	   	System.out.println("in book constr.");
	}
	
	

	public AvailableBook(User owner, UploadedBook book, Integer availablebookid) {
		super();
		this.owner = owner;
		this.book = book;
		this.availablebookid = availablebookid;
	}



	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public UploadedBook getBook() {
		return book;
	}

	public void setBook(UploadedBook book) {
		this.book = book;
	}

	public Integer getAvailablebookid() {
		return availablebookid;
	}

	public void setAvailablebookid(Integer availablebookid) {
		this.availablebookid = availablebookid;
	}



	@Override
	public String toString() {
		return "AvailableBook [owner=" + owner + ", book=" + book + ", availablebookid=" + availablebookid + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
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
		AvailableBook other = (AvailableBook) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}
	
	public boolean equalsByCategory(String category) {
		if(this.book.getCategory().equalsIgnoreCase(category)){
			System.out.println(this.book.getCategory()+category);
			return true;
			
		}
			
		else
			return false;
	}
	
	public boolean equalsByLanguage(String language) {
		if(this.book.getLanguage().equalsIgnoreCase(language)){
			return true;			
		}			
		else
			return false;
	}
	
	public boolean equalsByAuthor(String author) {
		if(this.book.getAuthor().equalsIgnoreCase(author)){
			return true;			
		}			
		else
			return false;
	}
	
	public boolean equalsByTitle(String title) {
		if(this.book.getTitle().equalsIgnoreCase(title)){
			return true;			
		}			
		else
			return false;
	}
			
        
		
}

