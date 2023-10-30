/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telasNovas;

import telasPesquisa.VendedorControle;
import bean.TkslVendedor;
import dao.tksl_VendedorDao;
import java.util.List;
import tools.util;

public class JDlgVendedorNovo extends javax.swing.JDialog {

    /**
     * Creates new form JDlgPesquis.f
     */
    JDlgVendedorIA vendedorNovo;
    util util;
    VendedorControle controleVendedor;
    TkslVendedor vendedor;
    tksl_VendedorDao vendedorDao;

    public JDlgVendedorNovo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Pesquisar.f");
        vendedor = new TkslVendedor();
        vendedorDao = new tksl_VendedorDao();
        controleVendedor = new VendedorControle();
        List lista = vendedorDao.listAll();
        controleVendedor.setList(lista);
        jTable1.setModel(controleVendedor);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tksl_jBtnExcluir = new javax.swing.JButton();
        tksl_jBtnAlterar = new javax.swing.JButton();
        tksl_jBtnIncluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        tksl_jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N
        tksl_jBtnExcluir.setText("Excluir");
        tksl_jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tksl_jBtnExcluirActionPerformed(evt);
            }
        });

        tksl_jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        tksl_jBtnAlterar.setText("Alterar");
        tksl_jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tksl_jBtnAlterarActionPerformed(evt);
            }
        });

        tksl_jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir.png"))); // NOI18N
        tksl_jBtnIncluir.setText("Incluir");
        tksl_jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tksl_jBtnIncluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tksl_jBtnIncluir)
                        .addGap(30, 30, 30)
                        .addComponent(tksl_jBtnAlterar)
                        .addGap(44, 44, 44)
                        .addComponent(tksl_jBtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tksl_jBtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tksl_jBtnIncluir)
                        .addComponent(tksl_jBtnAlterar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tksl_jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tksl_jBtnExcluirActionPerformed
        // TODO add your handling code here:
        if (util.perguntar("Quer excluir")) {
            vendedor = controleVendedor.getTkslVendedor(jTable1.getSelectedRow());
            vendedorDao.delete(vendedor);
            util.mensagem("Excluido");

        } else {
            util.mensagem("Selecione uma linha para exclusão");
        }
    }//GEN-LAST:event_tksl_jBtnExcluirActionPerformed

    private void tksl_jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tksl_jBtnAlterarActionPerformed
        // TODO add your handling code here:
        if (util.perguntar("Quer Alterar")) {
            vendedorNovo = new JDlgVendedorIA(null, true);
            vendedorNovo.setTelaAnterior(this);
            vendedorNovo.setTitle("Aterando");
            vendedorNovo.beanView(controleVendedor.getTkslVendedor(jTable1.getSelectedRow()));
            vendedorNovo.setVisible(true);
        } else {
            util.mensagem("Selecione uma linha para Alterar");
        }
    }//GEN-LAST:event_tksl_jBtnAlterarActionPerformed

    private void tksl_jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tksl_jBtnIncluirActionPerformed
        if (util.perguntar("Quer Incluir")) {
            vendedorNovo = new JDlgVendedorIA(null, true);
            vendedorNovo.setTelaAnterior(this);
            vendedorNovo.setTitle("Incluindo");
            vendedorNovo.setVisible(true);
        }
    }//GEN-LAST:event_tksl_jBtnIncluirActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            controleVendedor.setList(vendedorDao.listAll());
        }
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(JDlgVendedorNovo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgVendedorNovo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgVendedorNovo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgVendedorNovo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgVendedorNovo dialog = new JDlgVendedorNovo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton tksl_jBtnAlterar;
    private javax.swing.JButton tksl_jBtnExcluir;
    private javax.swing.JButton tksl_jBtnIncluir;
    // End of variables declaration//GEN-END:variables
}
