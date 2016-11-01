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
public class FPrincipal extends javax.swing.JFrame  implements IntVentanas{

    /**
     * Creates new form Principal
     */
    public FPrincipal() {
        setTitle("SGRME");        
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

        pPrincipal = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mInicio = new javax.swing.JMenu();
        miLogueo = new javax.swing.JMenuItem();
        miCambioContrasenia = new javax.swing.JMenuItem();
        mClientes = new javax.swing.JMenu();
        miRegistrarCliente = new javax.swing.JMenuItem();
        miBuscarCliente = new javax.swing.JMenuItem();
        mPaquetes = new javax.swing.JMenu();
        miRegistrarPaquete = new javax.swing.JMenuItem();
        miBuscarPaquete = new javax.swing.JMenuItem();
        mRutas = new javax.swing.JMenu();
        mReportes = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGRME");
        setResizable(false);

        javax.swing.GroupLayout pPrincipalLayout = new javax.swing.GroupLayout(pPrincipal);
        pPrincipal.setLayout(pPrincipalLayout);
        pPrincipalLayout.setHorizontalGroup(
            pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        pPrincipalLayout.setVerticalGroup(
            pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        jMenuBar1.setToolTipText("");

        mInicio.setText("Inicio");

        miLogueo.setText("Logueo");
        miLogueo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLogueoActionPerformed(evt);
            }
        });
        mInicio.add(miLogueo);

        miCambioContrasenia.setText("Cambiar Contrasenña");
        miCambioContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCambioContraseniaActionPerformed(evt);
            }
        });
        mInicio.add(miCambioContrasenia);

        jMenuBar1.add(mInicio);

        mClientes.setText("Clientes");

        miRegistrarCliente.setText("Registrar Cliente");
        miRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegistrarClienteActionPerformed(evt);
            }
        });
        mClientes.add(miRegistrarCliente);

        miBuscarCliente.setText("Buscar Cliente");
        miBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBuscarClienteActionPerformed(evt);
            }
        });
        mClientes.add(miBuscarCliente);

        jMenuBar1.add(mClientes);

        mPaquetes.setText("Paquetes");

        miRegistrarPaquete.setText("Registrar Paquete");
        miRegistrarPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegistrarPaqueteActionPerformed(evt);
            }
        });
        mPaquetes.add(miRegistrarPaquete);

        miBuscarPaquete.setText("Buscar Paquetes");
        miBuscarPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBuscarPaqueteActionPerformed(evt);
            }
        });
        mPaquetes.add(miBuscarPaquete);

        jMenuBar1.add(mPaquetes);

        mRutas.setText("Rutas");
        mRutas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mRutasMouseClicked(evt);
            }
        });
        mRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mRutasActionPerformed(evt);
            }
        });
        jMenuBar1.add(mRutas);

        mReportes.setText("Reportes");
        mReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mReportesMouseClicked(evt);
            }
        });
        mReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mReportesActionPerformed(evt);
            }
        });
        jMenuBar1.add(mReportes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miLogueoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLogueoActionPerformed
        DLogueo dLogueo = new DLogueo(this, rootPaneCheckingEnabled);
        dLogueo.setVisible(true);
    }//GEN-LAST:event_miLogueoActionPerformed

    private void miCambioContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCambioContraseniaActionPerformed
        DCambioContrasenia dCambioContrasenia = new DCambioContrasenia(this, rootPaneCheckingEnabled);
        dCambioContrasenia.setVisible(true);
    }//GEN-LAST:event_miCambioContraseniaActionPerformed

    private void miRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegistrarClienteActionPerformed
        DRegistrarCliente dRegistrarCliente = new DRegistrarCliente(this, rootPaneCheckingEnabled);
        dRegistrarCliente.setVisible(true);
    }//GEN-LAST:event_miRegistrarClienteActionPerformed

    private void miBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBuscarClienteActionPerformed
        DBuscarCliente dBuscarCliente = new DBuscarCliente(this, rootPaneCheckingEnabled);
        dBuscarCliente.setVisible(true);
    }//GEN-LAST:event_miBuscarClienteActionPerformed

    private void miRegistrarPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegistrarPaqueteActionPerformed
        DRegistrarPaquete dRegistrarPaquete = new DRegistrarPaquete(this, rootPaneCheckingEnabled);
        dRegistrarPaquete.setVisible(true);
    }//GEN-LAST:event_miRegistrarPaqueteActionPerformed

    private void miBuscarPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBuscarPaqueteActionPerformed
        DBuscarPaquete dBuscarPaquete = new DBuscarPaquete(this, rootPaneCheckingEnabled);
        dBuscarPaquete.setVisible(true);
    }//GEN-LAST:event_miBuscarPaqueteActionPerformed

    private void mRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mRutasActionPerformed
        
    }//GEN-LAST:event_mRutasActionPerformed

    private void mReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mReportesActionPerformed
        
    }//GEN-LAST:event_mReportesActionPerformed

    private void mReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mReportesMouseClicked
        System.out.println("HOl");
        DParametrosReporte dParametrosReporte = new DParametrosReporte(this, rootPaneCheckingEnabled);
        dParametrosReporte.setVisible(true);
        System.out.println("pase ");
    }//GEN-LAST:event_mReportesMouseClicked

    private void mRutasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mRutasMouseClicked
        DRutas dRutas = new DRutas(this, rootPaneCheckingEnabled);
        dRutas.setVisible(true);
    }//GEN-LAST:event_mRutasMouseClicked

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
            java.util.logging.Logger.getLogger(FPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FPrincipal p = new FPrincipal();
                p.pack();     
                
                p.setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mClientes;
    private javax.swing.JMenu mInicio;
    private javax.swing.JMenu mPaquetes;
    private javax.swing.JMenu mReportes;
    private javax.swing.JMenu mRutas;
    private javax.swing.JMenuItem miBuscarCliente;
    private javax.swing.JMenuItem miBuscarPaquete;
    private javax.swing.JMenuItem miCambioContrasenia;
    private javax.swing.JMenuItem miLogueo;
    private javax.swing.JMenuItem miRegistrarCliente;
    private javax.swing.JMenuItem miRegistrarPaquete;
    private javax.swing.JPanel pPrincipal;
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