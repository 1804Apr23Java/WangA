package com.revature.beans;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENT")
public class Comment implements Serializable {

	public Comment(int commentId, String comment, Commenter commenter) {
		super();
		this.commentId = commentId;
		this.comment = comment;
		this.commenter = commenter;
	}

	public Comment(String comment, Commenter commenter) {
		super();
		this.comment = comment;
		this.commenter = commenter;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -762568776377125312L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commentSequence")
	@SequenceGenerator(allocationSize = 1, name = "commentSequence", sequenceName = "SQ_COMMENT_PK")
	@Column(name = "COMMENT_ID")
	private int commentId;

	@Column(name = "COMMENT")
	private String comment;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COMMENTER_ID")
	private Commenter commenter;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Commenter getCommenter() {
		return commenter;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + ", commenter=" + commenter + "]";
	}

}
