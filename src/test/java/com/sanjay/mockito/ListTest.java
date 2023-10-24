package com.sanjay.mockito;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void test() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
	}
	
	@Test
	public void testForGetReturn() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenReturn("Sanjay");
		assertEquals("Sanjay", listMock.get(0));
		assertEquals("Sanjay", listMock.get(1));
		assertEquals("Sanjay", listMock.get(2));
	}

}
