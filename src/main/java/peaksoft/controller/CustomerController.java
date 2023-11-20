package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.model.Booking;
import peaksoft.model.Customer;
import peaksoft.service.BookingService;
import peaksoft.service.CustomerService;
import peaksoft.service.EmployeeService;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final BookingService bookingService;
    private final EmployeeService employeeService;

    @GetMapping("/new")
    public String getSaveForm(Model model){
        model.addAttribute("newCustomer",new Customer());
        return "customer_form";
    }

    @PostMapping("/save")
    public String saveCustomer(Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customer";
    }

    @GetMapping("/{id}/profile")
    public String getCustomerProfile(@PathVariable long id, Model model){
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer_profile";
    }

    @PostMapping("/{cId}/createBooking/{emId}")
    public String createBooking( @PathVariable("cId") long cId, @PathVariable("emId") long emId){
        Booking booking = new Booking();
        booking.setCustomer(customerService.getCustomerById(cId));
        booking.setEmployee(employeeService.getEmployeeById(emId));
        booking.setSalon(employeeService.getEmployeeById(emId).getSalon());

        Customer customer = customerService.getCustomerById(cId);

        bookingService.saveBooking(booking);
        customer.getBookings().add(booking);
        customerService.update(customer.getId(),customer);
        return "redirect:/customer/" + customer.getId() + "/profile";
    }
}
