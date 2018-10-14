package tb.com.catalogservices.models;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SeatResponse {
	@JsonProperty("seats")
	private Map<String, List<Integer>> seats;

	public Map<String, List<Integer>> getSeats() {
		return seats;
	}

	public void setSeats(Map<String, List<Integer>> seats) {
		this.seats = seats;
	}
}
