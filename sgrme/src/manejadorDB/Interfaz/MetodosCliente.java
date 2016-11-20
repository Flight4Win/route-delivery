/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.Interfaz;

import entidad.Cliente;
import entidad.Empleado;
import java.util.Date;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosCliente {
    public void crear(Cliente cliente);
    public List<Cliente> todos();
    public int cantidad ();
    public void eliminar(Integer idCliente);
    public List<Cliente> buscar(int opcion, String filtro);
    public List<Cliente> buscarByFecha(Date fechaReg);
    public boolean existe(String codigo);
    public Cliente obtener_cliente(int id);
}
