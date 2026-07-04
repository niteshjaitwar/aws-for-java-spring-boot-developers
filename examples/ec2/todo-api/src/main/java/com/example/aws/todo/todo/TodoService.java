package com.example.aws.todo.todo;

import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private final AtomicLong sequence = new AtomicLong();
	private final Map<Long, TodoItem> todos = new ConcurrentHashMap<>();

	public List<TodoItem> findAll() {
		return this.todos.values().stream()
			.sorted(Comparator.comparing(TodoItem::id))
			.toList();
	}

	public TodoItem create(String title) {
		long id = this.sequence.incrementAndGet();
		TodoItem item = new TodoItem(id, title.trim(), false, Instant.now());
		this.todos.put(id, item);
		return item;
	}

	public TodoItem toggle(long id) {
		TodoItem current = this.todos.get(id);
		if (current == null) {
			throw new TodoNotFoundException(id);
		}

		TodoItem updated = new TodoItem(current.id(), current.title(), !current.completed(), current.createdAt());
		this.todos.put(id, updated);
		return updated;
	}
}
