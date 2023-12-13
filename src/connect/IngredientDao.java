/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import Model.Ingredient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class IngredientDao {
    public List<Ingredient> getAllIngredient() {
        List<Ingredient> ingredientes = new ArrayList<Ingredient>();
        
        Connection connection = connectSQL.getJDBCConnection();
        
        String sql = "SELECT * FROM Ingredient";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                Ingredient ingredient = new Ingredient();
                ingredient.setID(rs.getString("ID"));
                ingredient.setT(rs.getString("Title"));
                ingredient.setU(rs.getString("Unit"));
                ingredientes.add(ingredient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ingredientes;
    }
    public Ingredient getIngredientByID(int id){
        Connection connection = connectSQL.getJDBCConnection();
        String sql = "SELECT * FROM Ingredient WHERE id = ?";
        Ingredient ingre = new Ingredient();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()) {       
                ingre.setID(rs.getString("ID"));
                ingre.setT(rs.getString("Title"));
                ingre.setU(rs.getString("Unit"));
                  
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return ingre;
    }
}
