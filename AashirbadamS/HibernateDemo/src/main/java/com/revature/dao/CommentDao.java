package com.revature.dao;

import java.util.List;

import com.revature.beans.Comment;

public interface CommentDao {
	
	public List<Comment> getComment();

    public Comment getCommentyById(int id);

    public int addComment(Comment c);

    public void updateComment(Comment c);

    public void deleteComment(Comment c);

}
