/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.Interfaz;

import entidad.Cliente;
import entidad.Estado;
import entidad.Paquete;
import java.util.Date;
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
    public List<Paquete> buscarPorCliente(int idCliente);
    public List<Paquete> buscarPorCodigo(String codigo);
    public List<Paquete> buscarPorDescripcion(String codigo);
    public List<Paquete> buscarPorFechaRegistro(Date fecha);
    public List<Paquete> buscarPorFechaLlegada(Date fecha);
    public List<Paquete> buscarPorFechasRegistro(Date fechaInicio, Date fechaFin);
    public List<Paquete> buscarPorCiudadOrigen(int idCiudadOrigen);
    public List<Paquete> buscarPorCiudadDestino(int idCiudadDestino);
    public Paquete obtener_paquete(int id);
    public List<Paquete> reportePorRangoFechas(Date fechaInicio, Date fechaFin);
    public List<Paquete> reportePorEstado(Estado idEstado);
    public List<Paquete> reportePorCliente(Cliente idCliente);
    public List<Paquete> reporteClienteEstado(Cliente idCliente, Estado idEstado);
    public List<Paquete> reporteClienteFecha(Cliente idCliente, Date fechaInicio, Date fechaFin);
    public List<Paquete> reporteEstadoFecha(Estado idEstado, Date fechaInicio, Date fechaFin);
    public List<Paquete> reporteClienteEstadoFecha(Cliente idCliente, Estado idEstado, Date fechaInicio, Date fechaFin);
}