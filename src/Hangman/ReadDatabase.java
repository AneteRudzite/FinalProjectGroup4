package Hangman;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadDatabase {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";
    static final String USER = "sa";
    static final String PASS = "";

    public ReadDatabase() {
    }


    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            stmt = conn.createStatement();
            String sql = "SELECT id, name, guess from HANGMAN";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String guess = rs.getString("guess");
                System.out.print(" id: " + id);
                System.out.println(" name: " + name);
                System.out.println(" guess: " + guess);
            }

            rs.close();
        } catch (SQLException var22) {
            var22.printStackTrace();
        } catch (Exception var23) {
            var23.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException var21) {
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException var20) {
                var20.printStackTrace();
            }

        }

    }
}