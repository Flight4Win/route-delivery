
import clases.PlanVuelo;
import entidad.Aeropuerto;
import entidad.Avion;
import entidad.Cargo;
import entidad.Cliente;
import entidad.Empleado;
import entidad.Estado;
import entidad.Lugar;
import entidad.Paquete;
import entidad.Perfil;
import entidad.Persona;
import entidad.Plandevuelo;
import entidad.Usuario;
import entidad.Vuelo;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import manejadorDB.controlador.AeropuertoControlador;
import manejadorDB.controlador.AvionControlador;
import manejadorDB.controlador.CargoControlador;
import manejadorDB.controlador.ClienteControlador;
import manejadorDB.controlador.EmpleadoControlador;
import manejadorDB.controlador.EstadoControlador;
import manejadorDB.controlador.LugarControlador;
import manejadorDB.controlador.PaqueteControlador;
import manejadorDB.controlador.PerfilControlador;
import manejadorDB.controlador.PersonaControlador;
import manejadorDB.controlador.PlandevueloControlador;
import manejadorDB.controlador.UsuarioControlador;
import manejadorDB.controlador.VueloControlador;
import remoto.MetodosAdicionales;
import remoto.MetodosAeropuerto;
import remoto.MetodosAvion;
import remoto.MetodosCargo;
import remoto.MetodosCliente;
import remoto.MetodosEmpleado;
import remoto.MetodosEstado;
import remoto.MetodosLugar;
import remoto.MetodosPaquete;
import remoto.MetodosPerfil;
import remoto.MetodosPersona;
import remoto.MetodosPlandevuelo;
import remoto.MetodosUsuario;
import remoto.MetodosVuelo;
import utiles.Controlador;
import utiles.Helper;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juani
 */
public class MainSGRME extends UnicastRemoteObject implements MetodosAeropuerto,MetodosAvion,MetodosCargo,MetodosCliente,MetodosEmpleado,MetodosEstado,
        MetodosLugar,MetodosPaquete,MetodosPerfil,MetodosPersona,MetodosPlandevuelo,MetodosUsuario,MetodosVuelo, MetodosAdicionales{

    public MainSGRME () throws RemoteException{
        super();
    }
    
    
    public static void main(String[] args) {
        
        
        /*data de entrada import.sql*/
        Helper.cargar_data_entrada();
        
        /*se inicia la carga de archivos*/
        Controlador.IniControlador();
        
        /*inicializar servidor*/
        try{
            Registry registro = LocateRegistry.createRegistry(1099);
            registro.rebind("rmi://localhost:1099/InterfaceSGRME", new MainSGRME());
            System.out.println("Servidor creado y escuchando puerto 1099....hi");
        }catch(Exception ex){
            ex.printStackTrace();
        }                       
    }    

   
    /*Implementacion de metodos remotos*/    
    
    
    /*Metodos Aeropuerto*/
    @Override
    public Aeropuerto crear_aero(Aeropuerto aeropuerto) throws RemoteException {
        AeropuertoControlador ac = new AeropuertoControlador();
        return (ac.crear(aeropuerto));
    }

    @Override
    public List<Aeropuerto> todos_aero() throws RemoteException {
        AeropuertoControlador ac = new AeropuertoControlador();
        return (ac.todos());
    }

    @Override
    public int cantidad_aero() throws RemoteException {
        AeropuertoControlador ac = new AeropuertoControlador();
        return (ac.cantidad());
    }

    @Override
    public List<Aeropuerto> buscarByLugar_aero(Lugar filtro) throws RemoteException {
        AeropuertoControlador ac = new AeropuertoControlador();
        return (ac.buscarByLugar(filtro));
    }

    @Override
    public Aeropuerto obtener_Aeropuerto_aero(int id) throws RemoteException {
        AeropuertoControlador ac = new AeropuertoControlador();
        return (ac.obtener_Aeropuerto(id));
    }

    
    /*Metodos Avion*/  
    @Override
    public void crear_avio(Avion avion) throws RemoteException {
        AvionControlador av = new AvionControlador();
        av.crear(avion);
    }

    @Override
    public List<Avion> todos_avio() throws RemoteException {
        AvionControlador av = new AvionControlador();
        return (av.todos());
    }

    @Override
    public int cantidad_avio() throws RemoteException {
        AvionControlador av = new AvionControlador();
        return (av.cantidad());
    }

    
    /*Metodos cargo*/
    @Override
    public void crear_carg(Cargo cargo) throws RemoteException {
        CargoControlador cc = new CargoControlador();
        cc.crear(cargo);
    }

    @Override
    public List<Cargo> todos_carg() throws RemoteException {
        CargoControlador cc = new CargoControlador();
        return (cc.todos());
    }

    @Override
    public int cantidad_carg() throws RemoteException {
        CargoControlador cc = new CargoControlador();
        return (cc.cantidad());
    }

    @Override
    public Cargo devolverCargo_carg(Integer idCodigo) throws RemoteException {
        CargoControlador cc = new CargoControlador();
        return (cc.devolverCargo(idCodigo));
    }

    
    /*Cliente*/
    @Override
    public void crear_client(Cliente cliente) throws RemoteException {
        ClienteControlador cc = new ClienteControlador();
        cc.crear(cliente);
    }

    @Override
    public List<Cliente> todos_client() throws RemoteException {
        ClienteControlador cc = new ClienteControlador();
        return (cc.todos());
    }

    @Override
    public int cantidad_client() throws RemoteException {
        ClienteControlador cc = new ClienteControlador();
        return (cc.cantidad());
    }

    @Override
    public void eliminar_client(Cliente cliente) throws RemoteException {
        ClienteControlador cc = new ClienteControlador();
        cc.eliminar(cliente);
    }

    @Override
    public List<Cliente> buscar_client(int opcion, String filtro) throws RemoteException {
        ClienteControlador cc = new ClienteControlador();
        return (cc.buscar(opcion, filtro));
    }

    @Override
    public List<Cliente> buscarByFecha_client(Date fechaReg) throws RemoteException {
        ClienteControlador cc = new ClienteControlador();
        return (cc.buscarByFecha(fechaReg));
    }

    @Override
    public List<Cliente> buscarPorId_client(int idCliente) throws RemoteException {
        ClienteControlador cc = new ClienteControlador();
        return (cc.buscarPorId(idCliente));
    }

    @Override
    public boolean existe_client(String codigo) throws RemoteException {
        ClienteControlador cc = new ClienteControlador();
        return (cc.existe(codigo));
    }

    @Override
    public Cliente obtener_cliente_client(int id) throws RemoteException {
        ClienteControlador cc = new ClienteControlador();
        return (cc.obtener_cliente(id));
    }

    @Override
    public void actualizar_client(Cliente cliente) throws RemoteException {
        ClienteControlador cc = new ClienteControlador();
        cc.actualizar(cliente);
    }

    
    /*Empleado*/
    @Override
    public void crear_emp(Empleado empleado) throws RemoteException {
        EmpleadoControlador ec = new EmpleadoControlador();
        ec.crear(empleado);
    }

    @Override
    public List<Empleado> todos_emp() throws RemoteException {
        EmpleadoControlador ec = new EmpleadoControlador();
        return (ec.todos());
    }

    @Override
    public int cantidad_emp() throws RemoteException {
        EmpleadoControlador ec = new EmpleadoControlador();
        return (ec.cantidad());
    }

    @Override
    public void eliminar_emp(Integer idPersona) throws RemoteException {
        EmpleadoControlador ec = new EmpleadoControlador();
        ec.eliminar(idPersona);
    }

    @Override
    public List<Empleado> buscar_emp(int opcion, String filtro) throws RemoteException {
        EmpleadoControlador ec = new EmpleadoControlador();
        return (ec.buscar(opcion, filtro));
    }

    @Override
    public boolean existe_emp(String codigo) throws RemoteException {
        EmpleadoControlador ec = new EmpleadoControlador();
        return(ec.existe(codigo));
    }

    @Override
    public void actualizar_emp(Empleado empleado) throws RemoteException {
        EmpleadoControlador ec = new EmpleadoControlador();
        ec.actualizar(empleado);
    }

    
    /*Estado*/
    @Override
    public void crear_est(Estado estado) throws RemoteException {
        EstadoControlador ec = new EstadoControlador();
        ec.crear(estado);
    }

    @Override
    public List<Estado> todos_est() throws RemoteException {
        EstadoControlador ec = new EstadoControlador();
        return (ec.todos());
    }

    @Override
    public int cantidad_est() throws RemoteException {
        EstadoControlador ec = new EstadoControlador();
        return (ec.cantidad());
    }

    @Override
    public Estado devolverEstado_est(Integer idEstado) throws RemoteException {
        EstadoControlador ec = new EstadoControlador();
        return ec.devolverEstado(idEstado);
    }

    /*Lugar*/
    @Override
    public Lugar leer_lug(Lugar lugar) throws RemoteException {
        LugarControlador lc = new LugarControlador();
        return (lc.leer(lugar));
    }

    @Override
    public Lugar crear_lug(Lugar lugar) throws RemoteException {
        LugarControlador lc = new LugarControlador();
        return (lc.crear(lugar));
    }

    @Override
    public List<Lugar> todos_lug() throws RemoteException {
        LugarControlador lc = new LugarControlador();
        return (lc.todos());
    }

    @Override
    public int cantidad_lug() throws RemoteException {
        LugarControlador lc = new LugarControlador();
        return (lc.cantidad());
    }

    @Override
    public List<Lugar> buscarPorCiudad_lug(String ciudad) throws RemoteException {
        LugarControlador lc = new LugarControlador();
        return lc.buscarPorCiudad(ciudad);
    }

    @Override
    public Lugar obtener_lugar_lug(int id) throws RemoteException {
        LugarControlador lc = new LugarControlador();
        return lc.obtener_lugar(id);
    }

    /*Paquete*/
    @Override
    public Paquete crear(Paquete paquete) throws RemoteException {
        PaqueteControlador pc = new PaqueteControlador();
        return (pc.crear(paquete));
    }

    @Override
    public List<Paquete> todos() throws RemoteException {
        PaqueteControlador pc = new PaqueteControlador();
        return (pc.todos());
    }

    @Override
    public int cantidad() throws RemoteException {
        PaqueteControlador pc = new PaqueteControlador();
        return (pc.cantidad());
    }

    @Override
    public boolean existe(String Codigo) throws RemoteException {
        PaqueteControlador pc = new PaqueteControlador();
        return (pc.existe(Codigo));
    }

    @Override
    public List<Paquete> buscarPorCliente(int idCliente) throws RemoteException {
        PaqueteControlador pc = new PaqueteControlador();
        return (pc.buscarPorCliente(idCliente));
    }

    @Override
    public List<Paquete> buscarPorCodigo(String codigo) throws RemoteException {
        PaqueteControlador pc = new PaqueteControlador();
        return (pc.buscarPorCodigo(codigo));
    }

    @Override
    public List<Paquete> buscarPorDescripcion(String codigo) throws RemoteException {
        PaqueteControlador pc = new PaqueteControlador();
        return (pc.buscarPorDescripcion(codigo));
    }

    @Override
    public List<Paquete> buscarPorFechaRegistro(Date fecha) throws RemoteException {
        PaqueteControlador pc = new PaqueteControlador();
        return (pc.buscarPorFechaRegistro(fecha));
    }

    @Override
    public List<Paquete> buscarPorFechaLlegada(Date fecha) throws RemoteException {
        PaqueteControlador pc = new PaqueteControlador();
        return (pc.buscarPorFechaLlegada(fecha));
    }

    @Override
    public List<Paquete> buscarPorFechasRegistro(Date fechaInicio, Date fechaFin) throws RemoteException {
            PaqueteControlador pc = new PaqueteControlador();
            return (pc.buscarPorFechasRegistro(fechaInicio, fechaFin));
    }

    @Override
    public List<Paquete> buscarPorCiudadOrigen(int idCiudadOrigen) throws RemoteException {
        PaqueteControlador pc = new PaqueteControlador();
        return (pc.buscarPorCiudadOrigen(idCiudadOrigen));
    }

    @Override
    public List<Paquete> buscarPorCiudadDestino(int idCiudadDestino) throws RemoteException {
        PaqueteControlador pc = new PaqueteControlador();
        return (pc.buscarPorCiudadDestino(idCiudadDestino));
    }

    @Override
    public Paquete obtener_paquete(int id) throws RemoteException {
        PaqueteControlador pc = new PaqueteControlador();
        return (pc.obtener_paquete(id));
    }

    /*Perfil*/
    @Override
    public void crear_perf(Perfil perfil) throws RemoteException {
        PerfilControlador pc = new PerfilControlador();
        pc.crear(perfil);
    }

    @Override
    public List<Perfil> todos_perf() throws RemoteException {
        PerfilControlador pc = new PerfilControlador();
        return (pc.todos());
    }

    @Override
    public int cantidad_perf() throws RemoteException {
        PerfilControlador pc = new PerfilControlador();
        return (pc.cantidad());
    }

    @Override
    public Perfil devolverPerfilPorID_perf(Integer idPerfil) throws RemoteException {
        PerfilControlador pc = new PerfilControlador();
        return (pc.devolverPerfilPorID(idPerfil));
    }

    @Override
    public Perfil devolverPerfilPorNivelAcceso_perf(Integer nivelAcceso) throws RemoteException {
        PerfilControlador pc = new PerfilControlador();
        return (pc.devolverPerfilPorNivelAcceso(nivelAcceso));
    }

    /*Persona*/
    @Override
    public Persona crear_per(Persona persona) throws RemoteException {
        PersonaControlador pc = new PersonaControlador();
        return (pc.crear(persona));
    }

    @Override
    public List<Persona> todos_per() throws RemoteException {
        PersonaControlador pc = new PersonaControlador();
        return (pc.todos());
    }

    @Override
    public int cantidad_per() throws RemoteException {
        PersonaControlador pc = new PersonaControlador();
        return (pc.cantidad());
    }

    @Override
    public void eliminar_per(Persona persona) throws RemoteException {
        PersonaControlador pc = new PersonaControlador();
        pc.eliminar(persona);
    }

    @Override
    public void modificar_per(Persona persona) throws RemoteException {
        PersonaControlador pc = new PersonaControlador();
        pc.modificar(persona);
    }

    @Override
    public List<Persona> buscarPorId_per(int idPersona) throws RemoteException {
        PersonaControlador pc = new PersonaControlador();
        return (pc.buscarPorId(idPersona));
    }

    @Override
    public Persona obtener_Persona_per(int id) throws RemoteException {
        PersonaControlador pc = new PersonaControlador();
        return (pc.obtener_Persona(id));
    }

    
    /*Plan de Vuelo*/
    @Override
    public Plandevuelo crear_plan(Plandevuelo plandeVuelo) throws RemoteException {
        PlandevueloControlador pvc = new PlandevueloControlador();
        return (pvc.crear(plandeVuelo));
    }

    @Override
    public List<Plandevuelo> todos_plan() throws RemoteException {
        PlandevueloControlador pvc = new PlandevueloControlador();
        return (pvc.todos());
    }

    @Override
    public int cantidad_plan() throws RemoteException {
        PlandevueloControlador pvc = new PlandevueloControlador();
        return (pvc.cantidad());
    }

    @Override
    public Plandevuelo obtener_plan_plan(int id) throws RemoteException {
        PlandevueloControlador pvc = new PlandevueloControlador();
        return (pvc.obtener_plan(id));
    }

    
    /*Usuario*/
    @Override
    public Usuario crear_usu(Usuario usuario) throws RemoteException {
        UsuarioControlador uc = new UsuarioControlador();
        return (uc.crear(usuario));
    }

    @Override
    public Usuario logueo_usu(String usuario, String pass) throws RemoteException {
        UsuarioControlador uc = new UsuarioControlador();
        return (uc.logueo(usuario, pass));
    }

    @Override
    public Usuario cambioContrasenha_usu(Usuario usuario) throws RemoteException {
        UsuarioControlador uc = new UsuarioControlador();
        return (uc.cambioContrasenha(usuario));
    }

    @Override
    public void eliminar_usu(Usuario usuario) throws RemoteException {
        UsuarioControlador uc = new UsuarioControlador();
        uc.eliminar(usuario);
    }

    /*Vuelo*/
    @Override
    public void crear_vue(Vuelo vuelo) throws RemoteException {
        VueloControlador vc = new VueloControlador();
        vc.crear(vuelo);
    }

    @Override
    public List<Vuelo> todos_vue() throws RemoteException {
        VueloControlador vc = new VueloControlador();     
        return (vc.todos());
    }

    @Override
    public int cantidad_vue() throws RemoteException {
        VueloControlador vc = new VueloControlador();
        return (vc.cantidad());
    }

    /*adicionales*/
    
    @Override
    public String generarCodigo(int opcion) throws RemoteException {
        return Helper.generarCodigo(opcion);
    }

    @Override
    public void primera_simu() throws RemoteException {
        Controlador.getPlanVuelos().ResetearColeccion();
        Controlador.getTempo().ActivarPrimSim();
        Controlador.getDespacher().ActivarPrimSim();
    }

    @Override
    public void segunda_simu() throws RemoteException {
        Controlador.getPlanVuelos().ResetearColeccion();
        Controlador.getTempo().ActivarSegSim();
        Controlador.getDespacher().ActivarSegSim();
    }

    @Override
    public void tercera_simu() throws RemoteException {
        Controlador.getPlanVuelos().ResetearColeccion();
        Controlador.getTempo().ActivarTerSim();
        Controlador.getDespacher().ActivarTerSim();
    }

    /*de clases*/
    @Override
    public ArrayList<PlanVuelo> obtener_planes() throws RemoteException {
        return Controlador.getPlanVuelos().getPlanVuelos();
    }

    @Override
    public ArrayList<clases.Aeropuerto> obtener_aeropuertos() throws RemoteException {
        return Controlador.getAeropuertos().getAeropuertos();
    }

    @Override
    public boolean contiene_plan(PlanVuelo pl) throws RemoteException {
        boolean contiene = false;
        for(PlanVuelo p : Controlador.getPlanVuelos().getEnVuelo()){
            if((p.getPartida().getId()==pl.getPartida().getId()&&
                    (p.getDestino().getId()==pl.getDestino().getId())&&
                    p.getHora_ini()==pl.getHora_ini())){
                contiene = true;
                return contiene;
            }
        }
        return contiene;
    }

    @Override
    public void tempo_cancelar() throws RemoteException {
        Controlador.getTempo().Cancelar();
    }

    @Override
    public void tempo_pausar() throws RemoteException {
        Controlador.getTempo().Pausar();
    }

    @Override
    public void tempo_renaudar() throws RemoteException {
        Controlador.getTempo().Reanudar();
    }

    @Override
    public void despachador_pausar() throws RemoteException {
        Controlador.getDespacher().Pausar();
    }

    @Override
    public void despachador_renaudar() throws RemoteException {
        Controlador.getDespacher().Reanudar();
    }

    
    public List<String> ciudadesMasEnvios() throws RemoteException {
        LugarControlador lc= new LugarControlador();
        return lc.ciudadesMasEnvios();
    }

    
    public List<String> ciudadesMasRecepciones() throws RemoteException {
        LugarControlador lc= new LugarControlador();
        return lc.ciudadesMasRecepciones();
    }

    
    public List<Paquete> reportePorRangoFechas(Date fechaInicio, Date fechaFin) throws RemoteException{
        PaqueteControlador pqtc = new PaqueteControlador();
        return pqtc.reportePorRangoFechas(fechaInicio, fechaFin);
    }
    
    
    public List<Paquete> reportePorEstado(Estado idEstado) throws RemoteException{
        PaqueteControlador pqtc = new PaqueteControlador();
        return pqtc.reportePorEstado(idEstado);
    }
    
    
    public List<Paquete> reporteClienteEstado(Cliente idCliente, Estado idEstado){
        PaqueteControlador pqtc = new PaqueteControlador();
        return pqtc.reporteClienteEstado(idCliente, idEstado);
    }     
    
    
    public List<Paquete> reporteClienteFecha(Cliente idCliente, Date fechaInicio, Date fechaFin) {
        PaqueteControlador pqtc = new PaqueteControlador();
        return pqtc.reporteClienteFecha(idCliente, fechaInicio, fechaFin);
    }
    
    
    public List<Paquete> reporteEstadoFecha(Estado idEstado, Date fechaInicio, Date fechaFin){
        PaqueteControlador pqtc = new PaqueteControlador();
        return pqtc.reporteEstadoFecha(idEstado, fechaInicio, fechaFin);
    }

    
    public List<Paquete> reportePorCliente(Cliente idCliente) throws RemoteException {
        PaqueteControlador pqtc = new PaqueteControlador();
        return pqtc.reportePorCliente(idCliente);
    }

    
    public List<Paquete> reporteClienteEstadoFecha(Cliente idCliente, Estado idEstado, Date fechaInicio, Date fechaFin) throws RemoteException {
        PaqueteControlador pqtc = new PaqueteControlador();
        return pqtc.reporteClienteEstadoFecha(idCliente, idEstado, fechaInicio, fechaFin);
    }

    @Override
    public boolean existeEmail(String email) throws RemoteException {
        UsuarioControlador uc = new UsuarioControlador();
        return uc.existeEmail(email);
    }
    
    @Override
    public boolean existeDocumento(String documento) throws RemoteException {
        PersonaControlador pc = new PersonaControlador();
        return pc.existeDocumento(documento);
    }
        
    @Override
    public boolean termino_sistema() throws RemoteException{
        return Controlador.isFallo_sistema();
    }
    
    @Override
    public clases.Paquete paquete_fallo() throws RemoteException{
        return Controlador.getPaquete_fallo();
    }

    @Override
    public void reset_simulacion() throws RemoteException{
        Controlador.setFallo_sistema(false);
    }
}
