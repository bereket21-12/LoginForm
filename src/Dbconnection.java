import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnection {
    public  Connection connection;
    public  Connection getconnection(){
        String url = "jdbc:mysql://localhost:3306/login";
        String user = "root";
        final String password = "";
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;

    }
    
}
