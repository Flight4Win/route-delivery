/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.Interfaz;

import entidad.Plandevuelo;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosPlandevuelo {
    public Plandevuelo crear(Plandevuelo plandeVuelo);
    public List<Plandevuelo> todos();
    public int cantidad ();
    public Plandevuelo obtener_plan(int id);
}
