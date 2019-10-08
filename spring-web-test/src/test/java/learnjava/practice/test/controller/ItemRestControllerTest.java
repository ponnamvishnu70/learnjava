package learnjava.practice.test.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import learnjava.practice.dao.ItemDaoImpl;
import learnjava.practice.model.Item;
import learnjava.practice.restcontroller.ItemRestController;
import learnjava.practice.service.ItemService;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemRestController.class)
public class ItemRestControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	@MockBean
	ItemDaoImpl itemDaoImpl;
	@MockBean
	ItemService itemService;
	
	
	@Test
	public void item_basic() throws Exception {
		RequestBuilder req = MockMvcRequestBuilders.get("/item").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(req)
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().json("{\"id\":1,\"name\":\"phone\",\"price\":250,\"quantity\":5}"))
				.andReturn();
	}
	
	@Test
	public void item_dao_basic() throws Exception {
		when(itemDaoImpl.getItem()).thenReturn( new Item(1, "phone", 250, 5));
		RequestBuilder req = MockMvcRequestBuilders.get("/item-from-datalayer").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(req)
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().json("{\"id\":1,\"name\":\"phone\",\"price\":250,\"quantity\":5}"))
				.andReturn();
	}
	
	@Test
	public void item_database_basic() throws Exception {
		when(itemService.getAllItems()).thenReturn(Arrays.asList(new Item(100, "iphone3",10,25),new Item(101, "iphone5",10,25)));
		RequestBuilder req = MockMvcRequestBuilders.get("/item-from-database").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(req)
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().json("\r\n" + 
						"[{\"id\":100,\"name\":\"iphone3\",\"price\":10,\"quantity\":25,\"value\":20},{\"id\":101,\"name\":\"iphone5\",\"price\":10,\"quantity\":25,\"value\":20}]"))
				.andReturn();
	}
	
}
