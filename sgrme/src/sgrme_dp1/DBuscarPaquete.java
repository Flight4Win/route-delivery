/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgrme_dp1;

import utilitarios.IntVentanas;
import utilitarios.ImagenFondo;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author ferna
 */
public class DBuscarPaquete extends javax.swing.JDialog implements IntVentanas{

    /**
     * Creates new form DBuscarPaquete
     */
    public DBuscarPaquete(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        centrarPantalla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgFiltros = new javax.swing.ButtonGroup();
        pFondo = new javax.swing.JPanel();
        lbIconoPaquete = new javax.swing.JLabel();
        tfCodigoPaquete = new javax.swing.JTextField();
        tfCodigoCliente = new javax.swing.JTextField();
        dccFechaRegistro = new com.toedter.calendar.JDateChooser();
        bCancelar = new javax.swing.JButton();
        bAceptar = new javax.swing.JButton();
        bBuscarCiente = new javax.swing.JButton();
        rbCodigCliente = new javax.swing.JRadioButton();
        rbCodigoPaquete = new javax.swing.JRadioButton();
        rbFechaRegistro = new javax.swing.JRadioButton();
        scTablaClientes = new javax.swing.JScrollPane();
        tPaquetes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busqueda de Paquetes");
        setResizable(false);

        lbIconoPaquete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbIconoPaquete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIconoPaquete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscarPaquete.png"))); // NOI18N

        tfCodigoPaquete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tfCodigoCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        dccFechaRegistro.setDateFormatString("dd/MM/yyyy");
        dccFechaRegistro.setMaxSelectableDate(new java.util.Date(253370786511000L));
        dccFechaRegistro.setMinimumSize(new java.awt.Dimension(20, 20));

        bCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bCancelar.setMnemonic('C');
        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        bAceptar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bAceptar.setMnemonic('A');
        bAceptar.setText("Aceptar");
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        bBuscarCiente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bBuscarCiente.setText("Buscar");
        bBuscarCiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarCienteActionPerformed(evt);
            }
        });

        bgFiltros.add(rbCodigCliente);
        rbCodigCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbCodigCliente.setText("   Código Cliente");

        bgFiltros.add(rbCodigoPaquete);
        rbCodigoPaquete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbCodigoPaquete.setSelected(true);
        rbCodigoPaquete.setText("   Código de Paquete");

        bgFiltros.add(rbFechaRegistro);
        rbFechaRegistro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbFechaRegistro.setText("   Fecha de Registro");
        rbFechaRegistro.setToolTipText("");

        tPaquetes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scTablaClientes.setViewportView(tPaquetes);

        javax.swing.GroupLayout pFondoLayout = new javax.swing.GroupLayout(pFondo);
        pFondo.setLayout(pFondoLayout);
        pFondoLayout.setHorizontalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pFondoLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pFondoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scTablaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(bBuscarCiente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pFondoLayout.createSequentialGroup()
                                    .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(rbCodigoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfCodigoPaquete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rbFechaRegistro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dccFechaRegistro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(pFondoLayout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(tfCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(rbCodigCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(33, 33, 33)
                                    .addComponent(lbIconoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pFondoLayout.setVerticalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbIconoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addComponent(rbCodigoPaquete)
                        .addGap(0, 0, 0)
                        .addComponent(tfCodigoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(rbCodigCliente)
                        .addGap(0, 0, 0)
                        .addComponent(tfCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(rbFechaRegistro)
                        .addGap(0, 0, 0)
                        .addComponent(dccFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(bBuscarCiente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(scTablaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        this.dispose();
        DDataPaquete dDataPaquete = new DDataPaquete(null, rootPaneCheckingEnabled);
        dDataPaquete.setVisible(true);
    }//GEN-LAST:event_bAceptarActionPerformed

    private void bBuscarCienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarCienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bBuscarCienteActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DBuscarPaquete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DBuscarPaquete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DBuscarPaquete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DBuscarPaquete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DBuscarPaquete dialog = new DBuscarPaquete(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bBuscarCiente;
    private javax.swing.JButton bCancelar;
    private javax.swing.ButtonGroup bgFiltros;
    private com.toedter.calendar.JDateChooser dccFechaRegistro;
    private javax.swing.JLabel lbIconoPaquete;
    private javax.swing.JPanel pFondo;
    private javax.swing.JRadioButton rbCodigCliente;
    private javax.swing.JRadioButton rbCodigoPaquete;
    private javax.swing.JRadioButton rbFechaRegistro;
    private javax.swing.JScrollPane scTablaClientes;
    private javax.swing.JTable tPaquetes;
    private javax.swing.JTextField tfCodigoCliente;
    private javax.swing.JTextField tfCodigoPaquete;
    // End of variables declaration//GEN-END:variables

    @Override
    public Icon ingresarImagen(String direccion){
        Icon i = new ImageIcon(getClass().getResource(direccion));
        return i;
    }

    @Override
    public final void centrarPantalla() {
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        //para obtener las dimensiones de la pantalla
        Dimension dimen = this.getSize();
        //igual pero para la ventana
        this.setLocation(
            (pantalla.width - dimen.width) / 2,
            (pantalla.height - dimen.height) / 2);
    }

    @Override
    public void ponerImagenPanel(String direccion,javax.swing.JPanel pFondo){
        ImagenFondo Imagen = new ImagenFondo(pFondo.getWidth(),pFondo.getHeight(),direccion);
        pFondo.add(Imagen);
        pFondo.repaint();
    }
}

