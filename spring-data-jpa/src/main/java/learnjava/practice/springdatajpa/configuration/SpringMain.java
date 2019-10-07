package learnjava.practice.springdatajpa.configuration;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import learnjava.practice.springdatajpa.model.HistEodData;
import learnjava.practice.springdatajpa.model.HistEodDataId;
import learnjava.practice.springdatajpa.repository.HistEodDataRepository;

@SpringBootApplication

public class SpringMain implements CommandLineRunner{

	@Autowired
	 HistEodDataRepository histEodDataRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMain.class, args);
		
	}

	public void run(String... args) throws Exception {
		System.out.println("HELLOOOOOOOOOOOOOOOOOOOOO the count is "+histEodDataRepository.count());
		HistEodDataId id= new HistEodDataId("MU", LocalDate.parse( "1984-12-27"));
		//Optional<HistEodData> findById = histEodDataRepository.findById(id);
		//System.out.println(findById.get().getVolume());
		//List<HistEodData> findAll = histEodDataRepository.findAll();
		//findAll.forEach(s->{ System.out.println(s.getDate()) ;});
		//List<HistEodData> findByTickerAndOpenPriceGreaterThan = histEodDataRepository.findByTickerAndOpenPriceGreaterThan("MDT", 90);
		//findByTickerAndOpenPriceGreaterThan.forEach(s->{System.out.println(s.getTicker() +" --> "+ s.getOpenPrice());});
		//List<HistEodData> findByTickerAndOpenPriceLessThan = histEodDataRepository.findByTickerAndOpenPriceLessThan("MDT", 100);
		//findByTickerAndOpenPriceLessThan.forEach(s->{System.out.println("less than"+s.getTicker() +" --> "+ s.getOpenPrice());});
		List<HistEodData> findByVolumenumber = histEodDataRepository.findByVolume(123456);
		findByVolumenumber.forEach(s->{System.out.println(s.getTicker());});
	
	}
	
}
