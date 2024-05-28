package Filtros;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public final class FiltroGeral {
    private final JComboBox<String> jComboBox1;
    private final JTable jTable;
    private final DefaultTableModel tableModel;

    public FiltroGeral(JTable jTable, JComboBox<String> jComboBox1) {
        this.jTable = jTable;
        this.tableModel = (DefaultTableModel) jTable.getModel();
        this.jComboBox1 = jComboBox1;

        jComboBox1.addActionListener((evt) -> {
            filtrarTabela();
        });
    }

    public void filtrarTabela() {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        jTable.setRowSorter(sorter);

        String filtroSelecionado = (String) jComboBox1.getSelectedItem();
        if (!filtroSelecionado.equals("Pesquisar Todos")) {
            sorter.setRowFilter(new RowFilter<DefaultTableModel, Object>() {
                @Override
                public boolean include(RowFilter.Entry<? extends DefaultTableModel, ? extends Object> entry) {
                    String tipo = (String) entry.getValue(8); // Índice da coluna "Tipo"
                    String quantidadeStr = (String) entry.getValue(6); // Índice da coluna "Quantidade"

                    // Tenta analisar a quantidade, se falhar, exclui do filtro
                    int quantidade;
                    try {
                        quantidade = Integer.parseInt(quantidadeStr);
                    } catch (NumberFormatException e) {
                        return false; // Exclui itens com valores de quantidade inválidos
                    }

                    switch (filtroSelecionado) {
                        case "Somente Produtos":
                            return "Produto".equals(tipo);
                        case "Somente Serviços":
                            return "Serviço".equals(tipo);
                        case "Somente Estoque Normal":
                            return quantidade > 5;
                        case "Somente Estoque Baixo":
                            return quantidade > 0 && quantidade <= 5;
                        case "Somente Estoque Zerado":
                            return quantidade == 0;
                        default:
                            return true;
                    }
                }
            });
        } else {
            sorter.setRowFilter(null); // Remove qualquer filtro
        }
    }
}
