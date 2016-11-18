/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import clases.Controlador;
import utilitario.IntVentanas;
import utilitario.ImagenFondo;

import entidad.Usuario;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


import manejadorDB.controlador.UsuarioControlador;


/**
 *
 * @author ferna
 */
public class DLogueo extends javax.swing.JDialog implements IntVentanas{

    /**
     * Creates new form dLogueo
     */

    public FInicial parentFInicial ;
    
    //Connection con;

    public DLogueo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();  
        
        lbOlvidoUsuarioContrasenia.setVisible(false);
        centrarPantalla();        
    }

    public DLogueo(java.awt.Frame parent, boolean modal, FInicial parentFInicial) {
        super(parent, modal);
        initComponents();  
                
        lbOlvidoUsuarioContrasenia.setVisible(false);
        this.parentFInicial = parentFInicial;
        centrarPantalla();
        //con = parentFInicial.conexion;
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
        lbIconoUsuario1 = new javax.swing.JLabel();
        lbOlvidoUsuarioContrasenia = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        lbContrasenia = new javax.swing.JLabel();
        pfContrasenha = new javax.swing.JPasswordField();
        bCancelar = new javax.swing.JButton();
        bAceptar = new javax.swing.JButton();
        tfUsuario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Logueo");
        setResizable(false);

        lbIconoUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIconoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/usuario.png"))); // NOI18N

        lbIconoUsuario1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIconoUsuario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagen/candado.png"))); // NOI18N

        lbOlvidoUsuarioContrasenia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbOlvidoUsuarioContrasenia.setForeground(new java.awt.Color(255, 0, 0));
        lbOlvidoUsuarioContrasenia.setText("Datos incorrectos");

        lbUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbUsuario.setText("Usuario");

        lbContrasenia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbContrasenia.setText("Contraseña");

        pfContrasenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pfContrasenha.setText("admin123");
        pfContrasenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pfContrasenhaFocusGained(evt);
            }
        });
        pfContrasenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pfContrasenhaKeyTyped(evt);
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

        tfUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfUsuario.setText("sgrmeadmin");
        tfUsuario.setToolTipText("");
        tfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfUsuarioKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pFondoLayout = new javax.swing.GroupLayout(pFondo);
        pFondo.setLayout(pFondoLayout);
        pFondoLayout.setHorizontalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pFondoLayout.createSequentialGroup()
                                .addComponent(lbIconoUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pfContrasenha))
                            .addGroup(pFondoLayout.createSequentialGroup()
                                .addComponent(lbIconoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbContrasenia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFondoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbOlvidoUsuarioContrasenia)
                .addGap(155, 155, 155))
        );
        pFondoLayout.setVerticalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbUsuario)
                .addGap(12, 12, 12)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbIconoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbIconoUsuario1)
                    .addComponent(pfContrasenha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbOlvidoUsuarioContrasenia)
                .addGap(18, 18, 18)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(pFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pfContrasenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pfContrasenhaFocusGained
        pfContrasenha.setText("");
    }//GEN-LAST:event_pfContrasenhaFocusGained

    private void pfContrasenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfContrasenhaKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            bAceptar.doClick();
        }
    }//GEN-LAST:event_pfContrasenhaKeyTyped

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        verificarLogueo();
    }//GEN-LAST:event_bAceptarActionPerformed

    private void tfUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfUsuarioKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            bAceptar.doClick();
        }
    }//GEN-LAST:event_tfUsuarioKeyTyped

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DLogueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DLogueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DLogueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DLogueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DLogueo dialog = new DLogueo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    private String convertirArrayCharAString(char[] chars){
        String aux = "";
        for (int i = 0; i < chars.length; i++) {
            aux  = aux +chars[i];            
        }
        return aux;
    }
    

    public void verificarLogueo(){      
        UsuarioControlador uc = new UsuarioControlador();        
        /*Se comprueba el logueo*/
        String usuario = tfUsuario.getText();
        String pass = convertirArrayCharAString(pfContrasenha.getPassword());
        
        System.out.println(usuario+" "+pass);
        Usuario user = uc.logueo(usuario, pass);
        System.out.println(user);        
        /*si es nulo, no existe el usuario.*/        
        if(user==null){
           parentFInicial.idLogueado = -1;
           parentFInicial.nivelAcceso =-1;
        }else{
            parentFInicial.idLogueado= user.getIdusuario();
            parentFInicial.nivelAcceso=  user.getIdperfil().getIdperfil();            
        }
        if(parentFInicial.idLogueado !=-1 || parentFInicial.nivelAcceso != -1){
//            JOptionPane.showMessageDialog(this,"Sesión Iniciada Correctamente", 
//                "FELICIDADES", JOptionPane.PLAIN_MESSAGE,
//                ingresarImagen("/vista/imagen/check64.png"));
            System.out.println("Asignar el perfil");
            parentFInicial.asignarPerfil();
            this.dispose();
            Controlador.IniControlador();
        }else{
//           JOptionPane.showMessageDialog(this,"Datos Incorrectos", 
//                "FELICIDADES", JOptionPane.PLAIN_MESSAGE,
//                ingresarImagen("/vista/imagen/error.png")); 
            lbOlvidoUsuarioContrasenia.setVisible(true);
        }        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JLabel lbContrasenia;
    private javax.swing.JLabel lbIconoUsuario;
    private javax.swing.JLabel lbIconoUsuario1;
    private javax.swing.JLabel lbOlvidoUsuarioContrasenia;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JPanel pFondo;
    private javax.swing.JPasswordField pfContrasenha;
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

}
