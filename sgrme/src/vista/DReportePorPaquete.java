/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import utilitario.IntVentanas;
import utilitario.ImagenFondo;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author ferna
 */
public class DReportePorPaquete extends javax.swing.JDialog implements IntVentanas{

    /**
     * Creates new form DReportePorPaquete
     * @param parent
     * @param modal
     */
    public DReportePorPaquete(java.awt.Frame parent, boolean modal) {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tReportes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lbCodigoPaquete = new javax.swing.JLabel();
        tfCodigoPaquete = new javax.swing.JTextField();
        lbTipoPaquete = new javax.swing.JLabel();
        cbTipoPaquete = new javax.swing.JComboBox();
        lbEstadoPaquete = new javax.swing.JLabel();
        cbEstadoPaquete = new javax.swing.JComboBox();
        lbFechaInicio = new javax.swing.JLabel();
        dccFechaInicio = new com.toedter.calendar.JDateChooser();
        lbFechaFin = new javax.swing.JLabel();
        dccFechaFin = new com.toedter.calendar.JDateChooser();
        bGenerarReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reportes por Paquetes");

        bAceptar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bAceptar.setMnemonic('A');
        bAceptar.setText("Aceptar");
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        tReportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tReportes);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbCodigoPaquete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodigoPaquete.setText("Código de Paquete");

        lbTipoPaquete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTipoPaquete.setText("Tipo de Paquete");

        cbTipoPaquete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbTipoPaquete.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Documentos", "Caja", "Caja Frágil" }));

        lbEstadoPaquete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbEstadoPaquete.setText("Estado de Paquete");

        cbEstadoPaquete.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "En Recepción", "En Tránsito", "Espera", "Recepcionado" }));

        lbFechaInicio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbFechaInicio.setText("Fecha Inicio");
        lbFechaInicio.setToolTipText("");

        dccFechaInicio.setMaxSelectableDate(new java.util.Date(253370786511000L));
        dccFechaInicio.setMinimumSize(new java.awt.Dimension(20, 20));

        lbFechaFin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbFechaFin.setText("Fecha Fin");
        lbFechaFin.setToolTipText("");

        dccFechaFin.setMaxSelectableDate(new java.util.Date(253370786511000L));
        dccFechaFin.setMinimumSize(new java.awt.Dimension(20, 20));

        bGenerarReporte.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bGenerarReporte.setText("Generar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbCodigoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfCodigoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTipoPaquete)
                            .addComponent(cbTipoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEstadoPaquete)
                            .addComponent(cbEstadoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dccFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dccFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCodigoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCodigoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbTipoPaquete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbEstadoPaquete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEstadoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbFechaInicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dccFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbFechaFin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dccFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(bGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pFondoLayout = new javax.swing.GroupLayout(pFondo);
        pFondo.setLayout(pFondoLayout);
        pFondoLayout.setHorizontalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFondoLayout.createSequentialGroup()
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        pFondoLayout.setVerticalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(DReportePorPaquete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DReportePorPaquete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DReportePorPaquete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DReportePorPaquete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DReportePorPaquete dialog = new DReportePorPaquete(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bGenerarReporte;
    private javax.swing.JComboBox cbEstadoPaquete;
    private javax.swing.JComboBox cbTipoPaquete;
    private com.toedter.calendar.JDateChooser dccFechaFin;
    private com.toedter.calendar.JDateChooser dccFechaInicio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCodigoPaquete;
    private javax.swing.JLabel lbEstadoPaquete;
    private javax.swing.JLabel lbFechaFin;
    private javax.swing.JLabel lbFechaInicio;
    private javax.swing.JLabel lbTipoPaquete;
    private javax.swing.JPanel pFondo;
    private javax.swing.JTable tReportes;
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
