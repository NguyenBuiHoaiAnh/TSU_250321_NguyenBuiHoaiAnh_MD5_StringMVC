package ra.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.edu.model.Product;
import ra.edu.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/controller")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String showProducts(Model model) {
        List<Product> productsList = productService.findAll();
        model.addAttribute("productsList", productsList);
        return "listProduct";
    }
}