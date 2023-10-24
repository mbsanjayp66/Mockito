package com.sanjay.mockito;

import java.util.ArrayList;
import java.util.List;

public class TodoBusinessImpl {
	TodoService todoService;

	public TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}
	
	public List<String>getTodoList(String user){
		List<String>filterList = new ArrayList<String>();
		for(String todo:todoService.retrieveTodos(user)) {
			if(todo.contains("Spring")) {
				filterList.add(todo);
			}
		}
		return filterList;
	}
	public void deleteTodoList(String user){
		List<String>todoList = todoService.retrieveTodos(user);
		for(String todo:todoList) {
			if(!todo.contains("Spring")) {
				todoService.deleteTodo(todo);
			}
		}
	}
}
