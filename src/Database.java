import javax.swing.plaf.nimbus.State;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;

public class Database {

    public void dbStore(String name, int score) throws SQLException {
        Connection conn = null;
        Statement stmt;

        conn = DriverManager.getConnection(
                "jdbc:mysql://" + DatabaseConnection.DBURL + ":" + DatabaseConnection.port + "/" + DatabaseConnection.DBname +
                        "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                DatabaseConnection.user, DatabaseConnection.password);
        stmt = conn.createStatement();


        String save = "INSERT INTO score (name, score) VALUES ( '" + name + "','" + score + "')";
        stmt.executeUpdate(save);

    }

    public User[] dbShow() throws SQLException{
        User users[] = new User[10];

        Connection conn = null;
        Statement stmt;

        conn = DriverManager.getConnection(
                "jdbc:mysql://" + DatabaseConnection.DBURL + ":" + DatabaseConnection.port + "/" + DatabaseConnection.DBname +
                        "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                DatabaseConnection.user, DatabaseConnection.password);
        stmt = conn.createStatement();

        String get = "SELECT * FROM score ORDER BY score DESC LIMIT 10";

        ResultSet rset = stmt.executeQuery(get);

        for (int i = 0; rset.next(); i++){
            users[i] = new User(rset.getString("name"), rset.getInt("score"));
        }

        return users;
    }
}