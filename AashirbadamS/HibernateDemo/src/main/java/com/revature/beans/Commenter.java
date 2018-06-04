package com.revature.beans;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "COMMENTER")
public class Commenter implements Serializable {

	public Commenter(int commenterId, String firstName, String lastName, String email) {
		super();
		this.commenterId = commenterId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Commenter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commenter(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commenterSequence")
	@SequenceGenerator(allocationSize = 1, name = "commenterSequence", sequenceName = "SQ_COMMENTOR_PK")
	@Column(name = "COMMENTER_ID")
	private int commenterId;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "EMAIL")
	private String email;

	public int getCommenterId() {
		return commenterId;
	}

	public void setCommenterId(int commenterId) {
		this.commenterId = commenterId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Commenter [commenterId=" + commenterId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + "]";
	}

}
