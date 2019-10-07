package learnjava.practice.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import learnjava.practice.model.Item;

@RestController
public class ItemRestController {

	
	@GetMapping("/item")
	public Item getItem() {
		return new Item(1, "phone", 250, 5);
	}
}
