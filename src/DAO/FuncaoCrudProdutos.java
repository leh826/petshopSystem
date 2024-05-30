package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncaoCrudProdutos {

    private final ConnectionPetDAO ConnectionPetDAO;

    public FuncaoCrudProdutos() throws SQLException {
        this.ConnectionPetDAO = new ConnectionPetDAO();
    }

    public boolean inserirProduto(int codigoBarras, String referencia, int codigo, String unidade, double valor_compra, double valor_venda, int quantidade, String categoria, String tipo, String marca, String validade, String localizacao, String fornecedor, String data_entrada) {
        String sql = "INSERT INTO Cadastro_Produtos_Pets (codigo_barras, referencia, codigo, unidade, valor_compra, valor_venda, quantidade, categoria, tipo, marca, validade, localizacao, fornecedor, data_entrada) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection conexao = ConnectionPetDAO.getConnection();
             PreparedStatement psInsert = conexao.prepareStatement(sql)) {
            psInsert.setInt(1, codigoBarras);
            psInsert.setString(2, referencia);
            psInsert.setInt(3, codigo);
            psInsert.setString(4, unidade);
            psInsert.setDouble(5, valor_compra);
            psInsert.setDouble(6, valor_venda);
            psInsert.setInt(7, quantidade);
            psInsert.setString(8, categoria);
            psInsert.setString(9, tipo);
            psInsert.setString(10, marca);
            psInsert.setString(11, validade);
            psInsert.setString(12, localizacao);
            psInsert.setString(13, fornecedor);
            psInsert.setString(14, data_entrada);
            return psInsert.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterarProduto(String campo, String valor, int codigo) {
        String sql = "UPDATE Cadastro_Produtos_Pets SET " + campo + " = ? WHERE codigo = ?";
        try (Connection conexao = ConnectionPetDAO.getConnection();
            PreparedStatement psUpdate = conexao.prepareStatement(sql)) {
            psUpdate.setString(1, valor);
            psUpdate.setInt(2, codigo);
            int rowsAffected = psUpdate.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removerProduto(int codigo) {
        String sql = "DELETE FROM Cadastro_Produtos_Pets WHERE codigo=?";
        try (Connection conexao = ConnectionPetDAO.getConnection();
            PreparedStatement psDelete = conexao.prepareStatement(sql)) {
            psDelete.setInt(1, codigo);
            int rowsAffected = psDelete.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<String> getDados() {
        ArrayList<String> dados = new ArrayList<>();
        String sql = "SELECT * FROM Cadastro_Produtos_Pets";
        try (Connection conexao = ConnectionPetDAO.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String codigoBarras = rs.getString("codigo_barras");
                String referencia = rs.getString("referencia");
                int codigo = rs.getInt("codigo");
                String unidade = rs.getString("unidade");
                double valorCompra = rs.getDouble("valor_compra");
                double valorVenda = rs.getDouble("valor_venda");
                int quantidade = rs.getInt("quantidade");
                String categoria = rs.getString("categoria");
                String tipo = rs.getString("tipo");
                String marca = rs.getString("marca");
                String validade = rs.getString("validade");
                String localizacao = rs.getString("localizacao");
                String fornecedor = rs.getString("fornecedor");
                String dataEntrada = rs.getString("data_entrada");

                String dado = codigoBarras + ", " + referencia + ", " + codigo + ", " + unidade + ", " + valorCompra + ", " + valorVenda + ", " + quantidade + ", " + categoria + ", " + tipo + ", " + marca + ", " + validade + ", " + localizacao + ", " + fornecedor + ", " + dataEntrada;
                dados.add(dado);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
     return dados;
    }
    public boolean existsById(int id) {
    
    try (Connection conexao = ConnectionPetDAO.getConnection();) {
        String sql = "SELECT * FROM pets WHERE id = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next(); // Retorna true se um registro foi encontrado, false caso contrário
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false; // Retorna false se ocorrer um erro
}
}
