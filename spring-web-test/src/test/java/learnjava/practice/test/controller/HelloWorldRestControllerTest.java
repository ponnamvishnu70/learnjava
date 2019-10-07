package learnjava.practice.test.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import learnjava.practice.restcontroller.HelloWorldRestController;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldRestController.class)
public class HelloWorldRestControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void helloWorld_basic() throws Exception {
		RequestBuilder req = MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON);
		// MvcResult result = mockMvc.perform(req).andReturn();
		MvcResult result = mockMvc.perform(req)
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().string("Hello World"))
				.andReturn();
//		assertEquals("Hello World", result.getResponse().getContentAsString());
	}

}
