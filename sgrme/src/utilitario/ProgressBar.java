/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitario;

import java.util.List;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import vista.FSimulacion;

/**
 *
 * @author MFGuevaraL
 */
public class ProgressBar extends SwingWorker<Integer, Integer>{
    private JProgressBar pb;    
    private  FSimulacion simu;
    String textoDone;
    

    public ProgressBar(JProgressBar pb, FSimulacion simu) {
        this.pb = pb;
        this.simu = simu;
    }

    public ProgressBar(JProgressBar pb, FSimulacion simu, String textoDone) {
        this.pb = pb;
        this.simu = simu;
        this.textoDone = textoDone;
    }

    public JProgressBar getLbCargando() {
        return pb;
    }

    public void setLbCargando(JProgressBar pb) {
        this.pb = pb;
    }

    public FSimulacion getdLogueo() {
        return simu;
    }

    public void setdLogueo(FSimulacion simu) {
        this.simu = simu;
    }

    @Override
    protected Integer doInBackground() throws Exception {        
        try{
            for (int i = 0; i <= 100; i++){
                Thread.sleep(50);
                pb.setValue(i);
                publish(i);
            }
        }catch (Exception e){
            System.out.println("error: " +e);
        }        
        
        return 0;
    }
    
    @Override
    protected void done(){        
//        getLbCargando().setVisible(false);
//        getdLogueo().dispose();
//        getdLogueo().parentFInicial.asignarPerfil();
//        simu.actualizarBitacora(textoDone);
        System.out.println("Data Cargada");
    }
    
    @Override
    protected void process(List<Integer> chunks) {
        chunks.stream().forEach((string) -> {
            System.out.println("- "+string+" -");
//      messagesTextArea.append(string);
//      messagesTextArea.append("\n");
        });
    }
    
}
