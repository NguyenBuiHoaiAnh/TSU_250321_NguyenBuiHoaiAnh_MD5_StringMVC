package com.example.btvn.dao.imp;

import com.example.btvn.dao.CategoryDAO;
import com.example.btvn.model.Category;
import com.example.btvn.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImp implements CategoryDAO {

    // Display
    @Override
    public List<Category> getAllCategories() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Category> categoriesList = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call display_category()}");
            ResultSet rs = callSt.executeQuery();

            categoriesList = new ArrayList<>();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setCateName(rs.getString("cate_name"));
                category.setDescription(rs.getString("description"));
                category.setStatus(rs.getBoolean("status"));
                categoriesList.add(category);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }

        return categoriesList;
    }

    // Add
    @Override
    public boolean addCategory(Category category) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call add_category(?,?,?)}");
            callSt.setString(1, category.getCateName());
            callSt.setString(2, category.getDescription());
            callSt.setBoolean(3, category.isStatus());
            callSt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    // Update And Delete
    @Override
    public Category getCategoryById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Category category = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_by_id(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                category = new Category();
                category.setId(rs.getInt("id"));
                category.setCateName(rs.getString("cate_name"));
                category.setDescription(rs.getString("description"));
                category.setStatus(rs.getBoolean("status"));
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return category;
    }

    @Override
    public boolean updateCategory(Category category) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_category(?,?,?,?)}");
            callSt.setInt(1, category.getId());
            callSt.setString(2, category.getCateName());
            callSt.setString(3, category.getDescription());
            callSt.setBoolean(4, category.isStatus());
            callSt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean deleteCategory(int id) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_category(?)}");
            callSt.setInt(1, id);
            callSt.executeUpdate();
            return true;

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

}
