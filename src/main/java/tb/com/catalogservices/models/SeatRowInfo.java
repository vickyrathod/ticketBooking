package tb.com.catalogservices.models;

import java.util.Map;

public class SeatRowInfo {
	
	private Map<String, SeatInfo> rows;

	public Map<String, SeatInfo> getRows() {
		return rows;
	}

	public void setRows(Map<String, SeatInfo> rows) {
		this.rows = rows;
	}
}
