/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import entidad.Cliente;
import entidad.Empleado;
import utilitario.IntVentanas;
import utilitario.ImagenFondo;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import manejadorDB.controlador.ClienteControlador;
import manejadorDB.controlador.EmpleadoControlador;

/**
 *
 * @author ferna
 */
public class DBuscarClienteEmpleado extends javax.swing.JDialog implements IntVentanas{

    /**
     * Creates new form DBuscarCliente
     */
    private final boolean buscarCliente;
    
    private Empleado empleado;
    private Cliente cliente;
    private Calendar c2;
    private java.util.List<Empleado> reporteEmpleado = null;
    private java.util.List<Cliente> reporteCliente = null;
    /*---------------*/
    private final ClienteControlador cc = new ClienteControlador();
    private final EmpleadoControlador empc = new EmpleadoControlador();    
    /*---------------*/
    private final DefaultTableModel dtm ;
    private final TableColumnModel tcm;        
    /*--------------*/
    public DRegistrarUnPaquete parentDRegistrarUnPaquete = null;
    
    public DBuscarClienteEmpleado(java.awt.Frame parent, boolean modal, boolean buscarCliente) {
        super(parent, modal);
        initComponents();
        centrarPantalla(); 
        dtm = (DefaultTableModel)tClientesEmpleados.getModel();        
        tcm = (TableColumnModel)tClientesEmpleados.getColumnModel();
        c2 = new GregorianCalendar();
        /*---------------*/ 
        this.buscarCliente=buscarCliente;
        definirTabla();
        if(!buscarCliente){
            System.out.println("Ventana de Bsucar Empleado");
            rbFechaRegistro.setVisible(false);
            dccFechaRegistro.setVisible(false);
            setTitle("Busqueda de  Empleado");
        }else{
            System.out.println("Ventana de Bsucar Cliente");            
            dccFechaRegistro.setCalendar(c2);
        }        
    }

    public DBuscarClienteEmpleado(java.awt.Frame parent, boolean modal, DRegistrarUnPaquete parentDRegistrarUnPaquete) {
        super(parent, modal);
        initComponents();
        centrarPantalla(); 
        dtm = (DefaultTableModel)tClientesEmpleados.getModel();        
        tcm = (TableColumnModel)tClientesEmpleados.getColumnModel();
        c2 = new GregorianCalendar();
        /*---------------*/ 
        buscarCliente= true;
        this.parentDRegistrarUnPaquete = parentDRegistrarUnPaquete;
        /*---------------*/ 
        definirTabla();
        if(buscarCliente){
            System.out.println("Ventana de Buscar Cliente");     
            dccFechaRegistro.setCalendar(c2);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgFiltros = new javax.swing.ButtonGroup();
        pFondo = new javax.swing.JPanel();
        bCancelar = new javax.swing.JButton();
        bAceptar = new javax.swing.JButton();
        bBuscarCiente = new javax.swing.JButton();
        scTablaClientes = new javax.swing.JScrollPane();
        tClientesEmpleados = new javax.swing.JTable();
        rbDNI = new javax.swing.JRadioButton();
        rbFechaRegistro = new javax.swing.JRadioButton();
        rbApellidos = new javax.swing.JRadioButton();
        rbCodigo = new javax.swing.JRadioButton();
        lbIcono = new javax.swing.JLabel();
        tfDocumento = new javax.swing.JTextField();
        tfApellidos = new javax.swing.JTextField();
        tfCodigo = new javax.swing.JTextField();
        dccFechaRegistro = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busqueda de Cliente");
        setResizable(false);

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

        bBuscarCiente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bBuscarCiente.setMnemonic('B');
        bBuscarCiente.setText("Buscar");
        bBuscarCiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarCienteActionPerformed(evt);
            }
        });

        tClientesEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scTablaClientes.setViewportView(tClientesEmpleados);

        bgFiltros.add(rbDNI);
        rbDNI.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbDNI.setSelected(true);
        rbDNI.setText("   DNI");

        bgFiltros.add(rbFechaRegistro);
        rbFechaRegistro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbFechaRegistro.setText("   Fecha de Registro");

        bgFiltros.add(rbApellidos);
        rbApellidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbApellidos.setText("   Apellidos");

        bgFiltros.add(rbCodigo);
        rbCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbCodigo.setText("   Código");

        lbIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/buscarUser122.png"))); // NOI18N

        tfDocumento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfDocumento.setText("11111111");
        tfDocumento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfDocumentoMouseClicked(evt);
            }
        });

        tfApellidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfApellidos.setText("Ferraro");
        tfApellidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfApellidosMouseClicked(evt);
            }
        });

        tfCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfCodigo.setText("ADADAD111");
        tfCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfCodigoMouseClicked(evt);
            }
        });

        dccFechaRegistro.setToolTipText("");
        dccFechaRegistro.setDateFormatString("dd/MM/yyyy");
        dccFechaRegistro.setMinSelectableDate(new java.util.Date(1041400911000L));
        dccFechaRegistro.setMinimumSize(new java.awt.Dimension(20, 20));
        dccFechaRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dccFechaRegistroMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pFondoLayout = new javax.swing.GroupLayout(pFondo);
        pFondo.setLayout(pFondoLayout);
        pFondoLayout.setHorizontalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scTablaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFondoLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(rbDNI, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbFechaRegistro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dccFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bBuscarCiente, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbIcono))
                        .addGap(95, 95, 95)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190))
        );
        pFondoLayout.setVerticalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lbIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFondoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(dccFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pFondoLayout.createSequentialGroup()
                                    .addComponent(rbDNI)
                                    .addGap(11, 11, 11)
                                    .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rbApellidos)
                                        .addComponent(tfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(11, 11, 11)
                                    .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rbCodigo)
                                        .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(11, 11, 11)
                                    .addComponent(rbFechaRegistro))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bBuscarCiente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scTablaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
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
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bBuscarCienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarCienteActionPerformed
        limpiarTabla();
        if(!buscarCliente){
            //buscar empleados
            if(rbDNI.isSelected()){
                buscarEmpleadoPorDocumento();
            }else if (rbApellidos.isSelected()){
                buscarEmpleadoPorApellidos();
            }else if(rbCodigo.isSelected()){
                buscarEmpleadoPorCodigo();
            }            
        }else{
            //buscar clientes
           if(rbDNI.isSelected()){
                buscarClientePorDocumento();
            }else if (rbApellidos.isSelected()){
                buscarClientePorApellidos();
            }else if(rbCodigo.isSelected()){
                buscarClientePorCodigo();
            }else if(rbFechaRegistro.isSelected()){
                buscarClientePorFechaRegistro();
            } 
        }
    }//GEN-LAST:event_bBuscarCienteActionPerformed

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        int seleccion;
        try{
            seleccion= tClientesEmpleados.getSelectedRow();
            if (seleccion==-1){
                System.out.println("ninguna Fila");
            }else{
                System.out.println("se capturo la fila :  "+seleccion);
                if(buscarCliente){
                    cliente = reporteCliente.get(seleccion);
                    DDataCliente dDataCliente = new DDataCliente(null, rootPaneCheckingEnabled, this, cliente/*,con*/);
                    dDataCliente.setVisible(true);
                }else{
                    empleado = reporteEmpleado.get(seleccion);
                    DDataEmpleado dDataEmpleado = new DDataEmpleado(null, rootPaneCheckingEnabled, this, empleado/*,con*/);
                    dDataEmpleado.setVisible(true);
                }
            }
        }catch (HeadlessException ex){
            System.out.println("Error en capturar la celda :  "+ex.getMessage());
        } 
        this.dispose();        
    }//GEN-LAST:event_bAceptarActionPerformed

    private void tfDocumentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfDocumentoMouseClicked
        rbDNI.setSelected(true);
    }//GEN-LAST:event_tfDocumentoMouseClicked

    private void tfApellidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfApellidosMouseClicked
        rbApellidos.setSelected(true);
    }//GEN-LAST:event_tfApellidosMouseClicked

    private void tfCodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfCodigoMouseClicked
        rbCodigo.setSelected(true);
    }//GEN-LAST:event_tfCodigoMouseClicked

    private void dccFechaRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dccFechaRegistroMouseClicked
        rbFechaRegistro.setSelected(true);
    }//GEN-LAST:event_dccFechaRegistroMouseClicked
   
    //BuscarEmpleado
    private void buscarEmpleadoPorDocumento(){
        llenarTablaEmpleados(empc.buscar(1, tfDocumento.getText()));   
    }
    
    private void buscarEmpleadoPorCodigo(){
        llenarTablaEmpleados(empc.buscar(2, tfCodigo.getText()));   
    }
    
    private void buscarEmpleadoPorApellidos(){
        llenarTablaEmpleados(empc.buscar(3, tfApellidos.getText()));          
    }
    //BuscarCliente
    private void buscarClientePorDocumento(){
        llenarTablaClientes(cc.buscar(1, tfDocumento.getText())); 
    }
    
    private void buscarClientePorCodigo(){
        llenarTablaClientes(cc.buscar(2, tfCodigo.getText()));   
    }
    
    private void buscarClientePorApellidos(){
        llenarTablaClientes(cc.buscar(3, tfApellidos.getText()));       
    }
    
    private void buscarClientePorFechaRegistro(){
        System.out.println(dccFechaRegistro.getDate().toString());
//        dccFechaRegistro.setDateFormatString("YYYY-MM-DD HH:MM:SS");
//        System.out.println();
//        System.out.println(dccFechaRegistro.getCalendar().get(Calendar.YEAR));
//        System.out.println(dccFechaRegistro.getCalendar().get(Calendar.MONTH)+1);
//        System.out.println(dccFechaRegistro.getCalendar().get(Calendar.DAY_OF_MONTH));
//        
       
        Date fechadereg = new Date(dccFechaRegistro.getCalendar().get(Calendar.YEAR), 
                (dccFechaRegistro.getCalendar().get(Calendar.MONTH)),
                (dccFechaRegistro.getCalendar().get(Calendar.DAY_OF_MONTH)),
                c2.get(Calendar.HOUR_OF_DAY),
                c2.get(Calendar.MINUTE),
                c2.get(Calendar.SECOND) );
        llenarTablaClientes(cc.buscarByFecha(fechadereg));         
    }
    
    private void llenarTablaEmpleados(java.util.List<Empleado> reporte){                
        //llenar tabla Emleados
        reporte.stream().map((r) -> {
            Object[] fila = new Object[dtm.getColumnCount()];
            fila[0] = r.getCodigo();
            fila[1] = r.getIdpersona().getDocumento();
            fila[2] = r.getIdpersona().getNombres();
            fila[3] = r.getIdpersona().getApellidopat() + " " + r.getIdpersona().getApellidomat();
            fila[4] = r.getIdcargo().getNombre();
            fila[5] = r.getIdusuario().getCorreo();
            return fila;
        }).forEach((fila) -> {
            dtm.addRow(fila);
        });             
        reporteEmpleado = reporte;
    }
    
    private void llenarTablaClientes(java.util.List<Cliente> reporte){
        //llenar tabla Emleados
        reporte.stream().map((r) -> {
            Object[] fila = new Object[dtm.getColumnCount()];
            fila[0] = r.getCodigo();
            fila[1] = r.getIdpersona().getDocumento();
            fila[2] = r.getIdpersona().getNombres();
            fila[3] = r.getIdpersona().getApellidopat() + " " + r.getIdpersona().getApellidomat();
            fila[4] = r.getIdpersona().getCelular();
            fila[5] = r.getIdusuario().getCorreo();
            return fila;
        }).forEach((fila) -> {
            dtm.addRow(fila);
        });                
        reporteCliente = reporte;
    }
    
    private void limpiarTabla(){
        if(reporteCliente != null){
            reporteCliente.clear();        
        }
        if(reporteEmpleado != null ){
            reporteEmpleado.clear();
        }
        
        for (int i = 0; i < dtm.getRowCount(); i++) {
                dtm.removeRow(i);
                i-=1;
        }        
    }
    
    private void definirTabla(){
        if(!buscarCliente){
            dtm.addColumn("Código");
            dtm.addColumn("Documento");
            dtm.addColumn("Nombres");
            dtm.addColumn("Apellidos");
            dtm.addColumn("Cargo");
            dtm.addColumn("Correo"); 
            
            tcm.getColumn(0).setPreferredWidth(50);
            tcm.getColumn(1).setPreferredWidth(100);
            tcm.getColumn(2).setPreferredWidth(100);
            tcm.getColumn(3).setPreferredWidth(100);
            tcm.getColumn(4).setPreferredWidth(100);
            tcm.getColumn(5).setPreferredWidth(100);               
        }else{
            dtm.addColumn("Código");
            dtm.addColumn("Documento");
            dtm.addColumn("Nombres");
            dtm.addColumn("Apellidos");
            dtm.addColumn("Telefono");
            dtm.addColumn("Correo"); 
            
            tcm.getColumn(0).setPreferredWidth(50);
            tcm.getColumn(1).setPreferredWidth(100);
            tcm.getColumn(2).setPreferredWidth(100);
            tcm.getColumn(3).setPreferredWidth(100);
            tcm.getColumn(4).setPreferredWidth(100);
            tcm.getColumn(5).setPreferredWidth(100);              
        }
        
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
//            java.util.logging.Logger.getLogger(DBuscarClienteEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DBuscarClienteEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DBuscarClienteEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DBuscarClienteEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DBuscarClienteEmpleado dialog = new DBuscarClienteEmpleado(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bBuscarCiente;
    private javax.swing.JButton bCancelar;
    private javax.swing.ButtonGroup bgFiltros;
    private com.toedter.calendar.JDateChooser dccFechaRegistro;
    private javax.swing.JLabel lbIcono;
    private javax.swing.JPanel pFondo;
    private javax.swing.JRadioButton rbApellidos;
    private javax.swing.JRadioButton rbCodigo;
    private javax.swing.JRadioButton rbDNI;
    private javax.swing.JRadioButton rbFechaRegistro;
    private javax.swing.JScrollPane scTablaClientes;
    private javax.swing.JTable tClientesEmpleados;
    private javax.swing.JTextField tfApellidos;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfDocumento;
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

