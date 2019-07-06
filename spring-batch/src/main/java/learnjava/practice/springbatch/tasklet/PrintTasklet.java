package learnjava.practice.springbatch.tasklet;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class PrintTasklet implements Tasklet {
	AtomicInteger ai = new AtomicInteger(0);

	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
			
			if(ai.intValue()<10) {
				ai.set(ai.incrementAndGet());
				System.out.println(Thread.currentThread().getName() + " ai vlaue is "+ ai.intValue()+" *********");				
				return RepeatStatus.CONTINUABLE;
			}
		return RepeatStatus.FINISHED;
	}

}
