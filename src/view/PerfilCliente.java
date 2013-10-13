/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dados.ClienteDAO;
import dados.PedidoDAO;
import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import negocio.Cliente;
import negocio.Pedido;

/**
 *
 * @author massilva
 */
public class PerfilCliente extends javax.swing.JFrame {

    DefaultTableModel modelo;
    Color bgcolor;
    Cliente cliente;
    ClienteDAO cDAO = new ClienteDAO();
    
    /**
     * Creates new form ListarCliente
     */
    public PerfilCliente(Color bgcolor, Cliente cliente) {
         initComponents();
        
        this.cliente = cliente;
        int numPedido = cDAO.getNumPedidoClienteById(cliente.getId());
        cliente.setNumPedidos(numPedido);
        jL_NumPedidos.setText(""+numPedido);
        
        this.bgcolor = bgcolor;
        jDesktopPane1.setBackground(bgcolor);
        
        jL_titulo.setText(cliente.getNome());
        jL_Telefone.setText(cliente.getTelefone());
        jL_Endereco.setText(cliente.getEndereco());
        jL_NumPedidos.setText(""+cliente.getNumPedidos());
        
        try {
            atualizarLista();
        } catch (Exception ex) {
            Logger.getLogger(PerfilCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
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
        jB_Adicionar = new javax.swing.JButton();
        jB_voltar = new javax.swing.JButton();
        jL_Endereco = new javax.swing.JLabel();
        jL_EnderecoN = new javax.swing.JLabel();
        jL_TelefoneN = new javax.swing.JLabel();
        jL_Telefone = new javax.swing.JLabel();
        jL_NumPedidosN = new javax.swing.JLabel();
        jL_NumPedidos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Clientes");
        setAlwaysOnTop(true);
        setResizable(false);

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 204));

        jL_titulo.setFont(new java.awt.Font("Ume Mincho S3", 1, 48)); // NOI18N
        jL_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_titulo.setText("Cliente");
        jL_titulo.setBounds(0, 0, 800, 80);
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

        jS_lista.setBounds(20, 180, 580, 300);
        jDesktopPane1.add(jS_lista, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jB_Adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/imagem/+.png"))); // NOI18N
        jB_Adicionar.setMnemonic('e');
        jB_Adicionar.setText("Add Pedido");
        jB_Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_AdicionarActionPerformed(evt);
            }
        });
        jB_Adicionar.setBounds(620, 180, 160, 80);
        jDesktopPane1.add(jB_Adicionar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jB_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/imagem/back.png"))); // NOI18N
        jB_voltar.setMnemonic('v');
        jB_voltar.setText("Voltar");
        jB_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_voltarActionPerformed(evt);
            }
        });
        jB_voltar.setBounds(620, 400, 160, 80);
        jDesktopPane1.add(jB_voltar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jL_Endereco.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jL_Endereco.setBounds(140, 80, 630, 40);
        jDesktopPane1.add(jL_Endereco, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jL_EnderecoN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jL_EnderecoN.setText("Endereço:");
        jL_EnderecoN.setBounds(40, 80, 90, 40);
        jDesktopPane1.add(jL_EnderecoN, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jL_TelefoneN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jL_TelefoneN.setText("Telefone:");
        jL_TelefoneN.setBounds(40, 120, 90, 40);
        jDesktopPane1.add(jL_TelefoneN, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jL_Telefone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jL_Telefone.setBounds(140, 120, 240, 40);
        jDesktopPane1.add(jL_Telefone, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jL_NumPedidosN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jL_NumPedidosN.setText("N° de Pedidos:");
        jL_NumPedidosN.setBounds(360, 120, 160, 40);
        jDesktopPane1.add(jL_NumPedidosN, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jL_NumPedidos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jL_NumPedidos.setBounds(530, 120, 240, 40);
        jDesktopPane1.add(jL_NumPedidos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void atualizarLista() throws Exception{
        
        this.setAlwaysOnTop(false);
        
        String [] colunas = new String []{"#","Endereço","Valor"};
        modelo = new DefaultTableModel(null, colunas){
            
            @Override
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        
        PedidoDAO f = new PedidoDAO();
        List listar = f.listaPedidoIdCliente(cliente);
        
        Iterator it = listar.iterator();
        while(it.hasNext()){
            Pedido l = (Pedido)it.next();
            modelo.addRow(new Object[]{l.getId(),l.getEndereco(),l.getValor()});
        }
        
        jT_lista.setModel(modelo);
        jT_lista.setShowHorizontalLines(false);
        jT_lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jT_lista.getColumnModel().getColumn(0).setPreferredWidth(80);   
        jT_lista.getColumnModel().getColumn(1).setPreferredWidth(120);  
    }
    
    private void jB_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_voltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jB_voltarActionPerformed

    private void jB_AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_AdicionarActionPerformed
        // TODO add your handling code here:
       new CadastroPedido(bgcolor,cliente).setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jB_AdicionarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_Adicionar;
    private javax.swing.JButton jB_voltar;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jL_Endereco;
    private javax.swing.JLabel jL_EnderecoN;
    private javax.swing.JLabel jL_NumPedidos;
    private javax.swing.JLabel jL_NumPedidosN;
    private javax.swing.JLabel jL_Telefone;
    private javax.swing.JLabel jL_TelefoneN;
    private javax.swing.JLabel jL_titulo;
    private javax.swing.JScrollPane jS_lista;
    private javax.swing.JTable jT_lista;
    // End of variables declaration//GEN-END:variables
}
