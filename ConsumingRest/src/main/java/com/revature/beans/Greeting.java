package com.revature.beans;

public class Greeting {

	private int id;
    private String content;

    public Greeting(int id, String content) {
        this.id = id;
        this.content = content;
    }
    
    public Greeting(String content) {
    	this.content = content;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
        return content;
    }
}
