/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import Model.Ingredient_detail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Ingredient_detailDao {
    public List<Ingredient_detail> getAllIngredient_detail() {
        List<Ingredient_detail> ingredient_details = new ArrayList<Ingredient_detail>();
        
        Connection connection = connectSQL.getJDBCConnection();
        
        String sql = "SELECT * FROM Ingredient_detail_detail";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                Ingredient_detail ingredient_detail = new Ingredient_detail();
                ingredient_detail.setID(rs.getString("ID"));
                ingredient_detail.setI(rs.getDate("Import_date"));
                ingredient_detail.setE(rs.getDate("Expiration_date"));
                ingredient_detail.setQ(rs.getFloat("Quantity"));
                ingredient_details.add(ingredient_detail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ingredient_details;
    } 
    public Ingredient_detail getIngredient_detailByID(int id){
        Connection connection = connectSQL.getJDBCConnection();
        String sql = "SELECT * FROM Ingredient_detail WHERE id = ?";
        Ingredient_detail ingre = new Ingredient_detail();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, id);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()) {       
                ingre.setID(rs.getString("ID"));
                ingre.setI(rs.getDate("import_date"));
                ingre.setE(rs.getDate("Expiration_date"));
                ingre.setQ(rs.getFloat("Quantity"));
                  
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return ingre;
    }
}
