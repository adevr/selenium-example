package dbconnection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Connection {

    private static String hostURL;
    private static String user;
    private static String pass;

    public Connection() {

        setHostURL("jdbc:mysql://localhost:3036/test");
        setUser("root");
        setPass("");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            java.sql.Connection conn = DriverManager.getConnection(hostURL, user, pass);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM test");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getPass() {
        return pass;
    }

    public static String getHostURL() {
        return hostURL;
    }

    public static String getUser() {
        return user;
    }

    public static String setUser(String user) {
        Connection.user = user;
        return user;
    }

    public static String setPass(String pass) {
        Connection.pass = pass;
        return pass;
    }

    public static String setHostURL(String hostURL) {
        Connection.hostURL = hostURL;
        return hostURL;
    }
}
