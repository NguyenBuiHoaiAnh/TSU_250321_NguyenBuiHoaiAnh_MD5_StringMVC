package ra.edu.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ra.edu.model.entity.Doctor;
import ra.edu.service.DoctorService;

import java.util.List;

@Controller
@RequestMapping(value = {"/", "/doctors"})
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctors")
    public String listDoctors(Model model) {
        List<Doctor> list = doctorService.getDoctors();
        model.addAttribute("doctors", list);
        return "doctor/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Doctor d = new Doctor();
        model.addAttribute("d", d);
        return "doctor/add";
    }

    @PostMapping("/add")
    public String doAdd(@Valid @ModelAttribute("d") Doctor d,
                        BindingResult result,
                        Model model) {
        if (result.hasErrors()) {
            return "doctor/add";
        }

        boolean bl = doctorService.addDoctor(d);
        if (bl) {
            return "redirect:/doctors";
        } else {
            model.addAttribute("error", "Insert failed!");
            return "doctor/add";
        }
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id")Integer id, Model model){
        Doctor d = doctorService.findById(id);
        model.addAttribute("d",d);
        return "doctor/update";
    }

    @PostMapping("/update")
    public String doUpdate(@Valid @ModelAttribute("d")Doctor d, BindingResult result, Model model){
        if(result.hasErrors()){
            return "doctor/update";
        }

        boolean bl = doctorService.updateDoctor(d);
        if(bl){
            return "redirect:/doctors";
        }else{
            model.addAttribute("error","Update failed!");
            return "doctor/update";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable("id")Integer id, RedirectAttributes redirectAttributes){
        boolean bl = doctorService.deleteDoctor(id);
        if(bl){
            redirectAttributes.addFlashAttribute("success","Delete successfully for doctor: "+id+" !");
        }else{
            redirectAttributes.addFlashAttribute("error","Delete failed for doctor: "+id+" !");
        }
        return "redirect:/doctors";
    }

    @GetMapping("/change-status/{id}")
    public String changeStatus(@PathVariable("id")Integer id){
        doctorService.changeStatus(id);
        return "redirect:/doctors";
    }
}
