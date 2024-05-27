
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

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
/**
  private Connection connect;
    
    private final String URLBD = "jdbc:mysql://localhost:3306/java_database"; 
    
    private final String user = "iumy";
    private final String password = "iumy"; 

    // Metodo responsavel por abrir a conexão
    public ConnectionDAO() {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            connect = DriverManager.getConnection(URLBD, user, password); 
            
            System.out.println("Conectado com sucesso!");
            
        }catch (Exception e){
            e.printStackTrace();
            
            JOptionPane.showMessageDialog(null, "Erro de conexão!\nERRO: " + e.getMessage(), "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
        
        }
    }
    
    
    // Metodo responsavel por fechar a conexão
    public void desconnectDAO() {
        try {
            if (connect != null && !connect.isClosed()) {
                
            
                connect.close(); 
            
                System.out.println("Conexão fechada com sucesso!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão!\nERRO: " + e.getMessage(), "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
        }
    }*/
}