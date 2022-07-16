//package controllers;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import dto.AppointmentDTO;
//import services.AppointmentService;
//
//@RestController
//@RequestMapping("/appointment")
//public class AppointmentController {
//
//	@Autowired
//	private AppointmentService appointmentService;
//
//
//	@GetMapping("/AllAppointments")
//	public List<AppointmentDTO> getAllAppointment() {
//		try {
//			return appointmentService.getAllAppointments();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	@PostMapping("/createAppointments")
//	public String createAppointments(@RequestBody AppointmentDTO appointmentDTO) {
//		try {
//			String status = appointmentService.createAppointment(appointmentDTO);
//			return status;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//
//	}
//
//	   @PutMapping("/cancelAppointment/{appointmentId}/{cancelReason}")
//	    public ResponseEntity<String> cancelAppointment(@PathVariable Long appointmentId,@PathVariable String cancelReason) {
//	       try { 
//	    	   String status=appointmentService.cancelAppointment(appointmentId,cancelReason);
//	        return new ResponseEntity<String>(status, HttpStatus.OK);
//	       }catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<String>("Failed on Deleted",HttpStatus.BAD_REQUEST);
//		}
//	    }
//	
//		@GetMapping("/patientHistory/{patientName}")
//		public List<AppointmentDTO> patientHistory(@PathVariable String patientName) {
//			try {
//				return appointmentService.patientHistory(patientName);
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				return null;
//			}
//		}
//		
//		@GetMapping("/searchByDate/{start}/{end}")
//		public List<AppointmentDTO> searchByDate(@PathVariable String start,@PathVariable String end) {
//			try {
//				Date start1=new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(start);
//				Date end1=new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(end);				
//				return appointmentService.searchByDate(start1,end1);
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				return null;
//			}
//		}
//	   
//	public AppointmentService getAppointmentService() {
//		return appointmentService;
//	}
//
//	public void setAppointmentService(AppointmentService appointmentService) {
//		this.appointmentService = appointmentService;
//	}
//
//}