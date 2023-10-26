/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.TkslCliente;
import bean.TkslVendasproduto;
import bean.TkslVendedor;
import dao.tksl_ClienteDao;
import dao.tksl_VendasDao;
import dao.tksl_VendasProdutoDao;
import dao.tksl_VendedorDao;
import bean.TkslVendas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import telasPesquisa.JDlgPesquisaVenda;
import tools.util;

public class JDlgVendas extends javax.swing.JDialog {

    public TkslVendas venda;
    TkslCliente cliente;
    TkslVendedor vendedor;
    tksl_VendasDao vendaDAO;
    tksl_ClienteDao clienteDAO;
    tksl_VendedorDao vendedorDAO;
    TkslVendasproduto vendaProduto;
    tksl_VendasProdutoDao vendaProdutoDAO;
    public VendasProdControle vendasProdControle;
    boolean incluindo;
    MaskFormatter mascaraData;
    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

    public JDlgVendas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Vendas");
        setLocationRelativeTo(null);
        Habilitar(false);
        limparCampos();
        venda = new TkslVendas();
        cliente = new TkslCliente();
        vendedor = new TkslVendedor();
        vendaDAO = new tksl_VendasDao();
        clienteDAO = new tksl_ClienteDao();
        vendedorDAO = new tksl_VendedorDao();
        vendaProdutoDAO = new tksl_VendasProdutoDao();
        vendaProduto = new TkslVendasproduto();
        incluindo = false;
        vendasProdControle = new VendasProdControle();
        vendasProdControle.setList(new ArrayList());
        jTable1.setModel(vendasProdControle);
        List listC;
        listC = clienteDAO.listAll();
        for (int i = 0; i < listC.size(); i++) {
            cliente = (TkslCliente) listC.get(i);
            tksl_jCboCliente.addItem(cliente);
        }

        List listV;
        listV = vendedorDAO.listAll();
        for (int i = 0; i < listV.size(); i++) {
            vendedor = (TkslVendedor) listV.get(i);
            tksl_jCboVendedor.addItem(vendedor);
        }

        try {
            mascaraData = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgVendas.class.getName()).log(Level.SEVERE, null, ex);
        }
        tksl_jFmtData.setFormatterFactory(new DefaultFormatterFactory(mascaraData));
    }

    public void Habilitar(boolean valor) {
        tksl_jTxtId.setEnabled(valor);
        tksl_jCboCliente.setEnabled(valor);
        tksl_jCboVendedor.setEnabled(valor);

        tksl_jFmtData.setEnabled(valor);
        tksl_jFmtTotal.setEnabled(valor);
        jTable1.setEnabled(valor);
        tksl_jBtnIncluirProd.setEnabled(valor);
        tksl_jBtnAlterarProd.setEnabled(valor);
        tksl_jBtnExcluirProd.setEnabled(valor);
        tksl_jBtnCancelar.setEnabled(valor);
        tksl_jBtnConfirmar.setEnabled(valor);

        tksl_jBtnAlterar.setEnabled(!valor);
        tksl_jBtnExcluir.setEnabled(!valor);
        tksl_jBtnIncluir.setEnabled(!valor);
        tksl_jBtnPesquisar.setEnabled(!valor);

    }

    public void limparCampos() {
        tksl_jTxtId.setText("");
        tksl_jCboCliente.setSelectedIndex(-1);
        tksl_jCboVendedor.setSelectedIndex(-1);

        tksl_jFmtData.setText("");

        tksl_jFmtTotal.setText("0.0");
    }

    public void paseTotal(Double total) {
        double calculo = Double.parseDouble(tksl_jFmtTotal.getText()) + total;
        tksl_jFmtTotal.setText(String.valueOf(calculo));
    }

    public TkslVendas viewBean() {
        venda.setTkslIdVendas(Integer.valueOf(tksl_jTxtId.getText()));
        venda.setTkslCliente((String) tksl_jCboCliente.getSelectedItem());
        try {
            venda.setTkslData(formatoData.parse(tksl_jFmtData.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(JDlgVendas.class.getName()).log(Level.SEVERE, null, ex);
        }
        venda.setTkslTotal(Double.valueOf(tksl_jFmtTotal.getText()));
        venda.setTkslVendedor((String) tksl_jCboVendedor.getSelectedItem());
        return venda;
    }

    public void beanView(TkslVendas venda) {
        tksl_jTxtId.setText(String.valueOf(venda.getTkslIdVendas()));
        tksl_jFmtData.setText(formatoData.format(venda.getTkslData()));
        tksl_jFmtTotal.setText(String.valueOf(venda.getTkslTotal()));
        tksl_jCboCliente.setSelectedItem(venda.getTkslCliente());
        tksl_jCboVendedor.setSelectedItem(venda.getTkslVendedor().toString());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tksl_jTxtId = new javax.swing.JTextField();
        tksl_jCboCliente = new javax.swing.JComboBox<TkslCliente>();
        tksl_jCboVendedor = new javax.swing.JComboBox<TkslVendedor>();
        tksl_jFmtData = new javax.swing.JFormattedTextField();
        tksl_jFmtTotal = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tksl_jBtnIncluirProd = new javax.swing.JButton();
        tksl_jBtnAlterarProd = new javax.swing.JButton();
        tksl_jBtnExcluirProd = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        tksl_jBtnAlterar = new javax.swing.JButton();
        tksl_jBtnIncluir = new javax.swing.JButton();
        tksl_jBtnExcluir = new javax.swing.JButton();
        tksl_jBtnCancelar = new javax.swing.JButton();
        tksl_jBtnConfirmar = new javax.swing.JButton();
        tksl_jBtnPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ID_Venda:");

        jLabel2.setText("Cliente:");

        jLabel3.setText("Vendedor:");

        jLabel4.setText("Data da Venda:");

        jLabel5.setText("Total:");

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

        tksl_jBtnIncluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir_1.png"))); // NOI18N
        tksl_jBtnIncluirProd.setText("Incluir");
        tksl_jBtnIncluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tksl_jBtnIncluirProdActionPerformed(evt);
            }
        });

        tksl_jBtnAlterarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        tksl_jBtnAlterarProd.setText("Alterar");
        tksl_jBtnAlterarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tksl_jBtnAlterarProdActionPerformed(evt);
            }
        });

        tksl_jBtnExcluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N
        tksl_jBtnExcluirProd.setText("Excluir");
        tksl_jBtnExcluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tksl_jBtnExcluirProdActionPerformed(evt);
            }
        });

        tksl_jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
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

        tksl_jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N
        tksl_jBtnExcluir.setText("Excluir");
        tksl_jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tksl_jBtnExcluirActionPerformed(evt);
            }
        });

        tksl_jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        tksl_jBtnCancelar.setText("Cancelar");
        tksl_jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tksl_jBtnCancelarActionPerformed(evt);
            }
        });

        tksl_jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confirmar.png"))); // NOI18N
        tksl_jBtnConfirmar.setText("Confirmar");
        tksl_jBtnConfirmar.setMaximumSize(new java.awt.Dimension(91, 33));
        tksl_jBtnConfirmar.setMinimumSize(new java.awt.Dimension(91, 33));
        tksl_jBtnConfirmar.setPreferredSize(new java.awt.Dimension(91, 33));
        tksl_jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tksl_jBtnConfirmarActionPerformed(evt);
            }
        });

        tksl_jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        tksl_jBtnPesquisar.setText("Pesquisar");
        tksl_jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tksl_jBtnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 703, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tksl_jBtnIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(tksl_jBtnAlterar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(tksl_jBtnExcluir)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(tksl_jBtnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(tksl_jBtnCancelar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(tksl_jBtnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tksl_jBtnAlterar)
                        .addComponent(tksl_jBtnIncluir)
                        .addComponent(tksl_jBtnExcluir)
                        .addComponent(tksl_jBtnCancelar)
                        .addComponent(tksl_jBtnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tksl_jBtnPesquisar))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tksl_jBtnIncluirProd, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tksl_jBtnAlterarProd)
                            .addComponent(tksl_jBtnExcluirProd)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(tksl_jTxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tksl_jFmtData, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tksl_jCboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tksl_jCboVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tksl_jFmtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(tksl_jBtnIncluirProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tksl_jBtnAlterarProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tksl_jBtnExcluirProd))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tksl_jTxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tksl_jFmtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tksl_jCboVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tksl_jCboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tksl_jFmtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tksl_jBtnIncluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tksl_jBtnIncluirProdActionPerformed
        // TODO add your handling code here:
        JDlgVendas_Prod jDlgVendas_Prod = new JDlgVendas_Prod(null, true);
        jDlgVendas_Prod.setTelaAnterior(this, Integer.valueOf(tksl_jTxtId.getText()));
        jDlgVendas_Prod.setVisible(true);
    }//GEN-LAST:event_tksl_jBtnIncluirProdActionPerformed

    private void tksl_jBtnAlterarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tksl_jBtnAlterarProdActionPerformed
        // TODO add your handling code here:
        int linha = jTable1.getSelectedRow();
        if (linha == -1) {
            util.mensagem("Nenhuma linha selecionada");
        } else {
            vendasProdControle.removeList(linha);
            JDlgVendas_Prod jDlgVendas_Prod = new JDlgVendas_Prod(null, true);
            jDlgVendas_Prod.setTelaAnterior(this, Integer.valueOf(tksl_jTxtId.getText()));
            jDlgVendas_Prod.setVisible(true);
        }

    }//GEN-LAST:event_tksl_jBtnAlterarProdActionPerformed

    private void tksl_jBtnExcluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tksl_jBtnExcluirProdActionPerformed
        // TODO add your handling code here:
        int linha = jTable1.getSelectedRow();
        if (linha == -1) {
            util.mensagem("Nenhuma linha selecionada");
        } else {
            if (util.perguntar("Deseja excluir?")) {
                vendasProdControle.removeList(jTable1.getSelectedRow());
                util.mensagem("Excluido");

            } else {
                util.mensagem("exclusão cancelada");
            }
        }
    }//GEN-LAST:event_tksl_jBtnExcluirProdActionPerformed

    private void tksl_jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tksl_jBtnAlterarActionPerformed
        if (venda != null) {
            Habilitar(true);
            incluindo = false;
            tksl_jTxtId.setEnabled(incluindo);
        } else {
            util.mensagem("Deve pesquisar antes");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tksl_jBtnAlterarActionPerformed

    private void tksl_jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tksl_jBtnIncluirActionPerformed
        Habilitar(true);
        limparCampos();
        incluindo = true;
        venda = new TkslVendas();
    }//GEN-LAST:event_tksl_jBtnIncluirActionPerformed

    private void tksl_jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tksl_jBtnExcluirActionPerformed
        if (venda != null) {
            if (util.perguntar("Deseja excluir?")) {
                venda = viewBean();
                vendaDAO.delete(venda);
                limparCampos();
                venda = null;
                util.mensagem("Excluido");
            } else {

                util.mensagem("Exclusão cancelada");
            }
        } else {

            util.mensagem("Nenhuma venda foi selecionado");
        }
    }//GEN-LAST:event_tksl_jBtnExcluirActionPerformed

    private void tksl_jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tksl_jBtnCancelarActionPerformed
        if (util.perguntar("Deseja Cancelar")) {
            venda = null;
            incluindo = false;
            limparCampos();
            Habilitar(false);
        } else {
            util.mensagem("Cancelado");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_tksl_jBtnCancelarActionPerformed

    private void tksl_jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tksl_jBtnConfirmarActionPerformed
        venda = viewBean();
        if (incluindo == true) {
//            for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
//                vendaProduto = vendasProdControle.getBean(linha);
//                vendaProduto.setTkslVendas(venda);
                vendaProdutoDAO.insert(vendaProduto);
            }
//            vendaDAO.insert(venda);
            else {
//            for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
//                vendaProduto = vendasProdControle.getBean(linha);
//                vendaProduto.setTkslVendas(venda);
                vendaProdutoDAO.update(vendaProduto);
            }
//            vendaDAO.update(venda);
//        }
        Habilitar(false);
        venda = null;
        incluindo = false;
        limparCampos();
        // TODO add your handling code here:
    }//GEN-LAST:event_tksl_jBtnConfirmarActionPerformed

    private void tksl_jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tksl_jBtnPesquisarActionPerformed
        /*        int resp = Integer.valueOf(JOptionPane.showInputDialog("DIGITE UM ID PARA PESQUISA"));
        venda = (Venda) vendaDAO.list(resp);
        beanView(venda);*/
        venda = new TkslVendas();
        JDlgPesquisaVenda jDlgPesquisaVenda = new JDlgPesquisaVenda(null, true);
        jDlgPesquisaVenda.setTelaAnterior(this);
        jDlgPesquisaVenda.setVisible(true);
    }//GEN-LAST:event_tksl_jBtnPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                JDlgVendas dialog = new JDlgVendas(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton tksl_jBtnAlterar;
    private javax.swing.JButton tksl_jBtnAlterarProd;
    private javax.swing.JButton tksl_jBtnCancelar;
    private javax.swing.JButton tksl_jBtnConfirmar;
    private javax.swing.JButton tksl_jBtnExcluir;
    private javax.swing.JButton tksl_jBtnExcluirProd;
    private javax.swing.JButton tksl_jBtnIncluir;
    private javax.swing.JButton tksl_jBtnIncluirProd;
    private javax.swing.JButton tksl_jBtnPesquisar;
    private javax.swing.JComboBox<TkslCliente> tksl_jCboCliente;
    private javax.swing.JComboBox<TkslVendedor> tksl_jCboVendedor;
    private javax.swing.JFormattedTextField tksl_jFmtData;
    private javax.swing.JFormattedTextField tksl_jFmtTotal;
    private javax.swing.JTextField tksl_jTxtId;
    // End of variables declaration//GEN-END:variables
}
