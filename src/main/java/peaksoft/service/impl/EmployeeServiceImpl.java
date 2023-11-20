package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.model.Employee;
import peaksoft.repo.EmployeeRepository;
import peaksoft.service.EmployeeService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Employee not found by id: " + id));
    }

    @Override
    public void deleteEmployeeById(long id) {
     employeeRepository.deleteById(id);
    }

    @Override
    public void updateEmployee(long id, Employee employee) {
        Employee employee1 = employeeRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Employee not found by id: " + id));
        employee1.setName(employee.getName());
        employee1.setSurname(employee.getSurname());
        employee1.setSalary(employee.getSalary());
        employee1.setPosition(employee.getPosition());
        employeeRepository.save(employee1);
    }
}
