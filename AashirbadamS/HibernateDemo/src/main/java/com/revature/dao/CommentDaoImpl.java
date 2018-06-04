package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.Util.HibernateUtil;
import com.revature.beans.Comment;

public class CommentDaoImpl implements CommentDao {

	@Override
	public List<Comment> getComment() {
		// TODO Auto-generated method stub
		List<Comment> comment = new ArrayList<>();
		Session s = HibernateUtil.getSession();
		comment = s.createQuery("from Comment").list();
		s.close();
		return comment;
	}

	@Override
	public Comment getCommentyById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addComment(Comment c) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int result = (int) s.save(c);
		tx.commit();
		s.close();

		return result;
	}

	@Override
	public void updateComment(Comment c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteComment(Comment c) {
		// TODO Auto-generated method stub

	}

}
