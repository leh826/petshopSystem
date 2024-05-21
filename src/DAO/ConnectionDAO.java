/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Leticia
 */
public class ConnectionDAO {

    private Connection conn = null;
    private String url = "jdbc:mysql://localhost:3306/uepa_alunos?user=root&password=root";

    public Connection connectionBD() {
        try {
            conn = DriverManager.getConnection(url);// ,user,password);
            return conn;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "don't conected to database\n ERRO:" + erro.getMessage());
        }
        return null;
    }
}