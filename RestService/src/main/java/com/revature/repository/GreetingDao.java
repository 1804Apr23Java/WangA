package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Greeting;

@Repository
public interface GreetingDao extends JpaRepository<Greeting,Integer> {

	public Greeting findGreetingById(int id);
	
	public Greeting save(); //create or update greeting
	
	public void deleteById(int id);

}