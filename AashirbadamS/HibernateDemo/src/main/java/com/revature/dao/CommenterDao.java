package com.revature.dao;

import java.util.List;
import java.util.Locale.Category;

import com.revature.beans.Commenter;

public interface CommenterDao {
	public List<Commenter> getCommenter();

	public Commenter getCommenterById(int id);

	public int addCommenter(Commenter c);

	public void updateCommenter(Commenter c);

	public void deleteCommenter(Commenter c);

}
