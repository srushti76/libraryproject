package com.app.P2PLibrary.pojos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;

import javax.persistence.*;

@Entity
@Table(name = "user_details")
public class User{
	
	
	
	 
	@OneToMany(cascade = CascadeType.ALL,mappedBy =
	"borrower") private List<BorrowedBook> borrowedBooks;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy =
			"owner") private List<BorrowedBook> books;
	 
	
	@OneToMany(mappedBy =
			"owner") private List<AvailableBook> availableBooks = new ArrayList<AvailableBook>();
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy =
			"owner") private List<UploadedBook> uploadedBooks;
			
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Integer userid;
	
	private String firstname;
    private String lastname;
    
    @Column(unique = true)
    private String email;
    
    @Column(unique = true)
    private String phone;
    
    private String password;
    @Column(nullable = false,columnDefinition = "boolean default false")
    private boolean inactive;
    
    public User() {
    	System.out.println("in user constructor!");
    }

	public User(Integer userId, String firstName, String lastName, String email, String phone, String password) {
		super();
		this.userid = userId;
		this.firstname = firstName;
		this.lastname = lastName;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
    public Integer getUserId() {
		return userid;
	}
	public void setUserId(Integer id) {
		this.userid = id;
	}
	
	@Column(length = 20)
	public String getFirstName() {
		return firstname;
	}
	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}
	@Column(length = 20)
	public String getLastName() {
		return lastname;
	}
	public void setLastName(String lastName) {
		this.lastname = lastName;
	}
	@Email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public boolean isInactive() {
		return inactive;
	}
	public void setInactive(boolean inactive) {
		this.inactive = inactive;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userid + ", firstName=" + firstname + ", lastName=" + lastname + ", email=" + email
				+ ", phone=" + phone + ", password=" + password + ", inactive=" + inactive + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (inactive ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
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
		User other = (User) obj;
		if (inactive != other.inactive)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}

	 
	
}
