package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import peaksoft.model.Employee;
import peaksoft.model.Salon;

import java.util.List;

@Repository
public interface SalonRepository extends JpaRepository<Salon, Long>{
    @Query("SELECT e FROM Employee e WHERE e NOT IN (SELECT se FROM Salon s JOIN s.employeeList se WHERE s.id = :id)")
    List<Employee> getNotAssignedEmployeesToSalon(@Param("id") long id);

    @Modifying
    @Query("UPDATE Employee e SET e.salon.id = :salonId WHERE e.id IN :employeeId")
    void assignEmployeesToSalon(@Param("salonId") long salonId, @Param("employeeId") List<Long> employeeId);

}
