package tb.com.catalogservices.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seat")
public class Seat {

	@Id
	@Column(name = "id")
	String id;
	
	@Column(name="number")
	int number;
	
	@Column(name = "row")
	String row;
	
	@Column(name = "theatername")
	String theaterName;

	@Column(name = "moviename")
	String movieName;
	
	@Column(name = "reservation")
	boolean reservation;
	
	@Column(name = "isle")
	boolean isle;

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public boolean isReservation() {
		return reservation;
	}

	public void setReservation(boolean reservation) {
		this.reservation = reservation;
	}

	public boolean isIsle() {
		return isle;
	}

	public void setIsle(boolean isle) {
		this.isle = isle;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
}
