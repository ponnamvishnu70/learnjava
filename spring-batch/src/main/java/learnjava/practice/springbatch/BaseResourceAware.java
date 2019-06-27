package learnjava.practice.springbatch;

import org.springframework.batch.item.ResourceAware;
import org.springframework.core.io.Resource;

public class BaseResourceAware implements ResourceAware {
	Resource resource;

	public void setResource(Resource resource) {
		this.resource = resource;
	}
	
	public Resource getResource() {
		return this.resource ;
	}

}
