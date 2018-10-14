package tb.com.catalogservices.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SeatInfo {
		
	    @JsonProperty("numberOfSeats")
		private int numberOfSeats;
	    
	    @JsonProperty("aisleSeats")
		private List<Integer> aisleSeats;
		
		
		public int getNumberOfSeats() {
			return numberOfSeats;
		}
		public void setNumberOfSeats(int numberOfSeats) {
			this.numberOfSeats = numberOfSeats;
		}
		public List<Integer> getAisleSeats() {
			return aisleSeats;
		}
		public void setAisleSeats(List<Integer> aisleSeats) {
			this.aisleSeats = aisleSeats;
		}
		
		
}
