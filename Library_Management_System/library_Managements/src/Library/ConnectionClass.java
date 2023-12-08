package Library;
import java.sql.*;

public class ConnectionClass {
    Connection conn;
    Statement sta;
    ConnectionClass() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/Library", "root", "");
            sta = conn.createStatement();
            System.out.println("Successfully connected");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String args[])
    {
        new ConnectionClass();
    }
}
