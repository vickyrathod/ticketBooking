package tb.com.catalogservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tb.com.catalogservices.models.ReserveRequest;
import tb.com.catalogservices.models.TheaterPostRequest;
import tb.com.catalogservices.models.TheaterPostResponse;
import tb.com.catalogservices.services.ReserveSeatService;
import tb.com.catalogservices.services.TheaterService;

@RestController
@RequestMapping("/")
public class TBController {
	
	@Autowired
	TheaterService theaterService;
	
	@Autowired
	ReserveSeatService reserveSeatService;
	
	@PostMapping("/screens")
	public ResponseEntity<Object> saveTheater(@RequestBody final TheaterPostRequest theaterPostRequest){
		
		if(theaterPostRequest == null){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ msg: 'error while loading'}");
		}
		
		if(theaterService.addTheater(theaterPostRequest)){
			return ResponseEntity.status(HttpStatus.OK).body("{ msg: 'data uploaded'}");
		} else{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ msg: 'error while loading'}");
		}
	}
	
	@PostMapping("/screens/{theatername}/reserve")
	public ResponseEntity<Object> reserveSeat(@RequestBody final ReserveRequest reserveRequest, @PathVariable("theatername") String theaterName){
		reserveRequest.setTheaterName(theaterName);
		
		if(reserveSeatService.reserveSeat(reserveRequest)){
			return ResponseEntity.status(HttpStatus.OK).body("{ msg: 'ticket booked'}");
		} else{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ msg: 'error while booking'}");
		}
	}
	
	@GetMapping("/screens/{theatername}/seats")
	public ResponseEntity<Object> viewSeats(@PathVariable("theatername") String theaterName, @RequestParam(value = "status" , required = false, defaultValue = "") String status, @RequestParam(value = "numSeats", required = false, defaultValue = "1") int numSeats , @RequestParam(value = "choice" , required = false, defaultValue = "") String choice){
		if(!status.equals(""))
			return ResponseEntity.status(HttpStatus.OK).body(reserveSeatService.viewSeat(theaterName, status));
		else
			try {
				return ResponseEntity.status(HttpStatus.OK).body(reserveSeatService.viewSeatWithnum(theaterName, numSeats, choice));
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ msg: 'no contigues seats'}");
			}
	}
}
