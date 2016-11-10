/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import utilitario.IntVentanas;
import utilitario.ImagenFondo;
import Temporizador.TemporizadorAplicacion;
import clases.Controlador;
import clases.Paquete;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author MFGuevaraL
 */

public class DRegistrarMasPaquetes extends javax.swing.JDialog implements IntVentanas {

    /**
     * Creates new form RegistrarMasPaquetes
     * @param modal
     */

    //Connection con;

    CallableStatement cst;   
    private DRegistrarUnPaquete parentRegistrarUnPaquete = null;
    public DRegistrarMasPaquetes(java.awt.Frame parent, boolean modal, DRegistrarUnPaquete parentRegistrarUnPaquete) {
        super(parent, modal);
        initComponents();
        centrarPantalla(); 
        //this.con = con;
        this.parentRegistrarUnPaquete = parentRegistrarUnPaquete;
       
    }

    public DRegistrarMasPaquetes(java.awt.Dialog parent, boolean modal) {
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

        pFondo = new javax.swing.JPanel();
        bCancelar = new javax.swing.JButton();
        bAceptar = new javax.swing.JButton();
        pDataDestinatario = new javax.swing.JPanel();
        lbNombres = new javax.swing.JLabel();
        tfApellidosDestinatario = new javax.swing.JTextField();
        lbApellidos = new javax.swing.JLabel();
        tfNombreDestinatario = new javax.swing.JTextField();
        lbCorreo = new javax.swing.JLabel();
        tfCorreoDestinatario = new javax.swing.JTextField();
        lbTelefono = new javax.swing.JLabel();
        tfTelefonoDestinatario = new javax.swing.JTextField();
        lbDominio = new javax.swing.JLabel();
        cdDominioDestinatario = new javax.swing.JComboBox();
        bModificarDestinatario = new javax.swing.JButton();
        pDataCliente = new javax.swing.JPanel();
        lbCliente = new javax.swing.JLabel();
        lbNombresApellidosCliente = new javax.swing.JLabel();
        tfNombresApellidosCliente = new javax.swing.JTextField();
        tfCodigoCliente = new javax.swing.JTextField();
        pDataPaquete = new javax.swing.JPanel();
        cbTipoPaquete = new javax.swing.JComboBox();
        cbDestino = new javax.swing.JComboBox();
        cbPartida = new javax.swing.JComboBox();
        lbTipoPaquete = new javax.swing.JLabel();
        lbDestino = new javax.swing.JLabel();
        lbDescripcion = new javax.swing.JLabel();
        lbPartida = new javax.swing.JLabel();
        lbImagenCliente = new javax.swing.JLabel();
        tfDescripcion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        bAnhadir = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Múltiples Paquetes");

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

        pDataDestinatario.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Paquete", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        lbNombres.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbNombres.setText("Nombres");

        tfApellidosDestinatario.setEditable(false);
        tfApellidosDestinatario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfApellidosDestinatario.setEnabled(false);

        lbApellidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbApellidos.setText("Apellidos");

        tfNombreDestinatario.setEditable(false);
        tfNombreDestinatario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfNombreDestinatario.setEnabled(false);

        lbCorreo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCorreo.setText("Correo");

        tfCorreoDestinatario.setEditable(false);
        tfCorreoDestinatario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfCorreoDestinatario.setEnabled(false);

        lbTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTelefono.setText("Teléfono");

        tfTelefonoDestinatario.setEditable(false);
        tfTelefonoDestinatario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfTelefonoDestinatario.setEnabled(false);

        lbDominio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDominio.setText("Dominio");

        cdDominioDestinatario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cdDominioDestinatario.setMaximumRowCount(5);
        cdDominioDestinatario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "@gmail.com", "@pucp.edu.pe", "@yahoo.es", "@outlook.com", "@hotmail.com" }));
        cdDominioDestinatario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cdDominioDestinatarioActionPerformed(evt);
            }
        });

        bModificarDestinatario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bModificarDestinatario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editaruser21.png"))); // NOI18N
        bModificarDestinatario.setBorder(null);
        bModificarDestinatario.setBorderPainted(false);
        bModificarDestinatario.setContentAreaFilled(false);
        bModificarDestinatario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bModificarDestinatario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bModificarDestinatario.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editaruser18.png"))); // NOI18N
        bModificarDestinatario.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editaruser24.png"))); // NOI18N
        bModificarDestinatario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarDestinatarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pDataDestinatarioLayout = new javax.swing.GroupLayout(pDataDestinatario);
        pDataDestinatario.setLayout(pDataDestinatarioLayout);
        pDataDestinatarioLayout.setHorizontalGroup(
            pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataDestinatarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDataDestinatarioLayout.createSequentialGroup()
                        .addGroup(pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pDataDestinatarioLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pDataDestinatarioLayout.createSequentialGroup()
                                        .addGroup(pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(lbApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lbTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(tfCorreoDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(33, 33, 33))
                                    .addComponent(tfTelefonoDestinatario, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)))
                            .addComponent(bModificarDestinatario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDataDestinatarioLayout.createSequentialGroup()
                        .addGroup(pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbNombres, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfApellidosDestinatario)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pDataDestinatarioLayout.createSequentialGroup()
                                .addComponent(lbCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbDominio, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cdDominioDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tfNombreDestinatario))
                        .addGap(19, 19, 19))))
        );
        pDataDestinatarioLayout.setVerticalGroup(
            pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataDestinatarioLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lbNombres)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNombreDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbApellidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfApellidosDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDominio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCorreoDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cdDominioDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfTelefonoDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bModificarDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pDataCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Paquete", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        lbCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCliente.setText("Código Cliente");

        lbNombresApellidosCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbNombresApellidosCliente.setText("Nombres y Apellidos");

        tfNombresApellidosCliente.setEditable(false);
        tfNombresApellidosCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfNombresApellidosCliente.setEnabled(false);

        tfCodigoCliente.setEditable(false);
        tfCodigoCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfCodigoCliente.setEnabled(false);

        javax.swing.GroupLayout pDataClienteLayout = new javax.swing.GroupLayout(pDataCliente);
        pDataCliente.setLayout(pDataClienteLayout);
        pDataClienteLayout.setHorizontalGroup(
            pDataClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataClienteLayout.createSequentialGroup()
                .addGroup(pDataClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pDataClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tfCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pDataClienteLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pDataClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNombresApellidosCliente)
                            .addComponent(lbCliente)
                            .addComponent(tfNombresApellidosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pDataClienteLayout.setVerticalGroup(
            pDataClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDataClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lbNombresApellidosCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNombresApellidosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pDataPaquete.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Paquete", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        cbTipoPaquete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbTipoPaquete.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Documentos", "Caja", "Caja Frágil" }));

        cbDestino.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbDestino.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbPartida.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbPartida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbTipoPaquete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTipoPaquete.setText("Tipo de Paquete");

        lbDestino.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDestino.setText("Destino");

        lbDescripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDescripcion.setText("Descripción");

        lbPartida.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbPartida.setText("Partida");

        lbImagenCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbImagenCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImagenCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/cajita.png"))); // NOI18N

        javax.swing.GroupLayout pDataPaqueteLayout = new javax.swing.GroupLayout(pDataPaquete);
        pDataPaquete.setLayout(pDataPaqueteLayout);
        pDataPaqueteLayout.setHorizontalGroup(
            pDataPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataPaqueteLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pDataPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pDataPaqueteLayout.createSequentialGroup()
                        .addGroup(pDataPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPartida))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pDataPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDestino)
                            .addComponent(cbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pDataPaqueteLayout.createSequentialGroup()
                        .addGroup(pDataPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDescripcion)
                            .addComponent(cbTipoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTipoPaquete))
                        .addGap(18, 18, 18)
                        .addComponent(lbImagenCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pDataPaqueteLayout.setVerticalGroup(
            pDataPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataPaqueteLayout.createSequentialGroup()
                .addGroup(pDataPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDataPaqueteLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lbDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDescripcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTipoPaquete)
                        .addGap(6, 6, 6)
                        .addComponent(cbTipoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPartida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDataPaqueteLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbImagenCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbDestino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        bAnhadir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bAnhadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/anhadir.png"))); // NOI18N
        bAnhadir.setText("   Añadir");

        bModificar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/edit.png"))); // NOI18N
        bModificar.setText("  Modificar");

        bEliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/borrar.png"))); // NOI18N
        bEliminar.setText("  Eliminar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bAnhadir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(bAnhadir, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addComponent(bModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout pFondoLayout = new javax.swing.GroupLayout(pFondo);
        pFondo.setLayout(pFondoLayout);
        pFondoLayout.setHorizontalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(276, 276, 276)
                .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pDataDestinatario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pDataCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addComponent(pDataPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(318, 318, 318))
        );
        pFondoLayout.setVerticalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFondoLayout.createSequentialGroup()
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pDataPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pFondoLayout.createSequentialGroup()
                                .addComponent(pDataCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pDataDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pFondoLayout.createSequentialGroup()
                                .addGap(233, 233, 233)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 882, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this,"Los datos ingresados no se guardarán \n ¿Desea continuar?",
            "ADVERTENCIA", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
            ingresarImagen("/vista/imagen/warning.png"));
        if(opcion==0){
            this.dispose();
            if(parentRegistrarUnPaquete != null){
                parentRegistrarUnPaquete.parentDataCliente.setVisible(true);
            }
        }

    }//GEN-LAST:event_bCancelarActionPerformed

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        /* FAlta recorrer la tabla exceptuando la primera fila ( la del primer pa   uete), por que ya se registro en la 
        interfaz anterior, y luego a c/u aplicarle las 6 sgtes lineas
        */
//        LocalDateTime fechaRegistro = TemporizadorAplicacion.getFecha();
//        Paquete p = new Paquete((Integer)cbPartida.getSelectedItem(),
//                (Integer)cbDestino.getSelectedItem(),fechaRegistro.getHour(),
//                asignarIDPaquete(),fechaRegistro);//el 0 es el que tienes que cambiar
//        Controlador.AgregarPaquete(p);
//        Controlador.EjecutarAlgoritmo(p);

        JOptionPane.showMessageDialog(this,"Todos los paquete fueron registrados correctamente",
            "FELICIDADES", JOptionPane.PLAIN_MESSAGE,
            ingresarImagen("/vista/imagen/check64.png"));
        this.dispose();
        if(parentRegistrarUnPaquete != null){
            parentRegistrarUnPaquete.parentDataCliente.setVisible(true);
        }
    }//GEN-LAST:event_bAceptarActionPerformed

    private void cdDominioDestinatarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cdDominioDestinatarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cdDominioDestinatarioActionPerformed

    private void bModificarDestinatarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarDestinatarioActionPerformed
        modificarDatos(true);
    }//GEN-LAST:event_bModificarDestinatarioActionPerformed

    
    private void modificarDatos(boolean activar){
        tfApellidosDestinatario.setEditable(activar);
        tfNombreDestinatario.setEditable(activar);        
        tfCorreoDestinatario.setEditable(activar);
        tfTelefonoDestinatario.setEditable(activar);
        
        tfApellidosDestinatario.setEnabled(activar);
        tfNombreDestinatario.setEnabled(activar);
        tfCorreoDestinatario.setEnabled(activar);
        tfTelefonoDestinatario.setEnabled(activar);
        
        cbTipoPaquete.setEditable(activar);
        cbTipoPaquete.setEnabled(activar);
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
//            java.util.logging.Logger.getLogger(DRegistrarMasPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DRegistrarMasPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DRegistrarMasPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DRegistrarMasPaquetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DRegistrarMasPaquetes dialog = new DRegistrarMasPaquetes(new javax.swing.JFrame(), true);
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

    private int asignarIDPaquete(){
        int id=0;
        /*try {
                cst = con.prepareCall("{?=call obtenerUltimoIdPaquete(?)}");                
                cst.registerOutParameter(1, java.sql.Types.INTEGER);                 
                cst.execute();
                id = cst.getInt(1);
            } catch (SQLException ex) {
                System.out.println("Error en registrar Un paquete, funcion asignar ID a Paquete:  "+ex.getMessage());
            }*/
        return id;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bAnhadir;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bModificar;
    private javax.swing.JButton bModificarDestinatario;
    private javax.swing.JComboBox cbDestino;
    private javax.swing.JComboBox cbPartida;
    private javax.swing.JComboBox cbTipoPaquete;
    private javax.swing.JComboBox cdDominioDestinatario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbApellidos;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lbCorreo;
    private javax.swing.JLabel lbDescripcion;
    private javax.swing.JLabel lbDestino;
    private javax.swing.JLabel lbDominio;
    private javax.swing.JLabel lbImagenCliente;
    private javax.swing.JLabel lbNombres;
    private javax.swing.JLabel lbNombresApellidosCliente;
    private javax.swing.JLabel lbPartida;
    private javax.swing.JLabel lbTelefono;
    private javax.swing.JLabel lbTipoPaquete;
    private javax.swing.JPanel pDataCliente;
    private javax.swing.JPanel pDataDestinatario;
    private javax.swing.JPanel pDataPaquete;
    private javax.swing.JPanel pFondo;
    private javax.swing.JTextField tfApellidosDestinatario;
    private javax.swing.JTextField tfCodigoCliente;
    private javax.swing.JTextField tfCorreoDestinatario;
    private javax.swing.JTextField tfDescripcion;
    private javax.swing.JTextField tfNombreDestinatario;
    private javax.swing.JTextField tfNombresApellidosCliente;
    private javax.swing.JTextField tfTelefonoDestinatario;
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
    }
}
