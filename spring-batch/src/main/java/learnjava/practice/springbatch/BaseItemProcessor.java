package learnjava.practice.springbatch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.core.io.Resource;

import learnjava.practice.springbatch.model.EodData;

public class BaseItemProcessor implements ItemProcessor<EodData,EodData>{

	public EodData process(EodData item) throws Exception {
		Resource location = item.getResource();
		String ticker = location.getFilename().split("\\.")[0];
		item.setTicker(ticker);
		return item;
	}

}
