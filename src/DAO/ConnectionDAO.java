package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {

    private Connection conexao;
    private final String URLDB = "jdbc:mysql://localhost:3306/petshop?";
    private final String usuario = "root";
    private final String senha = "root";
    
    public ConnectionDAO() throws SQLException{
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexao = DriverManager.getConnection(URLDB, usuario, senha);
        } catch (ClassNotFoundException ex){
            System.out.println("Driver não localizado");
        } catch (SQLException ex){
            System.out.println("Erro ao acessar o banco" + ex.getMessage());
        } 
    }
    
    public Connection getConnection() {
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
}