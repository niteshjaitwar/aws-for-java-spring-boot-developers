package com.example.aws.todo.todo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateTodoRequest(
	@NotBlank
	@Size(max = 120)
	String title
) {
}

