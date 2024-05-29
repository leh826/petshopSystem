package DAO;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPetDAO {
    private java.sql.Connection conexao;
    private final String URLDB = "jdbc:mysql://localhost:3306/petshop";
    private final String usuario = "iumy";
    private final String senha = "iumy";
    
    public ConnectionPetDAO() throws SQLException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URLDB, usuario, senha);
        } catch (ClassNotFoundException ex){
            System.out.println("Driver não localizado");
        } catch (SQLException ex){
            System.out.println("Erro ao acessar o banco" + ex.getMessage());
        } 
    }
    
    public java.sql.Connection getConnection() {
        return conexao;
    }

    public void desconectar() {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Conexão encerrada.");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
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