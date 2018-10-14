package tb.com.catalogservices.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import tb.com.catalogservices.models.ReserveRequest;
import tb.com.catalogservices.models.Seat;
import tb.com.catalogservices.models.SeatInfo;
import tb.com.catalogservices.models.SeatResponse;
import tb.com.catalogservices.repository.SeatRepository;

@ComponentScan
@Service
public class ReserveSeatService {

	@Autowired
	private SeatRepository seatRepository;

	public boolean reserveSeat(ReserveRequest reserveRequest) {

		Map<String, List<Integer>> seats = reserveRequest.getSeats();

		if (seats == null || seats.isEmpty()) {
			return false;
		}
		try {
			for (Entry entity : seats.entrySet()) {
				List<Integer> seatList = (List<Integer>) entity.getValue();
				String row = (String) entity.getKey();

				if (row == null || row.equals("") || seatList == null) {
					return false;
				}
				for (int seatnum : seatList) {

					Seat seat = seatRepository.getOne(reserveRequest.getTheaterName().trim() + row.trim() + seatnum);
					if(seat.isReservation()){
						return false;
					}
					seat.setReservation(true);

					seatRepository.save(seat);
				}
			}
			return true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	public SeatResponse viewSeat(String theaterName, String status) {

		if (theaterName == null || theaterName.equals("") || status == null || status.equals("")) {
			return null;
		}
		SeatResponse seatResponse = new SeatResponse();

		if (status.equals("unreserved")) {
			List<Seat> seats = seatRepository.getReserveSeats(theaterName, false);
			Map<String, List<Integer>> Rows = new HashMap<String, List<Integer>>();

			if (seats == null) {
				return seatResponse;
			}

			for (Seat seat : seats) {
				if (Rows.containsKey(seat.getRow())) {
					Rows.get(seat.getRow()).add(seat.getNumber());
				} else {
					List<Integer> ls = new ArrayList<Integer>();
					ls.add(seat.getNumber());

					Rows.put(seat.getRow(), ls);
				}
			}
			seatResponse.setSeats(Rows);
		}

		return seatResponse;
	}

	public SeatResponse viewSeatWithnum(String theaterName, int numSeats, String choice) throws Exception {
		SeatResponse seatResponse = new SeatResponse();
		int startnum = Integer.parseInt(choice.replaceAll("[^0-9]", ""));
		String row = choice.replaceAll("[^a-zA-Z]", "").trim();
		if (startnum < 0) {
			return seatResponse;
		}
		Map<String, List<Integer>> Rows = new HashMap<String, List<Integer>>();

		List<Integer> ls = new ArrayList<Integer>();
		Rows.put(row, ls);
		try {
			for (int i = 0; i < numSeats; i++) {
				Seat st = seatRepository.getOne(theaterName + row + (i + startnum));
				if (st != null && !st.isIsle() && !st.isReservation()) {
					Rows.get(row).add(i + startnum);
				} else {
					throw new Exception();
				}
			}
			seatResponse.setSeats(Rows);

		} catch (Exception ex) {
			throw ex;
		}

		return seatResponse;
	}
}
