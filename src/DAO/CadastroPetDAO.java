
package DAO;
import DAO.ConnectionPetDAO;
import View.Busca_Pet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Model.ModeloTabelaPets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CadastroPetDAO {
    
    private final ConnectionPetDAO ConnectionPetDAO;

    public CadastroPetDAO() throws SQLException {
        this.ConnectionPetDAO = new ConnectionPetDAO();
    }
    
    public boolean insetCadastrosPet(String nomePet, String especie, String raca, String sexo, String idade, String cor, String peso, String caracteristicas, String nomeTutor, String contato, String num_cpf, String endereco, String historico_vacinacao, String medicamentos_uso, String alergias, String hist_doencas_cond_medicas){
       
        String sql = "INSERT INTO Cadastro_Pets(nomePet, especie, raca, sexo, idade, cor, peso, caracteristicas, nomeTutor, contato, num_cpf, endereco, historico_vacinacao, medicamentos_uso, alergias, hist_doencas_cond_medicas) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try(Connection conexao = ConnectionPetDAO.getConnection();
             PreparedStatement psInsert = conexao.prepareStatement(sql)){
            
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
    
     public boolean alterCadastros(String campo, String valor, int id){
         String sql = "UPDATE Cadastro_Pets SET " + campo + " = ? WHERE id = ?";
        try(Connection conexao = ConnectionPetDAO.getConnection();
             PreparedStatement psInsert = conexao.prepareStatement(sql)){
            
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
        String sql = "DELETE FROM Cadastro_Pets WHERE id = ?";
        try(Connection conexao = ConnectionPetDAO.getConnection();
             PreparedStatement psDelete = conexao.prepareStatement(sql)){
            
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
        
        String sql = "SELECT * FROM Cadastro_Pets ORDER BY id";
        try(Connection conexao = ConnectionPetDAO.getConnection();
             PreparedStatement psInsert = conexao.prepareStatement(sql)){
           
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
    /*
    public boolean selectFilterCadastros(String filtro, String valor){
        List<String> validColumns = Arrays.asList("nomePet", "caracteristicas", "nomeTutor", "endereco");

        if (!validColumns.contains(filtro)) {
            throw new IllegalArgumentException("Filtro inválido: " + filtro);
        }
        
        String sql = "SELECT * FROM Cadastro_Pets WHERE " + filtro + " LIKE ? ORDER BY id";
        try(Connection conexao = ConnectionPetDAO.getConnection();
             PreparedStatement psInsert = conexao.prepareStatement(sql)){
           
            psInsert.setString(1, "%" + valor + "%");
            
            ResultSet rs;
            rs = psInsert.executeQuery();
            
            List<ModeloTabelaPets> resultados = new ArrayList<>();

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
                resultados.add(cad);
            }
            
            Busca_Pet bp = new Busca_Pet();
            bp.atualizarTabela2(resultados);
            return psInsert.execute();
            
        }catch (Exception e){
            e.printStackTrace();
            
            return false;
        }*/
    

}
