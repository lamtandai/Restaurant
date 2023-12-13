/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import Model.Origin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OriginDao {
    public List<Origin> getAllOrigin() {
        List<Origin> origines = new ArrayList<Origin>();
        
        Connection connection = connectSQL.getJDBCConnection();
        
        String sql = "SELECT * FROM Origin";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                Origin origin = new Origin();
                origin.setID(rs.getString("ID"));
                origin.setTitle(rs.getString("Title"));
                origines.add(origin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return origines;
    }
    public List<Origin> getOriginByDishId(short dish_id) {
        List<Origin> origins = new ArrayList<Origin>();
        
        Connection connection = connectSQL.getJDBCConnection();
        
        String sql = "select origin.ID, Title from dish\n" +
                     "join dish_ori on dish.ID = dish_ori.Dish_ID\n" +
                     "join origin on dish_ori.Ori_ID = origin.ID where dish_id = ?";
                     
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"id");
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                Origin ori = new Origin();
                ori.setID(rs.getString("ID"));
                ori.setTitle(rs.getString("Title"));
                origins.add(ori);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return origins;
    } 
}
