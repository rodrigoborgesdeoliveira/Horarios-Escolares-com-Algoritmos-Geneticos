/*
 * Classe com métodos de conexão ao banco de dados.
 */
package database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.jdbc.Driver"; //Driver do SGBD MySQL.
    private static final String URL = "jdbc:mysql://localhost:3306/"; //Caminho para o MySQL.
    private static final String DB = "dbgerenciahorario";
    private static String USER = null;
    private static String PASS = null;

    public static void createDatabase() {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASS);
            stmt = con.prepareStatement("CREATE DATABASE IF NOT EXISTS " + DB + ";");
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            if (ex.getMessage().contains("Access denied")) {
                JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                        + "Usuário e/ou senha incorretos!", "Dados incorretos", JOptionPane.ERROR_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                        + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);

            return DriverManager.getConnection(URL + DB, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão: ", ex);
        }
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                        + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {
        closeConnection(con);

        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                        + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        closeConnection(con, stmt);

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                        + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void setUser(String user) {
        USER = user;
    }

    public static void setPass(String pass) {
        PASS = pass;
    }
}
