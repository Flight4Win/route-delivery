/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import clases.Aeropuerto;
import utiles.IntVentanas;
import utiles.ImagenFondo;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import utiles.Conexion;
import utiles.SimulationMap;

//import clases.Controlador;
/**
 *
 * @author MFGuevaraL
 */
public class DMonitoreoPaquetes extends javax.swing.JDialog implements IntVentanas{

    /**
     * Creates new form DRutas
     */
    
    int tipoSimulacion;
    FSimulacion parent ;
    private final DefaultTableModel dtmCiudad ;
    private final TableColumnModel tcmCiudad; 
    
    public DMonitoreoPaquetes(java.awt.Frame parent, boolean modal, int tipoSimulacion) {
        super(parent, modal);
        initComponents();
        centrarPantalla();
        
        this.tipoSimulacion = tipoSimulacion;
        processing.core.PApplet mapa = new SimulationMap();
        pMonitoreo.add(mapa);
        dtmCiudad = (DefaultTableModel)TablaCiudades.getModel();        
        tcmCiudad = (TableColumnModel)TablaCiudades.getColumnModel();
//        pBuscarPorPaquetes.setVisible(false);
        //Controlador.getTempo().AgregarListener((SimulationMap)mapa);
        
        mapa.init(); //Esto es necesario para iniciar el Sketch
        //ponerImagenPanel("/imagenes/rutasAviones.jpg",pMonitoreo);
    }

    /**
     *
     * @param parent
     * @param modal
     * @param tipoSimulacion
     * @param parentSimualcion
     */
    
    public DMonitoreoPaquetes(java.awt.Frame parent, boolean modal, int tipoSimulacion, FSimulacion parentSimualcion) {
        super(parent, modal);
        initComponents();
        centrarPantalla();
        dtmCiudad = (DefaultTableModel)TablaCiudades.getModel();        
        tcmCiudad = (TableColumnModel)TablaCiudades.getColumnModel();
        this.tipoSimulacion = tipoSimulacion;
        this.parent = parentSimualcion;
        processing.core.PApplet mapa = new SimulationMap();
        pMonitoreo.add(mapa);
//        pBuscarPorPaquetes.setVisible(false);
        //Controlador.getTempo().AgregarListener((SimulationMap)mapa);
        
        mapa.init(); //Esto es necesario para iniciar el Sketch
        //ponerImagenPanel("/imagenes/rutasAviones.jpg",pMonitoreo);
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
        pBuscarPorPaquetes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCiudades = new javax.swing.JTable();
        bAceptar = new javax.swing.JButton();
        pMonitoreo = new javax.swing.JPanel();
        bPausar = new javax.swing.JButton();
        bReanudar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Monitoreo de Paquetes");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pBuscarPorPaquetes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TablaCiudades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Aeropuerto", "Capacidad ocupada"
            }
        ));
        TablaCiudades.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(TablaCiudades);

        javax.swing.GroupLayout pBuscarPorPaquetesLayout = new javax.swing.GroupLayout(pBuscarPorPaquetes);
        pBuscarPorPaquetes.setLayout(pBuscarPorPaquetesLayout);
        pBuscarPorPaquetesLayout.setHorizontalGroup(
            pBuscarPorPaquetesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pBuscarPorPaquetesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pBuscarPorPaquetesLayout.setVerticalGroup(
            pBuscarPorPaquetesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBuscarPorPaquetesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bAceptar.setMnemonic('A');
        bAceptar.setText("Aceptar");
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        pMonitoreo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout pMonitoreoLayout = new javax.swing.GroupLayout(pMonitoreo);
        pMonitoreo.setLayout(pMonitoreoLayout);
        pMonitoreoLayout.setHorizontalGroup(
            pMonitoreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
        );
        pMonitoreoLayout.setVerticalGroup(
            pMonitoreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        bPausar.setMnemonic('A');
        bPausar.setLabel("Pausar");
        bPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPausarActionPerformed(evt);
            }
        });

        bReanudar.setMnemonic('A');
        bReanudar.setLabel("Reanudar");
        bReanudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReanudarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pFondoLayout = new javax.swing.GroupLayout(pFondo);
        pFondo.setLayout(pFondoLayout);
        pFondoLayout.setHorizontalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(pMonitoreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pBuscarPorPaquetes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bPausar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bReanudar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pFondoLayout.setVerticalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pBuscarPorPaquetes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pMonitoreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bPausar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bReanudar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        this.dispose();
        try {
            Conexion.mr_adicionales.tempo_cancelar();
            Conexion.mr_adicionales.despachador_cancelar();
            Conexion.mr_adicionales.reset_simulacion();
        } catch (RemoteException ex) {
            Logger.getLogger(DMonitoreoPaquetes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_bAceptarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(tipoSimulacion != 1){
            System.exit(0);
        }        
    }//GEN-LAST:event_formWindowClosing

    private void bPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPausarActionPerformed
        try {
            // TODO add your handling code here:
            Conexion.mr_adicionales.despachador_pausar();
            Conexion.mr_adicionales.tempo_pausar();
        } catch (RemoteException ex) {
            Logger.getLogger(DMonitoreoPaquetes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bPausarActionPerformed

    private void bReanudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReanudarActionPerformed
        try {
            // TODO add your handling code here:
            Conexion.mr_adicionales.despachador_renaudar();
            Conexion.mr_adicionales.tempo_renaudar();
        } catch (RemoteException ex) {
            Logger.getLogger(DMonitoreoPaquetes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bReanudarActionPerformed

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
//            java.util.logging.Logger.getLogger(DMonitoreoPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DMonitoreoPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DMonitoreoPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DMonitoreoPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DMonitoreoPaquetes dialog = new DMonitoreoPaquetes(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable TablaCiudades;
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bPausar;
    private javax.swing.JButton bReanudar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pBuscarPorPaquetes;
    private javax.swing.JPanel pFondo;
    private javax.swing.JPanel pMonitoreo;
    // End of variables declaration//GEN-END:variables

    
        public void llenarTablaCiudades(ArrayList<Aeropuerto> aeropuertos){
        limpiarFilasTablaCiudad();
        aeropuertos.stream().map((cAeropuerto) -> {
            Object[] fila = new Object[2];
            fila[0] = cAeropuerto.getNombre();
            fila[1] = cAeropuerto.getCapacidadOcupada();
            return fila;
        }).forEach((fila) -> {
            dtmCiudad.addRow(fila);
        });
    }  
    
        private void limpiarTotalTablaCiudad(){  
        for (int i = 0; i < dtmCiudad.getRowCount(); i++) {
            dtmCiudad.removeRow(i);
            i-=1;
        }     
        if(dtmCiudad.getColumnCount() != 0){
            for(int i = dtmCiudad.getColumnCount()-1; i >= 0 ; i--){
                System.out.println(i);
                TablaCiudades.removeColumn(tcmCiudad.getColumn(i));
                dtmCiudad.setColumnCount(i);
            }
        }
    }
    
    private void limpiarFilasTablaCiudad(){
        for (int i = 0; i < dtmCiudad.getRowCount(); i++) {
            dtmCiudad.removeRow(i);
            i-=1;
        }   
    }
    
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
    
    @Override
    public void asignarIcono(){
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/vista/imagen/iconoAvion.png"));
        this.setIconImage(icon);
    }
    
}
