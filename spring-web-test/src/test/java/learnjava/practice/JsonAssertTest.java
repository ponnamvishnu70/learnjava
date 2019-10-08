package learnjava.practice;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
	String actualResp ="{\"id\":1,\"name\":\"phone\",\"price\":250,\"quantity\":5}";
	
	@Test
	public void jsonAssert() throws JSONException {
		String expResp="{\"id\":1,\"name\":\"phone\",\"price\":250,\"quantity\":5}";
		//strict = true will only allow spaces but if there is a missing element then junit fails
		JSONAssert.assertEquals(expResp, actualResp, true);
	}
	
	@Test
	public void jsonAssert_false() throws JSONException {
		String expResp="{id: 1, name: phone,price: 250,quantity: 5}";
		//strict = false will allow spaces and missing elements and pinpoints the error
		JSONAssert.assertEquals(expResp, actualResp, false);
	}


}
