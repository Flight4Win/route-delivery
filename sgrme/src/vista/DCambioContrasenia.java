/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import utilitario.IntVentanas;
import utilitario.ImagenFondo;
import entidad.Usuario;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import manejadorDB.controlador.UsuarioControlador;
import utilitario.StringEncrypt;

/**
 *
 * @author ferna
 */
public class DCambioContrasenia extends javax.swing.JDialog implements IntVentanas{
    

    /**
     * Creates new form dCambioContrasenia
     */
    private FInicial parentFInicial;
    private int idLogueado = 0;
    private int nroPerfil = 0;
    private UsuarioControlador uc ;
    
    public DCambioContrasenia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        /*-----------------------------*/
        centrarPantalla();
        /*-----------------------------*/
        uc = new UsuarioControlador();
    }

    public DCambioContrasenia(java.awt.Frame parent, boolean modal, FInicial parentFInicial) {
        super(parent, modal);
        initComponents();  
        /*-----------------------------*/
        this.parentFInicial = parentFInicial;
        /*-----------------------------*/
        centrarPantalla();
        /*-----------------------------*/
        uc = new UsuarioControlador();
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
        lbIconoUsuario = new javax.swing.JLabel();
        lbIconoContrasenha = new javax.swing.JLabel();
        lbIconoContrasenha1 = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        lbContraseniaNueva = new javax.swing.JLabel();
        lbContraseniaAnterior = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        pfContrasenha = new javax.swing.JPasswordField();
        pfNuevaContrasenha = new javax.swing.JPasswordField();
        bCancelar = new javax.swing.JButton();
        bAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cambio de Contraseña");
        setResizable(false);

        lbIconoUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIconoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/usuario.png"))); // NOI18N

        lbIconoContrasenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIconoContrasenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/candado.png"))); // NOI18N

        lbIconoContrasenha1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIconoContrasenha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/candado.png"))); // NOI18N

        lbUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbUsuario.setText("Usuario");

        lbContraseniaNueva.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbContraseniaNueva.setText("Contraseña Nueva");

        lbContraseniaAnterior.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbContraseniaAnterior.setText("Contraseña Anterior");

        tfUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfUsuario.setText("sgrmeadmin");
        tfUsuario.setToolTipText("");

        pfContrasenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pfContrasenha.setText("admin123");

        pfNuevaContrasenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pfNuevaContrasenha.setText("admin456");

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

        javax.swing.GroupLayout pFondoLayout = new javax.swing.GroupLayout(pFondo);
        pFondo.setLayout(pFondoLayout);
        pFondoLayout.setHorizontalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbContraseniaNueva)
                    .addComponent(lbContraseniaAnterior)
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addComponent(lbIconoContrasenha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pfContrasenha, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addComponent(lbIconoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addComponent(lbIconoContrasenha1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pfNuevaContrasenha, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pFondoLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pFondoLayout.setVerticalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbIconoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbContraseniaAnterior)
                .addGap(11, 11, 11)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbIconoContrasenha)
                    .addComponent(pfContrasenha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbContraseniaNueva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbIconoContrasenha1)
                    .addComponent(pfNuevaContrasenha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        cambiarContrasenha();
        this.dispose();
    }//GEN-LAST:event_bAceptarActionPerformed

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
//            java.util.logging.Logger.getLogger(DCambioContrasenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DCambioContrasenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DCambioContrasenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DCambioContrasenia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DCambioContrasenia dialog = new DCambioContrasenia(new javax.swing.JFrame(), true);
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
    
    private String convertirArrayCharAString(char[] chars){
        String aux = "";
        for (int i = 0; i < chars.length; i++) {
            aux  = aux +chars[i];            
        }
        return aux;
    }
    

    private void cambiarContrasenha(){
        String usuario = tfUsuario.getText();
        String passAnt = convertirArrayCharAString(pfContrasenha.getPassword());
        String passNvo = convertirArrayCharAString(pfNuevaContrasenha.getPassword());
        
        String passEncriptadoAnterior;
        String passEncriptadoNueva;
        try {
            passEncriptadoAnterior = StringEncrypt.encriptar(passAnt);
            passEncriptadoNueva = StringEncrypt.encriptar(passNvo);
            
            uc = new UsuarioControlador();
            Usuario user = uc.logueo(usuario, passEncriptadoAnterior);
            user.setContrasenha(passEncriptadoNueva);
            /*si es nulo, no existe el usuario.*/   
            if(user!=null){    
                uc.cambioContrasenha(user);
                System.out.println(user); 
                JOptionPane.showMessageDialog(this,"Contraseña Cambiada Correctamente",
                "FELICIDADES", JOptionPane.PLAIN_MESSAGE,
                ingresarImagen("/vista/imagen/check64.png"));
                this.dispose();                       
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Datos Incorrectos", 
                    "FELICIDADES", JOptionPane.PLAIN_MESSAGE,
                    ingresarImagen("/vista/imagen/error.png"));
        }  
        
           
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JLabel lbContraseniaAnterior;
    private javax.swing.JLabel lbContraseniaNueva;
    private javax.swing.JLabel lbIconoContrasenha;
    private javax.swing.JLabel lbIconoContrasenha1;
    private javax.swing.JLabel lbIconoUsuario;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JPanel pFondo;
    private javax.swing.JPasswordField pfContrasenha;
    private javax.swing.JPasswordField pfNuevaContrasenha;
    private javax.swing.JTextField tfUsuario;
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
    }

    @Override
    public void asignarIcono(){
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/vista/imagen/iconoAvion.png"));
        this.setIconImage(icon);
    }
    
}
