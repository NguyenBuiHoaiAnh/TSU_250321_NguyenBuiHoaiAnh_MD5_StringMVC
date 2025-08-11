package ra.edu.repo;

import org.springframework.stereotype.Repository;
import ra.edu.model.Category_EN;
import ra.edu.model.Category_VI;
import ra.edu.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepo {
    public List<Category_EN> findAllEN() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Category_EN> categoryEnList = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call display_category_en()}");
            ResultSet rs = callSt.executeQuery();
            categoryEnList = new ArrayList<>();
            while (rs.next()) {
                Category_EN categoryEn = new Category_EN();
                categoryEn.setId(rs.getInt("id"));
                categoryEn.setCategoryName(rs.getString("category_name"));
                categoryEn.setDescription(rs.getString("description"));
                categoryEnList.add(categoryEn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return categoryEnList;
    }

    public List<Category_VI> findAllVI() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Category_VI> categoryViList = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call display_category_en()}");
            ResultSet rs = callSt.executeQuery();
            categoryViList = new ArrayList<>();
            while (rs.next()) {
                Category_VI categoryVi = new Category_VI();
                categoryVi.setId(rs.getInt("id"));
                categoryVi.setCategoryName(rs.getString("category_name"));
                categoryVi.setDescription(rs.getString("description"));
                categoryViList.add(categoryVi);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return categoryViList;
    }

    public boolean addCategory(Category_VI categoryVi, Category_EN categoryEn) {
        Connection conn = null;
        CallableStatement callStmt = null;
        try {
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("{call add_category(?,?,?,?)}");
            callStmt.setString(1, categoryVi.getCategoryName());
            callStmt.setString(2, categoryVi.getDescription());
            callStmt.setString(3, categoryEn.getCategoryName());
            callStmt.setString(4, categoryEn.getDescription());
            callStmt.executeUpdate();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return false;
    }
}
