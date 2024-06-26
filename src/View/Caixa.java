/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Caixa extends javax.swing.JFrame {

    /**
     * Creates new form Caixa
     */
    public Caixa() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnImprimir = new javax.swing.JButton();
        cbmStatusPedido = new javax.swing.JComboBox<>();
        fmtxtHora = new javax.swing.JFormattedTextField();
        lblDataFechamento = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        fmtxtDataFechamento = new javax.swing.JFormattedTextField();
        lblTotalPedido = new javax.swing.JLabel();
        txtTotalPedido = new javax.swing.JTextField();
        lblStatusPedido = new javax.swing.JLabel();
        lblNum = new javax.swing.JLabel();
        txtNumeroPedido = new javax.swing.JTextField();
        lblTotalPedido1 = new javax.swing.JLabel();
        txtTotalPedido1 = new javax.swing.JTextField();
        btnImprimir1 = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblCaixa = new javax.swing.JLabel();

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Caixa");
        setName("Caixa"); // NOI18N

        cbmStatusPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "fechado", "em andamento" }));
        cbmStatusPedido.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbmStatusPedidoItemStateChanged(evt);
            }
        });
        cbmStatusPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmStatusPedidoActionPerformed(evt);
            }
        });

        try {
            fmtxtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fmtxtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fmtxtHoraActionPerformed(evt);
            }
        });

        lblDataFechamento.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        lblDataFechamento.setText("Data Fechamento");

        lblHora.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        lblHora.setText("Hora");

        try {
            fmtxtDataFechamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblTotalPedido.setText("Total do pedido");

        lblStatusPedido.setText("Pedido status");

        lblNum.setText("N°");

        lblTotalPedido1.setText("Cliente");

        btnImprimir1.setText("Imprimir");
        btnImprimir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimir1ActionPerformed(evt);
            }
        });

        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icon-check.png"))); // NOI18N
        btnConfirmar.setText("Confirmar");

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icon-x.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSairMouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/mulher-caixa.png"))); // NOI18N

        lblCaixa.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        lblCaixa.setText("CAIXA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalPedido1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblNum)
                                .addGap(56, 56, 56)
                                .addComponent(lblStatusPedido))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fmtxtDataFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(fmtxtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTotalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblDataFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(42, 42, 42)
                                    .addComponent(lblHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(txtNumeroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20)
                                    .addComponent(cbmStatusPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTotalPedido1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSair)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(btnImprimir1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCaixa)
                .addGap(22, 22, 22)
                .addComponent(lblTotalPedido1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtTotalPedido1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNum)
                            .addComponent(lblStatusPedido))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumeroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbmStatusPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDataFechamento)
                            .addComponent(lblHora))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(fmtxtDataFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fmtxtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addComponent(lblTotalPedido)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(txtTotalPedido)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(btnImprimir1)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbmStatusPedidoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbmStatusPedidoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbmStatusPedidoItemStateChanged

    private void cbmStatusPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmStatusPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbmStatusPedidoActionPerformed

    private void fmtxtHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fmtxtHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fmtxtHoraActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed

    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnImprimir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimir1ActionPerformed
        imprimir("C:\\Users\\Leticia\\OneDrive\\Documentos\\Constraints_letícia souza.docx");
    }//GEN-LAST:event_btnImprimir1ActionPerformed

    private void btnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseClicked
        dispose();
        new TelaOrçamento().setVisible(true);
    }//GEN-LAST:event_btnSairMouseClicked
    public void imprimir(String caminhoArquivo) {
        Desktop desktop = Desktop.getDesktop();

        try {
            File arquivoImprimir = new File(caminhoArquivo);
            desktop.print(arquivoImprimir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document documentoPDF = new Document();

        try {
            //cria uma instancia do documento e da nome do pdf
            PdfWriter.getInstance(documentoPDF, new FileOutputStream("C:\\Documentos"));
            //abrir documento pdf
            documentoPDF.open();

            //setar o tamanho da página
            documentoPDF.setPageSize(PageSize.A4);
            
             
            //adicionando primeiro paragrafo
            documentoPDF.add(new Paragraph("COMPROVANTE DE PAGAMENTO"));
            
            //nova pagina
            documentoPDF.newPage();
            
        } catch (DocumentException de) {
            de.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            documentoPDF.close();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Caixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Caixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Caixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Caixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Caixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnImprimir1;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> cbmStatusPedido;
    private javax.swing.JFormattedTextField fmtxtDataFechamento;
    private javax.swing.JFormattedTextField fmtxtHora;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblCaixa;
    private javax.swing.JLabel lblDataFechamento;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblStatusPedido;
    private javax.swing.JLabel lblTotalPedido;
    private javax.swing.JLabel lblTotalPedido1;
    private javax.swing.JTextField txtNumeroPedido;
    private javax.swing.JTextField txtTotalPedido;
    private javax.swing.JTextField txtTotalPedido1;
    // End of variables declaration//GEN-END:variables
}
