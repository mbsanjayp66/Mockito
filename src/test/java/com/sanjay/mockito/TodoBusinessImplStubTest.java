package com.sanjay.mockito;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TodoBusinessImplStubTest {

	@Test
	public void test() {
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(new TodoServiceStub());
		List<String>filtered = todoBusinessImpl.getTodoList("Spring");
		assertEquals(2, filtered.size());
	}

}
