package learnjava.practice.springbatch.listeners;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class LoadDataStepListener implements StepExecutionListener {

	public void beforeStep(StepExecution stepExecution) {
		System.out.println("before step begins");		
	}

	public ExitStatus afterStep(StepExecution stepExecution) {
		System.out.println("after step complete");
		return new ExitStatus("STEP_COMPLETE");
	}

	
}
