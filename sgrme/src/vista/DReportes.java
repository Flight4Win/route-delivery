/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import entidad.Cliente;
import entidad.Paquete;
import entidad.Persona;
import utilitario.IntVentanas;
import utilitario.ImagenFondo;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import manejadorDB.controlador.ClienteControlador;
import manejadorDB.controlador.PaqueteControlador;

/**
 *
 * @author MFGuevaraL
 */
public final class DReportes extends javax.swing.JDialog implements IntVentanas{

    /**
     * Creates new form DParametrosReporte
     */
    
    private ClienteControlador cc;
    private PaqueteControlador pqtc;
    /*---------------*/
    private List<Paquete> reportePaquetes;
    /*---------------*/
    private Calendar c2;    
    /*---------------*/
    private final DefaultTableModel dtm ;
    private final TableColumnModel tcm;        
    /*--------------*/
    
    public DReportes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        centrarPantalla();
        /*---------------*/
        cc = new ClienteControlador();
        pqtc = new PaqueteControlador();
        /*---------------*/
        dtm = (DefaultTableModel)tReportes.getModel();        
        tcm = (TableColumnModel)tReportes.getColumnModel();
        
        c2 = new GregorianCalendar();
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

        bgReportePaquetes = new javax.swing.ButtonGroup();
        pFondo = new javax.swing.JPanel();
        bAceptar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tReportes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        tfDocumentoCliente = new javax.swing.JTextField();
        dccFechaInicio = new com.toedter.calendar.JDateChooser();
        lbFechaFin = new javax.swing.JLabel();
        dccFechaFin = new com.toedter.calendar.JDateChooser();
        bGenerarReporte = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        rbDocumentoCLiente = new javax.swing.JRadioButton();
        rbFechas = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reportes por Cliente");
        setResizable(false);

        bAceptar.setMnemonic('A');
        bAceptar.setText("Aceptar");
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        tReportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tReportes);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tfDocumentoCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        dccFechaInicio.setDateFormatString("dd/MM/yyyy");
        dccFechaInicio.setMaxSelectableDate(new java.util.Date(253370786511000L));
        dccFechaInicio.setMinimumSize(new java.awt.Dimension(20, 20));

        lbFechaFin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbFechaFin.setText("Fecha Fin");
        lbFechaFin.setToolTipText("");

        dccFechaFin.setDateFormatString("dd/MM/yyyy");
        dccFechaFin.setMaxSelectableDate(new java.util.Date(253370786511000L));
        dccFechaFin.setMinimumSize(new java.awt.Dimension(20, 20));

        bGenerarReporte.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/reporte.png"))); // NOI18N
        bGenerarReporte.setText(" Generar Reporte ");
        bGenerarReporte.setActionCommand(" Generar Reporte");
        bGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGenerarReporteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Paquetes");

        bgReportePaquetes.add(rbDocumentoCLiente);
        rbDocumentoCLiente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbDocumentoCLiente.setSelected(true);
        rbDocumentoCLiente.setText("  Documento Cliente");

        bgReportePaquetes.add(rbFechas);
        rbFechas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbFechas.setText("  Fecha Inicio");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dccFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dccFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbFechas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbDocumentoCLiente)
                                .addGap(0, 17, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDocumentoCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbFechaFin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator1))
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(0, 275, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(bGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbDocumentoCLiente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFechaFin)
                    .addComponent(rbFechas, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dccFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dccFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pFondoLayout = new javax.swing.GroupLayout(pFondo);
        pFondo.setLayout(pFondoLayout);
        pFondoLayout.setHorizontalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        pFondoLayout.setVerticalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bAceptarActionPerformed

    private void bGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGenerarReporteActionPerformed
        limpiarTabla();
        if(rbDocumentoCLiente.isSelected()){
            if(!cc.buscar(1, tfDocumentoCliente.getText()).isEmpty()){
                 Cliente c = cc.buscar(1, tfDocumentoCliente.getText()).get(0);
                System.out.println("cliente:  "+c.getIdcliente()+"   -   "+c.getIdpersona().getNombres());
                reportePaquetes = pqtc.buscarPorCliente(c.getIdcliente());
                llenarTabla(reportePaquetes);
            }
           
        }else if(rbFechas.isSelected()){
            if(dccFechaInicio.getDate() != null){
                Date fechaInicio = new Date(dccFechaInicio.getCalendar().get(Calendar.YEAR), 
                    (dccFechaInicio.getCalendar().get(Calendar.MONTH)),
                    (dccFechaInicio.getCalendar().get(Calendar.DAY_OF_MONTH)),
                    c2.get(Calendar.HOUR_OF_DAY),
                    c2.get(Calendar.MINUTE),
                    c2.get(Calendar.SECOND) );
                if (dccFechaFin.getDate() == null) {
                    reportePaquetes = pqtc.buscarPorFechaRegistro(fechaInicio);
                    llenarTabla(reportePaquetes);
                }else{
                    Date fechaFin = new Date(dccFechaInicio.getCalendar().get(Calendar.YEAR), 
                    (dccFechaInicio.getCalendar().get(Calendar.MONTH)),
                    (dccFechaInicio.getCalendar().get(Calendar.DAY_OF_MONTH)),
                    c2.get(Calendar.HOUR_OF_DAY),
                    c2.get(Calendar.MINUTE),
                    c2.get(Calendar.SECOND) );
                    reportePaquetes = pqtc.buscarPorFechasRegistro(fechaInicio, fechaFin);               
                    llenarTabla(reportePaquetes);
                }
            }else{                
            }            
        }
        
        
    }//GEN-LAST:event_bGenerarReporteActionPerformed

    private void limpiarTabla(){
        if(reportePaquetes != null){
            reportePaquetes.clear();        
        }    
        for (int i = 0; i < dtm.getRowCount(); i++) {
            dtm.removeRow(i);
            i-=1;
        }        
    }
    
    private void definirTabla(){
            dtm.addColumn("Código");
            dtm.addColumn("Descripción");
            dtm.addColumn("Cliente");
            dtm.addColumn("Destino");
            dtm.addColumn("Estado");
            
            tcm.getColumn(0).setPreferredWidth(50);
            tcm.getColumn(1).setPreferredWidth(100);
            tcm.getColumn(2).setPreferredWidth(100);
            tcm.getColumn(3).setPreferredWidth(100);
            tcm.getColumn(4).setPreferredWidth(100);         
        
    }
    
    private void llenarTabla(java.util.List<Paquete> reporte){
        //llenar tabla Emleados
        reporte.stream().map((p) -> {
            Object[] fila = new Object[dtm.getColumnCount()];
            Cliente emisor = cc.buscarPorId(p.getIdcliente().getIdcliente()).get(0);     
            fila[0] = p.getCodigounico();
            fila[1] = p.getDescripcion();
            fila[2] = emisor.getIdpersona().getNombres()+" "+emisor.getIdpersona().getApellidopat()+" "+emisor.getIdpersona().getApellidomat();
            fila[4] = p.getIddestino().getIdlugar().getCiudad();
            fila[5] = p.getIdestado().getNombre();
            return fila;
        }).forEach((fila) -> {
            dtm.addRow(fila);
        });                     
        reportePaquetes = reporte;
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
//            java.util.logging.Logger.getLogger(DReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
//                DReportes dialog = new DReportes(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bGenerarReporte;
    private javax.swing.ButtonGroup bgReportePaquetes;
    private com.toedter.calendar.JDateChooser dccFechaFin;
    private com.toedter.calendar.JDateChooser dccFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbFechaFin;
    private javax.swing.JPanel pFondo;
    private javax.swing.JRadioButton rbDocumentoCLiente;
    private javax.swing.JRadioButton rbFechas;
    private javax.swing.JTable tReportes;
    private javax.swing.JTextField tfDocumentoCliente;
    // End of variables declaration//GEN-END:variables

    @Override
    public Icon ingresarImagen(String direccion){
        Icon i = new ImageIcon(getClass().getResource(direccion));
        return i;
    }

    @Override
    public void centrarPantalla() {
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
    }
}