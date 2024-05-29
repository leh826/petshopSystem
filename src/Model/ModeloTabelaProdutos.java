package Model;

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
        
        try {
            FuncaoCrudProdutos crud = new FuncaoCrudProdutos();
            registros = crud.getDados();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloTabelaProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return registros;
    }

    public void preencherTabela(JTable tabela) {
        DefaultTableModel model = new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Código de Barras", "Referência", "Código", "Uni", "Valor Compra", "Valor de Venda", "Quantidade", "Grupo/Categoria", "Tipo", "Marca do Produto", "Validade", "Localização", "Fornecedor", "Data de Entrada"
            }
        );

        ArrayList<String> registros = getRegistros();
        int expectedColumns = 14; // Número de colunas esperadas na tabela

        for (String registro : registros) {
            String[] partes = registro.split(", ");

            // Verifique se o número de partes corresponde ao número esperado de colunas
            if (partes.length == expectedColumns) {
                model.addRow(partes);
            } else {
                // Log de erro para depuração
                System.err.println("Erro: o registro não contém o número esperado de colunas. Registro: " + registro);
            }
        }

        tabela.setModel(model);
    }
}
