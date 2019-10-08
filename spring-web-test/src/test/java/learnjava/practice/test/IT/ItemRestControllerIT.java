package learnjava.practice.test.IT;

import static org.junit.Assert.assertEquals;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemRestControllerIT {

	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Test
	public void gellAllItems() throws JSONException {
		String allItems = testRestTemplate.getForObject("/item-from-database", String.class);
	//JSONAssert.assertEquals("[{id:100},{id:101}]",allItems, false);
		DocumentContext ctx = JsonPath.parse(allItems);
		int length = ctx.read("$.length()");
		System.out.println("length of array"+length);
		System.out.println((ctx.read("$..id").toString()));
		System.out.println((ctx.read("$.[1]").toString()));
		assertEquals(2, length);
	
	}
}
