package tb.com.catalogservices.models;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReserveRequest {
	
	private String theaterName;
	
	@JsonProperty("seats")
	private Map<String, List<Integer>> seats;

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public Map<String, List<Integer>> getSeats() {
		return seats;
	}

	public void setSeats(Map<String, List<Integer>> seats) {
		this.seats = seats;
	}
}
