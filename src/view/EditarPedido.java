/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dados.ClienteDAO;
import dados.PedidoDAO;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocio.Cliente;
import negocio.Pedido;

/**
 *
 * @author massilva
 */
public class EditarPedido extends javax.swing.JDialog {

    java.awt.Frame pai;
    Pedido pedido;
    List<Cliente> cliente;
    Cliente c;
    ClienteDAO cDAO = new ClienteDAO();
    PedidoDAO pDAO = new PedidoDAO();
    /**
     * Creates new form EditarPedido
     */
    public EditarPedido(java.awt.Frame parent, boolean modal,int id) {
        super(parent, modal);
        this.pai = parent;
        this.pedido = pDAO.getPedidoById(id);
        initComponents();
        this.cliente = cDAO.listaCliente("");
        atualizaLista();
        iniciarCampos();
    }
    
    private void atualizaLista(){
        for (Cliente cli : this.cliente) {
            jC_clientes.addItem("#"+cli.getId()+" - "+cli.getNome());
            if(cli.getId() == pedido.getCliente().getId()){
                jC_clientes.setSelectedItem("#"+cli.getId()+" - "+cli.getNome());
            }
        }
    }
    
    private void iniciarCampos(){
        jT_endereco.setText(pedido.getEndereco());
        jT_pedido_1.setText(pedido.getPedido1());
        jT_pedido_2.setText(pedido.getPedido2());
        jT_pedido_3.setText(pedido.getPedido3());
        jT_pedido_4.setText(pedido.getPedido4());
        jT_pedido_5.setText(pedido.getPedido5());
        jT_pedido_6.setText(pedido.getPedido6());
        jT_pedido_7.setText(pedido.getPedido7());
        jT_pedido_8.setText(pedido.getPedido8());
        jF_Valor.setText(""+pedido.getValor());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane2 = new javax.swing.JDesktopPane();
        jL_titulo = new javax.swing.JLabel();
        jL_pedido = new javax.swing.JLabel();
        jL_1 = new javax.swing.JLabel();
        jL_2 = new javax.swing.JLabel();
        jL_3 = new javax.swing.JLabel();
        jL_4 = new javax.swing.JLabel();
        jL_5 = new javax.swing.JLabel();
        jL_6 = new javax.swing.JLabel();
        jL_7 = new javax.swing.JLabel();
        jL_8 = new javax.swing.JLabel();
        jT_pedido_1 = new javax.swing.JTextField();
        jT_pedido_2 = new javax.swing.JTextField();
        jT_pedido_3 = new javax.swing.JTextField();
        jT_pedido_4 = new javax.swing.JTextField();
        jT_pedido_5 = new javax.swing.JTextField();
        jT_pedido_6 = new javax.swing.JTextField();
        jT_pedido_7 = new javax.swing.JTextField();
        jT_pedido_8 = new javax.swing.JTextField();
        jB_salvar = new javax.swing.JButton();
        jB_voltar = new javax.swing.JButton();
        jT_endereco = new javax.swing.JTextField();
        jL_endereco = new javax.swing.JLabel();
        jL_Valor = new javax.swing.JLabel();
        jF_Valor = new javax.swing.JFormattedTextField();
        jL_ClienteN = new javax.swing.JLabel();
        jC_clientes = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jDesktopPane2.setBackground(new java.awt.Color(204, 204, 204));

        jL_titulo.setFont(new java.awt.Font("Ume P Mincho S3", 1, 48)); // NOI18N
        jL_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_titulo.setText("Cadastro de Pedido");
        jL_titulo.setBounds(0, 0, 800, 80);
        jDesktopPane2.add(jL_titulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jL_pedido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jL_pedido.setText("Pedido");
        jL_pedido.setBounds(20, 180, 400, 30);
        jDesktopPane2.add(jL_pedido, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jL_1.setText("#1");
        jL_1.setBounds(30, 220, 20, 30);
        jDesktopPane2.add(jL_1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jL_2.setText("#2");
        jL_2.setBounds(30, 260, 20, 30);
        jDesktopPane2.add(jL_2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jL_3.setText("#3");
        jL_3.setBounds(30, 300, 20, 30);
        jDesktopPane2.add(jL_3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jL_4.setText("#4");
        jL_4.setBounds(30, 340, 20, 30);
        jDesktopPane2.add(jL_4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jL_5.setText("#5");
        jL_5.setBounds(410, 220, 20, 30);
        jDesktopPane2.add(jL_5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jL_6.setText("#6");
        jL_6.setBounds(410, 260, 20, 30);
        jDesktopPane2.add(jL_6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jL_7.setText("#7");
        jL_7.setBounds(410, 300, 20, 30);
        jDesktopPane2.add(jL_7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jL_8.setText("#8");
        jL_8.setBounds(410, 340, 20, 30);
        jDesktopPane2.add(jL_8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jT_pedido_1.setBounds(50, 220, 350, 28);
        jDesktopPane2.add(jT_pedido_1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jT_pedido_2.setBounds(50, 260, 350, 28);
        jDesktopPane2.add(jT_pedido_2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jT_pedido_3.setBounds(50, 300, 350, 28);
        jDesktopPane2.add(jT_pedido_3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jT_pedido_4.setBounds(50, 340, 350, 28);
        jDesktopPane2.add(jT_pedido_4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jT_pedido_5.setBounds(430, 220, 350, 28);
        jDesktopPane2.add(jT_pedido_5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jT_pedido_6.setBounds(430, 260, 350, 28);
        jDesktopPane2.add(jT_pedido_6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jT_pedido_7.setBounds(430, 300, 350, 28);
        jDesktopPane2.add(jT_pedido_7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jT_pedido_8.setBounds(430, 340, 350, 28);
        jDesktopPane2.add(jT_pedido_8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jB_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/imagem/save.png"))); // NOI18N
        jB_salvar.setMnemonic('a');
        jB_salvar.setText("Atualizar");
        jB_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_salvarActionPerformed(evt);
            }
        });
        jB_salvar.setBounds(20, 520, 160, 80);
        jDesktopPane2.add(jB_salvar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jB_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/imagem/back.png"))); // NOI18N
        jB_voltar.setMnemonic('v');
        jB_voltar.setText("Voltar");
        jB_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_voltarActionPerformed(evt);
            }
        });
        jB_voltar.setBounds(620, 520, 160, 80);
        jDesktopPane2.add(jB_voltar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jT_endereco.setBounds(20, 420, 760, 40);
        jDesktopPane2.add(jT_endereco, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jL_endereco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jL_endereco.setText("Endereço de Entrega");
        jL_endereco.setBounds(20, 390, 180, 30);
        jDesktopPane2.add(jL_endereco, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jL_Valor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jL_Valor.setText("Valor:   R$");
        jL_Valor.setBounds(530, 470, 120, 40);
        jDesktopPane2.add(jL_Valor, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jF_Valor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jF_Valor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jF_Valor.setBounds(650, 470, 130, 40);
        jDesktopPane2.add(jF_Valor, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jL_ClienteN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jL_ClienteN.setText("Cliente:");
        jL_ClienteN.setBounds(20, 140, 90, 30);
        jDesktopPane2.add(jL_ClienteN, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jC_clientes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ":: Selecione ::" }));
        jC_clientes.setBounds(110, 140, 360, 28);
        jDesktopPane2.add(jC_clientes, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_salvarActionPerformed
        // TODO add your handling code here:
        String  pedido1, pedido2, pedido3, pedido4, pedido5, pedido6, pedido7, pedido8;
        String  endereco;
        PedidoDAO pD = new PedidoDAO();

        endereco = jT_endereco.getText();
        pedido1 = jT_pedido_1.getText();
        pedido2 = jT_pedido_2.getText();
        pedido3 = jT_pedido_3.getText();
        pedido4 = jT_pedido_4.getText();
        pedido5 = jT_pedido_5.getText();
        pedido6 = jT_pedido_6.getText();
        pedido7 = jT_pedido_7.getText();
        pedido8 = jT_pedido_8.getText();
        String valor = jF_Valor.getText();

        if(valor.isEmpty()){
            JOptionPane.showMessageDialog(this,"O campo valor está vázio");
        }
        else{

            valor = valor.replace(",",".");
            String selecionado = (String) jC_clientes.getSelectedItem();
            String [] sel = selecionado.split("-");
            int id = Integer.parseInt(sel[0].replace("#","").trim());
            c = new Cliente(id);
            pedido.setPedido1(pedido1);
            pedido.setPedido2(pedido2);
            pedido.setPedido3(pedido3);
            pedido.setPedido4(pedido4);
            pedido.setPedido5(pedido5);
            pedido.setPedido6(pedido6);
            pedido.setPedido7(pedido7);
            pedido.setPedido8(pedido8);
            pedido.setValor(Float.parseFloat(valor));
            pedido.setEndereco(endereco);
            pedido.setCliente(c);
            try {
                if(pD.atualizaPedido(pedido)){
                    try {
                        ((GerenciarPedido)pai).atualizarLista("");
                        JOptionPane.showMessageDialog(this, "Pedido atualizado com sucesso.");                   
                        this.dispose();
                    } catch (Exception ex) {
                        Logger.getLogger(EditarPedido.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Erro ao atualizar!");
                }
            } catch (Exception ex) {
                Logger.getLogger(CadastroPedido.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jB_salvarActionPerformed

    private void jB_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_voltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jB_voltarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_salvar;
    private javax.swing.JButton jB_voltar;
    private javax.swing.JComboBox jC_clientes;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JFormattedTextField jF_Valor;
    private javax.swing.JLabel jL_1;
    private javax.swing.JLabel jL_2;
    private javax.swing.JLabel jL_3;
    private javax.swing.JLabel jL_4;
    private javax.swing.JLabel jL_5;
    private javax.swing.JLabel jL_6;
    private javax.swing.JLabel jL_7;
    private javax.swing.JLabel jL_8;
    private javax.swing.JLabel jL_ClienteN;
    private javax.swing.JLabel jL_Valor;
    private javax.swing.JLabel jL_endereco;
    private javax.swing.JLabel jL_pedido;
    private javax.swing.JLabel jL_titulo;
    private javax.swing.JTextField jT_endereco;
    private javax.swing.JTextField jT_pedido_1;
    private javax.swing.JTextField jT_pedido_2;
    private javax.swing.JTextField jT_pedido_3;
    private javax.swing.JTextField jT_pedido_4;
    private javax.swing.JTextField jT_pedido_5;
    private javax.swing.JTextField jT_pedido_6;
    private javax.swing.JTextField jT_pedido_7;
    private javax.swing.JTextField jT_pedido_8;
    // End of variables declaration//GEN-END:variables
}
