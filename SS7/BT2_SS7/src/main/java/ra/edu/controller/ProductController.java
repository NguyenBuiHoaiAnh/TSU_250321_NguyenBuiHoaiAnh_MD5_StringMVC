package ra.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.edu.model.Product;

@Controller
@RequestMapping(value = {"/product"})
public class ProductController {
    @GetMapping
    public String showProductForm(Model model) {
        model.addAttribute("p", new Product());
        return "productForm";
    }

    @PostMapping
    public String addProduct(@ModelAttribute("p") Product product, Model model) {
        model.addAttribute("p", product);
        return "result";
    }
}