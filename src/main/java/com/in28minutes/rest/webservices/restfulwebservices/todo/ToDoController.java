package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoController {
	private TodoService ltodo ;
	
	public ToDoController(TodoService lts) {
		this.ltodo= lts;
	}
	@GetMapping(path="/todos")
	public List<Todo> getTodos(){
		return ltodo.getAllTodos();
	}
	
	@GetMapping("/users/{username}/todos")
	public List<Todo> getUserTodos(@PathVariable String username){
		return ltodo.findByUsername( username);
	}
	@GetMapping("/users/{username}/todos/{id}")
	public Todo getUserTod( @PathVariable String username, @PathVariable Integer id) {
		return ltodo.findByUserAndId(username, id);
	}
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable Integer id){
		ltodo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
