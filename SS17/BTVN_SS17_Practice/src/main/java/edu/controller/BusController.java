package edu.controller;

import edu.model.entity.Bus;
import edu.service.BusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
@RequestMapping("/buses")
public class BusController {
    @Autowired
    private BusService busService;

    @GetMapping
    public String listService(Model model,
                              @RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "5") int size) {
        Page<Bus> pageBus = busService.findAll(page, size);
        model.addAttribute("currentPage", page);

        model.addAttribute("pageBus", pageBus.getContent());
        model.addAttribute("totalPages", pageBus.getTotalPages());
        return "bus/pageBus";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("bus", new Bus());
        return "bus/addBus";
    }

    @PostMapping("/add")
    public String saveService(@Valid @ModelAttribute("bus") Bus bus,
                              BindingResult rs,
                              Model model) {
        if (rs.hasErrors()) {
            return "bus/addBus";
        }

        if (!busService.findByLicensePlate(bus.getLicensePlate())) {
            model.addAttribute("error", "Invalid data!");
            return "bus/addBus";
        }

        Bus busInserted = busService.save(bus);

        if (busInserted != null) {
            return "redirect:/buses";
        } else {
            model.addAttribute("error", "Invalid data!");
            return "bus/addBus";
        }
    }


    // Hiển thị form edit
    @GetMapping("/edit/{id}")
    public String editServiceForm(@PathVariable Long id, Model model) {
        Bus bus = busService.findById(id);

        model.addAttribute("bus", bus);
        return "bus/editBus";
    }

    // Xử lý cập nhật
    @PostMapping("/edit")
    public String updateService(@Valid @ModelAttribute("bus") Bus bus,
                                BindingResult rs,
                                Model model) {

        if (rs.hasErrors()) {
            return "bus/addBus";
        }

        Bus edit = busService.save(bus);

        if (edit != null) {
            return "redirect:/buses";
        } else {
            model.addAttribute("error", "Update failed!");
            return "bus/editBus";
        }
    }

    // Xóa
    @GetMapping("/delete/{id}")
    public String deleteService(@PathVariable("id") Long id) {
        Bus bus = busService.findById(id);
        busService.delete(bus);
        return "redirect:/buses";
    }


}
