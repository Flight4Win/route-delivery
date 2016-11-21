/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import entidad.Aeropuerto;
import entidad.Lugar;
import utilitario.IntVentanas;
import utilitario.ImagenFondo;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import manejadorDB.controlador.AeropuertoControlador;
import manejadorDB.controlador.LugarControlador;

/**
 *
 * @author ferna
 */
public class DMantenimientoAeropuerto extends javax.swing.JDialog implements  IntVentanas{

    /**
     * Creates new form NewJDialog1
     * @param parent
     * @param modal
     */    
    /*---------------*/
    private final DefaultTableModel dtm ;
    private final TableColumnModel tcm;        
    /*--------------*/
    private final LugarControlador lc;
    private final AeropuertoControlador ac;
    /*--------------*/
    Lugar lugar;
    Aeropuerto aeropuerto;
    public DMantenimientoAeropuerto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        centrarPantalla();
        /*--------------*/
        dtm = (DefaultTableModel)tListaCiudad.getModel();        
        tcm = (TableColumnModel)tListaCiudad.getColumnModel();
        /*--------------*/
        lc = new LugarControlador();
        ac = new AeropuertoControlador();
        definirTabla();
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
        cpLstaCntienete = new javax.swing.JScrollPane();
        tListaCiudad = new javax.swing.JTable();
        bModificar = new javax.swing.JButton();
        bAnhadir = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        bAceptar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        pDataCiudad = new javax.swing.JPanel();
        lbNombreCiudad = new javax.swing.JLabel();
        tfCiudad = new javax.swing.JTextField();
        lbCapacidadAlmacen = new javax.swing.JLabel();
        tfCapacidadAlmacen = new javax.swing.JTextField();
        lbNombreContinente = new javax.swing.JLabel();
        tfContinente = new javax.swing.JTextField();
        lbNombrePais = new javax.swing.JLabel();
        tfPais = new javax.swing.JTextField();
        tfGMT = new javax.swing.JTextField();
        lbCapacidadAlmacen1 = new javax.swing.JLabel();
        bBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mantenimiento de Almacen");

        tListaCiudad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        cpLstaCntienete.setViewportView(tListaCiudad);

        bModificar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/edit.png"))); // NOI18N
        bModificar.setText("  Modificar");
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarActionPerformed(evt);
            }
        });

        bAnhadir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bAnhadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/anhadir.png"))); // NOI18N
        bAnhadir.setText("   Añadir");
        bAnhadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnhadirActionPerformed(evt);
            }
        });

        bEliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/borrar.png"))); // NOI18N
        bEliminar.setText("  Eliminar");
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });

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

        lbNombreCiudad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbNombreCiudad.setLabelFor(tfCiudad);
        lbNombreCiudad.setText("Nombre Ciudad");

        tfCiudad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCiudadActionPerformed(evt);
            }
        });
        tfCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCiudadKeyTyped(evt);
            }
        });

        lbCapacidadAlmacen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCapacidadAlmacen.setLabelFor(tfCapacidadAlmacen);
        lbCapacidadAlmacen.setText("Capacidad Almacén");

        tfCapacidadAlmacen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfCapacidadAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCapacidadAlmacenActionPerformed(evt);
            }
        });
        tfCapacidadAlmacen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCapacidadAlmacenKeyTyped(evt);
            }
        });

        lbNombreContinente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbNombreContinente.setLabelFor(tfCiudad);
        lbNombreContinente.setText("Nombre Continente");

        tfContinente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfContinente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContinenteActionPerformed(evt);
            }
        });
        tfContinente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfContinenteKeyTyped(evt);
            }
        });

        lbNombrePais.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbNombrePais.setLabelFor(tfPais);
        lbNombrePais.setText("Nombre País");

        tfPais.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPaisActionPerformed(evt);
            }
        });
        tfPais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfPaisKeyTyped(evt);
            }
        });

        tfGMT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfGMT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfGMTActionPerformed(evt);
            }
        });
        tfGMT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfGMTKeyTyped(evt);
            }
        });

        lbCapacidadAlmacen1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCapacidadAlmacen1.setLabelFor(tfCapacidadAlmacen);
        lbCapacidadAlmacen1.setText("GMT");

        javax.swing.GroupLayout pDataCiudadLayout = new javax.swing.GroupLayout(pDataCiudad);
        pDataCiudad.setLayout(pDataCiudadLayout);
        pDataCiudadLayout.setHorizontalGroup(
            pDataCiudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataCiudadLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pDataCiudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbCapacidadAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNombreContinente, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(lbNombreCiudad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pDataCiudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfContinente, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCapacidadAlmacen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(pDataCiudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDataCiudadLayout.createSequentialGroup()
                        .addComponent(lbNombrePais, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfPais, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDataCiudadLayout.createSequentialGroup()
                        .addComponent(lbCapacidadAlmacen1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfGMT, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pDataCiudadLayout.setVerticalGroup(
            pDataCiudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDataCiudadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDataCiudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombreContinente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfContinente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNombrePais, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pDataCiudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombreCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCapacidadAlmacen1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfGMT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pDataCiudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCapacidadAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCapacidadAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        bBuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/lupita21.png"))); // NOI18N
        bBuscar.setText("  Buscar");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pFondoLayout = new javax.swing.GroupLayout(pFondo);
        pFondo.setLayout(pFondoLayout);
        pFondoLayout.setHorizontalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2)
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cpLstaCntienete)
                            .addComponent(pDataCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(bModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(bAnhadir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171))
        );
        pFondoLayout.setVerticalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pDataCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAnhadir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cpLstaCntienete, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addComponent(bBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(bModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(bEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(pFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        JOptionPane.showMessageDialog(this,"Datos Registrados Correctamente",
            "FELICIDADES", JOptionPane.PLAIN_MESSAGE,
            ingresarImagen("/vista/imagen/check64.png"));
    }//GEN-LAST:event_bAceptarActionPerformed

    private void tfCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCiudadActionPerformed

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
//        String code = JOptionPane.showInputDialog(
//        this, 
//        "Ingrese", 
//        "Secret code needed (title)", 
//        ingresarImagen("/vista/imagen/warning.png")
//    );
//        String ciudadAbuscar = JOptionPane.showInputDialog(this,"Los datos de este cliente se eliminarán \n ¿Desea continuar?",
//                "ADVERTENCIA", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,                 
//                ingresarImagen("/vista/imagen/warning.png"));    
    }//GEN-LAST:event_bBuscarActionPerformed

    private void tfCapacidadAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCapacidadAlmacenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCapacidadAlmacenActionPerformed

    private void bAnhadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnhadirActionPerformed
        if(validarDatos()){
            if( lc.buscar(tfCiudad.getText(),1).get(0) != null){
                JOptionPane.showMessageDialog(this,"Esta Ciudad ya ha sido registrada", 
                "ERROR", JOptionPane.PLAIN_MESSAGE,
                ingresarImagen("/vista/imagen/error.png"));    
            }else{
                Lugar l = new Lugar(tfContinente.getText(), 
                        tfPais.getText(), 
                        tfCiudad.getText(),
                        Integer.parseInt(tfGMT.getText()));
                lc.crear(l);
                Aeropuerto a = new Aeropuerto(tfContinente.getText().substring(0,3).toUpperCase()+tfCiudad.getText().substring(0,3).toUpperCase(),
                        Integer.parseInt(tfCapacidadAlmacen.getText()),
                        l );
                ac.crear(a);
                
                Object[] fila = new Object[dtm.getColumnCount()];
                fila[0] = l.getIdlugar();
                fila[1] = a.getCapacidad();
                fila[2] = l.getContinente();
                fila[3] = l.getPais();
                fila[4] = l.getCiudad();
                fila[5] = l.getGmt();
                dtm.addRow(fila);
            }
            
            
        }
    }//GEN-LAST:event_bAnhadirActionPerformed

    private void tfCiudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCiudadKeyTyped
        char c=evt.getKeyChar(); 
         if(!Character.isLetter(c) ) { 
              getToolkit().beep();               
              evt.consume();                              
        } 
    }//GEN-LAST:event_tfCiudadKeyTyped

    private void tfCapacidadAlmacenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCapacidadAlmacenKeyTyped
        char c=evt.getKeyChar(); 
         if(!Character.isDigit(c) ) { 
              getToolkit().beep();               
              evt.consume();                              
        } 
    }//GEN-LAST:event_tfCapacidadAlmacenKeyTyped

    private void tfContinenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContinenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContinenteActionPerformed

    private void tfContinenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfContinenteKeyTyped
        char c=evt.getKeyChar(); 
         if(!Character.isLetter(c) ) { 
              getToolkit().beep();               
              evt.consume();                              
        } 
    }//GEN-LAST:event_tfContinenteKeyTyped

    private void tfPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPaisActionPerformed

    private void tfPaisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPaisKeyTyped
        char c=evt.getKeyChar(); 
         if(!Character.isLetter(c) ) { 
              getToolkit().beep();               
              evt.consume();                              
        } 
    }//GEN-LAST:event_tfPaisKeyTyped

    private void tfGMTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfGMTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfGMTActionPerformed

    private void tfGMTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfGMTKeyTyped
        char c=evt.getKeyChar(); 
         if(!Character.isDigit(c) ) { 
              getToolkit().beep();               
              evt.consume();                              
        } 
    }//GEN-LAST:event_tfGMTKeyTyped

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bModificarActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bEliminarActionPerformed

    private boolean validarDatos(){
        boolean validado = true;
        if(tfCapacidadAlmacen.getText().isEmpty()){
            validado = false;
            JOptionPane.showMessageDialog(this,"Falta Ingresar Apellido Materno", 
                "ERROR", JOptionPane.PLAIN_MESSAGE,
                ingresarImagen("/vista/imagen/error.png")); 
        }
        if(tfCiudad.getText().isEmpty()){
            validado = false;
            JOptionPane.showMessageDialog(this,"Falta Ingresar Apellido Paterno", 
                "ERROR", JOptionPane.PLAIN_MESSAGE,
                ingresarImagen("/vista/imagen/error.png")); 
        }
        return validado;                
    }
    
    private void definirTabla(){
            dtm.addColumn("Código");
            dtm.addColumn("Capacidad");
            dtm.addColumn("Continente");
            dtm.addColumn("Pais");
            dtm.addColumn("Ciudad");
            dtm.addColumn("GMT"); 
            
            tcm.getColumn(0).setPreferredWidth(50);
            tcm.getColumn(1).setPreferredWidth(100);
            tcm.getColumn(2).setPreferredWidth(100);
            tcm.getColumn(3).setPreferredWidth(100);
            tcm.getColumn(4).setPreferredWidth(100);
            tcm.getColumn(5).setPreferredWidth(50);               
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
//            java.util.logging.Logger.getLogger(DMantenimientoAeropuerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DMantenimientoAeropuerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DMantenimientoAeropuerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DMantenimientoAeropuerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DMantenimientoAeropuerto dialog = new DMantenimientoAeropuerto(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bAnhadir;
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bModificar;
    private javax.swing.JScrollPane cpLstaCntienete;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbCapacidadAlmacen;
    private javax.swing.JLabel lbCapacidadAlmacen1;
    private javax.swing.JLabel lbNombreCiudad;
    private javax.swing.JLabel lbNombreContinente;
    private javax.swing.JLabel lbNombrePais;
    private javax.swing.JPanel pDataCiudad;
    private javax.swing.JPanel pFondo;
    private javax.swing.JTable tListaCiudad;
    private javax.swing.JTextField tfCapacidadAlmacen;
    private javax.swing.JTextField tfCiudad;
    private javax.swing.JTextField tfContinente;
    private javax.swing.JTextField tfGMT;
    private javax.swing.JTextField tfPais;
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
    }}
