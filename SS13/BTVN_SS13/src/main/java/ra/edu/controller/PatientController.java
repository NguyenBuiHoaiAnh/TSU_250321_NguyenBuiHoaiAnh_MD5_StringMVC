package ra.edu.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ra.edu.model.entity.Patient;
import ra.edu.service.PatientService;

import java.util.List;

@Controller
@RequestMapping("patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public String patient(Model model) {
        List<Patient> patientList = patientService.findAll();
        model.addAttribute("patients", patientList);
        return "patient/listPatient";
    }

    @GetMapping("/add")
    public String addPatient(Model model) {
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
