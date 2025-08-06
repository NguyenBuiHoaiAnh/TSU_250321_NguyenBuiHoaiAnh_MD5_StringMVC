package ra.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.edu.model.Product;

@Controller
public class ProductController {

    // Hiển thị form nhập sản phẩm
    @GetMapping("/products/add")
    public String showAddForm() {
        return "addProduct";
    }

    // Nhận dữ liệu từ form thông qua @RequestParam
    @PostMapping("/productPost")
    public String handleAddProduct(
            @RequestParam("name") String name,
            @RequestParam("quantity") int quantity,
            @RequestParam("price") double price,
            Model model) {

        Product product = new Product(name, quantity, price);
        model.addAttribute("addedProduct", product);

        return "listProduct";
    }
}