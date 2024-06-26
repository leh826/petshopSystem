package View;

import javax.swing.table.DefaultTableModel;
import DAO.CadastroPetDAO;
import com.itextpdf.text.log.Logger;
import java.lang.System.Logger.Level;
import DAO.ConnectionPetDAO;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import Model.ModeloTabelaPets;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.swing.JOptionPane;

public class Busca_Pet extends javax.swing.JFrame {
    
    private JTable tabela1;
    private DefaultTableModel modeloTabela;
    private ModeloTabelaPets exibirCadastros;
    private JScrollPane scrollPane;
    
    public Busca_Pet() {
        initComponents();
        
        
        criarTabela();

        exibirCadastros = new ModeloTabelaPets();
        exibirCadastros.setModeloTabela(modeloTabela);

        modeloTabela.addTableModelListener(e -> {
   
        });

        atualizarTabela();
    }

    private void criarTabela() {

        tabela1 = new JTable();
        modeloTabela = new DefaultTableModel();

        modeloTabela.addColumn("COD PET");
        modeloTabela.addColumn("PET");
        modeloTabela.addColumn("ESPECIE");
        modeloTabela.addColumn("RAÇA");
        modeloTabela.addColumn("SEXO");
        modeloTabela.addColumn("IDADE");
        modeloTabela.addColumn("COR");
        modeloTabela.addColumn("PESO");
        modeloTabela.addColumn("CARACTERISTICAS");
        modeloTabela.addColumn("NOME DO TUTOR");
        modeloTabela.addColumn("CONTATO");
        modeloTabela.addColumn("CPF DO TUTOR");
        modeloTabela.addColumn("ENDEREÇO");
        modeloTabela.addColumn("HISTORICO DE VACINAS");
        modeloTabela.addColumn("MEDICAMENTOS EM USO");
        modeloTabela.addColumn("ALERGIAS");
        modeloTabela.addColumn("HIST. DOENÇAS/COND. MÉDICAS");

        tabela1.setModel(modeloTabela);

        scrollPane = new JScrollPane(tabela1);

        setLayout(null);

        scrollPane.setBounds(50, 100, 900, 400);

        add(scrollPane);

        
    }

    public void atualizarTabela() {
        
        modeloTabela.setRowCount(0);

        for (ModeloTabelaPets cad : ModeloTabelaPets.listaCadastros) {
            exibirCadastros.adicionarCads(cad);
        }
        
    }
    
    public void limparTabela() {
        modeloTabela.setRowCount(0); 
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        canvas1 = new java.awt.Canvas();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Buscar Pet");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Voltar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("Pets Cadastrados");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/barra-logo-5.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(269, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canvas1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(187, 187, 187)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jLabel2))
                .addGap(337, 337, 337)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        
        dispose();
        
        atualizarTabela();
        
        limparTabela();
        
        new Opc_Cadastros().setVisible(true);
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        
        int index = tabela1.getSelectedRow();
        System.out.print(index);
        String id = (String) tabela1.getValueAt​(index, 0);
        System.out.print(id);
        
        CadastroPetDAO bd;
        try {
            bd = new CadastroPetDAO();
            if (index != -1) {
            
            bd.deleteCadastros(parseInt(id)); 
            
            ((DefaultTableModel) tabela1.getModel()).removeRow(index);
            ModeloTabelaPets.listaCadastros.remove(index);

            } else {

                JOptionPane.showMessageDialog(this, "Nenhuma linha selecionada", "Aviso", JOptionPane.WARNING_MESSAGE);

            }
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
   
        //bd.desconnectBD();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        int index = tabela1.getSelectedRow();
        System.out.print(index);
        String campo = null;
        String valor = null;
        
        
        String id = (String) tabela1.getValueAt​(index, 0);
        String nomePet = (String) tabela1.getValueAt​(index, 1);
        String especie = (String) tabela1.getValueAt​(index, 2);
        String raca = (String) tabela1.getValueAt​(index, 3);
        String sexo = (String) tabela1.getValueAt​(index, 4);
        String idade = (String) tabela1.getValueAt​(index, 5);
        String cor = (String) tabela1.getValueAt​(index, 6);
        String peso = (String) tabela1.getValueAt​(index, 7);
        String caracteristicas = (String) tabela1.getValueAt​(index, 8);
        String nomeTutor = (String) tabela1.getValueAt​(index, 9);
        String contato = (String) tabela1.getValueAt​(index, 10);
        String num_cpf = (String) tabela1.getValueAt​(index, 11);
        String endereco = (String) tabela1.getValueAt​(index, 12);
        String historico_vacinacao = (String) tabela1.getValueAt​(index, 13);
        String medicamentos_uso = (String) tabela1.getValueAt​(index, 14);
        String alergias = (String) tabela1.getValueAt​(index, 15);
        String hist_doencas_cond_medicas = (String) tabela1.getValueAt​(index, 15);
        
        CadastroPetDAO bd;
        ConnectionPetDAO bdd;
        
        try {
                bdd = new ConnectionPetDAO();
                bd = new CadastroPetDAO();
            
                if (index != -1) {

                String op = JOptionPane.showInputDialog(this, "1 - IDADE\n 2 - PESO\n 3 - CARACTERISTICAS\n 4 - NOME DO TUTOR\n 5 - CONTATO\n 6 - CPF\n 7 - ENDEREÇO\n Escolha um valor a ser alterado: ");


                switch(op){
                    case "1":
                         idade = JOptionPane.showInputDialog(this, "Qual a idade de seu pet?");

                         ModeloTabelaPets.listaCadastros.get(index).setIdade(idade);
                         modeloTabela.setValueAt(idade, index, 5);

                         campo = "idade";
                         valor = idade;

                        break;

                    case "2":
                        peso = JOptionPane.showInputDialog(this, "Qual o novo peso do seu pet?");

                         ModeloTabelaPets.listaCadastros.get(index).setPeso(peso);
                         modeloTabela.setValueAt(peso, index, 7);

                         campo = "peso";
                         valor = peso;
                        break;

                    case "3":
                        caracteristicas = JOptionPane.showInputDialog(this, "Qual a nova caracteristica de seu pet?");

                         ModeloTabelaPets.listaCadastros.get(index).setCaracteristicas(caracteristicas);
                         modeloTabela.setValueAt(caracteristicas, index, 8);

                         campo = "caracteristicas";
                         valor = caracteristicas;
                        break;


                    case "4":
                        nomeTutor = JOptionPane.showInputDialog(this, "Qual o novo tutor do Pet");

                        campo = "nomeTutor";
                        valor = nomeTutor;
                         ModeloTabelaPets.listaCadastros.get(index).setNomeTutor(nomeTutor);
                         modeloTabela.setValueAt(nomeTutor, index, 9);

                        break;

                    case "5":
                        contato = JOptionPane.showInputDialog(this, "Qual o novo contato do tutor?");

                        campo = "contato";
                        valor = contato;
                         ModeloTabelaPets.listaCadastros.get(index).setNomeTutor(contato);
                         modeloTabela.setValueAt(contato, index, 10);

                        break;

                    case "6":
                        num_cpf = JOptionPane.showInputDialog(this, "Qual o CPF do seu novo tutor?");

                        campo = "num_cpf";
                        valor = num_cpf;
                         ModeloTabelaPets.listaCadastros.get(index).setNomeTutor(num_cpf);
                         modeloTabela.setValueAt(num_cpf, index, 11);

                        break;

                    case "7":
                        endereco = JOptionPane.showInputDialog(this, "Qual o novo endereço do tutor?");

                        campo = "endereco";
                        valor = endereco;
                         ModeloTabelaPets.listaCadastros.get(index).setNomeTutor(endereco);
                         modeloTabela.setValueAt(endereco, index, 12);

                        break;

                    default:

                        JOptionPane.showInputDialog(this, "OPCAO INVALIDA!");

                        break;
                }

               bd.alterCadastros(campo, valor, parseInt(id));
               


            } else {

                JOptionPane.showMessageDialog(this, "Nenhuma linha selecionada", "Aviso", JOptionPane.WARNING_MESSAGE);

            }
                
            bdd.desconectar();
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Busca_Pet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Busca_Pet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Busca_Pet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Busca_Pet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Busca_Pet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
