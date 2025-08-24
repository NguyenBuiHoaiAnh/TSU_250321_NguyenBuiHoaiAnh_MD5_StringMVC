package edu.controller;

import edu.model.entity.Bus;
import edu.model.entity.Schedule;
import edu.service.BusService;
import edu.service.CloudinaryService;
import edu.service.ScheduleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
@RequestMapping("/schedules")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private BusService busService;

    @Autowired
    private CloudinaryService cloudinaryService;

    @GetMapping
    public String listService(Model model,
                              @RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "5") int size) {
        Page<Schedule> pageSchedule = scheduleService.findAll(page, size);
        model.addAttribute("currentPage", page);

        model.addAttribute("pageSchedule", pageSchedule.getContent());
        model.addAttribute("totalPages", pageSchedule.getTotalPages());
        return "schedule/pageSchedule";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("schedule", new Schedule());
        model.addAttribute("listBus", busService.findAll());
        return "schedule/addSchedule";
    }

    @PostMapping("/add")
    public String saveService(@ModelAttribute("schedule") Schedule schedule,
                              @RequestParam("file") MultipartFile file,
                              Model model) throws IOException {

        if (!file.isEmpty()) {
            String url = cloudinaryService.uploadFile(file);
            schedule.setImage(url);
        }

        Schedule savedSchedule = scheduleService.save(schedule);

        if (savedSchedule != null) {
            return "redirect:/schedules";
        } else {
            model.addAttribute("error", "Invalid data!");
            return "schedule/addSchedule";
        }
    }


    // Hiển thị form edit
    @GetMapping("/edit/{id}")
    public String editServiceForm(@PathVariable Long id, Model model) {
        Schedule schedule = scheduleService.findById(id);

        model.addAttribute("listBus", busService.findAll());
        model.addAttribute("schedule", schedule);
        return "schedule/editSchedule";
    }

    // Xử lý cập nhật
    @PostMapping("/edit")
    public String updateService(@ModelAttribute("schedule") Schedule schedule,
                                @RequestParam("file") MultipartFile file,
                                Model model) throws IOException {

        if (!file.isEmpty()) {
            String url = cloudinaryService.uploadFile(file);
            schedule.setImage(url);
        }

        Schedule edit = scheduleService.save(schedule);

        if (edit != null) {
            return "redirect:/schedules";
        } else {
            model.addAttribute("error", "Update failed!");
            return "schedule/editSchedule";
        }
    }

    // Xóa
    @GetMapping("/delete/{id}")
    public String deleteService(@PathVariable("id") Long id) {
        Schedule schedule = scheduleService.findById(id);
        scheduleService.delete(schedule);
        return "redirect:/schedules";
    }


}
