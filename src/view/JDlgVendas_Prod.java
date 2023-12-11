package view;

import telasPesquisa.VendasProdControle;
import bean.TkslProduto;
import bean.TkslVendasproduto;
import com.mysql.jdbc.Util;
import dao.tksl_ProdutoDao;
import java.util.List;
import tools.util;

public class JDlgVendas_Prod extends javax.swing.JDialog {

    JDlgVendas jDlgVendas;
    private int codigoVenda;
    TkslProduto produto;
    tksl_ProdutoDao produtoDAO;
    util util;


    VendasProdControle vendaProdCont;

    public JDlgVendas_Prod(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Vendas Produtos");
        setLocationRelativeTo(null);
        produtoDAO = new tksl_ProdutoDao();

        jTxtTotal.setEnabled(false);
        jTxtValorUnitario.setEditable(false);

        List listaVP;
        listaVP = produtoDAO.listAll();
        for (int i = 0; i < listaVP.size(); i++) {
            jCboProduto.addItem((TkslProduto) listaVP.get(i));
        }
        jTxtTotal.setEnabled(false);
        jTxtValorUnitario.setEnabled(false);

    }

    public void setTelaAnterior(JDlgVendas jDlgVendas, int codigoVenda) {
        this.jDlgVendas = jDlgVendas;
//        this.codigoVenda = codigoVenda;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jCboProduto = new javax.swing.JComboBox<TkslProduto>();
        jTxtQuantidade = new javax.swing.JTextField();
        jTxtValorUnitario = new javax.swing.JTextField();
        jTxtTotal = new javax.swing.JTextField();
        jBtnOk = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setText("Produto:");

        jLabel4.setText("Quantidade:");

        jLabel5.setText("Total:");

        jLabel6.setText("Valor Unitario:");

        jCboProduto.setToolTipText("");
        jCboProduto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jCboProduto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCboProdutoItemStateChanged(evt);
            }
        });
        jCboProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jCboProdutoFocusLost(evt);
            }
        });
        jCboProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboProdutoActionPerformed(evt);
            }
        });

        jTxtQuantidade.setText("1");
        jTxtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxtQuantidadeKeyReleased(evt);
            }
        });

        jTxtValorUnitario.setText("0.0");
        jTxtValorUnitario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtValorUnitarioFocusLost(evt);
            }
        });

        jTxtTotal.setText("0.0");

        jBtnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jBtnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOkActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTxtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTxtTotal)))))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnCancelar)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jCboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOkActionPerformed
        // TODO add your handling code here:
        TkslVendasproduto vnp = new TkslVendasproduto();
        //vnp.setTksl((TkslProduto) jCboProduto.getSelectedItem());
        vnp.setTkslQuantidade(Integer.valueOf(jTxtQuantidade.getText()));
        vnp.setTkslValorUnitario(Double.parseDouble(jTxtValorUnitario.getText()));
        vnp.setTkslVendas(jDlgVendas.venda);
        jDlgVendas.vendasProdControle.addList(vnp);
        jDlgVendas.paseTotal(Double.parseDouble(jTxtTotal.getText()));
        setVisible(false);

    }//GEN-LAST:event_jBtnOkActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jTxtValorUnitarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtValorUnitarioFocusLost
        // TODO add your handling code here:
        TkslProduto produto = (TkslProduto) jCboProduto.getSelectedItem();
        double valor = produto.getTkslValorUnitario();
        jTxtValorUnitario.setText(String.valueOf(valor));
        double quantidade = Double.valueOf(jTxtQuantidade.getText());
        jTxtTotal.setText(String.valueOf(quantidade * valor));
    }//GEN-LAST:event_jTxtValorUnitarioFocusLost

    private void jCboProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCboProdutoFocusLost
        // TODO add your handling code here:
         TkslProduto produto = (TkslProduto) jCboProduto.getSelectedItem();
        double valor = produto.getTkslValorUnitario();
        jTxtValorUnitario.setText(String.valueOf(valor));
        double quantidade = Double.valueOf(jTxtQuantidade.getText());
        jTxtTotal.setText(String.valueOf(quantidade * valor));

    }//GEN-LAST:event_jCboProdutoFocusLost

    private void jCboProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboProdutoActionPerformed
        // TODO add your handling code here:
        TkslProduto produto = (TkslProduto) jCboProduto.getSelectedItem();
        double valor = produto.getTkslValorUnitario();
        jTxtValorUnitario.setText(String.valueOf(valor));
        double quantidade = Double.valueOf(jTxtQuantidade.getText());
        jTxtTotal.setText(String.valueOf(quantidade * valor));

    }//GEN-LAST:event_jCboProdutoActionPerformed

    private void jCboProdutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCboProdutoItemStateChanged
        // TODO add your handling code here:
        jTxtQuantidade.setText("1");
        TkslProduto produto = (TkslProduto) jCboProduto.getSelectedItem();
        jTxtValorUnitario.setText( util.doubleStr(produto.getTkslValorUnitario()));
    }//GEN-LAST:event_jCboProdutoItemStateChanged

    private void jTxtQuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtQuantidadeKeyReleased
        // TODO add your handling code here:
        if(jTxtQuantidade.getText().isEmpty() == false) {
        double valor = Double.parseDouble(jTxtValorUnitario.getText());
        double quantidade = Integer.parseInt(jTxtQuantidade.getText());
        jTxtTotal.setText(String.valueOf(quantidade * valor));
        } else {
            jTxtTotal.setText("0");
        }
    }//GEN-LAST:event_jTxtQuantidadeKeyReleased

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
            java.util.logging.Logger.getLogger(JDlgVendas_Prod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas_Prod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas_Prod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas_Prod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                JDlgVendas_Prod dialog = new JDlgVendas_Prod(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnOk;
    private javax.swing.JComboBox<TkslProduto> jCboProduto;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTxtQuantidade;
    private javax.swing.JTextField jTxtTotal;
    private javax.swing.JTextField jTxtValorUnitario;
    // End of variables declaration//GEN-END:variables
}
