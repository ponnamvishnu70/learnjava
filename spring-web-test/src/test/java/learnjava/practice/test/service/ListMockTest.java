package learnjava.practice.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ListMockTest {

	@Test
	public void list_sizetest() {
		List<String> mock = mock(List.class);
		
		when(mock.size()).thenReturn(444);
		assertEquals(444, mock.size());
		when(mock.get(0)).thenReturn("vishnu");
		assertEquals("vishnu", mock.get(0));
		when(mock.get(anyInt())).thenReturn("ponnam");
		assertEquals("ponnam", mock.get(6456));
		verify(mock).get(6456);
		verify(mock, times(1)).get(0);
		mock.add("vishnu");
		mock.add("ponnam");
		ArgumentCaptor<String> ac = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(ac.capture());
		assertEquals("vishnu", ac.getAllValues().get(0));
		//----------------------------------------------------------------
		System.out.println("---------");
		List<String> spy = spy(ArrayList.class);
		//System.out.println("----->" + spy.get(0));
	}

}
