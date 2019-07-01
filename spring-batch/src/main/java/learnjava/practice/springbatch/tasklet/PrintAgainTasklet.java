package learnjava.practice.springbatch.tasklet;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class PrintAgainTasklet implements Tasklet {
	AtomicInteger ai = new AtomicInteger(0);

	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
			
			if(chunkContext.getStepContext().getJobExecutionContext().get("EVEN")!=null) {
			System.out.println("The joib id is even number");
			}else {
				System.out.println("The joib id is odd number");
			}
		return RepeatStatus.FINISHED;
	}

}
