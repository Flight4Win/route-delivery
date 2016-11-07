/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import algoritmo.GrafoAeropuerto;
import clases.Controlador;
import data.ColeccionAeropuerto;
import data.ColeccionPlanVuelo;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import Temporizador.TemporizadorAplicacion;

/**
 *
 * @author ferna
 */
public class FInicial extends javax.swing.JFrame implements IntVentanas{
    
    //public Connection conexion;

    /**
     * Creates new form FInicial
     */
    int idLogueado;
    int nroPerfil;
    
    @SuppressWarnings("LeakingThisInConstructor")
    public FInicial() {
        
        setTitle("SGRME"); 
        
        //ConexionMySQL con=new ConexionMySQL();
        //this.conexion=con.conexion();
       
        initComponents();
        centrarPantalla();  
        new ImagenFondo("/vista/imagen/logo2.jpg").ponerImagenFondo(this);
        aparecerMenu(false);
        
        Controlador.IniControlador();
        

    }

    public void setIdLogueado(int idLogueado) {
        this.idLogueado = idLogueado;
    }

    public void setNroPerfil(int nroPerfil) {
        this.nroPerfil = nroPerfil;
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
        mbPrincipal = new javax.swing.JMenuBar();
        mSesion = new javax.swing.JMenu();
        miLogueo = new javax.swing.JMenuItem();
        miCambioContrasenha = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miCerrarSesion = new javax.swing.JMenuItem();
        mEmpleados = new javax.swing.JMenu();
        miRegistrarEmpleado = new javax.swing.JMenuItem();
        miBuscarEmpleado = new javax.swing.JMenuItem();
        mCliente = new javax.swing.JMenu();
        miRegistrarCliente = new javax.swing.JMenuItem();
        miBuscarCliente = new javax.swing.JMenuItem();
        mPaquetes = new javax.swing.JMenu();
        miRegistrarPaquete = new javax.swing.JMenuItem();
        miBuscarPaquete = new javax.swing.JMenuItem();
        mMonitoreo = new javax.swing.JMenu();
        miMonitoreoPaquetes = new javax.swing.JMenuItem();
        mReportes = new javax.swing.JMenu();
        miReportePorCliente = new javax.swing.JMenuItem();
        miReportePorPaquete = new javax.swing.JMenuItem();
        mMantenimiento = new javax.swing.JMenu();
        miVuelos = new javax.swing.JMenuItem();
        miCiudades = new javax.swing.JMenuItem();
        miContimente = new javax.swing.JMenuItem();
        miAlmacen = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        javax.swing.GroupLayout pFondoLayout = new javax.swing.GroupLayout(pFondo);
        pFondo.setLayout(pFondoLayout);
        pFondoLayout.setHorizontalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 614, Short.MAX_VALUE)
        );
        pFondoLayout.setVerticalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        mbPrincipal.setPreferredSize(new java.awt.Dimension(259, 30));

        mSesion.setText("Sesión");

        miLogueo.setText("Iniciar Sesión");
        miLogueo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLogueoActionPerformed(evt);
            }
        });
        mSesion.add(miLogueo);

        miCambioContrasenha.setText("Cambio Contraseña");
        miCambioContrasenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCambioContrasenhaActionPerformed(evt);
            }
        });
        mSesion.add(miCambioContrasenha);
        mSesion.add(jSeparator1);

        miCerrarSesion.setText("Cerrar Sesión");
        miCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCerrarSesionActionPerformed(evt);
            }
        });
        mSesion.add(miCerrarSesion);

        mbPrincipal.add(mSesion);

        mEmpleados.setText("Empleados");

        miRegistrarEmpleado.setText("Registrar Empleado");
        miRegistrarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegistrarEmpleadoActionPerformed(evt);
            }
        });
        mEmpleados.add(miRegistrarEmpleado);

        miBuscarEmpleado.setText("Buscar empleado");
        miBuscarEmpleado.setToolTipText("");
        miBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBuscarEmpleadoActionPerformed(evt);
            }
        });
        mEmpleados.add(miBuscarEmpleado);

        mbPrincipal.add(mEmpleados);

        mCliente.setText("Cliente");

        miRegistrarCliente.setText("Registrar Cliente");
        miRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegistrarClienteActionPerformed(evt);
            }
        });
        mCliente.add(miRegistrarCliente);

        miBuscarCliente.setText("Buscar Cliente");
        miBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBuscarClienteActionPerformed(evt);
            }
        });
        mCliente.add(miBuscarCliente);

        mbPrincipal.add(mCliente);

        mPaquetes.setText("Paquetes");

        miRegistrarPaquete.setText("Registrar Paquete");
        miRegistrarPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegistrarPaqueteActionPerformed(evt);
            }
        });
        mPaquetes.add(miRegistrarPaquete);

        miBuscarPaquete.setText("Buscar Paquete");
        miBuscarPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBuscarPaqueteActionPerformed(evt);
            }
        });
        mPaquetes.add(miBuscarPaquete);

        mbPrincipal.add(mPaquetes);

        mMonitoreo.setText("Monitoreo");

        miMonitoreoPaquetes.setText("Monitoreo de Paquetes");
        miMonitoreoPaquetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMonitoreoPaquetesActionPerformed(evt);
            }
        });
        mMonitoreo.add(miMonitoreoPaquetes);

        mbPrincipal.add(mMonitoreo);

        mReportes.setText("Reportes");

        miReportePorCliente.setText("Por Clientes");
        miReportePorCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miReportePorClienteActionPerformed(evt);
            }
        });
        mReportes.add(miReportePorCliente);

        miReportePorPaquete.setText("Por Paquetes");
        miReportePorPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miReportePorPaqueteActionPerformed(evt);
            }
        });
        mReportes.add(miReportePorPaquete);

        mbPrincipal.add(mReportes);

        mMantenimiento.setText("Mantenimiento");

        miVuelos.setText("Vuelos");
        miVuelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVuelosActionPerformed(evt);
            }
        });
        mMantenimiento.add(miVuelos);

        miCiudades.setText("Ciudades");
        miCiudades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCiudadesActionPerformed(evt);
            }
        });
        mMantenimiento.add(miCiudades);

        miContimente.setText("Continente");
        miContimente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miContimenteActionPerformed(evt);
            }
        });
        mMantenimiento.add(miContimente);

        miAlmacen.setText("Almacenes");
        miAlmacen.setToolTipText("");
        miAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAlmacenActionPerformed(evt);
            }
        });
        mMantenimiento.add(miAlmacen);

        mbPrincipal.add(mMantenimiento);

        setJMenuBar(mbPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miLogueoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLogueoActionPerformed
        DLogueo dLogueo = new DLogueo(this, rootPaneCheckingEnabled,this);
        dLogueo.setVisible(true);        
    }//GEN-LAST:event_miLogueoActionPerformed

    private void miCambioContrasenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCambioContrasenhaActionPerformed
        DCambioContrasenia dCambioContrasenia = new DCambioContrasenia(this, rootPaneCheckingEnabled,this);
        dCambioContrasenia.setVisible(true);
    }//GEN-LAST:event_miCambioContrasenhaActionPerformed

    private void miRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegistrarClienteActionPerformed
        DRegistrarClienteEmpleado dRegistrarCliente = new DRegistrarClienteEmpleado(this, rootPaneCheckingEnabled,true);
        dRegistrarCliente.setVisible(true);
    }//GEN-LAST:event_miRegistrarClienteActionPerformed

    private void miBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBuscarClienteActionPerformed
        DBuscarClienteEmpleado dBuscarCliente = new DBuscarClienteEmpleado(this, rootPaneCheckingEnabled,true);
        dBuscarCliente.setVisible(true);
    }//GEN-LAST:event_miBuscarClienteActionPerformed

    private void miRegistrarPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegistrarPaqueteActionPerformed
        DRegistrarUnPaquete dRegistrarPaquete = new DRegistrarUnPaquete(this, rootPaneCheckingEnabled);
        dRegistrarPaquete.setVisible(true);
    }//GEN-LAST:event_miRegistrarPaqueteActionPerformed

    private void miBuscarPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBuscarPaqueteActionPerformed
        DBuscarPaquete dBuscarPaquete = new DBuscarPaquete(this, rootPaneCheckingEnabled);
        dBuscarPaquete.setVisible(true);
    }//GEN-LAST:event_miBuscarPaqueteActionPerformed

    private void miMonitoreoPaquetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMonitoreoPaquetesActionPerformed
        DMonitoreoPaquetes dRutas = new DMonitoreoPaquetes(this, rootPaneCheckingEnabled);
        dRutas.setVisible(true);
    }//GEN-LAST:event_miMonitoreoPaquetesActionPerformed

    private void miReportePorClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miReportePorClienteActionPerformed
        DReportePorCliente dReportePorCliente = new DReportePorCliente(this, rootPaneCheckingEnabled);
        dReportePorCliente.setVisible(true); 
    }//GEN-LAST:event_miReportePorClienteActionPerformed

    private void miReportePorPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miReportePorPaqueteActionPerformed
        DReportePorPaquete dReportePorPaquete = new DReportePorPaquete(null, rootPaneCheckingEnabled);
        dReportePorPaquete.setVisible(true);
    }//GEN-LAST:event_miReportePorPaqueteActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        
    }//GEN-LAST:event_formMouseDragged

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        
    }//GEN-LAST:event_formComponentResized

    private void miVuelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miVuelosActionPerformed
        DMantenimientoVuelos dMantenimientoVuelos = new DMantenimientoVuelos(this, rootPaneCheckingEnabled);
        dMantenimientoVuelos.setVisible(true);
    }//GEN-LAST:event_miVuelosActionPerformed

    private void miCiudadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCiudadesActionPerformed
        DMantenimientoCiudad dMantenimientoCiudad = new DMantenimientoCiudad(this, rootPaneCheckingEnabled);
        dMantenimientoCiudad.setVisible(true);
    }//GEN-LAST:event_miCiudadesActionPerformed

    private void miContimenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miContimenteActionPerformed
        DMantenimientoContinente dMantenimientoContinente = new DMantenimientoContinente(this, rootPaneCheckingEnabled);
        dMantenimientoContinente.setVisible(true);
    }//GEN-LAST:event_miContimenteActionPerformed

    private void miAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAlmacenActionPerformed
        DMantenimientoAlmacen dMantenimientoAlmacen = new DMantenimientoAlmacen(this, rootPaneCheckingEnabled);
        dMantenimientoAlmacen.setVisible(true);
    }//GEN-LAST:event_miAlmacenActionPerformed

    private void miRegistrarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegistrarEmpleadoActionPerformed
        DRegistrarClienteEmpleado dRegistrarEmpleado = new DRegistrarClienteEmpleado(this, rootPaneCheckingEnabled,false);
        dRegistrarEmpleado.setVisible(true);
    }//GEN-LAST:event_miRegistrarEmpleadoActionPerformed

    private void miBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBuscarEmpleadoActionPerformed
        DBuscarClienteEmpleado dBuscarEmpleado = new DBuscarClienteEmpleado(this, rootPaneCheckingEnabled,false);
        dBuscarEmpleado.setVisible(true);
    }//GEN-LAST:event_miBuscarEmpleadoActionPerformed

    private void miCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCerrarSesionActionPerformed
        nroPerfil = -1;
        idLogueado = -1;
        aparecerMenu(false);
    }//GEN-LAST:event_miCerrarSesionActionPerformed

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
            java.util.logging.Logger.getLogger(FInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FInicial().setVisible(true);
            }
        });
    }

    private void desbloquearMenuOperador(boolean desaparecer){
        mCliente.setVisible(desaparecer);
        mMonitoreo.setVisible(desaparecer);
        mPaquetes.setVisible(desaparecer);
        mReportes.setVisible(desaparecer);
    }
    
    private void desbloquearMenuAdministrador(boolean desaparecer){
        mCliente.setVisible(desaparecer);
        mEmpleados.setVisible(desaparecer);
        mMantenimiento.setVisible(desaparecer);
        mMonitoreo.setVisible(desaparecer);
        mPaquetes.setVisible(desaparecer);
        mReportes.setVisible(desaparecer);
    }
    
    private void desbloquearMenuCliente(boolean desaparecer){
        mMonitoreo.setVisible(desaparecer);
    }
    
    public void asignarPerfil(){
        switch (nroPerfil){
            case 0:
                desbloquearMenuAdministrador(true);
                break;
            case 1:
                desbloquearMenuOperador(true);
                break;
            case 2:
                desbloquearMenuCliente(true);
                break;              
        }
    }
    private void aparecerMenu(boolean desaparecer){
        mCliente.setVisible(desaparecer);
        mEmpleados.setVisible(desaparecer);
        mMantenimiento.setVisible(desaparecer);
        mMonitoreo.setVisible(desaparecer);
        mPaquetes.setVisible(desaparecer);
        mReportes.setVisible(desaparecer);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu mCliente;
    private javax.swing.JMenu mEmpleados;
    private javax.swing.JMenu mMantenimiento;
    private javax.swing.JMenu mMonitoreo;
    private javax.swing.JMenu mPaquetes;
    private javax.swing.JMenu mReportes;
    private javax.swing.JMenu mSesion;
    private javax.swing.JMenuBar mbPrincipal;
    private javax.swing.JMenuItem miAlmacen;
    private javax.swing.JMenuItem miBuscarCliente;
    private javax.swing.JMenuItem miBuscarEmpleado;
    private javax.swing.JMenuItem miBuscarPaquete;
    private javax.swing.JMenuItem miCambioContrasenha;
    private javax.swing.JMenuItem miCerrarSesion;
    private javax.swing.JMenuItem miCiudades;
    private javax.swing.JMenuItem miContimente;
    private javax.swing.JMenuItem miLogueo;
    private javax.swing.JMenuItem miMonitoreoPaquetes;
    private javax.swing.JMenuItem miRegistrarCliente;
    private javax.swing.JMenuItem miRegistrarEmpleado;
    private javax.swing.JMenuItem miRegistrarPaquete;
    private javax.swing.JMenuItem miReportePorCliente;
    private javax.swing.JMenuItem miReportePorPaquete;
    private javax.swing.JMenuItem miVuelos;
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