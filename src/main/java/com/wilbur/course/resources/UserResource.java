package com.wilbur.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilbur.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findaAll(){
		User u = new User(1L, "Maria", "Maria@gmail.com", "11999183558", "123456");
		return ResponseEntity.ok().body(u);
	}
	
}
