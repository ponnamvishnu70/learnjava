package learnjava.practice;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestAssertTest {
	
	@Test
	public void learning() {
		List<Integer> numbers = Arrays.asList(3,44,55);
		assertThat(numbers,hasSize(3));
		assertThat(numbers,hasItems(44,55));
		assertThat(numbers, everyItem(greaterThan(2)));
	}

}
