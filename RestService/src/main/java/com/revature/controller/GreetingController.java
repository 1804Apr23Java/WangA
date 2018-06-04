package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Greeting;
import com.revature.repository.GreetingDao;

@RestController
public class GreetingController {
	
	@Autowired
	GreetingDao gd;

    private static final String template = "Hello, %s!";

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="id") int id, @RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(id, String.format(template, name));
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Greeting> getGreetingById(@PathVariable int id) {
		ResponseEntity<Greeting> resp = new ResponseEntity<>(gd.findGreetingById(id), HttpStatus.OK);
		return resp;
	}
}
