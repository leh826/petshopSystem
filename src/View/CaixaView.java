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

public class CaixaView extends javax.swing.JFrame {


    public CaixaView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox2 = new javax.swing.JComboBox<>();
        jSpinner1 = new javax.swing.JSpinner();
        caixa = new javax.swing.JPanel();
        lblCaixa = new javax.swing.JLabel();
        cbmStatusPedido = new javax.swing.JComboBox<>();
        fmtxtHora = new javax.swing.JFormattedTextField();
        lblDataFechamento = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        fmtxtDataFechamento = new javax.swing.JFormattedTextField();
        btnConfirmar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lblTotalPedido = new javax.swing.JLabel();
        txtTotalPedido = new javax.swing.JTextField();
        btnImprimir = new javax.swing.JButton();
        lblStatusPedido = new javax.swing.JLabel();
        lblNum = new javax.swing.JLabel();
        txtNumeroPedido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        caixa.setBackground(new java.awt.Color(204, 204, 204));
        caixa.setBorder(javax.swing.BorderFactory.createTitledBorder("Tela Caixa"));
        caixa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCaixa.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        lblCaixa.setText("CAIXA");
        caixa.add(lblCaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 50, -1));

        cbmStatusPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "fechado", "em andamento" }));
        cbmStatusPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmStatusPedidoActionPerformed(evt);
            }
        });
        caixa.add(cbmStatusPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 160, 30));

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
        caixa.add(fmtxtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 66, 28));

        lblDataFechamento.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        lblDataFechamento.setText("Data Fechamento");
        caixa.add(lblDataFechamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 128, -1));

        lblHora.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        lblHora.setText("Hora");
        caixa.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 61, -1));

        try {
            fmtxtDataFechamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        caixa.add(fmtxtDataFechamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 182, 128, 30));

        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icon-check.png"))); // NOI18N
        btnConfirmar.setText("Confirmar");
        caixa.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, -1, 50));

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icon-x.png"))); // NOI18N
        btnSair.setText("Sair");
        caixa.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 97, 50));

        lblTotalPedido.setText("Total do pedido");
        caixa.add(lblTotalPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 144, -1));
        caixa.add(txtTotalPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 212, 41));

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        caixa.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, -1, -1));

        lblStatusPedido.setText("Pedido status");
        caixa.add(lblStatusPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, -1));

        lblNum.setText("N°");
        caixa.add(lblNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));
        caixa.add(txtNumeroPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 30, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/mulher-caixa.png"))); // NOI18N
        caixa.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 130, 140));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(caixa, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(caixa, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    private void cbmStatusPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmStatusPedidoActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_cbmStatusPedidoActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        imprimir("C:\\Users\\Leticia\\OneDrive\\Documentos\\Constraints_letícia souza.docx");
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void fmtxtHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fmtxtHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fmtxtHoraActionPerformed
    public void imprimir(String caminhoArquivo){
        Desktop desktop = Desktop.getDesktop();
        
        try {
           File arquivoImprimir = new File (caminhoArquivo);
           desktop.print(arquivoImprimir);
        } catch (IOException e) {
            e.printStackTrace();
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
            java.util.logging.Logger.getLogger(CaixaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CaixaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CaixaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaixaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CaixaView().setVisible(true);
            }
        });
        Document documentoPDF = new Document();
        
        try {
            //cria uma instancia do documento e da nome do pdf
            PdfWriter.getInstance(documentoPDF, new FileOutputStream ("C:\\PDF_teste1.0.pdf"));
            //abrir documento pdf
            documentoPDF.open();
            
            //setar o tamanho da página
            documentoPDF.setPageSize(PageSize.A4);
            
            //adicionando primeiro paragrafo
            documentoPDF.add(new Paragraph("GERANDO PDF COM PROGRAMINHA JAVA"));
        } catch (DocumentException de) {
            de.printStackTrace();
        }catch(IOException ioe){
           ioe.printStackTrace();
        }finally{
            documentoPDF.close();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel caixa;
    private javax.swing.JComboBox<String> cbmStatusPedido;
    private javax.swing.JFormattedTextField fmtxtDataFechamento;
    private javax.swing.JFormattedTextField fmtxtHora;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lblCaixa;
    private javax.swing.JLabel lblDataFechamento;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblStatusPedido;
    private javax.swing.JLabel lblTotalPedido;
    private javax.swing.JTextField txtNumeroPedido;
    private javax.swing.JTextField txtTotalPedido;
    // End of variables declaration//GEN-END:variables
}
