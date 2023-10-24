package com.sanjay.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TodoBusinessImplMockTest {

	@Test
	public void test() {
		
		TodoService todoServiceMock = mock(TodoService.class);
		when(todoServiceMock.retrieveTodos("dummy")).thenReturn(Arrays.asList("Learn Spring Mvc","Learn Spring","Learn Mockito"));
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String>filtered = todoBusinessImpl.getTodoList("dummy");
		assertEquals(2, filtered.size());
		assertThat(filtered.size(),is(2));
	}
	
	@Test
	public void testForDelete() {
		
		TodoService todoServiceMock = mock(TodoService.class);
		when(todoServiceMock.retrieveTodos("dummy")).thenReturn(Arrays.asList("Learn Spring Mvc","Learn Spring","Learn Mockito"));
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String>filtered = todoBusinessImpl.getTodoList("dummy");
		
		todoBusinessImpl.deleteTodoList("dummy");
		
		verify(todoServiceMock).deleteTodo("Learn Mockito");
		
		assertEquals(2, filtered.size());
		assertThat(filtered.size(),is(2));
	}
	
	@Test
	public void testForArgumentCapturing() {
		
		TodoService todoServiceMock = mock(TodoService.class);
		when(todoServiceMock.retrieveTodos("dummy")).thenReturn(Arrays.asList("Learn Spring Mvc","Learn Spring","Learn Mockito"));
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String>filtered = todoBusinessImpl.getTodoList("dummy");
		
		todoBusinessImpl.deleteTodoList("dummy");
		
		verify(todoServiceMock).deleteTodo("Learn Spring Mvc");
		
		assertEquals(2, filtered.size());
		assertThat(filtered.size(),is(2));
	}

}
