/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dados.ClienteDAO;
import dados.PedidoDAO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import negocio.Pedido;

/**
 *
 * @author massilva
 */
public class GerenciarPedido extends javax.swing.JFrame {

    Dimension dimensao;
    Color bgcolor;
    /**
     * Creates new form ListarCliente
     */
    public GerenciarPedido(Color bgcolor) {
        initComponents();
        this.bgcolor = bgcolor;
        this.dimensao = this.getToolkit().getScreenSize();
        jL_titulo.setSize((int) dimensao.getWidth(),80);
        jDesktopPane1.setBackground(bgcolor);
        try {
            atualizarLista("");
        } catch (Exception ex) {
            Logger.getLogger(GerenciarPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    DefaultTableModel modelo;
    public void atualizarLista(String nome) throws Exception{
        this.setAlwaysOnTop(false);
        
        String [] colunas = new String []{"#","Nome do Cliente","Pedido 1","Pedido 2","Pedido 3","Pedido 4","Endereço Entrega","Valor"};
        modelo = new DefaultTableModel(null, colunas){
            
        @Override
        public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        
        PedidoDAO f = new PedidoDAO();
        List listar = f.listaPedido(nome);
        if(listar.isEmpty()){
            jB_editar.setVisible(false);
            jB_excluir.setVisible(false);
        }
        
        Iterator it = listar.iterator();
        while(it.hasNext()){
            Pedido pedido = (Pedido)it.next();
            modelo.addRow(new Object[]{pedido.getId(),pedido.getCliente().getNome(),pedido.getPedido1(),pedido.getPedido2(),pedido.getPedido3(),pedido.getPedido4(),pedido.getEndereco(),pedido.getValor()});
        }
        
        jT_lista.setModel(modelo);
        jT_lista.setShowHorizontalLines(false);
        jT_lista.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jT_lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jT_lista.getColumnModel().getColumn(0).setPreferredWidth((int) (0.04*jS_lista.getSize().getWidth()));   
        jT_lista.getColumnModel().getColumn(2).setPreferredWidth((int) (0.10*jS_lista.getSize().getWidth()));  
        jT_lista.getColumnModel().getColumn(3).setPreferredWidth((int) (0.10*jS_lista.getSize().getWidth()));
        jT_lista.getColumnModel().getColumn(4).setPreferredWidth((int) (0.10*jS_lista.getSize().getWidth()));
        jT_lista.getColumnModel().getColumn(5).setPreferredWidth((int) (0.10*jS_lista.getSize().getWidth()));
        jT_lista.getColumnModel().getColumn(1).setPreferredWidth((int) (0.20*jS_lista.getSize().getWidth()));  
        jT_lista.getColumnModel().getColumn(6).setPreferredWidth((int) (0.35*jS_lista.getSize().getWidth()));  
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jL_titulo = new javax.swing.JLabel();
        jS_lista = new javax.swing.JScrollPane();
        jT_lista = new javax.swing.JTable();
        jB_editar = new javax.swing.JButton();
        jB_excluir = new javax.swing.JButton();
        jB_voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Clientes");
        setAlwaysOnTop(true);

        jL_titulo.setFont(new java.awt.Font("Ume P Mincho S3", 1, 48)); // NOI18N
        jL_titulo.setForeground(new java.awt.Color(0, 0, 0));
        jL_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_titulo.setText("Gerenciar Pedidos");
        jL_titulo.setBounds(0, 0, 1360, 80);
        jDesktopPane1.add(jL_titulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jT_lista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jS_lista.setViewportView(jT_lista);

        jS_lista.setBounds(20, 80, 1250, 520);
        jDesktopPane1.add(jS_lista, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jB_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/imagem/text_edit.png"))); // NOI18N
        jB_editar.setMnemonic('e');
        jB_editar.setText("Editar");
        jB_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_editarActionPerformed(evt);
            }
        });
        jB_editar.setBounds(20, 620, 160, 80);
        jDesktopPane1.add(jB_editar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jB_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/imagem/-.png"))); // NOI18N
        jB_excluir.setMnemonic('x');
        jB_excluir.setText("Excluir");
        jB_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_excluirActionPerformed(evt);
            }
        });
        jB_excluir.setBounds(240, 620, 160, 80);
        jDesktopPane1.add(jB_excluir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jB_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/imagem/back.png"))); // NOI18N
        jB_voltar.setMnemonic('v');
        jB_voltar.setText("Voltar");
        jB_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_voltarActionPerformed(evt);
            }
        });
        jB_voltar.setBounds(1100, 620, 160, 80);
        jDesktopPane1.add(jB_voltar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_voltarActionPerformed
        try{
            Principal principal = new Principal();
            principal.setExtendedState(JFrame.MAXIMIZED_BOTH);
            Toolkit theKit = principal.getToolkit(); // for Fullscreen  
            principal.setBounds(new Rectangle(theKit.getScreenSize()));  
            principal.setVisible(true);
            this.dispose();
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_jB_voltarActionPerformed

    private void jB_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_editarActionPerformed
        try {
            int numLinhaSelecionada = jT_lista.getSelectedRow();         
            int id = Integer.parseInt(jT_lista.getValueAt(numLinhaSelecionada, 0).toString());
            JDialog dialogo = new EditarPedido(this,true,id);
            dialogo.setVisible(true);
        } catch (Exception e){
            JOptionPane.showMessageDialog(this,"Por favor, selecione o pedido.");
        }
    }//GEN-LAST:event_jB_editarActionPerformed

    private void jB_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_excluirActionPerformed
        try {
            int numLinhaSelecionada = jT_lista.getSelectedRow();
            int id = Integer.parseInt(jT_lista.getValueAt(numLinhaSelecionada, 0).toString());
            PedidoDAO pD = new PedidoDAO();
            int conf = JOptionPane.showConfirmDialog(this, "Desejar deletar?","", JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(conf == 0){
                pD.excluirPedido(id);
            }
            try {
                atualizarLista("");
            } catch (Exception ex) {
                Logger.getLogger(GerenciarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(this,"Por favor, selecione o pedido.");
        }
    }//GEN-LAST:event_jB_excluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_editar;
    private javax.swing.JButton jB_excluir;
    private javax.swing.JButton jB_voltar;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jL_titulo;
    private javax.swing.JScrollPane jS_lista;
    private javax.swing.JTable jT_lista;
    // End of variables declaration//GEN-END:variables
}