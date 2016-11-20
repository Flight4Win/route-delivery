/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.Interfaz;

import entidad.Usuario;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosUsuario {
    public Usuario crear(Usuario usuario);
    public Usuario logueo(String usuario,String pass);
    public Usuario cambioContrasenha(String usuario,String passAnt,String passNvo);
    public void eliminar(Integer idUsuario);
    
}
