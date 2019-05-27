package lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.domain.Center;

@Repository
public interface CenterRepository extends JpaRepository<Center, Long>{
	List<Center> findByName(String name);
	
}
