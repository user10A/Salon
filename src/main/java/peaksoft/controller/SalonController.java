package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Salon;
import peaksoft.service.CustomerService;
import peaksoft.service.SalonService;

import java.util.List;

@Controller
@RequestMapping("/salon")
@RequiredArgsConstructor
public class SalonController {

    private final SalonService salonService;
    private final CustomerService customerService;

    @GetMapping
    public String getSalonPage(Model model){
        model.addAttribute("salons", salonService.getAllSalons());
        return "salon";
    }

    @GetMapping("/new")
    public String getSaveForm( Model model){
        model.addAttribute("newSalon", new Salon());
        return "salon_form";
    }

    @PostMapping("/save")
    public String saveSalon(@ModelAttribute("newSalon") Salon salon){
        salonService.saveSalon(salon);
        return "redirect:/salon";
    }

    @GetMapping("/{id}/profile/{cId}")
    public String getSalonProfile(@PathVariable("id") long id, Model model,@PathVariable("cId") long cId){
        model.addAttribute("salonFound", salonService.getSalonById(id));
        model.addAttribute("customer", customerService.getCustomerById(cId));
        return "salon_profile";
    }


    @GetMapping("/{id}/notAssignedEmployees")
    public String getNotAssignedEmployees(@PathVariable("id") long id, Model model){
        model.addAttribute("salonFound", salonService.getSalonById(id));
        model.addAttribute("notAssignedEmployees", salonService.getNotAssignedEmployeesToSalon(id));
        return "not_assigned_employees";
    }

    @PostMapping("/{id}/assignEmployees")
    public String assignEmployees(@PathVariable("id") long id, @RequestParam List<Long> employeeId){
        salonService.assignEmployeesToSalon(id, employeeId);
        return "redirect:/salon/{id}/profile";
    }

}
