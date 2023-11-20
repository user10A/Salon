package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Employee;
import peaksoft.service.EmployeeService;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public String getEmployeePage(Model model){
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";
    }

    @GetMapping("/new")
    public String getSaveForm( Model model){
        model.addAttribute("newEmployee", new Employee());
        return "employee_form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("newEmployee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/{id}/update")
    public String getUpdateForm(@PathVariable long id, Model model){
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "employee_update";
    }

    @PostMapping("/update")
    public String updateEmployee(long id, @ModelAttribute("employee") Employee employee){
        employeeService.updateEmployee(id, employee);
        return "redirect:/employee";
    }

}
