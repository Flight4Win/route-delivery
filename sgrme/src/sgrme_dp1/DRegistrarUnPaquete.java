/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgrme_dp1;

import clases.Controlador;
import clases.Paquete;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import Temporizador.TemporizadorAplicacion;

/**
 *
 * @author ferna
 */
public class DRegistrarUnPaquete extends javax.swing.JDialog implements IntVentanas{

    /**
     * Creates new form dRegistrarPaquete
     */
//    DRegistrarClienteEmpleado parentRegistrarCliente = null;
    @SuppressWarnings({"SillyAssignment", "UnusedAssignment"})
//    public DRegistrarUnPaquete(java.awt.Frame parent, boolean modal, DRegistrarClienteEmpleado parentRegistrarCliente) {
//        super(parent, modal);
//        this.parentRegistrarCliente = parentRegistrarCliente;
//        initComponents();
//        centrarPantalla();        
//    }
    DDataCliente parentDataCliente = null;
    public DRegistrarUnPaquete(java.awt.Frame parent, boolean modal, DDataCliente dDataCliente) {
        super(parent, modal);
        this.parentDataCliente = dDataCliente;
        initComponents();
        centrarPantalla();        
    }
    
    public DRegistrarUnPaquete(java.awt.Frame parent, boolean modal) {
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
        bCancelar = new javax.swing.JButton();
        bAceptar = new javax.swing.JButton();
        pDataDestinatario = new javax.swing.JPanel();
        lbNombres = new javax.swing.JLabel();
        tfNombreDestinatario = new javax.swing.JTextField();
        tfApellidosDestinatario = new javax.swing.JTextField();
        lbApellidos = new javax.swing.JLabel();
        lbCorreo = new javax.swing.JLabel();
        tfCorreoDestinatario = new javax.swing.JTextField();
        lbTelefono = new javax.swing.JLabel();
        tfTelefonoDestinatario = new javax.swing.JTextField();
        cdDominioDestinatario = new javax.swing.JComboBox();
        lbDominio = new javax.swing.JLabel();
        bBuscarDestinatario = new javax.swing.JButton();
        pDataCliente = new javax.swing.JPanel();
        tfCodigoCliente = new javax.swing.JTextField();
        lbCliente = new javax.swing.JLabel();
        lbNombresApellidosCliente = new javax.swing.JLabel();
        tfNombresApellidosCliente = new javax.swing.JTextField();
        bBuscarCliente = new javax.swing.JButton();
        pDataPaquete = new javax.swing.JPanel();
        lbTipoPaquete = new javax.swing.JLabel();
        cbTipoPaquete = new javax.swing.JComboBox();
        cbDestino = new javax.swing.JComboBox();
        lbDestino = new javax.swing.JLabel();
        lbDescripcion = new javax.swing.JLabel();
        tfDescripcion = new javax.swing.JTextField();
        lbImagenCliente = new javax.swing.JLabel();
        lbPartida = new javax.swing.JLabel();
        cbPartida = new javax.swing.JComboBox();
        bAnadirPaquete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Paquete");
        setResizable(false);

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

        pDataDestinatario.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Destinatario"));

        lbNombres.setLabelFor(tfNombreDestinatario);
        lbNombres.setText("Nombres *");

        lbApellidos.setLabelFor(tfApellidosDestinatario);
        lbApellidos.setText("Apellidos *");

        lbCorreo.setLabelFor(tfCorreoDestinatario);
        lbCorreo.setText("Correo *");

        lbTelefono.setLabelFor(tfTelefonoDestinatario);
        lbTelefono.setText("Teléfono *");

        cdDominioDestinatario.setMaximumRowCount(5);
        cdDominioDestinatario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "@gmail.com", "@pucp.edu.pe", "@yahoo.es", "@outlook.com", "@hotmail.com" }));
        cdDominioDestinatario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cdDominioDestinatarioActionPerformed(evt);
            }
        });

        lbDominio.setLabelFor(cdDominioDestinatario);
        lbDominio.setText("Dominio *");

        bBuscarDestinatario.setText("Buscar");
        bBuscarDestinatario.setToolTipText("");
        bBuscarDestinatario.setActionCommand("");
        bBuscarDestinatario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarDestinatarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pDataDestinatarioLayout = new javax.swing.GroupLayout(pDataDestinatario);
        pDataDestinatario.setLayout(pDataDestinatarioLayout);
        pDataDestinatarioLayout.setHorizontalGroup(
            pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataDestinatarioLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDataDestinatarioLayout.createSequentialGroup()
                        .addGroup(pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTelefonoDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDataDestinatarioLayout.createSequentialGroup()
                        .addGroup(pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNombreDestinatario)
                            .addComponent(lbNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(tfCorreoDestinatario)
                            .addComponent(lbCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cdDominioDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfApellidosDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbDominio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDataDestinatarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bBuscarDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pDataDestinatarioLayout.setVerticalGroup(
            pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataDestinatarioLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDataDestinatarioLayout.createSequentialGroup()
                        .addComponent(lbApellidos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfApellidosDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pDataDestinatarioLayout.createSequentialGroup()
                        .addComponent(lbNombres)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNombreDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pDataDestinatarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pDataDestinatarioLayout.createSequentialGroup()
                        .addComponent(lbCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(tfCorreoDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pDataDestinatarioLayout.createSequentialGroup()
                        .addComponent(lbDominio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cdDominioDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTelefono)
                .addGap(6, 6, 6)
                .addComponent(tfTelefonoDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bBuscarDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pDataCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cliente"));

        tfCodigoCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCodigoClienteFocusLost(evt);
            }
        });

        lbCliente.setText("Código Cliente");

        lbNombresApellidosCliente.setText("Nombres y Apellidos");

        bBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupita21.png"))); // NOI18N
        bBuscarCliente.setBorder(null);
        bBuscarCliente.setBorderPainted(false);
        bBuscarCliente.setContentAreaFilled(false);
        bBuscarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bBuscarCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bBuscarCliente.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupita18.png"))); // NOI18N
        bBuscarCliente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupita24.png"))); // NOI18N
        bBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pDataClienteLayout = new javax.swing.GroupLayout(pDataCliente);
        pDataCliente.setLayout(pDataClienteLayout);
        pDataClienteLayout.setHorizontalGroup(
            pDataClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataClienteLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pDataClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCliente)
                    .addComponent(tfCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pDataClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNombresApellidosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNombresApellidosCliente))
                .addGap(20, 20, 20))
        );
        pDataClienteLayout.setVerticalGroup(
            pDataClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDataClienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pDataClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pDataClienteLayout.createSequentialGroup()
                        .addGroup(pDataClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCliente)
                            .addComponent(lbNombresApellidosCliente))
                        .addGroup(pDataClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pDataClienteLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNombresApellidosCliente))
                            .addGroup(pDataClienteLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(tfCodigoCliente)))))
                .addContainerGap())
        );

        pDataPaquete.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Paquete"));

        lbTipoPaquete.setLabelFor(cbTipoPaquete);
        lbTipoPaquete.setText("Tipo de Paquete");

        cbTipoPaquete.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Documentos", "Caja", "Caja Frágil" }));

        cbDestino.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbDestino.setLabelFor(cbDestino);
        lbDestino.setText("Destino");

        lbDescripcion.setLabelFor(tfDescripcion);
        lbDescripcion.setText("Descripción");

        lbImagenCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImagenCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cajita.png"))); // NOI18N

        lbPartida.setLabelFor(cbDestino);
        lbPartida.setText("Partida");

        cbPartida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                            .addComponent(cbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDestino)))
                    .addGroup(pDataPaqueteLayout.createSequentialGroup()
                        .addGroup(pDataPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDescripcion)
                            .addComponent(cbTipoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTipoPaquete))
                        .addGap(18, 18, 18)
                        .addComponent(lbImagenCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pDataPaqueteLayout.setVerticalGroup(
            pDataPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataPaqueteLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lbDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pDataPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDataPaqueteLayout.createSequentialGroup()
                        .addComponent(tfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbTipoPaquete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbTipoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(lbPartida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pDataPaqueteLayout.createSequentialGroup()
                        .addComponent(lbImagenCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbDestino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        bAnadirPaquete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boxp.png"))); // NOI18N
        bAnadirPaquete.setText("Más Paquetes");
        bAnadirPaquete.setToolTipText("");
        bAnadirPaquete.setActionCommand("");
        bAnadirPaquete.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        bAnadirPaquete.setIconTextGap(2);
        bAnadirPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnadirPaqueteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pFondoLayout = new javax.swing.GroupLayout(pFondo);
        pFondo.setLayout(pFondoLayout);
        pFondoLayout.setHorizontalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pDataCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pDataPaquete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(pDataDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFondoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bAnadirPaquete)
                        .addGap(34, 34, 34))))
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196))
        );
        pFondoLayout.setVerticalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addComponent(pDataCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pDataPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addComponent(pDataDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bAnadirPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this,"Los datos ingresados no se guardarán \n ¿Desea continuar?",
                "ADVERTENCIA", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,                 
                ingresarImagen("/imagenes/warning.png"));    
        if(opcion==0){
            this.dispose();
            if(parentDataCliente != null){
                parentDataCliente.setVisible(true);
            } 
        }
           
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        JOptionPane.showMessageDialog(this,"Paquete Registrado Correctamente", 
                "FELICIDADES", JOptionPane.PLAIN_MESSAGE,
                ingresarImagen("/imagenes/check64.png"));
        this.dispose();
        /*
            Tienes que sacar el ultimo id de la bd y ponerlo
            en el penultimo parametro
        */
        LocalDateTime fechaRegistro = TemporizadorAplicacion.getFecha();
        Paquete p = new Paquete((Integer)cbPartida.getSelectedItem(),
                (Integer)cbDestino.getSelectedItem(),fechaRegistro.getHour(),
                0,fechaRegistro);//el 0 es el que tienes que cambiar
        Controlador.AgregarPaquete(p);
        Controlador.EjecutarAlgoritmo(p);
        
        if(parentDataCliente != null){
            parentDataCliente.setVisible(true);
        } 
    }//GEN-LAST:event_bAceptarActionPerformed

    private void tfCodigoClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodigoClienteFocusLost
        boolean existe=false;
        if(!existe){
//            JOptionPane.showMessageDialog(this,"Código Inválido, Usuario no Existe", 
//                "ERROR", JOptionPane.PLAIN_MESSAGE,
//                ingresarImagen("/imagenes/error.png"));
        }       
//        tfCodigoCliente.requestFocus();
    }//GEN-LAST:event_tfCodigoClienteFocusLost

    private void cdDominioDestinatarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cdDominioDestinatarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cdDominioDestinatarioActionPerformed

    private void bBuscarDestinatarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarDestinatarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bBuscarDestinatarioActionPerformed

    private void bAnadirPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnadirPaqueteActionPerformed
        this.dispose();
        DRegistrarMasPaquetes dRegistrarMasPaquetes;
        if (parentDataCliente != null){
            dRegistrarMasPaquetes = new DRegistrarMasPaquetes(null, rootPaneCheckingEnabled,this);            
        }else{
            dRegistrarMasPaquetes = new DRegistrarMasPaquetes(null, rootPaneCheckingEnabled);         
        }
        dRegistrarMasPaquetes.setVisible(true);
    }//GEN-LAST:event_bAnadirPaqueteActionPerformed

    private void bBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bBuscarClienteActionPerformed

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
//            java.util.logging.Logger.getLogger(DRegistrarPaquete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DRegistrarPaquete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DRegistrarPaquete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DRegistrarPaquete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DRegistrarPaquete dialog = new DRegistrarPaquete(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bAnadirPaquete;
    private javax.swing.JButton bBuscarCliente;
    private javax.swing.JButton bBuscarDestinatario;
    private javax.swing.JButton bCancelar;
    private javax.swing.JComboBox cbDestino;
    private javax.swing.JComboBox cbPartida;
    private javax.swing.JComboBox cbTipoPaquete;
    private javax.swing.JComboBox cdDominioDestinatario;
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
