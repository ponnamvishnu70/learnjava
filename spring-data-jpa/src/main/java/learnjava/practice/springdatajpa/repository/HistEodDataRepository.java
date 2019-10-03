package learnjava.practice.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learnjava.practice.springdatajpa.model.HistEodData;
import learnjava.practice.springdatajpa.model.HistEodDataId;

@Repository
public interface HistEodDataRepository extends JpaRepository<HistEodData, HistEodDataId>{
 
	
}
