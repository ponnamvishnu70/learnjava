package learnjava.practice.dao;

import org.springframework.stereotype.Component;

import learnjava.practice.model.Item;
@Component
public class ItemDaoImpl {
	
	public Item getItem() {
		return new Item(1, "phone", 250, 5);
	}

}
