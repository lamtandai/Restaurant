/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import Model.Dish;
import Model.Category;
import Model.Origin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DishDao {
    public List<Dish> getAllDish() {
        List<Dish> dishes = new ArrayList<Dish>();
        CategoryDao CategoryDao = new CategoryDao();
        OriginDao OriginDao = new OriginDao();
        
        Connection connection = connectSQL.getJDBCConnection();
        
        String sql = "select * from dish";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                Dish dish = new Dish();
                
                dish.setID(rs.getShort("ID"));
                dish.setN(rs.getString("Name"));
                dish.setPrice(rs.getFloat("Price"));
                dish.setAvailability(rs.getBoolean("Availability"));
                dish.setCateList(CategoryDao.getCategoryByDishId(rs.getShort("ID")));
                dish.setOriList(OriginDao.getOriginByDishId(rs.getShort("ID")));
                dishes.add(dish);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dishes;
    } 
    public Dish getDishByID(short id){
        Connection connection = connectSQL.getJDBCConnection();
        String sql = "SELECT * FROM Dish WHERE id = ?";
        Dish dish = new Dish();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()) {       
                dish.setID(rs.getShort("ID"));
                dish.setN(rs.getString("Title"));
                dish.setAvailability(rs.getBoolean("Availability"));
                dish.setPrice(rs.getFloat("Unit"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return dish;
    }
    public void SearchByCategory(String Category){
        
    }
    
    public void SearchByOrigin(String Origin){
        
    }
}
