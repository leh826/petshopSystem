
package DAO;
import DAO.ConnectionDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Model.ModeloTabelaPets;

/**
 *
 * @author Iumy P.F
 */
public class CadastroPetDAO {
    
    private Connection connect;
    
    private final String URLBD = "jdbc:mysql://localhost:3306/petshop"; 
    
    private final String user = "iumy";
    private final String password = "iumy"; 

    // Metodo responsavel por abrir a conexão
    public CadastroPetDAO() {
        
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
    public void desconnectBD() {
        try {
            if (connect != null && !connect.isClosed()) {
                
            
                connect.close(); 
            
                System.out.println("Conexão fechada com sucesso!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão!\nERRO: " + e.getMessage(), "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /*
    ConnectionDAO bd = new ConnectionDAO();
    private Connection connect;*/
    
    public boolean insetCadastrosPet(String nomePet, String especie, String raca, String sexo, String idade, String cor, String peso, String caracteristicas, String nomeTutor, String contato, String num_cpf, String endereco, String historico_vacinacao, String medicamentos_uso, String alergias, String hist_doencas_cond_medicas){
       
        try{
            PreparedStatement psInsert = connect.prepareStatement("INSERT INTO Cadastro_Pets(nomePet, especie, raca, sexo, idade, cor, peso, caracteristicas, nomeTutor, contato, num_cpf, endereco, historico_vacinacao, medicamentos_uso, alergias, hist_doencas_cond_medicas) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            psInsert.setString(1, nomePet);
            psInsert.setString(2, especie);
            psInsert.setString(3, raca);
            psInsert.setString(4, sexo);
            psInsert.setString(5, idade);
            psInsert.setString(6, cor);
            psInsert.setString(7, peso);
            psInsert.setString(8, caracteristicas);
            psInsert.setString(9, nomeTutor);
            psInsert.setString(10, contato);
            psInsert.setString(11, num_cpf);
            psInsert.setString(12, endereco);
            psInsert.setString(13, historico_vacinacao);
            psInsert.setString(14, medicamentos_uso);
            psInsert.setString(15, alergias);
            psInsert.setString(16, hist_doencas_cond_medicas);
            
           JOptionPane.showMessageDialog(null, "Operacao com Sucesso! Cadastro inserido!");
             
            return psInsert.execute();
            
        }catch (Exception e){
            e.printStackTrace();
            
            return false;
        }
        
    }
    
    /*
    public boolean insetCadastrosPet(String nomePet, String especie, String raca, String sexo, String idade, String cor, String peso, String caracteristicas){
       
        try{
            PreparedStatement psInsert = connect.prepareStatement("INSERT INTO Cadastro_Pets(nomePet, especie, raca, sexo, idade, cor, peso, caracteristicas) VALUES (?,?,?,?,?,?,?,?)");
            psInsert.setString(1, nomePet);
            psInsert.setString(2, especie);
            psInsert.setString(3, raca);
            psInsert.setString(4, sexo);
            psInsert.setString(5, idade);
            psInsert.setString(6, cor);
            psInsert.setString(7, peso);
            psInsert.setString(8, caracteristicas);
            
           JOptionPane.showMessageDialog(null, "Operacao com Sucesso! Cadastro inserido!");
             
            return psInsert.execute();
            
        }catch (Exception e){
            e.printStackTrace();
            
            return false;
        }
        
    }
    
    public boolean insertInfoSaudePet(String historico_vacinacao, String medicamentos_uso, String alergias, String hist_doencas_cond_medicas){
       
        try{
            PreparedStatement psInsert = connect.prepareStatement("INSERT INTO Info_Saude_Pet(historico_vacinacao, medicamentos_uso, alergias, hist_doencas_cond_medicas) VALUES (?,?,?,?)");
            psInsert.setString(1, historico_vacinacao);
            psInsert.setString(2, medicamentos_uso);
            psInsert.setString(3, alergias);
            psInsert.setString(4, hist_doencas_cond_medicas);
            
           JOptionPane.showMessageDialog(null, "Operacao com Sucesso! Cadastro inserido!");
             
            return psInsert.execute();
            
        }catch (Exception e){
            e.printStackTrace();
            
            return false;
        }
        
    } 
    
    public boolean insertInfoTutor(String nomeTutor, String contato, String num_cpf, String endereco){
       
        try{
            PreparedStatement psInsert = connect.prepareStatement("INSERT INTO Info_Tutores_Pet(nomeTutor, contato, num_cpf, endereco) VALUES (?,?,?,?)");
            psInsert.setString(1, nomeTutor);
            psInsert.setString(2, contato);
            psInsert.setString(3, num_cpf);
            psInsert.setString(4, endereco);
            
           JOptionPane.showMessageDialog(null, "Operacao com Sucesso! Cadastro inserido!");
             
            return psInsert.execute();
            
        }catch (Exception e){
            e.printStackTrace();
            
            return false;
        }
        
    }
    */
    
     public boolean alterCadastros(String campo, String valor, int id){
        try{
            PreparedStatement psInsert = connect.prepareStatement("UPDATE Cadastro_Pets SET " + campo + " = ? WHERE id = ?");
            psInsert.setString(1, valor);
            psInsert.setInt(2, id); 
            
            JOptionPane.showMessageDialog(null, "Operacao com Sucesso! Informação Alterada!");
            return psInsert.execute();
            
            
        }catch (Exception e){
            e.printStackTrace();
            
            return false;
        }
    }
    
     
    // Metodo responsavel por deletar dados
    public boolean deleteCadastros(int id){
        try{
            PreparedStatement psDelete = connect.prepareStatement("DELETE FROM Cadastro_Pets WHERE id = ?");
            psDelete.setInt(1,id);
            int rowsAffected = psDelete.executeUpdate();
      
            JOptionPane.showMessageDialog(null, "Operação com Sucesso! Cadastro deletado!");
            return true;
            
        }catch (Exception e){
            e.printStackTrace();
            
            return false;
        }
    }
    
    
    public boolean selectCadastros(){
        try{
            PreparedStatement psInsert = connect.prepareStatement("SELECT * FROM Cadastro_Pets ORDER BY id");
            
            ResultSet rs;
            rs = psInsert.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String nomePet = rs.getString("nomePet");
                String especie = rs.getString("especie");
                String raca = rs.getString("raca");
                String sexo = rs.getString("sexo");
                String idade = rs.getString("idade");
                String cor = rs.getString("cor");
                String peso = rs.getString("peso");
                String caracteristicas = rs.getString("caracteristicas");
                String nomeTutor = rs.getString("nomeTutor");
                String contato = rs.getString("contato");
                String num_cpf = rs.getString("num_cpf");
                String endereco = rs.getString("endereco");
                String historico_vacinacao = rs.getString("historico_vacinacao");
                String medicamentos_uso = rs.getString("medicamentos_uso");
                String alergias = rs.getString("alergias");
                String hist_doencas_cond_medicas = rs.getString("hist_doencas_cond_medicas");
                
                ModeloTabelaPets cad = new ModeloTabelaPets(id, nomePet, especie, raca, sexo, idade, cor, peso, caracteristicas, nomeTutor, contato, num_cpf, endereco, historico_vacinacao, medicamentos_uso, alergias, hist_doencas_cond_medicas);
                
            }
            
            return psInsert.execute();
            
        }catch (Exception e){
            e.printStackTrace();
            
            return false;
        }
    }
    
    
}
