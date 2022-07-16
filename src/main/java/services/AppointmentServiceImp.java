//
//package services;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Locale;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import dto.AppointmentDTO;
//import mapper.AppointmentMapper;
//import model.Appointments;
//import repository.AdminRep;
//import repository.AppointmentRep;
//
//@Service
//public class AppointmentServiceImp implements AppointmentService {
//
//	@Autowired
//	private AppointmentRep rep;
//
//	@Autowired
//	private AdminRep adminRep;
//
//	@Autowired
//	private AppointmentMapper appointmentMapper;
//
//	@Override
//	public List<AppointmentDTO> getAllAppointments() {
//		// TODO Auto-generated method stub
//
//		List<AppointmentDTO> dtoList = new ArrayList<AppointmentDTO>();
//		List<Appointments> appointmentList = rep.findByCancelationCheck(1);
//		appointmentList.stream().map(appointment -> dtoList.add(appointmentMapper.toDto(appointment)))
//				.collect(Collectors.toList());
//		return dtoList;
//	}
//
//	@Override
//	public String createAppointment(AppointmentDTO dto) {
//		try {
//			Appointments appointment = appointmentMapper.toEntity(dto);
//			rep.save(appointment);
//			return "sucess";
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			return "Failed";
//		}
//
//	}
//
//	@Override
//	public String cancelAppointment(Long appointmentId, String cancelationReason) {
//		try {
//			Appointments appointment = rep.getById(appointmentId);
//			appointment.setCancelationCheck(0);
//			appointment.setCancelationReason(cancelationReason);
//			appointment.setCanceleationDate(new Date());
//			rep.save(appointment);
//			return "sucess";
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			return "Failed";
//		}
//	}
//
//	//search by start date and end date 
//	@Override
//	public List<AppointmentDTO> searchByDate(Date start, Date end) {
//		// TODO Auto-generated method stub
//		try {
//			List<AppointmentDTO> dtoList = new ArrayList<AppointmentDTO>();
//			List<Appointments> appointmentList=rep.getAllBetweenDates(start,end);
//			appointmentList.stream().map(appointment -> dtoList.add(appointmentMapper.toDto(appointment)))
//					.collect(Collectors.toList());
//			return dtoList;
//		} catch (Exception e) {
//			// TODO: handle exception
//			return null;
//		}
//
//	}
//
//	
//	@Override
//	public List<AppointmentDTO> patientHistory(String patientName) {
//		try {
//			List<AppointmentDTO> dtoList = new ArrayList<AppointmentDTO>();
//			List<Appointments> appointmentList = rep.findByPatient_Name(patientName);
//			appointmentList.stream().map(appointment -> dtoList.add(appointmentMapper.toDto(appointment)))
//					.collect(Collectors.toList());
//			return dtoList;
//		} catch (Exception e) {
//			// TODO: handle exception
//			return null;
//		}
//	}
//
//	public AppointmentRep getRep() {
//		return rep;
//	}
//
//	public void setRep(AppointmentRep rep) {
//		this.rep = rep;
//	}
//
//	public AdminRep getAdminRep() {
//		return adminRep;
//	}
//
//	public void setAdminRep(AdminRep adminRep) {
//		this.adminRep = adminRep;
//	}
//
//	public AppointmentMapper getAppointmentMapper() {
//		return appointmentMapper;
//	}
//
//	public void setAppointmentMapper(AppointmentMapper appointmentMapper) {
//		this.appointmentMapper = appointmentMapper;
//	}
//
//}
