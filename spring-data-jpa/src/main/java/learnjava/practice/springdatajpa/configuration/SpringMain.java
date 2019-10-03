package learnjava.practice.springdatajpa.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import learnjava.practice.springdatajpa.repository.HistEodDataRepository;

@SpringBootApplication
public class SpringMain implements CommandLineRunner{

	@Autowired
	 HistEodDataRepository histEodDataRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMain.class, args);
		
	}

	public void run(String... args) throws Exception {
		System.out.println(histEodDataRepository.count());
	}
	
}
