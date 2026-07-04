package com.example.aws.todo.todo;

import java.time.Instant;

public record TodoItem(
	long id,
	String title,
	boolean completed,
	Instant createdAt
) {
}

