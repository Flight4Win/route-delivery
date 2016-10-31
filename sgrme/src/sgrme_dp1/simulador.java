/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgrme_dp1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author joe
 */
public class simulador extends JPanel {
    
    BufferedImage imgFondo;
    private BufferStrategy bufferStrategy;
    
    public simulador() {
        this.setSize(1300,1400); //se selecciona el tamaño del panel
        setVisible(true);
        
        try {
            //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
            imgFondo = ImageIO.read(new File("mapaMundo.png"));
            //ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/mapaMundo.png")); 
        } catch (IOException ex) {
//            Logger.getLogger(simulador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setVisible(true);
        //createBufferStrategy(2);
		//La estrategia se debe obtener una vez creada para poder usarla
		//en el paint. Si se obtiene en el paint se producirá parpadeo
        //bufferStrategy = getBufferStrategy();
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);

        try{
            Graphics2D graph2D = (Graphics2D)bufferStrategy.getDrawGraphics();
            graph2D.drawImage(imgFondo, 0, 0, this);
            bufferStrategy.show();
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
}
