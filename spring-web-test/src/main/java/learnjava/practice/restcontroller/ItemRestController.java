package learnjava.practice.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import learnjava.practice.dao.ItemDaoImpl;
import learnjava.practice.model.Item;
import learnjava.practice.service.ItemService;

@RestController
public class ItemRestController {

	@Autowired
	ItemDaoImpl itemDaoImpl;
	
	@Autowired
	ItemService itemService;
	
	@GetMapping("/item")
	public Item getItem() {
		return new Item(1, "phone", 250, 5);
	}
	
	@GetMapping("/item-from-datalayer")
	public Item getItemFromDataLayer() {
		return itemDaoImpl.getItem();
	}
	
	@GetMapping("/item-from-database")
	public List<Item> getAllItemFromDatabase() {
		 List<Item> allItems = itemService.getAllItems();
		allItems.forEach(i->{
			i.setValue(i.getPrice()*2);
		});
		return allItems;
	}
}
