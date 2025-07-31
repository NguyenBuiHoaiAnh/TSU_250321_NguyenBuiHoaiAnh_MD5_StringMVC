package com.example.bt4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import validation.Validator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    List<Product> productList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        String productName = req.getParameter("name");

        double price = Double.parseDouble(req.getParameter("price"));

        String description = req.getParameter("description");

        int quantity = Integer.parseInt(req.getParameter("quantity"));

        Product product = new Product();
        product.setId(id);
        product.setProductName(productName);
        product.setPrice(price);
        product.setDescription(description);
        product.setQuantity(quantity);
        product.setStatus(true);
        productList.add(product);

        req.setAttribute("productList", productList);
        req.getRequestDispatcher("product.jsp").forward(req, resp);

    }
}
