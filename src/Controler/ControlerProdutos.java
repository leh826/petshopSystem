package Controler;

import Model.ModeloTabelaProdutos;
import DAO.FuncaoCrudProdutos;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControlerProdutos {


    public void chamarBtnAlterarDados(JTable jTable1) {
        btnAlterarDados(jTable1);
    }

    public void btnDeletar(JTable jTable1) {
        int index = jTable1.getSelectedRow();

        if (index != -1) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();//definindo o modelo da tabela
            Object idObject = model.getValueAt(index, 2);// valor da coluna que deseja usar para alterar

            if (idObject instanceof Integer) {
                int id = (int) idObject;
                deletarProduto(id, model, index, jTable1);//chama a função deletar produto com base no valor da coluna atribuido na variável
            } else if (idObject instanceof String) {
                String idString = ((String) idObject).trim();
                try {
                    int id = Integer.parseInt(idString);
                    deletarProduto(id, model, index, jTable1);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de codigo inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Formato de codigo inválido", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void deletarProduto(int codigo, DefaultTableModel model, int index, JTable jTable1) {
        try {
            FuncaoCrudProdutos fun = new FuncaoCrudProdutos();
            if (fun.removerProduto(codigo)) {//chama a função remover produto para remover o produto do banco de dados
                if (index >= model.getRowCount()) { //pega o valor da linha
                    jTable1.clearSelection();//pega a tabela e limpa a linha
                }
                JOptionPane.showMessageDialog(null, "Removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao remover produto.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlerProdutos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void btnInserir(String codigoBarras, String referencia, String codigo, String unidade, String valor_compra, String valor_venda, String quantidade, String categoria, String tipo, String marca, String validade, String localizacao, String fornecedor, String data_entrada) {
        try {
            // Convertendo os valores necessários para os tipos corretos antes de passá-los para o método de inserção
            int codigoInt = Integer.parseInt(codigo);
            int codigoBarrasInt = Integer.parseInt(codigoBarras);
            int quantidadeInt = Integer.parseInt(quantidade);
            double valor_compraDouble = Double.parseDouble(valor_compra);
            double valor_vendaDouble = Double.parseDouble(valor_venda);
            
            FuncaoCrudProdutos fun = new FuncaoCrudProdutos();
            if (fun.inserirProduto(codigoBarrasInt, referencia, codigoInt, unidade, valor_compraDouble, valor_vendaDouble, quantidadeInt, categoria, tipo, marca, validade, localizacao, fornecedor, data_entrada)) {
                JOptionPane.showMessageDialog(null, "Produto inserido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao inserir produto.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao converter valores. Verifique se os campos foram preenchidos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(ControlerProdutos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao criar conexão com o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnAlterarDados(JTable jTable1) {
        int linhaSelecionada = jTable1.getSelectedRow();

        if (linhaSelecionada != -1) {
            String[] camposInterface = {"Código de Barras", "Referência", "Código", "Unidade", "Quantidade", "Valor Compra", "Valor Venda", "Categoria", "Tipo", "Marca", "Validade", "Localização", "Fornecedor", "Data de Entrada"};
            String[] camposBanco = {"codigo_barras", "referencia", "codigo", "Unidade", "quantidade", "valor_compra", "valor_venda", "categoria", "tipo", "marca", "validade", "localizacao", "fornecedor", "data_entrada", "unidade"};
            
            JComboBox<String> campoComboBox = new JComboBox<>(camposInterface);// Criar um JComboBox com os campos de interface
            
            int result = JOptionPane.showConfirmDialog(null, campoComboBox, "Escolha o campo a ser alterado:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);// Exibir o JComboBox em um JOptionPane
            if (result == JOptionPane.OK_OPTION) {
                
                int escolhaCampo = campoComboBox.getSelectedIndex();// Obter o índice do campo selecionado no JComboBox
             
                if (escolhaCampo >= 0 && escolhaCampo < camposInterface.length) { // Verificar se a escolha é válida
                    String campoInterface = camposInterface[escolhaCampo];
                    String campoBanco = camposBanco[escolhaCampo];

                    Object codigoObject = jTable1.getValueAt(linhaSelecionada, 2); // Coluna do campo "Código"

                    if (codigoObject != null) {
                        String codigoStr = codigoObject.toString();
                        int codigo = Integer.parseInt(codigoStr);

                        String novoValor = JOptionPane.showInputDialog(null, "Digite o novo valor para " + campoInterface + ":");

                        if (novoValor != null && !novoValor.trim().isEmpty()) {
                            btnAlterar(campoBanco, novoValor.trim(), codigo);
                            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                            model.setRowCount(0);
                            ModeloTabelaProdutos dados = new ModeloTabelaProdutos();
                            dados.preencherTabela(jTable1);
                        } else {
                            JOptionPane.showMessageDialog(null, "O valor não pode ser vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "O código está nulo.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Escolha inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnAlterar(String campo, String valor, int codigo) {
        try {
            FuncaoCrudProdutos fun = new FuncaoCrudProdutos();
            if (fun.alterarProduto(campo, valor, codigo)) {
                JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao alterar registro.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlerProdutos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}