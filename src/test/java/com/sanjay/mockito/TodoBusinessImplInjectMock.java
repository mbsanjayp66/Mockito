package com.sanjay.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;


@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplInjectMock {
	
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	
	@Mock
	TodoService todoServiceMock;
	
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;
	
	@Captor
	ArgumentCaptor<String>stringArgumentCaptor;
	

	@Test
	public void test() {
		
		when(todoServiceMock.retrieveTodos("dummy")).thenReturn(Arrays.asList("Learn Spring Mvc","Learn Spring","Learn Mockito"));
		List<String>filtered = todoBusinessImpl.getTodoList("dummy");
		assertEquals(2, filtered.size());
		assertThat(filtered.size(),is(2));
	}
	
	@Test
	public void testForDelete() {
		
		when(todoServiceMock.retrieveTodos("dummy")).thenReturn(Arrays.asList("Learn Spring Mvc","Learn Spring","Learn Mockito"));
		List<String>filtered = todoBusinessImpl.getTodoList("dummy");
		
		todoBusinessImpl.deleteTodoList("dummy");
		
		verify(todoServiceMock).deleteTodo("Learn Mockito");
		
		assertEquals(2, filtered.size());
		assertThat(filtered.size(),is(2));
	}
	
	@Test
	public void testForArgumentCapturing() {
		
		when(todoServiceMock.retrieveTodos("dummy")).thenReturn(Arrays.asList("Learn Spring Mvc","Learn Spring","Learn Mockito"));
		List<String>filtered = todoBusinessImpl.getTodoList("dummy");
		
		todoBusinessImpl.deleteTodoList("dummy");
		
		//verify(todoServiceMock).deleteTodo("Learn Spring Mvc");
		
		assertEquals(2, filtered.size());
		assertThat(filtered.size(),is(2));
	}

}
