package com.example.bt5;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@WebServlet("")
public class ProductServlet extends HttpServlet {
    List<Product> productList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (productList.isEmpty()) {
            productList.add(new Product(1, "Iphone15", 3000, "sản phẩm mới về"));
            productList.add(new Product(2, "SamSung galaxy 21", 2900, "thế hệ đột phá"));
            productList.add(new Product(3, "Đồng hồ thụy sĩ", 1500, "đẹp khỏi chê"));
            productList.add(new Product(4, "Tai nghe airpods", 2000, "càng nghe càng thích"));
            productList.add(new Product(5, "Laptop lenovo", 3000, "đổi trả hàng trong vòng 30 ngày miễn phí"));
        }
        req.setAttribute("productList", productList);
        req.getRequestDispatcher("productList.jsp").forward(req, resp);
    }
}