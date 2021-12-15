package iset.dsi32.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    /**
     * URL de connection
     */
    private final static String URL = "jdbc:mysql://localhost:3306/soap_db";

    /**
     * Nom du user
     */
    private final static String USERNAME = "root";

    /**
     * Mot de passe du user
     */
    private final static String PASSWORD = "";

    public static Connection getConnexion() throws SQLException {
        final Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return con;
    }

    public static ResultSet execute(String sql) throws SQLException {
        Connection con = null;
        Statement stmt = null;
        con = getConnexion();
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }


    public static void update(PreparedStatement ps) {

        try {
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}

