package ra.edu.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ra.edu.model.Review;

@Controller
public class ReviewController {

    @GetMapping("/review")
    public String showForm(Model model) {
        model.addAttribute("review", new Review());
        return "reviewForm";
    }

    @PostMapping("/review")
    public String submitReview(@Valid @ModelAttribute("review") Review review,
                               BindingResult result,
                               Model model) {
        if (result.hasErrors()) {
            return "reviewForm";
        } else {
            model.addAttribute("review", review);
            return "reviewResult";
        }
    }
}