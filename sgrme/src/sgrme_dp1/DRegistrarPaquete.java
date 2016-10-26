/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgrme_dp1;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ferna
 */
public class DRegistrarPaquete extends javax.swing.JDialog implements IntVentanas{

    /**
     * Creates new form dRegistrarPaquete
     */
    DRegistrarCliente paRegistrarCliente = null;
    @SuppressWarnings({"SillyAssignment", "UnusedAssignment"})
    public DRegistrarPaquete(java.awt.Frame parent, boolean modal, DRegistrarCliente paRegistrarCliente) {
        super(parent, modal);
        this.paRegistrarCliente = paRegistrarCliente;
        initComponents();
        centrarPantalla();        
    }

    public DRegistrarPaquete(java.awt.Frame parent, boolean modal) {
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

        pFondo = new javax.swing.JPanel();
        bCancelar = new javax.swing.JButton();
        bAceptar = new javax.swing.JButton();
        pDataDestinatario = new javax.swing.JPanel();
        lbNombres = new javax.swing.JLabel();
        tfNombres = new javax.swing.JTextField();
        tfApellidos = new javax.swing.JTextField();
        lbApellidos = new javax.swing.JLabel();
        lbCorreo = new javax.swing.JLabel();
        tfCorreo = new javax.swing.JTextField();
        lbTelefono = new javax.swing.JLabel();
        tfTelefono = new javax.swing.JTextField();
        pDataDestinatario1 = new javax.swing.JPanel();
        tfCodigoCliente = new javax.swing.JTextField();
        lbCliente = new javax.swing.JLabel();
        tfNombres1 = new javax.swing.JTextField();
        lbNombres1 = new javax.swing.JLabel();
        pDataDestinatario2 = new javax.swing.JPanel();
        lbTipoPaquete = new javax.swing.JLabel();
        cbTipoPaquete = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();
        lbDestino = new javax.swing.JLabel();
        lbDescripcion = new javax.swing.JLabel();
        tfDescripcion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Paquete");
        setResizable(false);

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

        pDataDestinatario.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Destinatario"));

        lbNombres.setText("Nombres *");

        lbApellidos.setText("Apellidos *");

        lbCorreo.setText("Correo *");

        lbTelefono.setText("Teléfono *");

        javax.swing.GroupLayout pDataDestinatarioLayout = new javax.swing.GroupLayout(pDataDestinatario);
        pDataDestinatario.setLayout(pDataDestinatarioLayout);
        pDataDestinatarioLayout.setHorizontalGroup(
            pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataDestinatarioLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNombres)
                    .addComponent(lbNombres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pDataDestinatarioLayout.createSequentialGroup()
                        .addComponent(lbCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tfCorreo))
                .addGap(18, 18, 18)
                .addGroup(pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(lbApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfTelefono)
                    .addComponent(tfApellidos))
                .addGap(20, 20, 20))
        );
        pDataDestinatarioLayout.setVerticalGroup(
            pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataDestinatarioLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDataDestinatarioLayout.createSequentialGroup()
                        .addComponent(lbApellidos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pDataDestinatarioLayout.createSequentialGroup()
                        .addComponent(lbNombres)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTelefono))
                .addGap(6, 6, 6)
                .addGroup(pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        pDataDestinatario1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cliente"));

        tfCodigoCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCodigoClienteFocusLost(evt);
            }
        });

        lbCliente.setText("Código Cliente");

        lbNombres1.setText("Nombres y Apellidos");

        javax.swing.GroupLayout pDataDestinatario1Layout = new javax.swing.GroupLayout(pDataDestinatario1);
        pDataDestinatario1.setLayout(pDataDestinatario1Layout);
        pDataDestinatario1Layout.setHorizontalGroup(
            pDataDestinatario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataDestinatario1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pDataDestinatario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCliente)
                    .addComponent(tfCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pDataDestinatario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfNombres1)
                    .addComponent(lbNombres1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pDataDestinatario1Layout.setVerticalGroup(
            pDataDestinatario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataDestinatario1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDataDestinatario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pDataDestinatario1Layout.createSequentialGroup()
                        .addComponent(lbNombres1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNombres1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pDataDestinatario1Layout.createSequentialGroup()
                        .addComponent(lbCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pDataDestinatario2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Paquete"));

        lbTipoPaquete.setText("Tipo de Paquete");

        cbTipoPaquete.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Documentos", "Caja", "Caja Frágil" }));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbDestino.setText("Destino");

        lbDescripcion.setText("Descripción");

        javax.swing.GroupLayout pDataDestinatario2Layout = new javax.swing.GroupLayout(pDataDestinatario2);
        pDataDestinatario2.setLayout(pDataDestinatario2Layout);
        pDataDestinatario2Layout.setHorizontalGroup(
            pDataDestinatario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataDestinatario2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pDataDestinatario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDataDestinatario2Layout.createSequentialGroup()
                        .addComponent(lbDescripcion)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pDataDestinatario2Layout.createSequentialGroup()
                        .addGroup(pDataDestinatario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfDescripcion)
                            .addGroup(pDataDestinatario2Layout.createSequentialGroup()
                                .addGroup(pDataDestinatario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbDestino)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(pDataDestinatario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTipoPaquete)
                                    .addComponent(cbTipoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(25, 25, 25))))
        );
        pDataDestinatario2Layout.setVerticalGroup(
            pDataDestinatario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataDestinatario2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lbDescripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(pDataDestinatario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDestino)
                    .addComponent(lbTipoPaquete))
                .addGap(6, 6, 6)
                .addGroup(pDataDestinatario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTipoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout pFondoLayout = new javax.swing.GroupLayout(pFondo);
        pFondo.setLayout(pFondoLayout);
        pFondoLayout.setHorizontalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pDataDestinatario2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pDataDestinatario1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pDataDestinatario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pFondoLayout.setVerticalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(pDataDestinatario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pDataDestinatario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pDataDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this,"Los datos ingresados no se guardarán \n ¿Desea continuar?",
                "ADVERTENCIA", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,                 
                ingresarImagen("/imagenes/warning.png"));    
        if(opcion==0){
            this.dispose();
            if(paRegistrarCliente != null){
                paRegistrarCliente.setVisible(true);
            } 
        }
           
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        JOptionPane.showMessageDialog(this,"Paquete Registrado Correctamente", 
                "FELICIDADES", JOptionPane.PLAIN_MESSAGE,
                ingresarImagen("/imagenes/check64.png"));
        this.dispose();
    }//GEN-LAST:event_bAceptarActionPerformed

    private void tfCodigoClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodigoClienteFocusLost
        boolean existe=false;
        if(!existe){
            JOptionPane.showMessageDialog(this,"Código Inválido, Usuario no Existe", 
                "ERROR", JOptionPane.PLAIN_MESSAGE,
                ingresarImagen("/imagenes/error.png"));
        }       
//        tfCodigoCliente.requestFocus();
    }//GEN-LAST:event_tfCodigoClienteFocusLost

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(DRegistrarPaquete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DRegistrarPaquete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DRegistrarPaquete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DRegistrarPaquete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DRegistrarPaquete dialog = new DRegistrarPaquete(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox cbTipoPaquete;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel lbApellidos;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lbCorreo;
    private javax.swing.JLabel lbDescripcion;
    private javax.swing.JLabel lbDestino;
    private javax.swing.JLabel lbNombres;
    private javax.swing.JLabel lbNombres1;
    private javax.swing.JLabel lbTelefono;
    private javax.swing.JLabel lbTipoPaquete;
    private javax.swing.JPanel pDataDestinatario;
    private javax.swing.JPanel pDataDestinatario1;
    private javax.swing.JPanel pDataDestinatario2;
    private javax.swing.JPanel pFondo;
    private javax.swing.JTextField tfApellidos;
    private javax.swing.JTextField tfCodigoCliente;
    private javax.swing.JTextField tfCorreo;
    private javax.swing.JTextField tfDescripcion;
    private javax.swing.JTextField tfNombres;
    private javax.swing.JTextField tfNombres1;
    private javax.swing.JTextField tfTelefono;
    // End of variables declaration//GEN-END:variables

    @Override
    public Icon ingresarImagen(String direccion){
        Icon i = new ImageIcon(getClass().getResource(direccion));
        return i;
    }

    @Override
    public void centrarPantalla() {
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        //para obtener las dimensiones de la pantalla
        Dimension dimen = this.getSize();
        //igual pero para la ventana
        this.setLocation(
            (pantalla.width - dimen.width) / 2,
            (pantalla.height - dimen.height) / 2);
    }

    @Override
    public void ponerImagenFondo(String direccion) {
        ImagenFondo Imagen = new ImagenFondo(pFondo.getWidth(),pFondo.getHeight(),direccion);
        pFondo.add(Imagen);
        pFondo.repaint();
    }
}
