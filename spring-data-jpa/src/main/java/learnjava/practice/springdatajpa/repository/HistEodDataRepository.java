package learnjava.practice.springdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import learnjava.practice.springdatajpa.model.HistEodData;
import learnjava.practice.springdatajpa.model.HistEodDataId;

@Repository
public interface HistEodDataRepository extends JpaRepository<HistEodData, HistEodDataId>{
 
	
	List<HistEodData> findByTickerAndOpenPriceGreaterThan(String ticker, double openPrice);
	List<HistEodData> findByTickerAndOpenPriceLessThan(String ticker, double openPrice);
	
	@Query("SELECT h FROM HIST_EOD_DATA h WHERE h.volume = :volume")
	List<HistEodData> findByVolume(@Param("volume") long volume);
	
	
}
