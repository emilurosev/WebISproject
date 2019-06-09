package lms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Where;

@Entity
public class Administrator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	@Column(length = 128, nullable = false)
	private String firstname;

	@Column(length = 128, nullable = false)
	private String lastname;
	
	@OneToOne
    @MapsId
    private User user;
	
	private String note;
	
	
	
	


	public Administrator(Long id, String firstname, String lastname, User user, String note) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.user = user;
		this.note = note;
	}



	public Administrator(Long id, String firstname, String lastname, String note) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.note = note;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getNote() {
		return note;
	}



	public void setNote(String note) {
		this.note = note;
	}

	


	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Administrator() {}
	
	
	
}
