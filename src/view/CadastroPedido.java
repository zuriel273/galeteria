/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;

/**
 *
 * @author massilva
 */
public class CadastroPedido extends javax.swing.JFrame {

    private String msg_busca = "Digite o telefone ou o nome do cliente";
    /**
     * Creates new form CadastroPedido
     */
    public CadastroPedido(Color bgcolor) {
        initComponents();
        jT_busca.setText(msg_busca);
        jDesktopPane1.setBackground(bgcolor);
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
        jT_busca = new javax.swing.JTextField();
        jS_lista = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jL_pedido = new javax.swing.JLabel();
        jS_tabela = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jB_salvar = new javax.swing.JButton();
        jB_voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Pedido");
        setAlwaysOnTop(true);
        setResizable(false);

        jL_titulo.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        jL_titulo.setForeground(new java.awt.Color(0, 0, 0));
        jL_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_titulo.setText("Cadasto de Pedido");
        jL_titulo.setBounds(0, 0, 600, 80);
        jDesktopPane1.add(jL_titulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jT_busca.setForeground(new java.awt.Color(187, 187, 187));
        jT_busca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jT_buscaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jT_buscaFocusLost(evt);
            }
        });
        jT_busca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jT_buscaKeyReleased(evt);
            }
        });
        jT_busca.setBounds(20, 90, 250, 28);
        jDesktopPane1.add(jT_busca, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jS_lista.setViewportView(jList1);

        jS_lista.setBounds(20, 130, 250, 170);
        jDesktopPane1.add(jS_lista, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jL_pedido.setText("Pedido:");
        jL_pedido.setBounds(290, 90, 290, 30);
        jDesktopPane1.add(jL_pedido, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jS_tabela.setViewportView(jTextArea1);

        jS_tabela.setBounds(290, 130, 290, 170);
        jDesktopPane1.add(jS_tabela, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jB_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/imagem/save.png"))); // NOI18N
        jB_salvar.setText("Salvar");
        jB_salvar.setBounds(20, 310, 160, 80);
        jDesktopPane1.add(jB_salvar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jB_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/imagem/back.png"))); // NOI18N
        jB_voltar.setMnemonic('v');
        jB_voltar.setText("Voltar");
        jB_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_voltarActionPerformed(evt);
            }
        });
        jB_voltar.setBounds(420, 310, 160, 80);
        jDesktopPane1.add(jB_voltar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jT_buscaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jT_buscaFocusGained
        if(jT_busca.getText().equals(msg_busca)){
            jT_busca.setText("");
            jT_busca.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jT_buscaFocusGained

    private void jT_buscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_buscaKeyReleased
        if(!jT_busca.getText().isEmpty()){
            jT_busca.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jT_buscaKeyReleased

    private void jT_buscaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jT_buscaFocusLost
        if(jT_busca.getText().isEmpty())
        {
            jT_busca.setForeground(Color.gray);
            jT_busca.setText(msg_busca);
        }
    }//GEN-LAST:event_jT_buscaFocusLost

    private void jB_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_voltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jB_voltarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_salvar;
    private javax.swing.JButton jB_voltar;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jL_pedido;
    private javax.swing.JLabel jL_titulo;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jS_lista;
    private javax.swing.JScrollPane jS_tabela;
    private javax.swing.JTextField jT_busca;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
