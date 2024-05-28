package Filtros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class FiltroPesquisaProdutos {
    private TableRowSorter<DefaultTableModel> rowSorter;
    private JTextField filtroTextField;
    private JTable jTable;
    private JComboBox<String> jComboBox1;

    public void setupTableFilter(JTable jTable1, JTextField jTextField9, JComboBox<String> jComboBox1) {
        this.jTable = jTable1;
        this.rowSorter = new TableRowSorter<>((DefaultTableModel) jTable.getModel());
        jTable.setRowSorter(rowSorter);
        this.filtroTextField = jTextField9;
        this.jComboBox1 = jComboBox1;

        jTextField9.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                definirFiltro();
            }
        });

        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                definirFiltro();
            }
        });
    }

    public void definirFiltro() {
        if (filtroTextField != null && jComboBox1 != null) {
            String text = filtroTextField.getText();
            String categoriaSelecionada = (String) jComboBox1.getSelectedItem();

            List<RowFilter<Object, Object>> filters = new ArrayList<>();
            filters.add(RowFilter.regexFilter("(?i)" + text));

            if (!categoriaSelecionada.equals("Pesquisar Todos")) {
                filters.add(RowFilter.regexFilter("(?i)" + categoriaSelecionada));
            }

            // Adicione outros filtros, se necessário

            RowFilter<Object, Object> compoundRowFilter = RowFilter.andFilter(filters);
            rowSorter.setRowFilter(compoundRowFilter);
        }
    }

    public void verificarEstoqueBaixoEVazio(int colunaQuantidade) {
        if (jTable != null) {
            for (int i = 0; i < jTable.getRowCount(); i++) {
                Object quantidadeObj = jTable.getValueAt(i, colunaQuantidade);
                if (quantidadeObj != null && !quantidadeObj.toString().isEmpty()) {
                    try {
                        int quantidade = Integer.parseInt(quantidadeObj.toString());
                        if (quantidade == 0) {
                            jTable.setValueAt("Estoque Vazio", i, colunaQuantidade);
                        } else if (quantidade < 5) {
                            jTable.setValueAt("Estoque Baixo", i, colunaQuantidade);
                        }
                    } catch (NumberFormatException e) {
                        // Ignora o valor não numérico
                    }
                }
            }
        }
    }

    public void adicionarCategoriasComboBox(JTable jTable, JComboBox<String> jComboBox3, int suaColunaDeCategoria) {
        if (jTable != null && jComboBox3 != null) {
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            HashSet<String> categoriasSet = new HashSet<>();

            for (int i = 0; i < model.getRowCount(); i++) {
                String categoria = (String) model.getValueAt(i, suaColunaDeCategoria);
                if (categoria != null && !categoria.isEmpty()) {
                    categoriasSet.add(categoria);
                }
            }

            jComboBox3.removeAllItems();
            jComboBox3.addItem("Pesquisar Todos");
            for (String categoria : categoriasSet) {
                jComboBox3.addItem(categoria);
            }

            // Adicionar um ActionListener para a JComboBox
            jComboBox3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Quando uma nova opção é selecionada, atualizar o filtro da tabela
                    definirFiltro();
                }
            });
        }
    }
}
