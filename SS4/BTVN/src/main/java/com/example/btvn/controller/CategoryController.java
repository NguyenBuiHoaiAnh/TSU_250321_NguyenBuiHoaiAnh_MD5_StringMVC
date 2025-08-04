package com.example.btvn.controller;

import com.example.btvn.dao.CategoryDAO;
import com.example.btvn.dao.imp.CategoryDAOImp;
import com.example.btvn.model.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {
    private CategoryDAO categoryDAO;

    public CategoryController() {
        categoryDAO = new CategoryDAOImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");


        if (action.equals("findAll")) {
            // Display
            displayCategory(req, resp);

        } else if (action.equals("initUpdate")) {
            // Find by ID (update)
            int cateId = Integer.parseInt(req.getParameter("id"));
            Category category = categoryDAO.getCategoryById(cateId);
            req.setAttribute("category", category);
            req.getRequestDispatcher("views/UpdateCategory.jsp").forward(req, resp);
        } else if (action.equals("Delete")) {
            // Delete
            deleteCategory(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action.equals("Create")) {
            // Add
            addCategory(req, resp);
        } else if (action.equals("Update")) {
            // Update
            updateCategory(req, resp);
        }
    }

    public void displayCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categoriesList = categoryDAO.getAllCategories();
        categoriesList.forEach(System.out::println);

        req.setAttribute("categoriesList", categoriesList);
        req.getRequestDispatcher("/views/Category.jsp").forward(req, resp);
    }

    public void addCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. Lấy dữ liệu submit từ form trong request
        Category category = new Category();
        category.setCateName(req.getParameter("cateName"));
        category.setDescription(req.getParameter("description"));
        category.setStatus(Boolean.parseBoolean(req.getParameter("status")));
        //2. Gọi sang service thực hiện thêm mới
        boolean result = categoryDAO.addCategory(category);
        //3. Xử lý kết quả service trả về
        if (result) {
            displayCategory(req, resp);
        } else {
            req.getRequestDispatcher("views/Error.jsp").forward(req, resp);
        }
    }

    // Update And Delete
    public void updateCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Thực hiện cập nhật danh mục
        //1. Lấy dữ liệu trên form
        Category category = new Category();
        category.setId(Integer.parseInt(req.getParameter("id")));
        category.setCateName(req.getParameter("cateName"));
        category.setDescription(req.getParameter("description"));
        category.setStatus(Boolean.parseBoolean(req.getParameter("status")));
        //2. Gọi service thực hiện cập nhật
        boolean result = categoryDAO.updateCategory(category);
        //3. Xử lý kết quả
        if (result) {
            displayCategory(req, resp);
        } else {
            req.getRequestDispatcher("views/Error.jsp").forward(req, resp);
        }
    }

    public void deleteCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cateId = Integer.parseInt(req.getParameter("id"));
        boolean result = categoryDAO.deleteCategory(cateId);
        if (result) {
            displayCategory(req, resp);
        } else {
            req.getRequestDispatcher("views/Error.jsp").forward(req, resp);
        }
    }
}
