/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.Interfaz;

import entidad.Perfil;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosPerfil {
    public void crear(Perfil perfil );
    public List<Perfil> todos();
    public int cantidad ();
    public Perfil devolverPerfilPorID(Integer idPerfil);
    public Perfil devolverPerfilPorNivelAcceso(Integer nivelAcceso);
}
