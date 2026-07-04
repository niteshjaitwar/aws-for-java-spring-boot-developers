package com.example.aws.todo.todo;

import java.net.URI;
import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

	private final TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping
	public List<TodoItem> findAll() {
		return this.todoService.findAll();
	}

	@PostMapping
	public ResponseEntity<TodoItem> create(@Valid @RequestBody CreateTodoRequest request) {
		TodoItem created = this.todoService.create(request.title());
		return ResponseEntity.created(URI.create("/api/todos/" + created.id())).body(created);
	}

	@PatchMapping("/{id}/toggle")
	public TodoItem toggle(@PathVariable long id) {
		return this.todoService.toggle(id);
	}
}

