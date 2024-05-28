package Filtros;

import java.awt.event.ActionEvent;
import java.util.HashSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public final class FiltroCategoriaGrupo {
    private final JComboBox<String> jComboBox2;
    private final JTable jTable;
    private final DefaultTableModel tableModel;

    public FiltroCategoriaGrupo(JTable jTable) {
        this.jTable = jTable;
        this.tableModel = (DefaultTableModel) jTable.getModel();

        jComboBox2 = new JComboBox<>();
        adicionarCategoriasComboBox(7); // 6 é o índice da coluna onde estão as categorias

        // Adiciona um ouvinte de evento para detectar mudanças na seleção da JComboBox
        jComboBox2.addActionListener((ActionEvent e) -> {
            filtrarTabela();
        });
    }

    public void adicionarCategoriasComboBox(int colunaCategoria) {
        HashSet<String> categoriasSet = new HashSet<>();

        // Itera sobre as linhas da tabela para coletar categorias únicas
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String categoria = (String) tableModel.getValueAt(i, colunaCategoria);
            if (categoria != null && !categoria.isEmpty()) { // Verifica se a categoria não está vazia
                categoriasSet.add(categoria);
            }
        }

        // Adiciona as categorias únicas à JComboBox
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        comboBoxModel.addElement("Pesquisar Todos"); // Adiciona a opção "Pesquisar Todos" como padrão
        for (String categoria : categoriasSet) {
            comboBoxModel.addElement(categoria);
        }
        jComboBox2.setModel(comboBoxModel);
    }

    private void filtrarTabela() {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        jTable.setRowSorter(sorter);

        String categoriaSelecionada = (String) jComboBox2.getSelectedItem();
        if (!categoriaSelecionada.equals("Pesquisar Todos")) {
            sorter.setRowFilter(
                new javax.swing.RowFilter<Object, Object>() {
                    @Override
                    public boolean include(javax.swing.RowFilter.Entry<? extends Object, ? extends Object> entry) {
                        String categoriaNaLinha = (String) entry.getValue(7); // 7 é o índice da coluna onde estão as categorias
                        return categoriaSelecionada.equals(categoriaNaLinha);
                    }
                }
            );
        } else {
            sorter.setRowFilter(null); // Remove qualquer filtro
        }
    }

    public JComboBox<String> getComboBox() {
        return jComboBox2;
    }
}
