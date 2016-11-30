/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import utiles.IntVentanas;
import utiles.ImagenFondo;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import entidad.Usuario;
import java.awt.Image;


//import Temporizador.TemporizadorAplicacion;
//import manejadorDB.controlador.PerfilControlador;


/**
 *
 * @author ferna
 */
public final class FInicial extends javax.swing.JFrame implements IntVentanas{
    
    //public Connection conexion;

    /**
     * Creates new form FInicial
     */
    //private final PerfilControlador perfc = new PerfilControlador();
    private int idLogueado;
    private int nivelAcceso;
    
    @SuppressWarnings("LeakingThisInConstructor")
    public FInicial(Usuario usuario) {
        setTitle("SGRME"); 
        initComponents();
        centrarPantalla();  
        asignarIcono();  
        /*-----------------------*/
        new ImagenFondo("/vista/imagen/logo2.jpg").ponerImagenFondo(this);
        aparecerMenu(false);
        /*-----------------------*/
        idLogueado = usuario.getIdusuario();
        nivelAcceso = usuario.getIdperfil().getIdperfil();
//        /*-----------------------*/    
//        mMantenimiento.setVisible(false);
//        miAeropuertos.setVisible(false);
//        miVuelos.setVisible(false);
//        mReportes.setVisible(false);
//        miReportes.setVisible(false);
        /*-----------------------*/
        asignarPerfil();
    }

    public void setIdLogueado(int idLogueado) {
        this.idLogueado = idLogueado;
    }

    public void setNivelAcceso(int nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
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
        miCambioContrasenha = new javax.swing.JMenuItem();
        miCerrarSesion = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        miSalir = new javax.swing.JMenuItem();
        mEmpleados = new javax.swing.JMenu();
        miRegistrarEmpleado = new javax.swing.JMenuItem();
        miBuscarEmpleado = new javax.swing.JMenuItem();
        mCliente = new javax.swing.JMenu();
        miRegistrarCliente = new javax.swing.JMenuItem();
        miBuscarCliente = new javax.swing.JMenuItem();
        mPaquetes = new javax.swing.JMenu();
        miRegistrarPaquete = new javax.swing.JMenuItem();
        mMonitoreo = new javax.swing.JMenu();
        miMonitoreoPaquetes = new javax.swing.JMenuItem();
        mReportes = new javax.swing.JMenu();
        miReportes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        mSesion.setMnemonic('s');
        mSesion.setText("Sesión");
        mSesion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mSesion.setIconTextGap(5);

        miCambioContrasenha.setText("Cambio Contraseña");
        miCambioContrasenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCambioContrasenhaActionPerformed(evt);
            }
        });
        mSesion.add(miCambioContrasenha);

        miCerrarSesion.setText("Cerrar Sesión");
        miCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCerrarSesionActionPerformed(evt);
            }
        });
        mSesion.add(miCerrarSesion);
        mSesion.add(jSeparator2);

        miSalir.setText("Salir");
        miSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSalirActionPerformed(evt);
            }
        });
        mSesion.add(miSalir);

        mbPrincipal.add(mSesion);

        mEmpleados.setMnemonic('e');
        mEmpleados.setText("Empleados");
        mEmpleados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mEmpleados.setIconTextGap(5);

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

        mCliente.setMnemonic('c');
        mCliente.setText("Cliente");
        mCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mCliente.setIconTextGap(5);

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

        mPaquetes.setMnemonic('p');
        mPaquetes.setText("Paquetes");
        mPaquetes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mPaquetes.setIconTextGap(5);

        miRegistrarPaquete.setText("Registrar Paquete");
        miRegistrarPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegistrarPaqueteActionPerformed(evt);
            }
        });
        mPaquetes.add(miRegistrarPaquete);

        mbPrincipal.add(mPaquetes);

        mMonitoreo.setMnemonic('o');
        mMonitoreo.setText("Monitoreo");
        mMonitoreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mMonitoreo.setIconTextGap(5);

        miMonitoreoPaquetes.setText("Monitoreo de Paquetes");
        miMonitoreoPaquetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMonitoreoPaquetesActionPerformed(evt);
            }
        });
        mMonitoreo.add(miMonitoreoPaquetes);

        mbPrincipal.add(mMonitoreo);

        mReportes.setMnemonic('r');
        mReportes.setText("Reportes");
        mReportes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mReportes.setIconTextGap(5);

        miReportes.setText("Generar Reportes");
        miReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miReportesActionPerformed(evt);
            }
        });
        mReportes.add(miReportes);

        mbPrincipal.add(mReportes);

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
        DRegistrarPaquetes dRegistrarPaquetes = new DRegistrarPaquetes(this, rootPaneCheckingEnabled);
        dRegistrarPaquetes.setVisible(true);
    }//GEN-LAST:event_miRegistrarPaqueteActionPerformed

    private void miMonitoreoPaquetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMonitoreoPaquetesActionPerformed
        DMonitoreoPaquetes dRutas = new DMonitoreoPaquetes(this, rootPaneCheckingEnabled, 1);
        dRutas.setVisible(true);
    }//GEN-LAST:event_miMonitoreoPaquetesActionPerformed

    private void miReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miReportesActionPerformed
        DReportes dReportePorCliente = new DReportes(this, rootPaneCheckingEnabled);
        dReportePorCliente.setVisible(true); 
    }//GEN-LAST:event_miReportesActionPerformed

    private void miRegistrarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegistrarEmpleadoActionPerformed
        DRegistrarClienteEmpleado dRegistrarCliente = new DRegistrarClienteEmpleado(this, rootPaneCheckingEnabled,false);
        dRegistrarCliente.setVisible(true);
    }//GEN-LAST:event_miRegistrarEmpleadoActionPerformed

    private void miBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBuscarEmpleadoActionPerformed
        DBuscarClienteEmpleado dBuscarEmpleado = new DBuscarClienteEmpleado(this, rootPaneCheckingEnabled,false);
        dBuscarEmpleado.setVisible(true);
    }//GEN-LAST:event_miBuscarEmpleadoActionPerformed

    private void miCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCerrarSesionActionPerformed
        nivelAcceso = -1;
        idLogueado = -1;
//        aparecerMenu(false);        
        System.out.println("Cerrando sesión");
        DLogueo logueo = new DLogueo(this, rootPaneCheckingEnabled);
        logueo.setVisible(true);
        this.dispose();   // terminar la primera simulacion
    }//GEN-LAST:event_miCerrarSesionActionPerformed

    private void miSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_miSalirActionPerformed

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
//            java.util.logging.Logger.getLogger(FInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FInicial().setVisible(true);
//            }
//        });
//    }

    private void desbloquearMenuOperador(boolean desaparecer){
        mCliente.setVisible(desaparecer);
        mMonitoreo.setVisible(desaparecer);
        mPaquetes.setVisible(desaparecer);
        mReportes.setVisible(desaparecer);
    }
    
    private void desbloquearMenuAdministrador(boolean desaparecer){
        
        mCliente.setVisible(desaparecer);
        mEmpleados.setVisible(desaparecer);
//        mMantenimiento.setVisible(desaparecer);
        mMonitoreo.setVisible(desaparecer);
        mPaquetes.setVisible(desaparecer);
        mReportes.setVisible(desaparecer);
    }
    
    private void desbloquearMenuCliente(boolean desaparecer){
        mMonitoreo.setVisible(desaparecer);
    }
    
    public void asignarPerfil(){
        System.out.println("Voy a asiganr el perfil");
        System.out.println("Nivel de Acceso:   "+nivelAcceso);
        switch (nivelAcceso){
            case 1:
                System.out.println("Soy admin");
                desbloquearMenuAdministrador(true);
                break;
            case 2:
                System.out.println("Soy operador");
                desbloquearMenuOperador(true);
                break;
            case 3:
                System.out.println("Soy Cliente");
                desbloquearMenuCliente(true);
                break;              
        }
    }
    private void aparecerMenu(boolean desaparecer){

        mCliente.setVisible(desaparecer);
        mEmpleados.setVisible(desaparecer);
//        mMantenimiento.setVisible(desaparecer);
        mMonitoreo.setVisible(desaparecer);
        mPaquetes.setVisible(desaparecer);
        mReportes.setVisible(desaparecer);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu mCliente;
    private javax.swing.JMenu mEmpleados;
    private javax.swing.JMenu mMonitoreo;
    private javax.swing.JMenu mPaquetes;
    private javax.swing.JMenu mReportes;
    private javax.swing.JMenu mSesion;
    private javax.swing.JMenuBar mbPrincipal;
    private javax.swing.JMenuItem miBuscarCliente;
    private javax.swing.JMenuItem miBuscarEmpleado;
    private javax.swing.JMenuItem miCambioContrasenha;
    private javax.swing.JMenuItem miCerrarSesion;
    private javax.swing.JMenuItem miMonitoreoPaquetes;
    private javax.swing.JMenuItem miRegistrarCliente;
    private javax.swing.JMenuItem miRegistrarEmpleado;
    private javax.swing.JMenuItem miRegistrarPaquete;
    private javax.swing.JMenuItem miReportes;
    private javax.swing.JMenuItem miSalir;
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
    
    @Override
    public void asignarIcono(){
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/vista/imagen/iconoAvion.png"));
        this.setIconImage(icon);
    }    
    

}