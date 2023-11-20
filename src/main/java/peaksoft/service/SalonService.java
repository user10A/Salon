package peaksoft.service;

import org.springframework.data.repository.query.Param;
import peaksoft.model.Employee;
import peaksoft.model.Salon;

import java.util.List;

public interface SalonService {

    void saveSalon(Salon salon);

    List<Salon> getAllSalons();

    Salon getSalonById(long id);

    void deleteSalonById(long id);

    void updateSalon(long id, Salon salon);

    List<Employee> getNotAssignedEmployeesToSalon(long id);

    void assignEmployeesToSalon( long salonId, List<Long> employeeId);


}
