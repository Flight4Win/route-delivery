/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import entidad.Usuario;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import utiles.ImagenFondo;
import utiles.IntVentanas;
import utiles.ProgressBar;

import clases.Controlador;


/**
 *
 * @author MFGuevaraL
 */
public class DSimulacion extends javax.swing.JDialog implements IntVentanas{

    /**
     * Creates new form DSimulacion
     */
    
    private Usuario usuario;
    public DSimulacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        centrarPantalla();  
    }

    public DSimulacion(java.awt.Frame parent, boolean modal, Usuario usuario) {
        super(parent, modal);
        initComponents();
        centrarPantalla();  
                
        this.usuario = usuario;
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
        lbTitulo = new javax.swing.JLabel();
        bPrimeraSimulacion = new javax.swing.JButton();
        bSegundaSimulacion = new javax.swing.JButton();
        bTerceraSimulacion = new javax.swing.JButton();
        bSalir = new javax.swing.JButton();
        lbMensajeBienvenida = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Simulación");

        lbTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbTitulo.setText("Configuraciones para Simulación");


        bPrimeraSimulacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bPrimeraSimulacion.setText("1era Simulación");
        bPrimeraSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPrimeraSimulacionActionPerformed(evt);
            }
        });

        bSegundaSimulacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bSegundaSimulacion.setText("2da Simulación");
        bSegundaSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSegundaSimulacionActionPerformed(evt);
            }
        });

        bTerceraSimulacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bTerceraSimulacion.setText("3era Simulación");
        bTerceraSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTerceraSimulacionActionPerformed(evt);
            }
        });

        bSalir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/salir30.png"))); // NOI18N
        bSalir.setBorder(null);
        bSalir.setBorderPainted(false);
        bSalir.setContentAreaFilled(false);
        bSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bSalir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/salir28.png"))); // NOI18N
        bSalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/salir32.png"))); // NOI18N
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        lbMensajeBienvenida.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbMensajeBienvenida.setText("Bienvenid@ al software SGRME, vista de Simulación: ");

        javax.swing.GroupLayout pFondoLayout = new javax.swing.GroupLayout(pFondo);
        pFondo.setLayout(pFondoLayout);
        pFondoLayout.setHorizontalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitulo)
                    .addComponent(lbMensajeBienvenida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFondoLayout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(bPrimeraSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(bSegundaSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(bTerceraSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        pFondoLayout.setVerticalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addComponent(bSalir)
                        .addGap(42, 42, 42))
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addComponent(lbMensajeBienvenida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bPrimeraSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSegundaSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bTerceraSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
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

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_bSalirActionPerformed

    private void bPrimeraSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPrimeraSimulacionActionPerformed
        this.dispose();
        FInicial vistaPrimeraSimulacion = new FInicial(usuario, this);
        vistaPrimeraSimulacion.setVisible(true);
        Controlador.getPlanVuelos().ResetearColeccion();
        Controlador.getTempo().ActivarPrimSim();
        Controlador.getDespacher().ActivarPrimSim();
    }//GEN-LAST:event_bPrimeraSimulacionActionPerformed

    private void bSegundaSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSegundaSimulacionActionPerformed
        //this.dispose();
        Controlador.getPlanVuelos().ResetearColeccion();
        Controlador.getTempo().ActivarSegSim();
        Controlador.getDespacher().ActivarSegSim();
        DMonitoreoPaquetes vistaSegundaSimulacion = new DMonitoreoPaquetes(null, rootPaneCheckingEnabled, 2);
        vistaSegundaSimulacion.setVisible(true);
        
    }//GEN-LAST:event_bSegundaSimulacionActionPerformed

    private void bTerceraSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTerceraSimulacionActionPerformed
        //this.dispose();
        Controlador.getPlanVuelos().ResetearColeccion();
        Controlador.getTempo().ActivarTerSim();
        Controlador.getDespacher().ActivarTerSim();
        DMonitoreoPaquetes vistaTerceraSimulacion = new DMonitoreoPaquetes(null, rootPaneCheckingEnabled, 3);
        vistaTerceraSimulacion.setVisible(true);
        
    }//GEN-LAST:event_bTerceraSimulacionActionPerformed

    private void txtFileRouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFileRouteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFileRouteActionPerformed

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
            java.util.logging.Logger.getLogger(DSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DSimulacion dialog = new DSimulacion(new javax.swing.JFrame(), true);
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

           
//        ProgressBar pb = new ProgressBar(pbCargando, this,(String)cbData.getSelectedItem());
//        pb.execute();
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bPrimeraSimulacion;
    private javax.swing.JButton bSalir;
    private javax.swing.JButton bSegundaSimulacion;
    private javax.swing.JButton bTerceraSimulacion;
    private javax.swing.JLabel lbMensajeBienvenida;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel pFondo;
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
    public final void ponerImagenPanel(String direccion,javax.swing.JPanel pFondo) {
        ImagenFondo Imagen = new ImagenFondo(pFondo.getWidth(),pFondo.getHeight(),direccion);
        pFondo.add(Imagen);
        pFondo.repaint();
    }
    
    
    
}
