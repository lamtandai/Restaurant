/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import Model.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    public List<Category> getAllCategory() {
        List<Category> categorys = new ArrayList<Category>();
        
        Connection connection = connectSQL.getJDBCConnection();
        
        String sql = "SELECT * FROM Category";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                Category category = new Category();
                category.setID(rs.getString("ID"));
                category.setTitle(rs.getString("Title"));

                categorys.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return categorys;
    } 
    public List<Category> getCategoryByDishId(short dish_id) {
        List<Category> categorys = new ArrayList<Category>();
        
        Connection connection = connectSQL.getJDBCConnection();
        
        String sql = "select category.ID,Title from dish\n" +
                     "join dish_cate on dish.ID = dish_cate.Dish_ID\n" +
                     "join category on dish_cate.Cate_ID = category.ID where dish_id = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"id");
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                Category category = new Category();
                category.setID(rs.getString("ID"));
                category.setTitle(rs.getString("Title"));
                categorys.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return categorys;
    } 
}
