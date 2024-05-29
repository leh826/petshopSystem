package Controler;

import Model.ModeloTabelaProdutos;
import DAO.FuncaoCrudProdutos;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControlerProdutos {

    public void btnDeletar(JTable jTable1) {
        int index = jTable1.getSelectedRow();

        if (index != -1) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            Object codigoObject = model.getValueAt(index, 0); // Coluna do código de barras

            if (codigoObject != null) {
                if (codigoObject instanceof String) {
                    String codigoStr = (String) codigoObject;
                    try {
                        int codigoBarras = Integer.parseInt(codigoStr);
                        deletarProduto(codigoBarras, model, index);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Formato de código de barras inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (codigoObject instanceof Integer) {
                    int codigo = (int) codigoObject;
                    deletarProduto(codigo, model, index);
                } else {
                    JOptionPane.showMessageDialog(null, "Formato de código de barras inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                model.removeRow(index); // Remover pela linha selecionada
                JOptionPane.showMessageDialog(null, "Linha removida com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void deletarProduto(int codigo, DefaultTableModel model, int index) {
        try {
            FuncaoCrudProdutos fun = new FuncaoCrudProdutos();
            if (fun.removerProduto(codigo)) {
                model.removeRow(index);
                JOptionPane.showMessageDialog(null, "Removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao remover produto.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlerProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void btnInserir(String codigoBarras, String referencia, String codigo, String unidade, String valorCompra, String valorVenda, String quantidade, String categoria, String tipo, String marca, String validade, String localizacao, String fornecedor, String dataEntrada) {
        try {
            // Convertendo os valores necessários para os tipos corretos antes de passá-los para o método de inserção
            int codigoInt = Integer.parseInt(codigo);
            int codigoBarrasInt = Integer.parseInt(codigoBarras);
            int quantidadeInt = Integer.parseInt(quantidade);
            double valorCompraDouble = Double.parseDouble(valorCompra);
            double valorVendaDouble = Double.parseDouble(valorVenda);
            
            FuncaoCrudProdutos fun = new FuncaoCrudProdutos();
            if (fun.inserirProduto(codigoBarrasInt, referencia, codigoInt, unidade, valorCompraDouble, valorVendaDouble, quantidadeInt, categoria, tipo, marca, validade, localizacao, fornecedor, dataEntrada)) {
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

    public void btnAlterarDados(JTable jTable1) {
        int linhaSelecionada = jTable1.getSelectedRow();

        if (linhaSelecionada != -1) {
            String[] campos = {"Código de Barras", "Referência", "Código", "Quantidade", "Valor Compra", "Valor Venda", "Categoria", "Tipo", "Marca", "Validade", "Localização", "Fornecedor", "Data de Entrada"};
            StringBuilder mensagem = new StringBuilder("Escolha o número correspondente ao campo a ser alterado:\n");
            for (int i = 0; i < campos.length; i++) {
                mensagem.append(i + 1).append(". ").append(campos[i]).append("\n");
            }

            try {
                int escolhaCampo = Integer.parseInt(JOptionPane.showInputDialog(null, mensagem.toString()));

                if (escolhaCampo >= 1 && escolhaCampo <= campos.length) {
                    String campo = campos[escolhaCampo - 1];
                    Object codigoObject = jTable1.getValueAt(linhaSelecionada, 2); // Coluna do campo "Código"

                    if (codigoObject != null) {
                        String codigoStr = codigoObject.toString();
                        int codigo = Integer.parseInt(codigoStr);

                        String novoValor = JOptionPane.showInputDialog(null, "Digite o novo valor para " + campo + ":");

                        if (novoValor != null && !novoValor.trim().isEmpty()) {
                            btnAlterar(campo, novoValor.trim(), codigo);

                            JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                            model.setRowCount(0);
                            ModeloTabelaProdutos dados = new ModeloTabelaProdutos();
                            dados.preencherTabela(jTable1);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "O código está nulo.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Escolha inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Escolha inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void btnAlterar(String campo, String novoValor, int codigo) {
        try {
            FuncaoCrudProdutos fun = new FuncaoCrudProdutos();
            if (fun.alterarProduto(campo, novoValor, codigo)) {
                System.out.println("Operação bem-sucedida! Informação alterada.");
            } else {
                System.out.println("Falha ao executar a operação.");
            }
        } catch (SQLException e) {
            if (e.getMessage().contains("Os dados de sequência ou binários estão truncados")) {
                JOptionPane.showMessageDialog(null, "O valor inserido é muito grande. Por favor, insira um valor menor.");
            } else {
                e.printStackTrace();
            }
        }
    }
}