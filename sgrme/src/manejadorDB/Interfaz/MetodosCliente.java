/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.Interfaz;

import entidad.Cliente;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosCliente {
    public void crear(Cliente cliente);
    public List<Cliente> todos();
    public int cantidad ();
}
