/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author ferna
 */
public class ImagenFondo extends javax.swing.JPanel {
    String direccion;

    public ImagenFondo(int width,int height,String direccion) {
        this.direccion =direccion;
        this.setSize(width, height); //se selecciona el tamaño del panel
    }
    //Se crea un método cuyo parámetro debe ser un objeto Graphics
    public ImagenFondo(String direccion){
        this.direccion =direccion;
    }
    
    //poner fondo a JPanel
    @Override
    public void paint(Graphics grafico) {
        Dimension height = getSize();
        //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
        ImageIcon Img = new ImageIcon(getClass().getResource(direccion)); 
        //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
        grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
        setOpaque(false);
        super.paintComponent(grafico);
    }
    
    public void ponerImagenFondo(javax.swing.JFrame jFrame){
        jFrame.setContentPane(new FondoFrame(direccion));
    }
    
    public void ponerImagenFondo(javax.swing.JDialog jDialog){
        jDialog.setContentPane(new FondoFrame(direccion));
    }
    
    class FondoFrame extends Container{
	
	public ImageIcon icono;
	public JLabel labelTitulo;
	
	public FondoFrame(String direccion){
            java.net.URL imgUrl = getClass().getResource(direccion);
            System.out.println(imgUrl);
            icono = new ImageIcon (imgUrl);	
	} 
	
        @Override
	public void paint (Graphics g){
            Rectangle r = g.getClipBounds();
            g.setColor(this.getBackground());
            g.fillRect (r.x, r.y, r.width, r.height);
            g.drawImage (icono.getImage(), 0, 0, this.getWidth(), this.getHeight(), this.getBackground(), this);
            super.paint(g);
        }
        
    }
    
}