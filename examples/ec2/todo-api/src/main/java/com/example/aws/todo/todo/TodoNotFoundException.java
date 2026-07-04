package com.example.aws.todo.todo;

public class TodoNotFoundException extends RuntimeException {

	public TodoNotFoundException(long id) {
		super("Todo item %d was not found".formatted(id));
	}
}

