package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.model.Employee;
import peaksoft.model.Salon;
import peaksoft.repo.SalonRepository;
import peaksoft.service.SalonService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SalonServiceImpl implements SalonService {

    private final SalonRepository salonRepository;
    @Override
    public void saveSalon(Salon salon) {
        salonRepository.save(salon);

    }

    @Override
    public List<Salon> getAllSalons() {
        return salonRepository.findAll();
    }

    @Override
    public Salon getSalonById(long id) {
        return salonRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Salon not found by id: " + id));
    }

    @Override
    public void deleteSalonById(long id) {
    salonRepository.deleteById(id);
    }

    @Override
    public void updateSalon(long id, Salon salon) {
          Salon salon1 = salonRepository.findById(id).orElseThrow(
                    ()-> new RuntimeException("Salon not found by id: " + id));
            salon1.setName(salon.getName());
            salon1.setAddress(salon.getAddress());
            salonRepository.save(salon1);

    }

    @Override
    public List<Employee> getNotAssignedEmployeesToSalon(long id) {
        return salonRepository.getNotAssignedEmployeesToSalon(id);
    }

    @Override
    public void assignEmployeesToSalon(long salonId, List<Long> employeeId) {
        salonRepository.assignEmployeesToSalon(salonId, employeeId);
    }
}
