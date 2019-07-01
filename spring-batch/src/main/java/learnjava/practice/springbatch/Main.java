package learnjava.practice.springbatch;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
	    ApplicationContext app = new ClassPathXmlApplicationContext("springbatch/job/springbatch-job.xml");
		Job job = (Job) app.getBean("loadData");
		JobLauncher jl =  (JobLauncher) app.getBean("jobLauncher");
		JobParametersBuilder builder = new JobParametersBuilder();		
		builder.addDate("date", new Date());			
		JobExecution je = jl.run(job,builder.toJobParameters());		
		System.out.println(je.getExitStatus());
		((ClassPathXmlApplicationContext)app).close();
	}
}
