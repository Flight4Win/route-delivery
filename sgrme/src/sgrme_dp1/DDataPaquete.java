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

/**
 *
 * @author ferna
 */
public class DDataPaquete extends javax.swing.JDialog implements IntVentanas{

    /**
     * Creates new form DDataCliente
     */
    public DDataPaquete(java.awt.Frame parent, boolean modal) {
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
        bAceptar = new javax.swing.JButton();
        pDataDestinatario = new javax.swing.JPanel();
        lbNombresApellidosDestinatario = new javax.swing.JLabel();
        tfNombresApellidosDestinatario = new javax.swing.JTextField();
        lbCorreo = new javax.swing.JLabel();
        tfCorreo = new javax.swing.JTextField();
        lbTelefono = new javax.swing.JLabel();
        tfTelefono = new javax.swing.JTextField();
        pDataDestinatario1 = new javax.swing.JPanel();
        tfCodgioCliente = new javax.swing.JTextField();
        lbCodigoCliente = new javax.swing.JLabel();
        lbNombresApellidosCliente = new javax.swing.JLabel();
        tfNombresApellidosCliente = new javax.swing.JTextField();
        lbImagenCliente = new javax.swing.JLabel();
        pDataDestinatario2 = new javax.swing.JPanel();
        lbDestino = new javax.swing.JLabel();
        tfDestino = new javax.swing.JTextField();
        lbOrigen = new javax.swing.JLabel();
        tfOrigen = new javax.swing.JTextField();
        lbTipoPaquete = new javax.swing.JLabel();
        cbTipoPaquete = new javax.swing.JComboBox();
        lbEstadoPaquete = new javax.swing.JLabel();
        cbEstadoPaquete = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescripcion = new javax.swing.JTextArea();
        lbDescripcion = new javax.swing.JLabel();
        lbCodigoPaquete = new javax.swing.JLabel();
        tfCodigoPaquete = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Datos de Paquete");
        setResizable(false);

        bAceptar.setMnemonic('A');
        bAceptar.setText("Aceptar");

        pDataDestinatario.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Destinatario"));

        lbNombresApellidosDestinatario.setText("Nombres  y Apellidos");

        tfNombresApellidosDestinatario.setEnabled(false);
        tfNombresApellidosDestinatario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombresApellidosDestinatarioActionPerformed(evt);
            }
        });

        lbCorreo.setText("Correo *");

        tfCorreo.setEnabled(false);

        lbTelefono.setText("Teléfono *");

        tfTelefono.setEnabled(false);

        javax.swing.GroupLayout pDataDestinatarioLayout = new javax.swing.GroupLayout(pDataDestinatario);
        pDataDestinatario.setLayout(pDataDestinatarioLayout);
        pDataDestinatarioLayout.setHorizontalGroup(
            pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataDestinatarioLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(lbNombresApellidosDestinatario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfNombresApellidosDestinatario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        pDataDestinatarioLayout.setVerticalGroup(
            pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataDestinatarioLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombresApellidosDestinatario)
                    .addComponent(lbTelefono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNombresApellidosDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(lbCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pDataDestinatario1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cliente"));

        tfCodgioCliente.setEnabled(false);

        lbCodigoCliente.setText("Código Cliente");

        lbNombresApellidosCliente.setText("Nombre y Apellidos");

        tfNombresApellidosCliente.setEnabled(false);

        lbImagenCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImagenCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cajita.png"))); // NOI18N

        javax.swing.GroupLayout pDataDestinatario1Layout = new javax.swing.GroupLayout(pDataDestinatario1);
        pDataDestinatario1.setLayout(pDataDestinatario1Layout);
        pDataDestinatario1Layout.setHorizontalGroup(
            pDataDestinatario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataDestinatario1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pDataDestinatario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfCodgioCliente)
                    .addComponent(tfNombresApellidosCliente)
                    .addComponent(lbNombresApellidosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(lbCodigoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDataDestinatario1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(lbImagenCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        pDataDestinatario1Layout.setVerticalGroup(
            pDataDestinatario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataDestinatario1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lbCodigoCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCodgioCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNombresApellidosCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfNombresApellidosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbImagenCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pDataDestinatario2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Paquete"));

        lbDestino.setText("Destino");

        tfDestino.setEnabled(false);

        lbOrigen.setText("Origen");

        tfOrigen.setEnabled(false);

        lbTipoPaquete.setText("Tipo de Paquete");

        cbTipoPaquete.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Documentos", "Caja", "Caja Frágil" }));
        cbTipoPaquete.setEnabled(false);

        lbEstadoPaquete.setText("Estado de Paquete");

        cbEstadoPaquete.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "En Recepción", "En Tránsito", "Espera", "Recepcionado" }));
        cbEstadoPaquete.setEnabled(false);

        taDescripcion.setColumns(20);
        taDescripcion.setRows(5);
        taDescripcion.setEnabled(false);
        jScrollPane1.setViewportView(taDescripcion);

        lbDescripcion.setText("Descripción");

        lbCodigoPaquete.setText("Código de Paquete");

        tfCodigoPaquete.setEnabled(false);

        javax.swing.GroupLayout pDataDestinatario2Layout = new javax.swing.GroupLayout(pDataDestinatario2);
        pDataDestinatario2.setLayout(pDataDestinatario2Layout);
        pDataDestinatario2Layout.setHorizontalGroup(
            pDataDestinatario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataDestinatario2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pDataDestinatario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDataDestinatario2Layout.createSequentialGroup()
                        .addGroup(pDataDestinatario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDataDestinatario2Layout.createSequentialGroup()
                                .addGroup(pDataDestinatario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pDataDestinatario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cbTipoPaquete, javax.swing.GroupLayout.Alignment.LEADING, 0, 101, Short.MAX_VALUE)
                                        .addComponent(lbDestino, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfDestino, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(lbTipoPaquete))
                                .addGap(33, 33, 33))
                            .addGroup(pDataDestinatario2Layout.createSequentialGroup()
                                .addComponent(lbCodigoPaquete, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                .addGap(31, 31, 31)))
                        .addGroup(pDataDestinatario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfCodigoPaquete)
                            .addComponent(lbOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbEstadoPaquete)
                            .addComponent(cbEstadoPaquete, javax.swing.GroupLayout.Alignment.TRAILING, 0, 100, Short.MAX_VALUE)
                            .addComponent(tfOrigen, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pDataDestinatario2Layout.setVerticalGroup(
            pDataDestinatario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDataDestinatario2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pDataDestinatario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCodigoPaquete)
                    .addComponent(tfCodigoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pDataDestinatario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDestino)
                    .addComponent(lbOrigen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pDataDestinatario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pDataDestinatario2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDataDestinatario2Layout.createSequentialGroup()
                        .addComponent(lbTipoPaquete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pDataDestinatario2Layout.createSequentialGroup()
                        .addComponent(lbEstadoPaquete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEstadoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbDescripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout pFondoLayout = new javax.swing.GroupLayout(pFondo);
        pFondo.setLayout(pFondoLayout);
        pFondoLayout.setHorizontalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFondoLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pDataDestinatario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pFondoLayout.createSequentialGroup()
                            .addComponent(pDataDestinatario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(pDataDestinatario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        pFondoLayout.setVerticalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pDataDestinatario1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pDataDestinatario2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pDataDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNombresApellidosDestinatarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombresApellidosDestinatarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombresApellidosDestinatarioActionPerformed

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
            java.util.logging.Logger.getLogger(DDataPaquete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DDataPaquete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DDataPaquete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DDataPaquete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DDataPaquete dialog = new DDataPaquete(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bAceptar;
    private javax.swing.JComboBox cbEstadoPaquete;
    private javax.swing.JComboBox cbTipoPaquete;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCodigoCliente;
    private javax.swing.JLabel lbCodigoPaquete;
    private javax.swing.JLabel lbCorreo;
    private javax.swing.JLabel lbDescripcion;
    private javax.swing.JLabel lbDestino;
    private javax.swing.JLabel lbEstadoPaquete;
    private javax.swing.JLabel lbImagenCliente;
    private javax.swing.JLabel lbNombresApellidosCliente;
    private javax.swing.JLabel lbNombresApellidosDestinatario;
    private javax.swing.JLabel lbOrigen;
    private javax.swing.JLabel lbTelefono;
    private javax.swing.JLabel lbTipoPaquete;
    private javax.swing.JPanel pDataDestinatario;
    private javax.swing.JPanel pDataDestinatario1;
    private javax.swing.JPanel pDataDestinatario2;
    private javax.swing.JPanel pFondo;
    private javax.swing.JTextArea taDescripcion;
    private javax.swing.JTextField tfCodgioCliente;
    private javax.swing.JTextField tfCodigoPaquete;
    private javax.swing.JTextField tfCorreo;
    private javax.swing.JTextField tfDestino;
    private javax.swing.JTextField tfNombresApellidosCliente;
    private javax.swing.JTextField tfNombresApellidosDestinatario;
    private javax.swing.JTextField tfOrigen;
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
    
}
