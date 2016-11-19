/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import entidad.Empleado;
import entidad.Persona;
import entidad.Usuario;
import utilitario.IntVentanas;
import utilitario.ImagenFondo;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import manejadorDB.controlador.CargoControlador;
import manejadorDB.controlador.EmpleadoControlador;
import manejadorDB.controlador.EstadoControlador;
import manejadorDB.controlador.PerfilControlador;
import manejadorDB.controlador.PersonaControlador;
import manejadorDB.controlador.UsuarioControlador;
import utilitario.Helper;

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
    private DBuscarClienteEmpleado parentBuscarClienteEmpleado = null;
    private boolean dataModificada = false;


    //Connection con;
    private Persona persona;
    private Empleado empleado;
    private final PersonaControlador pc = new PersonaControlador();
    private final EmpleadoControlador empc = new EmpleadoControlador();
    private int nivelAcceso;
    
    public DDataEmpleado(java.awt.Frame parent, boolean modal, DBuscarClienteEmpleado parentDBuscarClienteEmpleado, Empleado empleado/*,Connection con*/) {
        super(parent, modal);
        initComponents();
                
        this.parentBuscarClienteEmpleado = parentDBuscarClienteEmpleado;
        this.empleado = empleado;
        
        
        parentDBuscarClienteEmpleado.setVisible(false);
        centrarPantalla(); 
        llenarDatos();
    }
    
    public DDataEmpleado(java.awt.Frame parent, boolean modal, Persona persona) {
        super(parent, modal);
        initComponents();
        
        this.persona = persona;
        
        centrarPantalla(); 
        llenarDatos();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPerfilesUsuarios = new javax.swing.ButtonGroup();
        pFondo = new javax.swing.JPanel();
        bCancelar = new javax.swing.JButton();
        bAceptar = new javax.swing.JButton();
        lbCorreo = new javax.swing.JLabel();
        lbTelefono = new javax.swing.JLabel();
        lbDireccion = new javax.swing.JLabel();
        lbDNI = new javax.swing.JLabel();
        lbCodigo = new javax.swing.JLabel();
        lbNombres = new javax.swing.JLabel();
        lbApellidoPaterno = new javax.swing.JLabel();
        lbApellidoMaterno = new javax.swing.JLabel();
        tfCorreo = new javax.swing.JTextField();
        tfTelefono = new javax.swing.JTextField();
        tfDireccion = new javax.swing.JTextField();
        tfDNI = new javax.swing.JTextField();
        tfCodigo = new javax.swing.JTextField();
        tfNombres = new javax.swing.JTextField();
        tfApellidoPaterno = new javax.swing.JTextField();
        tfApellidoMaterno = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        pPerfiles = new javax.swing.JPanel();
        lbPerfil = new javax.swing.JLabel();
        rbAdministrador = new javax.swing.JRadioButton();
        lbDescripcionAdministrador = new javax.swing.JLabel();
        rbOperador = new javax.swing.JRadioButton();
        lbDescripcionOperador = new javax.swing.JLabel();
        lbPerfil1 = new javax.swing.JLabel();
        bModificarDatosEmpleado = new javax.swing.JButton();
        bRemoverDatosEmpleado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Empleado");

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

        lbCorreo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCorreo.setText("Correo");

        lbTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTelefono.setText("Teléfono");

        lbDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDireccion.setText("Dirección");

        lbDNI.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDNI.setText("DNI");

        lbCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodigo.setText("Código");

        lbNombres.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbNombres.setText("Nombres");

        lbApellidoPaterno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbApellidoPaterno.setText("Apellido Paterno");

        lbApellidoMaterno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbApellidoMaterno.setText("Apellido Materno ");

        tfCorreo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tfTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tfDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tfDNI.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tfCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tfNombres.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tfApellidoPaterno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tfApellidoMaterno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbPerfil.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbPerfil.setLabelFor(pPerfiles);
        lbPerfil.setText("Perfil - Niveles de Acceso");

        bgPerfilesUsuarios.add(rbAdministrador);
        rbAdministrador.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbAdministrador.setText("Administrador");

        lbDescripcionAdministrador.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDescripcionAdministrador.setText("Puede realizar cambios en permisos de usuarios del sistema, creación y eliminación de activos.");

        bgPerfilesUsuarios.add(rbOperador);
        rbOperador.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbOperador.setSelected(true);
        rbOperador.setText("Operador");

        lbDescripcionOperador.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDescripcionOperador.setText("Puede registrar nuevos pedidos y clientes, así como generar reportes de estos");

        javax.swing.GroupLayout pPerfilesLayout = new javax.swing.GroupLayout(pPerfiles);
        pPerfiles.setLayout(pPerfilesLayout);
        pPerfilesLayout.setHorizontalGroup(
            pPerfilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPerfilesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPerfilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPerfilesLayout.createSequentialGroup()
                        .addComponent(lbPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(183, 183, 183))
                    .addGroup(pPerfilesLayout.createSequentialGroup()
                        .addGroup(pPerfilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbAdministrador)
                            .addComponent(rbOperador)
                            .addGroup(pPerfilesLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(pPerfilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbDescripcionOperador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbDescripcionAdministrador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pPerfilesLayout.setVerticalGroup(
            pPerfilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPerfilesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbAdministrador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDescripcionAdministrador)
                .addGap(12, 12, 12)
                .addComponent(rbOperador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDescripcionOperador)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbPerfil1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbPerfil1.setText("Datos Personales");

        bModificarDatosEmpleado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bModificarDatosEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/editaruser21.png"))); // NOI18N
        bModificarDatosEmpleado.setBorder(null);
        bModificarDatosEmpleado.setBorderPainted(false);
        bModificarDatosEmpleado.setContentAreaFilled(false);
        bModificarDatosEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bModificarDatosEmpleado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bModificarDatosEmpleado.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/editaruser18.png"))); // NOI18N
        bModificarDatosEmpleado.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/editaruser24.png"))); // NOI18N
        bModificarDatosEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarDatosEmpleadoActionPerformed(evt);
            }
        });

        bRemoverDatosEmpleado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bRemoverDatosEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/removerUser21.png"))); // NOI18N
        bRemoverDatosEmpleado.setBorder(null);
        bRemoverDatosEmpleado.setBorderPainted(false);
        bRemoverDatosEmpleado.setContentAreaFilled(false);
        bRemoverDatosEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bRemoverDatosEmpleado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bRemoverDatosEmpleado.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/removerUser18.png"))); // NOI18N
        bRemoverDatosEmpleado.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/removerUser24.png"))); // NOI18N
        bRemoverDatosEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemoverDatosEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pFondoLayout = new javax.swing.GroupLayout(pFondo);
        pFondo.setLayout(pFondoLayout);
        pFondoLayout.setHorizontalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addComponent(pPerfiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pFondoLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbCorreo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfCorreo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfCodigo)
                                            .addComponent(lbCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbNombres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(tfNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfApellidoMaterno)
                                            .addComponent(lbApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pFondoLayout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfDNI)
                                            .addComponent(tfApellidoPaterno)
                                            .addComponent(lbApellidoPaterno, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                            .addComponent(tfTelefono)
                                            .addComponent(lbTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbDNI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFondoLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(pFondoLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(lbPerfil1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bModificarDatosEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bRemoverDatosEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22))
        );
        pFondoLayout.setVerticalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lbPerfil1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pFondoLayout.createSequentialGroup()
                                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pFondoLayout.createSequentialGroup()
                                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lbDNI)
                                            .addComponent(lbCodigo))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(lbNombres)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pFondoLayout.createSequentialGroup()
                                .addComponent(bModificarDatosEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bRemoverDatosEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(lbApellidoPaterno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pFondoLayout.createSequentialGroup()
                            .addComponent(lbApellidoMaterno)
                            .addGap(26, 26, 26))
                        .addComponent(tfApellidoMaterno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addComponent(lbTelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(pPerfiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
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

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        if(rbAdministrador.isSelected()){
            nivelAcceso = 1;
        }else{
            nivelAcceso = 2;
        }        
        if(dataModificada){
            modificarDatosPersona();       
            JOptionPane.showMessageDialog(this,"Datos Modificados Correctamente", 
                "FELICIDADES", JOptionPane.PLAIN_MESSAGE,
                ingresarImagen("/vista/imagen/check64.png"));
        }else{
            if(parentBuscarClienteEmpleado == null){     
                agregarEmpleado();
            }
        }
        this.dispose();
        if(parentBuscarClienteEmpleado != null){
            parentBuscarClienteEmpleado.setVisible(true);
        } 
    }//GEN-LAST:event_bAceptarActionPerformed

    private void bModificarDatosEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarDatosEmpleadoActionPerformed
        dataModificada = true ;
        habilitarTextFileDatos(dataModificada);
    }//GEN-LAST:event_bModificarDatosEmpleadoActionPerformed

    private void bRemoverDatosEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoverDatosEmpleadoActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this,"Los datos de este cliente se eliminarán \n ¿Desea continuar?",
                "ADVERTENCIA", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,                 
                ingresarImagen("/vista/imagen/warning.png"));    
        if(opcion==0){            
            this.dispose();
            if(parentBuscarClienteEmpleado != null){//sigifica que viene de buscar 
                parentBuscarClienteEmpleado.setVisible(true);
                empc.eliminar(empleado.getIdempleado());
                pc.eliminar(empleado.getIdpersona().getIdpersona());
            } else{
                pc.eliminar(persona.getIdpersona());   
            }
        }
    }//GEN-LAST:event_bRemoverDatosEmpleadoActionPerformed
    
    private void habilitarTextFileDatos(boolean activar){
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
    
    private void llenarDatos(){
        if(parentBuscarClienteEmpleado != null){
            tfCodigo.setText(empleado.getCodigo());
            tfApellidoPaterno.setText(empleado.getIdpersona().getApellidopat());
            tfApellidoMaterno.setText(empleado.getIdpersona().getApellidomat());
            tfNombres.setText(empleado.getIdpersona().getNombres());
            tfDNI.setText(empleado.getIdpersona().getDocumento());
            tfCorreo.setText(empleado.getIdpersona().getCorreo());
            tfTelefono.setText(empleado.getIdpersona().getCelular());
            if(empleado.getIdusuario().getIdperfil().getNivelacceso() == 1){
                rbAdministrador.isSelected();                
            }else if (empleado.getIdusuario().getIdperfil().getNivelacceso() == 2){
                rbAdministrador.isSelected();   
            }
        }else{
            tfApellidoPaterno.setText(empleado.getIdpersona().getApellidopat());
            tfApellidoMaterno.setText(empleado.getIdpersona().getApellidomat());
            tfNombres.setText(empleado.getIdpersona().getNombres());
            tfDNI.setText(empleado.getIdpersona().getDocumento());
            tfCorreo.setText(empleado.getIdpersona().getCorreo());
            tfTelefono.setText(empleado.getIdpersona().getCelular());                    
       }
    }
    
    private Persona capturarDatos(){
        Persona p = new Persona(persona.getIdpersona(), 
                                tfDNI.getText(), 
                                tfApellidoPaterno.getText(), 
                                tfApellidoMaterno.getText(), 
                                tfNombres.getText(), 
                                tfTelefono.getText(), 
                                tfCorreo.getText());
        return p;
    }
    
    private void modificarDatosPersona(){
        pc.modificar(capturarDatos());        
        agregarEmpleado();
    }
           
    private void agregarEmpleado(){
        Date fechadereg = new Date(new GregorianCalendar().get(Calendar.YEAR), 
                (new GregorianCalendar().get(Calendar.MONTH)),
                (new GregorianCalendar().get(Calendar.DAY_OF_MONTH)),
                new GregorianCalendar().get(Calendar.HOUR_OF_DAY),
                new GregorianCalendar().get(Calendar.MINUTE),
                new GregorianCalendar().get(Calendar.SECOND) );
        //-------------------------------------
        UsuarioControlador uc = new UsuarioControlador();
        PerfilControlador pfc = new PerfilControlador();
        EstadoControlador ec = new EstadoControlador();
        CargoControlador cargoC = new CargoControlador();
        //-------------------------------------
        Usuario u = new Usuario(tfNombres.getText(), tfCorreo.getText(), tfNombres.getText(), pfc.devolverPerfilPorNivelAcceso(nivelAcceso));// idperfil 3 = cliente 
        Empleado e = new Empleado(Helper.generarCodigo(1),fechadereg, persona, uc.crear(u), cargoC.devolverCargo(3),ec.devolverEstado(1)); // estado 1 actvado
        empc.crear(e);
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
    private javax.swing.JButton bModificarDatosEmpleado;
    private javax.swing.JButton bRemoverDatosEmpleado;
    private javax.swing.ButtonGroup bgPerfilesUsuarios;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbApellidoMaterno;
    private javax.swing.JLabel lbApellidoPaterno;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbCorreo;
    private javax.swing.JLabel lbDNI;
    private javax.swing.JLabel lbDescripcionAdministrador;
    private javax.swing.JLabel lbDescripcionOperador;
    private javax.swing.JLabel lbDireccion;
    private javax.swing.JLabel lbNombres;
    private javax.swing.JLabel lbPerfil;
    private javax.swing.JLabel lbPerfil1;
    private javax.swing.JLabel lbTelefono;
    private javax.swing.JPanel pFondo;
    private javax.swing.JPanel pPerfiles;
    private javax.swing.JRadioButton rbAdministrador;
    private javax.swing.JRadioButton rbOperador;
    private javax.swing.JTextField tfApellidoMaterno;
    private javax.swing.JTextField tfApellidoPaterno;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfCorreo;
    private javax.swing.JTextField tfDNI;
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
