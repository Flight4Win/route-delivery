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
    public boolean contiene_plan(PlanVuelo pl) throws RemoteException;
    
    
    public void tempo_cancelar() throws RemoteException;
    public void tempo_pausar() throws RemoteException;
    public void tempo_renaudar() throws RemoteException;
    
    public void despachador_pausar() throws RemoteException;
    public void despachador_renaudar() throws RemoteException;

    public boolean termino_sistema() throws RemoteException;
    public clases.Paquete paquete_fallo() throws RemoteException;
    public void reset_simulacion() throws RemoteException;
}