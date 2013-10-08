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
public class ListarCliente extends javax.swing.JFrame {

    /**
     * Creates new form ListarCliente
     */
    public ListarCliente(Color bgcolor) {
        initComponents();
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
        jS_lista = new javax.swing.JScrollPane();
        jT_lista = new javax.swing.JTable();
        jB_editar = new javax.swing.JButton();
        jB_excluir = new javax.swing.JButton();
        jB_voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Clientes");
        setAlwaysOnTop(true);
        setResizable(false);

        jL_titulo.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        jL_titulo.setForeground(new java.awt.Color(0, 0, 0));
        jL_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_titulo.setText("Lista de Clientes");
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

        jS_lista.setBounds(20, 80, 580, 300);
        jDesktopPane1.add(jS_lista, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jB_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/imagem/text_edit.png"))); // NOI18N
        jB_editar.setMnemonic('e');
        jB_editar.setText("Editar");
        jB_editar.setBounds(620, 80, 160, 80);
        jDesktopPane1.add(jB_editar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jB_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/imagem/-.png"))); // NOI18N
        jB_excluir.setMnemonic('x');
        jB_excluir.setText("Excluir");
        jB_excluir.setBounds(620, 190, 160, 80);
        jDesktopPane1.add(jB_excluir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jB_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/imagem/back.png"))); // NOI18N
        jB_voltar.setMnemonic('v');
        jB_voltar.setText("Voltar");
        jB_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_voltarActionPerformed(evt);
            }
        });
        jB_voltar.setBounds(620, 300, 160, 80);
        jDesktopPane1.add(jB_voltar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jB_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_voltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jB_voltarActionPerformed

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
