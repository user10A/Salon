package peaksoft.service.impl;

import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.model.Booking;
import peaksoft.repo.BookingRepo;
import peaksoft.service.BookingService;

@Service
@Transactional
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepo bookingRepo;


    @Override
    public void saveBooking(Booking booking) {
        bookingRepo.save(booking);
    }
}
