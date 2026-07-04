package com.example.aws.todo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.aws.todo.todo.TodoItem;
import com.example.aws.todo.todo.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodoApiApplicationTests {

	@Autowired
	private TodoService todoService;

	@Test
	void contextLoads() {
		TodoItem created = this.todoService.create("Ship the app to EC2");
		assertThat(created.id()).isPositive();
		assertThat(this.todoService.findAll()).hasSize(1);
	}

}
