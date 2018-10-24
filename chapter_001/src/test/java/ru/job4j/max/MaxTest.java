package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
	
	@Test
    public void whenFirstLessSecond() {
		Max maxim = new Max();
		int result = maxim.max(1, 2);
		assertThat(result, is(2));
		}
		
	@Test
    public void whenFirstGreaterSecond() {
		Max maxim = new Max();
		int result = maxim.max(2, 1);
		assertThat(result, is(2));
		}

	@Test
	public void whenFirstGreaterSecondAndThird() {
		Max maxim = new Max();
		int result = maxim.maxofthree(8, 5, 2);
		assertThat(result, is(8));
	}

	@Test
	public void whenSecondGreaterFirstAndThird() {
		Max maxim = new Max();
		int result = maxim.maxofthree(2, 8, 5);
		assertThat(result, is(8));
	}

	@Test
	public void whenThirdGreaterFirstAndSecond() {
		Max maxim = new Max();
		int result = maxim.maxofthree(2, 5, 8);
		assertThat(result, is(8));
	}
}