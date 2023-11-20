package peaksoft.service;

import peaksoft.model.Employee;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(Employee employee);
   List<Employee> getAllEmployees();

    Employee getEmployeeById(long id);

    void deleteEmployeeById(long id);

    void updateEmployee(long id, Employee employee);



}
