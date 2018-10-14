package tb.com.catalogservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tb.com.catalogservices.models.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
	
}
