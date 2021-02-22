import java.sql.*;
import java.util.ArrayList;

public class Story {
    private String text;
    private String[] choices;
    Statement stmt;

    public Story(String text, String[] choices) {
        this.text = text;
        this.choices = choices;
    }

    public Story(int id) {
        // Set up connection to database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://" + DatabaseLogin.DBURL + ":" + DatabaseLogin.port + "/" + DatabaseLogin.DBname +
                            "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    DatabaseLogin.user, DatabaseLogin.password);


        // Setup statement
        Statement stmt = conn.createStatement();


        String strSelect = "select body from story where id = " + id;

        ResultSet rset = stmt.executeQuery(strSelect);

            strSelect = "select description, target_id from links where story_id = " + id;

            rset = stmt.executeQuery(strSelect);
            ArrayList<Integer> storyLinks = new ArrayList();
        // Loop through the result set and print
        rset.next();
        text = rset.getString("description");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Story(String text, String choices) {
        this.text = text;
        this.choices[0] = choices;
    }

    public String getText() {
        return text;
    }

    public String[] getChoices() {
        return choices;
    }

    public String getChoice(int i) {
        return choices[i];
    }
}

