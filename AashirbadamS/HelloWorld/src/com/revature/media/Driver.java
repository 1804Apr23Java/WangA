package com.revature.media;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main (String[] args) {
		
		List<Media> mediaList = new ArrayList<Media>();
		Book b1= new Book("Elie","Night",1960,"memoir");
		Book b2=new Book ("Ben Carson", "Gigter Hands", 1996,"autobiography");
		Movie m1= new Movie("Steven Spielberg", "jaws", 1975,"horror");
		Movie m2 = new Movie("David Michael Latt", "Sharknado", 2013, "science fiction");
		
		mediaList.add(b1);
		mediaList.add(m1);
		mediaList.add(b2);		
		mediaList.add(m2);
		
		//funWithReflections();
		
		System.out.println(genericReflections(mediaList));
		
	
				
	}
	//return the first Book from the media list, if it exits 
/*	public static<T>T genericReflections(List<T>l){
		for (T item:l) {
			if(item.getClass().getName().equals("com.revature.media.Book"));
			return item;
		}
		return null;
	}*/
	
	public static<T> List<T> genericReflections(List<T>l){
		List<T> newList = new ArrayList<T>();
		for (T item:l) {
			if(item.getClass().getName().equals("com.revature.media.Book"));
			newList.add(item);
		}
		return newList;
	}
	
	//What if we don't have type safety
	
/*	public static List<Object> objectReflections(List<Object> l){
		List<T> newList = new ArrayList<T>();
		for (Object item:l) {
			if(item.getClass().getName().equals("com.revature.media.Book"));
			newList.add(item);
		}
		return newList;
	}*/
	public static void funWithReflections() {
		
		try {
			Class clazz = Class.forName("com.revature.media.Book");
			System.out.println(clazz.getSimpleName());
			//print our declared fields
			Field[] fields=clazz.getDeclaredFields();
			for(Field f: fields) {
				System.out.println(f.getName() +f.getType());
			}
			
			Book b3= (Book) clazz.newInstance();
			Field author = clazz.getDeclaredField("author");
			author.setAccessible(true);
			author.set(b3,"Michael Bay");
			System.out.println(b3);
			
		}catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException c) {
			c.printStackTrace();
		}
	}
}
