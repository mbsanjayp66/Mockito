package com.sanjay.mockito;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMatchers {

	@Test
	public void test() {
		List<Integer>scores = Arrays.asList(1,2,3,4,5);
		assertThat(scores,hasSize(5));
		assertThat(scores,hasItems(5,3));
	}

}
