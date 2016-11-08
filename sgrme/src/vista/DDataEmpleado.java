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

        bgPerfilesUsuarios = new javax.swing.ButtonGroup();
        pFondo = new javax.swing.JPanel();
        bCancelar = new javax.swing.JButton();
        bAceptar = new javax.swing.JButton();
        bModificarDataEmpleado = new javax.swing.JButton();
        bRemoverDataEmpleado = new javax.swing.JButton();
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
        rbCliente = new javax.swing.JRadioButton();
        lbDescripcionCliente = new javax.swing.JLabel();
        lbPerfil1 = new javax.swing.JLabel();

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
        tfCorreo.setEnabled(false);

        tfTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfTelefono.setEnabled(false);

        tfDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfDireccion.setEnabled(false);

        tfDNI.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfDNI.setEnabled(false);

        tfCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfCodigo.setEnabled(false);

        tfNombres.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfNombres.setEnabled(false);

        tfApellidoPaterno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfApellidoPaterno.setEnabled(false);

        tfApellidoMaterno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfApellidoMaterno.setEnabled(false);

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

        bgPerfilesUsuarios.add(rbCliente);
        rbCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbCliente.setText("Cliente");

        lbDescripcionCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDescripcionCliente.setText("Sólo puede acceder a ver el monitoreo de sus paquetes");

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
                            .addComponent(rbCliente)
                            .addGroup(pPerfilesLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(pPerfilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbDescripcionOperador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbDescripcionAdministrador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbDescripcionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbOperador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDescripcionOperador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDescripcionCliente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbPerfil1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbPerfil1.setText("Datos Personales");

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
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addComponent(pPerfiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))
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
                                    .addComponent(lbDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bRemoverDataEmpleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bModificarDataEmpleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator1))
                .addGap(22, 22, 22))
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lbPerfil1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pFondoLayout.setVerticalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbPerfil1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(bModificarDataEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bRemoverDataEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pFondoLayout.createSequentialGroup()
                                .addComponent(lbNombres)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pFondoLayout.createSequentialGroup()
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
                            .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pPerfiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
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
    private javax.swing.ButtonGroup bgPerfilesUsuarios;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbApellidoMaterno;
    private javax.swing.JLabel lbApellidoPaterno;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbCorreo;
    private javax.swing.JLabel lbDNI;
    private javax.swing.JLabel lbDescripcionAdministrador;
    private javax.swing.JLabel lbDescripcionCliente;
    private javax.swing.JLabel lbDescripcionOperador;
    private javax.swing.JLabel lbDireccion;
    private javax.swing.JLabel lbNombres;
    private javax.swing.JLabel lbPerfil;
    private javax.swing.JLabel lbPerfil1;
    private javax.swing.JLabel lbTelefono;
    private javax.swing.JPanel pFondo;
    private javax.swing.JPanel pPerfiles;
    private javax.swing.JRadioButton rbAdministrador;
    private javax.swing.JRadioButton rbCliente;
    private javax.swing.JRadioButton rbOperador;
    private javax.swing.JTextField tfApellidoMaterno;
    private javax.swing.JTextField tfApellidoPaterno;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfCorreo;
    private javax.swing.JTextField tfDNI;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfNombres;
    private javax.swing.JTextField tfTelefono;
    // End of variables declaration                    @Override//GEN-END:variables
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
