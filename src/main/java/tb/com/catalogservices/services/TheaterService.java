package tb.com.catalogservices.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import tb.com.catalogservices.models.Seat;
import tb.com.catalogservices.models.SeatInfo;
import tb.com.catalogservices.models.SeatRowInfo;
import tb.com.catalogservices.models.Theater;
import tb.com.catalogservices.models.TheaterPostRequest;
import tb.com.catalogservices.repository.SeatRepository;
import tb.com.catalogservices.repository.TheaterRepository;

@ComponentScan
@Service
public class TheaterService {

	@Autowired
	private TheaterRepository theaterRepository;

	@Autowired
	private SeatRepository seatRepository;

	public boolean addTheater(TheaterPostRequest theaterPostRequest) {

		try {

			Theater theater = new Theater();

			if (theaterPostRequest.getName() == null || theaterPostRequest.getName().equals("")) {
				return false;
			}

			theater.setTheaterName(theaterPostRequest.getName());
			Map<String, SeatInfo> sifMap = theaterPostRequest.getRows();

			int totalSeats = 0;

			if (sifMap == null || sifMap.isEmpty()) {
				return false;
			}

			for (Entry e : sifMap.entrySet()) {
				String row = (String) e.getKey();
				SeatInfo sif = (SeatInfo) e.getValue();
				
				if(row == null || row.equals("") || sif == null){
					return false;
				}
				
				int rowseat = sif.getNumberOfSeats();
				List<Integer> aisleseats = sif.getAisleSeats();

				totalSeats += rowseat;

				List<Seat> seatList = new ArrayList<Seat>();

				for (int i = 0; i < rowseat; i++) {
					Seat seat = new Seat();

					seat.setNumber(i);
					seat.setId(theater.getTheaterName().trim() + row.trim() + i);

					seat.setRow(row);
					seat.setTheaterName(theater.getTheaterName());

					if (aisleseats.contains(i)) {
						seat.setIsle(true);
					} else {
						seat.setIsle(false);
					}
					seat.setReservation(false);

					seatList.add(seat);
				}

				theater.setTotalSeats(totalSeats);

				theaterRepository.save(theater);
				seatRepository.saveAll(seatList);
			}
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			return false;
		}
	}
}