package Model;

import DAO.ConnectionPetDAO;
import DAO.FuncaoCrudProdutos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ModeloTabelaProdutos {
        public ArrayList<String> getRegistros() {
        ArrayList<String> registros = new ArrayList<>();
        
        ConnectionPetDAO conexao = null;
        try {
            conexao = new ConnectionPetDAO();
            FuncaoCrudProdutos crud = new FuncaoCrudProdutos();
            registros = crud.getDados();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloTabelaProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return registros;
    }

    public void preencherTabela(JTable tabela) {

        DefaultTableModel model = new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Código de Barras", "Referência", "Código", "Uni", "Valor Compra", "Valor de Venda", "Quantidade", "Grupo/Categoria", "Tipo", "Marca do Produto", "Validade", "Localização", "Fornecedor", "Data de Entrada"
            }
        );

        ArrayList<String> registros = getRegistros();

        for (String registro : registros) {
            
            String[] partes = registro.split(", ");
            
            model.addRow(partes);
        }

        tabela.setModel(model);
    }
}
