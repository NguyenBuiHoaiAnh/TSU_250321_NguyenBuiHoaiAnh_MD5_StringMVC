package edu.controller;

import edu.model.entity.AnlService;
import edu.service.AnimalService;
import edu.service.CloudinaryService;
import edu.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private CloudinaryService cloudinaryService;

    @Autowired
    private AnimalService animalService;

    @Autowired
    private ServiceService serviceService;

    @GetMapping
    public String listService(Model model,
                              @RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "5") int size) {
        Page<AnlService> servicePage = serviceService.getAllServices(page, size);
        model.addAttribute("services", servicePage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", servicePage.getTotalPages());
        return "service/listService";
    }



    @GetMapping("/add")
    public String addServiceForm(Model model) {
        model.addAttribute("anlService", new AnlService());
        model.addAttribute("animals", animalService.findAll());
        return "service/addService";
    }


    @PostMapping("/add")
    public String saveService(@ModelAttribute("anlService")  AnlService anlService,
                              @RequestParam("file") MultipartFile file) throws IOException {


        if (!file.isEmpty()) {
            String url = cloudinaryService.uploadFile(file);
            anlService.setImage(url);
        }

        serviceService.save(anlService);
        return "redirect:/services";
    }


    // Hiển thị form edit
    @GetMapping("/edit/{id}")
    public String editServiceForm(@PathVariable Long id, Model model) {
        AnlService anlService = serviceService.findById(id);

        model.addAttribute("anlService", anlService);
        model.addAttribute("animals", animalService.findAll());
        return "service/editService";
    }

    // Xử lý cập nhật
    @PostMapping("/edit")
    public String updateService(@ModelAttribute("anlService") AnlService anlService,
                                @RequestParam("file") MultipartFile file,
                                Model model) throws IOException {

        if (!file.isEmpty()) {
            String url = cloudinaryService.uploadFile(file);
            anlService.setImage(url);
        }

        AnlService edit = serviceService.save(anlService);



        if (edit != null) {
            return "redirect:/services";
        } else {
            model.addAttribute("error","Update failed!");
            return "service/editService";
        }
    }

    // Xóa
    @GetMapping("/delete/{id}")
    public String deleteService(@PathVariable("id") Long id) {
        AnlService anlService = serviceService.findById(id);
        serviceService.delete(anlService);
        return "redirect:/services";
    }

    @GetMapping("/{id}")
    public String serviceDetail(@PathVariable Long id, Model model) {
        AnlService anlService = serviceService.findById(id);

        model.addAttribute("service", anlService);
        return "serviceDetail";
    }
}
