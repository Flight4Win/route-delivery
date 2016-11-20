/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.Interfaz;

import entidad.Paquete;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosPaquete {
    public Paquete crear(Paquete paquete);
    public List<Paquete> todos();
    public int cantidad ();
    public boolean existe(String Codigo);
    public Paquete obtener_paquete(int id);
}
