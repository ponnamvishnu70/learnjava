package learnjava.practice.springbatch.tasklet;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.MultiResourceItemReader;

import learnjava.practice.springbatch.model.EodData;

public class CustomReader implements ItemReader<EodData>{//, ItemStream {
	MultiResourceItemReader<EodData> delegate;
	String READ_COUNT = "read.count";

	public MultiResourceItemReader<EodData> getDelegate() {
		return delegate;
	}

	public void setDelegate(MultiResourceItemReader<EodData> delegate) {
		this.delegate = delegate;
	}

	public synchronized EodData read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		EodData ed = delegate.read();
	
		System.out.print("Thread name is " + Thread.currentThread().getName() + "-----");
		return ed;
	}

	public void open(ExecutionContext executionContext) throws ItemStreamException {
		this.delegate.close();
		
	}

	public void update(ExecutionContext executionContext) throws ItemStreamException {
		this.delegate.update(executionContext);
		
	}

	public void close() throws ItemStreamException {
		this.delegate.close();
	}



}
