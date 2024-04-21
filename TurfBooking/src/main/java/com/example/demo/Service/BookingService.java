package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Booking;
import com.example.demo.Model.Payment;
import com.example.demo.Model.User;
import com.example.demo.Repository.BookingRepository;
import com.example.demo.Repository.PaymentRepository;
import com.example.demo.Repository.UserRepository;
@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private PaymentRepository paymentService;
	

	public List<Booking> getAllBookings() {
         return bookingRepository.findAll();
	}

	public Booking createBooking(Booking booking,Long id) {
		User user=userrepo.findById(id).orElseThrow(()->new RuntimeException("User not found"));
		if(user!=null)
		{
			booking.setUser(user);
		}
		return bookingRepository.save(booking);
	}

	@SuppressWarnings("deprecation")
	public Booking getBookingById(Long id) {
		return bookingRepository.getById(id);
	}

	public Booking updateBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	public void deleteBooking(Long id) {
		bookingRepository.deleteById(id);
		
	}
	public Payment createPayment(Payment payment, Long id) {
	    List<Booking> booking = bookingRepository.findByUserId(id);

	    if (booking != null) {
	        payment.setBookings(booking);
	        Payment savedPayment = paymentService.save(payment);
	        return savedPayment;
	    }
	    
	    return null;
	}

}
