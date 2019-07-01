package learnjava.practice.springbatch.decider;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

public class EvenOddDecider implements JobExecutionDecider {

	public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
		if(jobExecution.getId()%2==0) {
			jobExecution.getExecutionContext().put("EVEN", true);
			return new FlowExecutionStatus("EVEN");
		}
		return new FlowExecutionStatus("ODD");
	}

}
