package CustomTableCellRenderer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomTableCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Verifica se a coluna atual é a coluna "Quantidade"
        if (table.getColumnName(column).equals("Quantidade")) {
            // Verifica se o valor não é nulo e não está vazio
            if (value != null && !value.toString().isEmpty()) {
                try {
                    // Obtém o valor da quantidade e converte para inteiro
                    int quantidade = Integer.parseInt(value.toString());

                    // Se a quantidade for menor ou igual a 5, define a cor de fundo como "Estoque Baixo"
                    if (quantidade <= 5 && quantidade > 0) {
                        cellComponent.setBackground(Color.YELLOW); // Estoque Baixo
                    } else if (quantidade == 0) {
                        cellComponent.setBackground(Color.RED); // Estoque Zerado
                    }else if (quantidade > 5) {
                        cellComponent.setBackground(Color.GREEN); // Em Estoque
                    } else {
                        // Caso contrário, mantenha a cor de fundo padrão da tabela
                        cellComponent.setBackground(table.getBackground());
                    }
                } catch (NumberFormatException e) {
                    // Se ocorrer uma exceção ao tentar converter para número, mantenha a cor de fundo padrão da tabela
                    cellComponent.setBackground(table.getBackground());
                }
            } else {
                // Se o valor for nulo ou vazio, mantenha a cor de fundo padrão da tabela
                cellComponent.setBackground(table.getBackground());
            }
        } else {
            // Caso não seja a coluna "Quantidade", mantenha a cor de fundo padrão da tabela
            cellComponent.setBackground(table.getBackground());
        }

        return cellComponent;
    }
}
