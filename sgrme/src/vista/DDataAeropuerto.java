/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.sun.glass.events.KeyEvent;
import entidad.Aeropuerto;
import entidad.Lugar;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import manejadorDB.controlador.AeropuertoControlador;
import manejadorDB.controlador.LugarControlador;
import utilitario.ImagenFondo;
import utilitario.IntVentanas;
import utilitario.Validaciones;

/**
 *
 * @author ferna
 */
public class DDataAeropuerto extends javax.swing.JDialog implements IntVentanas{

    /**
     * Creates new form DDataAeropuerto
     */
    
    private boolean datamodificada = false;
    
    private Aeropuerto aeropuerto;
    private Lugar lugar;
    
    private final AeropuertoControlador ac = new AeropuertoControlador();
    private final LugarControlador lc = new LugarControlador();
    
    public DDataAeropuerto(java.awt.Frame parent, boolean modal, Aeropuerto aeropuerto) {
        super(parent, modal);
        initComponents();
        
        this.aeropuerto=aeropuerto;
        this.lugar=lc.obtener_lugar(aeropuerto.getIdlugar().getIdlugar());
        centrarPantalla();
        llenarDatos();
        hablitarCampos(false);
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
        bModificar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        bAceptar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        tfCiudad = new javax.swing.JTextField();
        tfContinente = new javax.swing.JTextField();
        lbNombreCiudad = new javax.swing.JLabel();
        lbCapacidadAlmacen = new javax.swing.JLabel();
        lbNombreContinente = new javax.swing.JLabel();
        tfCapacidadAlmacen = new javax.swing.JTextField();
        lbCapacidadAlmacen1 = new javax.swing.JLabel();
        lbNombrePais = new javax.swing.JLabel();
        tfPais = new javax.swing.JTextField();
        tfGMT = new javax.swing.JTextField();
        lbCiudad = new javax.swing.JLabel();
        lbCapacidadAlmacen2 = new javax.swing.JLabel();
        tfLatitud = new javax.swing.JTextField();
        lbCapacidadAlmacen3 = new javax.swing.JLabel();
        tfLongitud = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bModificar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/edit.png"))); // NOI18N
        bModificar.setText("  Modificar");
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarActionPerformed(evt);
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

        lbNombreCiudad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbNombreCiudad.setText("Nombre Ciudad");

        lbCapacidadAlmacen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCapacidadAlmacen.setText("Capacidad Almacén");

        lbNombreContinente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbNombreContinente.setText("Nombre Continente");

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

        lbCapacidadAlmacen1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCapacidadAlmacen1.setText("GMT");

        lbNombrePais.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        lbCiudad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/aeropuerto.png"))); // NOI18N

        lbCapacidadAlmacen2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCapacidadAlmacen2.setText("Latitud");

        tfLatitud.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfLatitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLatitudActionPerformed(evt);
            }
        });
        tfLatitud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfLatitudKeyTyped(evt);
            }
        });

        lbCapacidadAlmacen3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCapacidadAlmacen3.setText("Longitud");

        tfLongitud.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfLongitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLongitudActionPerformed(evt);
            }
        });
        tfLongitud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfLongitudKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pFondoLayout = new javax.swing.GroupLayout(pFondo);
        pFondo.setLayout(pFondoLayout);
        pFondoLayout.setHorizontalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123)
                .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(192, 192, 192))
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addComponent(bModificar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pFondoLayout.createSequentialGroup()
                                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pFondoLayout.createSequentialGroup()
                                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbNombrePais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbNombreContinente, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfPais, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfContinente, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(pFondoLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(pFondoLayout.createSequentialGroup()
                                                .addComponent(lbCapacidadAlmacen3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tfLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(pFondoLayout.createSequentialGroup()
                                                    .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lbNombreCiudad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lbCapacidadAlmacen1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(tfGMT, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tfCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(pFondoLayout.createSequentialGroup()
                                                    .addComponent(lbCapacidadAlmacen2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(tfLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(pFondoLayout.createSequentialGroup()
                                        .addComponent(lbCapacidadAlmacen)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfCapacidadAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pFondoLayout.setVerticalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNombreContinente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfContinente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNombrePais, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNombreCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCapacidadAlmacen1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfGMT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCapacidadAlmacen2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCapacidadAlmacen3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCapacidadAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCapacidadAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed
        datamodificada = true;
        hablitarCampos(true);
    }//GEN-LAST:event_bModificarActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        if (datamodificada) {
//            if(Validaciones.validateLatLong(tfLatitud.getText()) && 
//               Validaciones.validateLatLong(tfLongitud.getText())){
//               
//            }else{
//                JOptionPane.showMessageDialog(this,"Latitud o Longitud no siguen el formato siguiente \n *) +19.99\n *) -14.39", 
//                "ADVERTENCIA", JOptionPane.PLAIN_MESSAGE,
//                ingresarImagen("/vista/imagen/warning.png")); 
//            }
        }
    }//GEN-LAST:event_bAceptarActionPerformed

    private void tfCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCiudadActionPerformed

    private void tfCiudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCiudadKeyTyped
        char c=evt.getKeyChar(); 
        if(!(Character.isLetter(c)||(c==KeyEvent.VK_BACKSPACE)||(c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_SPACE)) ) { 
              getToolkit().beep();               
              evt.consume();                              
        } 
    }//GEN-LAST:event_tfCiudadKeyTyped

    private void tfContinenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContinenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContinenteActionPerformed

    private void tfContinenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfContinenteKeyTyped
        char c=evt.getKeyChar(); 
        if(!(Character.isLetter(c)||(c==KeyEvent.VK_BACKSPACE)||(c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_SPACE)) ) { 
              getToolkit().beep();               
              evt.consume();                              
        } 
    }//GEN-LAST:event_tfContinenteKeyTyped

    private void tfCapacidadAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCapacidadAlmacenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCapacidadAlmacenActionPerformed

    private void tfCapacidadAlmacenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCapacidadAlmacenKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c)||(c==KeyEvent.VK_BACKSPACE)||(c==KeyEvent.VK_DELETE)) ) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tfCapacidadAlmacenKeyTyped

    private void tfPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPaisActionPerformed

    private void tfPaisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPaisKeyTyped
        char c=evt.getKeyChar(); 
         if(!(Character.isLetter(c)||(c==KeyEvent.VK_BACKSPACE)||(c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_SPACE))  ) { 
              getToolkit().beep();               
              evt.consume();                              
        } 
    }//GEN-LAST:event_tfPaisKeyTyped

    private void tfGMTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfGMTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfGMTActionPerformed

    private void tfGMTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfGMTKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c)||(c==KeyEvent.VK_BACKSPACE)||(c==KeyEvent.VK_DELETE)) ) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tfGMTKeyTyped

    private void tfLatitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLatitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLatitudActionPerformed

    private void tfLatitudKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLatitudKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c)|| c=='+'|| c=='-'|| c=='.' ||(c==KeyEvent.VK_BACKSPACE)||(c==KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tfLatitudKeyTyped

    private void tfLongitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLongitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLongitudActionPerformed

    private void tfLongitudKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLongitudKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c)|| c=='+'|| c=='-'|| c=='.' ||(c==KeyEvent.VK_BACKSPACE)||(c==KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tfLongitudKeyTyped

    
    private void llenarDatos(){
        tfContinente.setText(lugar.getContinente());
        tfPais.setText(lugar.getPais());
        tfCiudad.setText(lugar.getCiudad());
        tfGMT.setText(String.valueOf(lugar.getGmt()));
        tfLatitud.setText(String.valueOf(aeropuerto.getLatitud()));
        tfLongitud.setText(String.valueOf(aeropuerto.getLongitud()));
        tfCapacidadAlmacen.setText(String.valueOf(aeropuerto.getCapacidad()));
        
    }
    
    private void hablitarCampos(boolean activar){
        tfContinente.setEditable(activar);
        tfPais.setEditable(activar);
        tfCiudad.setEditable(activar);
        tfGMT.setEditable(activar);
        tfLatitud.setEditable(activar);
        tfLongitud.setEditable(activar);
        tfCapacidadAlmacen.setEditable(activar);
    }
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
//            java.util.logging.Logger.getLogger(DDataAeropuerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DDataAeropuerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DDataAeropuerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DDataAeropuerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DDataAeropuerto dialog = new DDataAeropuerto(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bModificar;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbCapacidadAlmacen;
    private javax.swing.JLabel lbCapacidadAlmacen1;
    private javax.swing.JLabel lbCapacidadAlmacen2;
    private javax.swing.JLabel lbCapacidadAlmacen3;
    private javax.swing.JLabel lbCiudad;
    private javax.swing.JLabel lbNombreCiudad;
    private javax.swing.JLabel lbNombreContinente;
    private javax.swing.JLabel lbNombrePais;
    private javax.swing.JPanel pFondo;
    private javax.swing.JTextField tfCapacidadAlmacen;
    private javax.swing.JTextField tfCiudad;
    private javax.swing.JTextField tfContinente;
    private javax.swing.JTextField tfGMT;
    private javax.swing.JTextField tfLatitud;
    private javax.swing.JTextField tfLongitud;
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
    public void ponerImagenPanel(String direccion,javax.swing.JPanel pFondo) {
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
