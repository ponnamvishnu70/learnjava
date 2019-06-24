package learnjava.practice.springbatch.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class PrintTasklet implements Tasklet {

	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
			System.out.println(contribution.getReadCount());
			
			if(chunkContext.getStepContext().getStepName().equals("print1")) {
				System.out.println("print1 step");
				return RepeatStatus.FINISHED;
			}
		return RepeatStatus.FINISHED;
	}

}
