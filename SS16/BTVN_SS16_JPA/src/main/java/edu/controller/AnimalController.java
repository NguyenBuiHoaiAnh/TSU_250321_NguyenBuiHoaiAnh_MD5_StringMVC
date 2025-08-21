package edu.controller;

import edu.model.entity.Animal;
import edu.service.AnimalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/animals")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @GetMapping
    public String listAnimal(Model model) {
        List<Animal> animals = animalService.findAll();
        model.addAttribute("animals", animals);
        return "animal/listAnimal";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        Animal animal = new Animal();
        model.addAttribute("animal", animal);
        return "animal/addAnimal";
    }

    @PostMapping("/add")
    public String addAnimal(@Valid @ModelAttribute("animal") Animal animal,
                            BindingResult bindingResult,
                            Model model) {

        if (bindingResult.hasErrors()) {
            return "animal/addAnimal";
        }

        Animal saved = animalService.save(animal);

        if (saved != null) {
            return "redirect:/animals";
        } else {
            model.addAttribute("message", "Insert failed");
            return "animal/addAnimal";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Animal animal = animalService.findById(id);
        model.addAttribute("animal", animal);
        return "animal/editAnimal";
    }

    @PostMapping("/edit")
    public String editAnimal(@ModelAttribute("animal") Animal animal,
                            Model model) {
        Animal saved = animalService.save(animal);
        if (saved != null) {
            return "redirect:/animals";
        } else  {
            model.addAttribute("message", "Update failed");
            return "animal/editAnimal";
        }
    }

    @GetMapping("delete/{id}")
    public String deleteAnimal(@PathVariable("id") Long id, Model model) {
        Animal animal = animalService.findById(id);
        animalService.delete(animal);
        return "redirect:/animals";
    }
}
