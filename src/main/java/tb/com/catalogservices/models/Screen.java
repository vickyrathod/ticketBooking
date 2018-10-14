package tb.com.catalogservices.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "screen")
public class Screen {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	long id;
	
	@Column(name = "theaterid")
	long theaterId;
	
	@Column(name = "movieid")
	long movieid;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(long theaterId) {
		this.theaterId = theaterId;
	}

	public long getMovieid() {
		return movieid;
	}

	public void setMovieid(long movieid) {
		this.movieid = movieid;
	}
	
}
