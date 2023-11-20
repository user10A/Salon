package peaksoft.repo;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.model.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Long> {
}
