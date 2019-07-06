package learnjava.practice.springbatch.tasklet;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.MultiResourceItemReader;

import learnjava.practice.springbatch.model.EodData;

public class CustomReader implements ItemReader<EodData>{//, ItemStream {
	
	MultiResourceItemReader<EodData> delegate;
	int count=0;
	@BeforeStep
	public void initialization(StepExecution spe) {		
	
		System.out.println("printing from before step"+count);
		System.out.println(spe.getId());
		count++;
	} 

	public synchronized EodData read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.print(Thread.currentThread().getName()+"----------");
		count++;
		EodData ed = delegate.read();
		
		return ed;
	}
	
	public MultiResourceItemReader<EodData> getDelegate() {
		return delegate;
	}

	public void setDelegate(MultiResourceItemReader<EodData> delegate) {
		this.delegate = delegate;
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
