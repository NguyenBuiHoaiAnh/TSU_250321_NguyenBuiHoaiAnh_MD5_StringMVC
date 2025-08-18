package ra.edu.controller;

import jakarta.validation.Valid;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ra.edu.model.entity.Appointment;
import ra.edu.model.entity.Doctor;
import ra.edu.model.entity.Patient;
import ra.edu.service.AppointmentService;
import ra.edu.service.DoctorService;
import ra.edu.service.PatientService;

import java.util.List;

@Service
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @GetMapping
    public String listAppointments(Model model) {
        List<Appointment> list = appointmentService.displayAllAppointments();
        model.addAttribute("appointments", list);
        return "appointment/listApp";
    }

    @GetMapping("/add")
    public String addAppointment(Model model) {
        Patient p = new Patient();
        model.addAttribute("p", p);
        return "patient/addPatient";
    }

    @PostMapping("/add")
    public String addPatient(@Valid @ModelAttribute("p") Patient p,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            return "patient/addPatient";
        }

        boolean bl = patientService.addPatient(p);

        if (bl) {
            return "redirect:/patients";
        } else {
            model.addAttribute("error", "Insert failed!");
            return "patient/addPatient";
        }
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Patient p = patientService.findById(id);
        model.addAttribute("p", p);
        return "patient/updatePatient";
    }

    @PostMapping("/update")
    public String updatePatient(@Valid @ModelAttribute("p") Patient p,
                                BindingResult rs, Model model) {
        if (rs.hasErrors()) {
            return "patient/updatePatient";
        }

        boolean bl = patientService.updatePatient(p);
        if (bl) {
            return "redirect:/patients";
        } else {
            model.addAttribute("error", "Update failed!");
            return "patient/updatePatient";
        }
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable("id") int id,
                                RedirectAttributes redirectAttributes) {
        boolean bl = patientService.deletePatient(id);
        if (bl) {
            redirectAttributes.addFlashAttribute("success", "Delete patient successfully!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Delete patient failed!");
        }
        return "redirect:/patients";
    }

    @GetMapping("change-status/{id}")
    public String changeStatus(@PathVariable("id") int id) {
        patientService.changeStatus(id);
        return "redirect:/patients";
    }

}
