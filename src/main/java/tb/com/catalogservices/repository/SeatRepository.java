package tb.com.catalogservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tb.com.catalogservices.models.Seat;

public interface SeatRepository  extends JpaRepository<Seat, String> {
	
	@Query(value = "SELECT * FROM seat where theatername = ?1 and reservation = ?2", nativeQuery = true)
	List<Seat> getReserveSeats(String theaterName, boolean reservation);

}
