/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitario;

import javax.swing.JLabel;
import javax.swing.SwingWorker;
import vista.DLogueo;

/**
 *
 * @author MFGuevaraL
 */
public class ProgressImagen extends SwingWorker<Integer, String>{
    private JLabel lbCargando;    
    private  DLogueo dLogueo;

    public ProgressImagen(JLabel lbCargando, DLogueo parentFInicial) {
        this.lbCargando = lbCargando;
        this.dLogueo = parentFInicial;
    }

    public JLabel getLbCargando() {
        return lbCargando;
    }

    public void setLbCargando(JLabel lbCargando) {
        this.lbCargando = lbCargando;
    }

    public DLogueo getdLogueo() {
        return dLogueo;
    }

    public void setdLogueo(DLogueo dLogueo) {
        this.dLogueo = dLogueo;
    }

    @Override
    protected Integer doInBackground() throws Exception {
        getLbCargando().setVisible(true);
        getdLogueo().verificarLogueo();
        try{
            for (int i = 0; i < 50; i++){
                Thread.sleep(10);
            }
        }catch (Exception e){
            System.out.println("error: " +e);
        }        
        return 0;
    }
    
    @Override
    protected void done(){        
        getLbCargando().setVisible(false);
        getdLogueo().dispose();
        getdLogueo().parentFInicial.asignarPerfil();
    }
    
    
}
