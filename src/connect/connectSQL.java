package connect;

import java.sql.DriverManager;
import java.sql.SQLException;


public class connectSQL {
    public static java.sql.Connection getJDBCConnection(){
        final String url = "jdbc:mysql://localhost:3306/restaurent";
        final String user = "root";
        final String password = "root";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}