package tb.com.catalogservices.models;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TheaterPostRequest {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("seatInfo")
	private Map<String, SeatInfo> rows;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, SeatInfo> getRows() {
		return rows;
	}
	public void setRows(Map<String, SeatInfo> rows) {
		this.rows = rows;
	}
	
}
