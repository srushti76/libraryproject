package com.app.P2PLibrary.pojos;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "uploaded_books")
public class UploadedBook{
	
	@ManyToOne
	@JoinColumn(name = "userid")
	@JsonIgnore
	private User owner;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookid;
	
	private String title;
	private String author;
	private String publisher;
	private String language;
	private String category;
    
    public UploadedBook() {
    	System.out.println("in book constr.");
    }
   
    

	public UploadedBook(Integer bookId, String title, String author, String publisher, String language, String category) {
		super();
		this.bookid = bookId;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.language = language;
		this.category = category;
	}
	
	



	public UploadedBook(Integer bookid) {
		super();
		this.bookid = bookid;
	}



	public Integer getBookid() {
		return bookid;
	}

	public void setBookid(Integer id) {
		bookid = id;
	}
	
	@Column(length = 50)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(length = 20)
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	public User getOwner() {
		return owner;
	}



	public void setOwner(User owner) {
		this.owner = owner;
	}



	@Override
	public String toString() {
		return "Book [user=" + ", bookid=" + bookid + ", title=" + title + ", author=" + author + ", publisher="
				+ publisher + ", language=" + language + ", category=" + category +"]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookid == null) ? 0 : bookid.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		UploadedBook other = (UploadedBook) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookid == null) {
			if (other.bookid != null)
				return false;
		} else if (!bookid.equals(other.bookid))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
    
    
    
	
	
}
