/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.CallableStatement;
import java.sql.Connection;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author MFGuevaraL
 */
public class DDataEmpleado extends javax.swing.JDialog implements IntVentanas {
    /**
     * Creates new form DDataEmpleado
     * @param parent
     * @param modal
     */
    DBuscarClienteEmpleado parentBuscarClienteEmpleado = null;
    private boolean dataModificada = false;
    //Connection con;
    CallableStatement cst;
    public DDataEmpleado(java.awt.Frame parent, boolean modal, DBuscarClienteEmpleado parentDBuscarClienteEmpleado/*,Connection con*/) {
        super(parent, modal);
        initComponents();
        centrarPantalla(); 
        //this.con = con;
        
        this.parentBuscarClienteEmpleado = parentDBuscarClienteEmpleado;
        parentDBuscarClienteEmpleado.setVisible(false);
    }
    
    public DDataEmpleado(java.awt.Frame parent, boolean modal/*,Connection con*/) {
        super(parent, modal);
        initComponents();
        centrarPantalla(); 
        //this.con = con;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pFondo = new javax.swing.JPanel();
        bCancelar = new javax.swing.JButton();
        bAceptar = new javax.swing.JButton();
        lbCorreo = new javax.swing.JLabel();
        tfCorreo = new javax.swing.JTextField();
        tfTelefono = new javax.swing.JTextField();
        lbTelefono = new javax.swing.JLabel();
        tfDireccion = new javax.swing.JTextField();
        lbDireccion = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        bModificarDataEmpleado = new javax.swing.JButton();
        bRemoverDataEmpleado = new javax.swing.JButton();
        lbPerfil = new javax.swing.JLabel();
        cbPerfiles = new javax.swing.JComboBox();
        lbCargo = new javax.swing.JLabel();
        cbCargo = new javax.swing.JComboBox();
        lbCodigo = new javax.swing.JLabel();
        tfDNI1 = new javax.swing.JTextField();
        lbDNI1 = new javax.swing.JLabel();
        tfDNI = new javax.swing.JTextField();
        lbNombres1 = new javax.swing.JLabel();
        lbApellidoPaterno = new javax.swing.JLabel();
        tfApellidoPaterno = new javax.swing.JTextField();
        tfNombres = new javax.swing.JTextField();
        lbApellidoMaterno = new javax.swing.JLabel();
        tfApellidoMaterno = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Empleado");

        bCancelar.setMnemonic('C');
        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        bAceptar.setMnemonic('A');
        bAceptar.setText("Aceptar");
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        lbCorreo.setText("Correo");

        tfCorreo.setEnabled(false);

        tfTelefono.setEnabled(false);

        lbTelefono.setText("Teléfono");

        tfDireccion.setEnabled(false);

        lbDireccion.setText("Dirección");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bModificarDataEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editaruser21.png"))); // NOI18N
        bModificarDataEmpleado.setBorder(null);
        bModificarDataEmpleado.setBorderPainted(false);
        bModificarDataEmpleado.setContentAreaFilled(false);
        bModificarDataEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bModificarDataEmpleado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bModificarDataEmpleado.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editaruser18.png"))); // NOI18N
        bModificarDataEmpleado.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editaruser24.png"))); // NOI18N
        bModificarDataEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarDataEmpleadoActionPerformed(evt);
            }
        });

        bRemoverDataEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/removerUser21.png"))); // NOI18N
        bRemoverDataEmpleado.setBorder(null);
        bRemoverDataEmpleado.setBorderPainted(false);
        bRemoverDataEmpleado.setContentAreaFilled(false);
        bRemoverDataEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bRemoverDataEmpleado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bRemoverDataEmpleado.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/removerUser18.png"))); // NOI18N
        bRemoverDataEmpleado.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/removerUser24.png"))); // NOI18N
        bRemoverDataEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemoverDataEmpleadoActionPerformed(evt);
            }
        });

        lbPerfil.setText("Perfil");

        cbPerfiles.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Operador", "Cliente" }));

        lbCargo.setText("Cargo");

        cbCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Operador", "Secretario", "Administrador" }));

        lbCodigo.setText("Código");

        tfDNI1.setEnabled(false);

        lbDNI1.setText("DNI");

        tfDNI.setEnabled(false);

        lbNombres1.setText("Nombres");

        lbApellidoPaterno.setText("Apellido Paterno");

        tfApellidoPaterno.setEnabled(false);

        tfNombres.setEnabled(false);

        lbApellidoMaterno.setText("Apellido Materno ");

        tfApellidoMaterno.setEnabled(false);

        javax.swing.GroupLayout pFondoLayout = new javax.swing.GroupLayout(pFondo);
        pFondo.setLayout(pFondoLayout);
        pFondoLayout.setHorizontalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171))
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbCorreo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfCorreo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfDNI1)
                                    .addComponent(lbCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                    .addComponent(lbNombres1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfNombres))
                                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfApellidoMaterno)
                                    .addComponent(lbApellidoMaterno, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))))
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pFondoLayout.createSequentialGroup()
                                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pFondoLayout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbDNI1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(tfDNI, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tfApellidoPaterno, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbApellidoPaterno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                                            .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(tfTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                                .addComponent(lbTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFondoLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFondoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pFondoLayout.createSequentialGroup()
                                .addComponent(lbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbPerfiles, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bRemoverDataEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pFondoLayout.createSequentialGroup()
                                .addComponent(lbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bModificarDataEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        pFondoLayout.setVerticalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfDNI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pFondoLayout.createSequentialGroup()
                                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbDNI1)
                                    .addComponent(lbCodigo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pFondoLayout.createSequentialGroup()
                                .addComponent(lbNombres1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pFondoLayout.createSequentialGroup()
                                .addComponent(lbApellidoPaterno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pFondoLayout.createSequentialGroup()
                                    .addComponent(lbApellidoMaterno)
                                    .addGap(26, 26, 26))
                                .addComponent(tfApellidoMaterno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pFondoLayout.createSequentialGroup()
                                .addComponent(lbTelefono)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bModificarDataEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bRemoverDataEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbPerfiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        this.dispose();
        if(parentBuscarClienteEmpleado != null){
            parentBuscarClienteEmpleado.setVisible(true);
        } 
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bModificarDataEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarDataEmpleadoActionPerformed
        dataModificada = true ;
        modificarDatos(true);
    }//GEN-LAST:event_bModificarDataEmpleadoActionPerformed

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        if(dataModificada){
            JOptionPane.showMessageDialog(this,"Datos Modificados Correctamente", 
                "FELICIDADES", JOptionPane.PLAIN_MESSAGE,
                ingresarImagen("/vista/imagen/check64.png"));
        }
        this.dispose();
        if(parentBuscarClienteEmpleado != null){
            parentBuscarClienteEmpleado.setVisible(true);
        } 
    }//GEN-LAST:event_bAceptarActionPerformed

    private void bRemoverDataEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoverDataEmpleadoActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this,"Los datos relacionados a este cliente se eliminarán \n ¿Desea continuar?",
                "ADVERTENCIA", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,                 
                ingresarImagen("/vista/imagen/warning.png"));    
        if(opcion==0){
            this.dispose();
            if(parentBuscarClienteEmpleado != null){
                parentBuscarClienteEmpleado.setVisible(true);
            } 
        }
    }//GEN-LAST:event_bRemoverDataEmpleadoActionPerformed
    
    private void modificarDatos(boolean activar){
        tfApellidoPaterno.setEditable(activar);
        tfApellidoMaterno.setEditable(activar);
        tfNombres.setEditable(activar);
        tfDNI.setEditable(activar);
        tfCorreo.setEditable(activar);
        tfDireccion.setEditable(activar);
        tfTelefono.setEditable(activar);
        
        tfApellidoPaterno.setEnabled(activar);
        tfApellidoMaterno.setEditable(activar);
        tfNombres.setEnabled(activar);
        tfDNI.setEnabled(activar);
        tfCorreo.setEnabled(activar);
        tfDireccion.setEnabled(activar);
        tfTelefono.setEnabled(activar);        
    }
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
//            java.util.logging.Logger.getLogger(DDataEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DDataEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DDataEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DDataEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DDataEmpleado dialog = new DDataEmpleado(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bModificarDataEmpleado;
    private javax.swing.JButton bRemoverDataEmpleado;
    private javax.swing.JComboBox cbCargo;
    private javax.swing.JComboBox cbPerfiles;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbApellidoMaterno;
    private javax.swing.JLabel lbApellidoPaterno;
    private javax.swing.JLabel lbCargo;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbCorreo;
    private javax.swing.JLabel lbDNI1;
    private javax.swing.JLabel lbDireccion;
    private javax.swing.JLabel lbNombres1;
    private javax.swing.JLabel lbPerfil;
    private javax.swing.JLabel lbTelefono;
    private javax.swing.JPanel pFondo;
    private javax.swing.JTextField tfApellidoMaterno;
    private javax.swing.JTextField tfApellidoPaterno;
    private javax.swing.JTextField tfCorreo;
    private javax.swing.JTextField tfDNI;
    private javax.swing.JTextField tfDNI1;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfNombres;
    private javax.swing.JTextField tfTelefono;
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
    public void ponerImagenPanel(String direccion,javax.swing.JPanel pFondo) {
        ImagenFondo Imagen = new ImagenFondo(pFondo.getWidth(),pFondo.getHeight(),direccion);
        pFondo.add(Imagen);
        pFondo.repaint();
    }}