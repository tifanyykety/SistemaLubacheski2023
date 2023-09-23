/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telasPesquisa;

import bean.TkslUsuarios;
import dao.tksl_UsuarioDao;
import java.util.List;
import view.JDlgUsuarios;
import javax.swing.JOptionPane;
import tools.util;

public class JDlgPesquisaUsuario extends javax.swing.JDialog {

    /**
     * Creates new form JDlgPesquisaCliente
     */
    JDlgUsuarios jDlgUsuarios;
    util util;
    tksl_UsuarioDao usuarioDao;
    UsuarioControle pesquisarUsuario;

    public JDlgPesquisaUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Pesquisar Usuario");
        usuarioDao = new tksl_UsuarioDao();

        pesquisarUsuario = new UsuarioControle();

        List lista = usuarioDao.listAll();

        pesquisarUsuario.setList(lista);
        jTable1.setModel(pesquisarUsuario);
    }

    public void setTelaAnterior(JDlgUsuarios jDlgUsuarios) {
        this.jDlgUsuarios = jDlgUsuarios;

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
        tksl_jBtnOk = new javax.swing.JButton();
        tksl_jBtnCancelar3 = new javax.swing.JButton();

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
        jScrollPane1.setViewportView(jTable1);

        tksl_jBtnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confirmar.png"))); // NOI18N
        tksl_jBtnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tksl_jBtnOkActionPerformed(evt);
            }
        });

        tksl_jBtnCancelar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        tksl_jBtnCancelar3.setText("Cancelar");
        tksl_jBtnCancelar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tksl_jBtnCancelar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tksl_jBtnOk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tksl_jBtnCancelar3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tksl_jBtnCancelar3)
                    .addComponent(tksl_jBtnOk)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tksl_jBtnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tksl_jBtnOkActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() == -1) {
            util.mensagem("Selecione uma linha!");
        } else {
            jDlgUsuarios.usuarios = pesquisarUsuario.getUsuaruio(jTable1.getSelectedRow());
            jDlgUsuarios.beanView(jDlgUsuarios.usuarios);
            setVisible(false);
        }
    }//GEN-LAST:event_tksl_jBtnOkActionPerformed

    private void tksl_jBtnCancelar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tksl_jBtnCancelar3ActionPerformed
        // TODO add your handling code here:
        if (util.perguntar("Quer cancelar ?")) {
            setVisible(false);
            util.mensagem("Cancelado");
        } else {
            util.mensagem("Selecione uma linha");
        }
    }//GEN-LAST:event_tksl_jBtnCancelar3ActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgPesquisaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgPesquisaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgPesquisaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgPesquisaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgPesquisaUsuario dialog = new JDlgPesquisaUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton tksl_jBtnCancelar;
    private javax.swing.JButton tksl_jBtnCancelar1;
    private javax.swing.JButton tksl_jBtnCancelar2;
    private javax.swing.JButton tksl_jBtnCancelar3;
    private javax.swing.JButton tksl_jBtnOk;
    // End of variables declaration//GEN-END:variables
}
