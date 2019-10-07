package learnjava.practice.test.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import learnjava.practice.data.SomeData;
import learnjava.practice.service.CalculatorService;


@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceTest {

	@InjectMocks
	CalculatorService cs = new CalculatorService();

	@Mock
	SomeData someData;

	@Test
	public void sum_basic() {
		when(someData.getData()).thenReturn(new int[] { 1, 2, 3 });
		assertEquals(6, cs.sum());
	}
	
	@Test
	public void sum_empty() {
		when(someData.getData()).thenReturn(new int[] {  });
		assertEquals(0, cs.sum());
	}
	
	@Test
	public void sum_singledigit() {
		when(someData.getData()).thenReturn(new int[] { 10 });
		assertEquals(10, cs.sum());
	}
	
	
	

}
