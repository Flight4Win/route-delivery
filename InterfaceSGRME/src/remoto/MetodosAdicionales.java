/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoto;

import clases.Aeropuerto;
import clases.PlanVuelo;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import clases.Paquete;
import java.time.LocalDateTime;
import java.util.Map;

/**
 *
 * @author juani
 */
public interface MetodosAdicionales extends Remote{
    
    public String generarCodigo(int opcion) throws RemoteException;
    public void primera_simu()throws RemoteException;
    public void segunda_simu()throws RemoteException;
    public void tercera_simu()throws RemoteException;
    
    public ArrayList<PlanVuelo> obtener_planes() throws RemoteException;
    public ArrayList<Aeropuerto> obtener_aeropuertos() throws RemoteException; 
    public Map obtenerCapacidades() throws RemoteException;
    public boolean contiene_plan(PlanVuelo pl) throws RemoteException;
    
    
    public void tempo_cancelar() throws RemoteException;
    public void tempo_pausar() throws RemoteException;
    public void tempo_renaudar() throws RemoteException;
    
    public void despachador_pausar() throws RemoteException;
    public void despachador_renaudar() throws RemoteException;
    public void despachador_cancelar() throws RemoteException;

    public boolean termino_sistema() throws RemoteException;
    public clases.Paquete paquete_fallo() throws RemoteException;
    public void reset_simulacion() throws RemoteException;
    public LocalDateTime obtener_fecha_sim() throws RemoteException;
    public void ejecutarAlgoritmo(Paquete p) throws RemoteException;
    

    
    /*Para el progress bar*/
    public int obtener_porcentaje() throws RemoteException;
    public boolean ha_acabado() throws RemoteException;  
    
    public float posX(PlanVuelo pV) throws RemoteException;
    public float posY(PlanVuelo pV) throws RemoteException;

    public float porcLleno(PlanVuelo pV) throws RemoteException;
    public int cantDias() throws RemoteException;

}
