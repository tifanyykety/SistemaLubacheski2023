/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.TkslCliente;
import dao.tksl_ClienteDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import telasPesquisa.JDlgPesquisaCliente;
import tools.util;

/**
 *
 * @author Tifany
 */
public class JDlgCliente extends javax.swing.JDialog {

    private boolean incluindo;
    MaskFormatter mascaraCep, mascaraCpf, mascaraDataNascimento, mascaraNumeroFone, mascaraRg;
    util util;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public TkslCliente cliente;
    tksl_ClienteDao clienteDao;

    /**
     * Creates new form JDlgCliente
     */
    public JDlgCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Cadastro de Cliente");
        setLocationRelativeTo(null);
        habilitar(false);
        limparCampos();
        cliente = new TkslCliente();
        clienteDao = new tksl_ClienteDao();
        try {
            mascaraCep = new MaskFormatter("#####-###");
            mascaraCpf = new MaskFormatter("###.###.###-##");
            mascaraDataNascimento = new MaskFormatter("##/##/####");
            mascaraNumeroFone = new MaskFormatter("(##)#####-####");
            mascaraRg = new MaskFormatter("#.###.###");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        tksl_jFmtCep.setFormatterFactory(new DefaultFormatterFactory(mascaraCep));
        tksl_jFmtCpf.setFormatterFactory(new DefaultFormatterFactory(mascaraCpf));
        tksl_jFmtDataNascimento.setFormatterFactory(new DefaultFormatterFactory(mascaraDataNascimento));
        tksl_jFmtNumeroFone.setFormatterFactory(new DefaultFormatterFactory(mascaraNumeroFone));
        tksl_jFmtRg.setFormatterFactory(new DefaultFormatterFactory(mascaraRg));

    }

    public void habilitar(boolean valor) {

        util.habilitar(valor, tksl_jTxtId, tksl_jTxtNomeCompleto, tksl_jTxtNomeFantasia,
                tksl_jTxtSexo, tksl_jFmtNumeroFone,
                tksl_jFmtDataNascimento,
                tksl_jTxtNacionalidade,
                tksl_jFmtRg, tksl_jFmtCpf,
                tksl_jTxtEmail, tksl_jTxtCargo,
                tksl_jFmtCep, tksl_jTxtLogradouro,
                tksl_jTxtPais, tksl_jTxtUf,
                tksl_jTxtCidade, tksl_jTxtBairro,
                tksl_jBtnConfirmar, tksl_jBtnCancelar
        );
        util.habilitar(!valor,
                tksl_jBtnIncluir,
                tksl_jBtnAlterar,
                tksl_jBtnExcluir,
                tksl_jBtnPesquisar
        );
    }

    public void limparCampos() {
        util.limparCampos(tksl_jTxtId, tksl_jTxtNomeCompleto, tksl_jTxtNomeFantasia,
                tksl_jTxtSexo, tksl_jFmtNumeroFone,
                tksl_jFmtDataNascimento,
                tksl_jTxtNacionalidade,
                tksl_jFmtRg, tksl_jFmtCpf,
                tksl_jTxtEmail, tksl_jTxtCargo,
                tksl_jFmtCep, tksl_jTxtLogradouro,
                tksl_jTxtPais, tksl_jTxtUf,
                tksl_jTxtCidade, tksl_jTxtBairro);

    }

    public TkslCliente viewBean() {

        cliente.setTkslIdCliente(Integer.valueOf(tksl_jTxtId.getText()));
        cliente.setTkslNomeCompleto(tksl_jTxtNomeCompleto.getText());
        cliente.setTkslNomeFantasia(tksl_jTxtNomeFantasia.getText());
        cliente.setTkslSexo(tksl_jTxtSexo.getText());
        cliente.setTkslNumeroFone(tksl_jFmtNumeroFone.getText());
        try {
            cliente.setTkslDataNascimento(dateFormat.parse(tksl_jFmtDataNascimento.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(JDlgCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        cliente.setTkslNacionalidade(tksl_jTxtNacionalidade.getText());
        cliente.setTkslRg(tksl_jFmtRg.getText());
        cliente.setTkslCpf(tksl_jFmtCpf.getText());
        cliente.setTkslEmail(tksl_jTxtEmail.getText());
        cliente.setTkslCargo(tksl_jTxtCargo.getText());
        cliente.setTkslCep(tksl_jFmtCep.getText());
        cliente.setTkslLogradouro(tksl_jTxtLogradouro.getText());
        cliente.setTkslPais(tksl_jTxtPais.getText());
        cliente.setTkslEstadoUf(tksl_jTxtUf.getText());
        cliente.setTkslCidade(tksl_jTxtCidade.getText());
        cliente.setTkslBairro(tksl_jTxtBairro.getText());
        return cliente;

    }

    public void beanView(TkslCliente cliente) {

        tksl_jTxtId.setText(String.valueOf(cliente.getTkslIdCliente()));
        tksl_jTxtNomeCompleto.setText(cliente.getTkslNomeCompleto());
        tksl_jTxtNomeFantasia.setText(cliente.getTkslNomeFantasia());
        tksl_jTxtSexo.setText(cliente.getTkslSexo());
        tksl_jFmtNumeroFone.setText(cliente.getTkslNumeroFone());
        tksl_jFmtDataNascimento.setText(dateFormat.format(cliente.getTkslDataNascimento()));
        tksl_jTxtNacionalidade.setText(cliente.getTkslNacionalidade());
        tksl_jFmtRg.setText(cliente.getTkslRg());
        tksl_jFmtCpf.setText(cliente.getTkslCpf());
        tksl_jTxtEmail.setText(cliente.getTkslEmail());
        tksl_jTxtCargo.setText(cliente.getTkslCargo());
        tksl_jFmtCep.setText(cliente.getTkslCep());
        tksl_jTxtLogradouro.setText(cliente.getTkslLogradouro());
        tksl_jTxtPais.setText(cliente.getTkslPais());
        tksl_jTxtUf.setText(cliente.getTkslEstadoUf());
        tksl_jTxtCidade.setText(cliente.getTkslCidade());
        tksl_jTxtBairro.setText(cliente.getTkslBairro());

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
        tksl_jTxtNomeCompleto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tksl_jTxtNomeFantasia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tksl_jTxtSexo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tksl_jFmtNumeroFone = new javax.swing.JFormattedTextField();
        tksl_jFmtDataNascimento = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        tksl_jTxtNacionalidade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tksl_jFmtRg = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        tksl_jFmtCpf = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        tksl_jTxtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tksl_jTxtCargo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tksl_jFmtCep = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        tksl_jTxtLogradouro = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tksl_jTxtPais = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tksl_jTxtUf = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tksl_jTxtCidade = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tksl_jTxtBairro = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        tksl_jBtnIncluir = new javax.swing.JButton();
        tksl_jBtnAlterar = new javax.swing.JButton();
        tksl_jBtnExcluir = new javax.swing.JButton();
        tksl_jBtnConfirmar = new javax.swing.JButton();
        tksl_jBtnCancelar = new javax.swing.JButton();
        tksl_jBtnPesquisar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        tksl_jTxtId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Nome Completo");

        jLabel1.setText("Nome Fantasia");

        jLabel3.setText("Sexo");

        jLabel4.setText("Data de Nascimento");

        jLabel5.setText("Numero de Telefone");

        jLabel6.setText("Nacionalidade");

        jLabel7.setText("RG");

        jLabel8.setText("CPF");

        jLabel9.setText("Email");

        jLabel10.setText("Cargo");

        jLabel11.setText("CEP");

        jLabel12.setText("Logradouro");

        jLabel13.setText("País");

        jLabel14.setText("UF");

        jLabel15.setText("Cidade");

        jLabel16.setText("Bairro");

        tksl_jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir.png"))); // NOI18N
        tksl_jBtnIncluir.setText("Incluir");
        tksl_jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tksl_jBtnIncluirActionPerformed(evt);
            }
        });

        tksl_jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        tksl_jBtnAlterar.setText("Alterar");
        tksl_jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tksl_tksl_jBtnAlterarActionPerformed(evt);
            }
        });

        tksl_jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N
        tksl_jBtnExcluir.setText("Excluir");
        tksl_jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tksl_jBtnExcluirActionPerformed(evt);
            }
        });

        tksl_jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confirmar.png"))); // NOI18N
        tksl_jBtnConfirmar.setText("Confirmar");
        tksl_jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tksl_jBtnConfirmarActionPerformed(evt);
            }
        });

        tksl_jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        tksl_jBtnCancelar.setText("Cancelar");
        tksl_jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tksl_jBtnCancelarActionPerformed(evt);
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
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tksl_jBtnIncluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tksl_jBtnAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tksl_jBtnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tksl_jBtnConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tksl_jBtnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tksl_jBtnPesquisar)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tksl_jBtnIncluir)
                    .addComponent(tksl_jBtnAlterar)
                    .addComponent(tksl_jBtnExcluir)
                    .addComponent(tksl_jBtnConfirmar)
                    .addComponent(tksl_jBtnCancelar)
                    .addComponent(tksl_jBtnPesquisar))
                .addContainerGap())
        );

        jLabel17.setText("ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12)
                                    .addComponent(tksl_jTxtCargo)
                                    .addComponent(tksl_jTxtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel13)
                                    .addComponent(tksl_jFmtCep)
                                    .addComponent(tksl_jTxtPais, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tksl_jTxtNomeCompleto, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tksl_jTxtNomeFantasia, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(tksl_jTxtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(tksl_jFmtDataNascimento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tksl_jFmtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel14)
                                                .addComponent(tksl_jTxtUf, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tksl_jTxtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tksl_jFmtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16)
                                            .addComponent(tksl_jTxtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel5)
                                    .addComponent(tksl_jFmtNumeroFone, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                    .addComponent(tksl_jTxtCidade)
                                    .addComponent(tksl_jTxtNacionalidade)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(tksl_jTxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(tksl_jTxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tksl_jTxtNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tksl_jFmtNumeroFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tksl_jTxtNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tksl_jTxtNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tksl_jFmtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tksl_jTxtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tksl_jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tksl_jTxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(9, 9, 9)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tksl_jTxtUf)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tksl_jFmtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tksl_jFmtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tksl_jTxtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tksl_jFmtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tksl_jTxtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tksl_jTxtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tksl_jTxtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tksl_jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tksl_jBtnIncluirActionPerformed
        // TODO add your handling code here:
        cliente = new TkslCliente();
        incluindo = true;
        habilitar(true);
        limparCampos();
    }//GEN-LAST:event_tksl_jBtnIncluirActionPerformed

    private void tksl_tksl_jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tksl_tksl_jBtnAlterarActionPerformed
        // TODO add your handling code here:
        if (cliente != null) {
            habilitar(true);
            incluindo = false;
            tksl_jTxtId.setEnabled(false);
        } else {
            util.mensagem("Deve pesquisar antes");
        }

    }//GEN-LAST:event_tksl_tksl_jBtnAlterarActionPerformed

    private void tksl_jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tksl_jBtnExcluirActionPerformed
        // TODO add your handling code here:
        if (cliente != null) {
            if (JOptionPane.showConfirmDialog(this, "Deseja excluir?", "Pergunta", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
                cliente = viewBean();
                clienteDao.delete(cliente);
                limparCampos();
                cliente = null;
                util.mensagem("Excluido");
            } else {
                util.mensagem("exclusão cancelada");
            }
        } else {

            util.mensagem("nenhum CLiente foi selecionado");
        }
    }//GEN-LAST:event_tksl_jBtnExcluirActionPerformed

    private void tksl_jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tksl_jBtnConfirmarActionPerformed
        // TODO add your handling code here:
        cliente = viewBean();
        if (incluindo == true) {
            clienteDao.insert(cliente);
        } else {
            clienteDao.update(cliente);
        }
        habilitar(false);
        cliente = null;
        incluindo = false;
        limparCampos();
    }//GEN-LAST:event_tksl_jBtnConfirmarActionPerformed

    private void tksl_jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tksl_jBtnCancelarActionPerformed
        // TODO add your handling code here:
        if (util.perguntar("Deseja Cancelar")) {
            cliente = null;
            incluindo = false;
            limparCampos();
            habilitar(false);
        } else {
            util.mensagem("Cancelado");
        }

    }//GEN-LAST:event_tksl_jBtnCancelarActionPerformed

    private void tksl_jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tksl_jBtnPesquisarActionPerformed
        // TODO add your handling code here:
        cliente = new TkslCliente();
        JDlgPesquisaCliente jDlgPesquisaCliente = new JDlgPesquisaCliente(null, true);
        jDlgPesquisaCliente.setTelaAnterior(this);
        jDlgPesquisaCliente.setVisible(true);

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
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgCliente dialog = new JDlgCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton tksl_jBtnAlterar;
    private javax.swing.JButton tksl_jBtnCancelar;
    private javax.swing.JButton tksl_jBtnConfirmar;
    private javax.swing.JButton tksl_jBtnExcluir;
    private javax.swing.JButton tksl_jBtnIncluir;
    private javax.swing.JButton tksl_jBtnPesquisar;
    private javax.swing.JFormattedTextField tksl_jFmtCep;
    private javax.swing.JFormattedTextField tksl_jFmtCpf;
    private javax.swing.JFormattedTextField tksl_jFmtDataNascimento;
    private javax.swing.JFormattedTextField tksl_jFmtNumeroFone;
    private javax.swing.JFormattedTextField tksl_jFmtRg;
    private javax.swing.JTextField tksl_jTxtBairro;
    private javax.swing.JTextField tksl_jTxtCargo;
    private javax.swing.JTextField tksl_jTxtCidade;
    private javax.swing.JTextField tksl_jTxtEmail;
    private javax.swing.JTextField tksl_jTxtId;
    private javax.swing.JTextField tksl_jTxtLogradouro;
    private javax.swing.JTextField tksl_jTxtNacionalidade;
    private javax.swing.JTextField tksl_jTxtNomeCompleto;
    private javax.swing.JTextField tksl_jTxtNomeFantasia;
    private javax.swing.JTextField tksl_jTxtPais;
    private javax.swing.JTextField tksl_jTxtSexo;
    private javax.swing.JTextField tksl_jTxtUf;
    // End of variables declaration//GEN-END:variables
}
