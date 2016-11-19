/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitario;

import clases.PlanVuelo;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import manejadorDB.controlador.AeropuertoControlador;
import manejadorDB.controlador.ClienteControlador;
import manejadorDB.controlador.EstadoControlador;
import manejadorDB.controlador.LugarControlador;
import manejadorDB.controlador.PaqueteControlador;
import manejadorDB.controlador.PersonaControlador;
import manejadorDB.controlador.PlandevueloControlador;



/**
 *
 * @author juani
 */
public class Factory {
    
    /*convertir  Aeropuerto*/    
    public static clases.Aeropuerto to_AeropuertoClass(entidad.Aeropuerto aeropuerto){
        
        int id = aeropuerto.getIdaeropuerto();
        String codigo = aeropuerto.getCodigo();
        int capacidad = aeropuerto.getCapacidad();
        int nropaquetes = aeropuerto.getNropaquetes();
        int nroaviones = aeropuerto.getNroaviones(); //no usado
        double longitud = aeropuerto.getLongitud();
        double latitud = aeropuerto.getLatitud();
        clases.Lugar lugar = to_LugarClass(aeropuerto.getIdlugar());
        
        boolean europa = false;
        
        if(lugar.getContinente().trim().equalsIgnoreCase(Helper.europa)) europa = true;
        
        clases.Aeropuerto aeropuertoretorno = new clases.Aeropuerto(lugar, codigo, capacidad, id, europa, (float)longitud, (float)latitud);
        aeropuertoretorno.setCapacidadOcupada(nropaquetes);
        
        return aeropuertoretorno;
    }
    
    public static entidad.Aeropuerto to_AeropuertoEntity(clases.Aeropuerto aeropuerto){
        
        int id = aeropuerto.getId();
        String codigo = aeropuerto.getNombre();
        int capacidad = (int)aeropuerto.getCapacidad();
        int nropaquetes = aeropuerto.getCapacidadOcupada();
        int nroaviones = 0; //no usado
        double longitud = aeropuerto.getLongitud();
        double latitud = aeropuerto.getLatitud();
        entidad.Lugar lugar = to_LugarEntity(aeropuerto.getLugar());
        
        
        entidad.Aeropuerto aeropuertoRetorno = new entidad.Aeropuerto(codigo, capacidad, nropaquetes, nroaviones);
        aeropuertoRetorno.setIdaeropuerto(new Integer(id));
        aeropuertoRetorno.setLongitud(longitud);
        aeropuertoRetorno.setLatitud(latitud);
        aeropuertoRetorno.setIdlugar(lugar);
        
        AeropuertoControlador ac = new AeropuertoControlador();
        
        aeropuertoRetorno=ac.crear(aeropuertoRetorno);
        
        return aeropuertoRetorno;
    }
    
    /*convertir Lugar*/
    public static clases.Lugar to_LugarClass(entidad.Lugar lugar){
        
        int id = lugar.getIdlugar();
        String continente = lugar.getContinente();
        String pais = lugar.getPais();
        String ciudad = lugar.getCiudad();
        int utc = lugar.getGmt();
        
        clases.Lugar lugarRetorno = new clases.Lugar(continente, pais, ciudad);
        
        lugarRetorno.setId_base(id);
        lugarRetorno.setUtc(utc);
        
        return lugarRetorno;
    }
    
    public static entidad.Lugar to_LugarEntity(clases.Lugar lugar){
        
        int id = lugar.getId_base();
        String continente = lugar.getContinente();
        String pais = lugar.getPais();
        String ciudad = lugar.getCiudad();
        int utc = lugar.getUtc();
        
        entidad.Lugar lugarRetorno;
        LugarControlador lc = new LugarControlador();
        
        if (id==-1){ //lugar nuevo, recién leido.
            
            lugarRetorno = new entidad.Lugar(continente,pais,ciudad,utc);
            lugarRetorno=lc.crear(lugarRetorno);
            
            //agregar el id
            lugar.setId_base(lugarRetorno.getIdlugar());
            
        }else{ //lugar ya existente.     
            lugarRetorno = lc.obtener_lugar(id);    
        }
   
        return lugarRetorno;
    }
    
    /*convertir Paquete*/
    public static clases.Paquete to_PaqueteClass(entidad.Paquete paquete){
        int id = paquete.getIdpaquete(); //ok
        String codigounico = paquete.getCodigounico(); //ok
        int codigo = Integer.parseInt(codigounico); //ok
        String descripcion = paquete.getDescripcion(); //ok
        clases.Aeropuerto aeropuertoOrigen = to_AeropuertoClass(paquete.getIdorigen()); //ok
        clases.Aeropuerto aeropuertoDestino = to_AeropuertoClass(paquete.getIddestino()); //ok
        Date fechainicio = paquete.getFechainicio(); //ok
        
        Date fechafin = paquete.getFechafin(); //no ok
        int tiempomaximo = paquete.getTiempomaximo(); //no ok
        int tiempoestimado = paquete.getTiempoestimado(); //no ok
        int idestado = paquete.getIdestado().getIdestado(); //no ok
        int idcliente = paquete.getIdcliente().getIdcliente(); //no ok
        int idpersona = paquete.getIdpersona().getIdpersona(); //no ok
        

        clases.Paquete paqueteRetorno = new clases.Paquete();
        
        paqueteRetorno.setId_base(id);
        paqueteRetorno.setId(codigo);
        paqueteRetorno.setDescripcion(descripcion);
        paqueteRetorno.setPartida(aeropuertoOrigen.getId());
        paqueteRetorno.setDestino(aeropuertoDestino.getId());
        paqueteRetorno.setMaximaDuracion(tiempomaximo);
        paqueteRetorno.setTiempo_estimado(tiempoestimado);
        paqueteRetorno.setId_estado(idestado);
        LocalDateTime fecharegistro = LocalDateTime.ofInstant(fechainicio.toInstant(), ZoneId.systemDefault());
        paqueteRetorno.setFechaRegistro(fecharegistro);
        paqueteRetorno.setHoraEntrega(fecharegistro.getHour());
        LocalDateTime fechafini = LocalDateTime.ofInstant(fechafin.toInstant(), ZoneId.systemDefault());
        paqueteRetorno.setFecha_fin(fechafini);
        paqueteRetorno.setIdpersona(idpersona);
        paqueteRetorno.setIdcliente(idcliente);


        
        return paqueteRetorno;
    }
    
    public static entidad.Paquete to_PaqueteEntity(clases.Paquete paquete){
        
        int id = paquete.getId_base();
        String codigounico = paquete.getId()+"";
        String descripcion = paquete.getDescripcion();
        if(descripcion==null){descripcion = "No hay descripcion del paquete.";}
        int idorigen = paquete.getPartida();
        int iddestino = paquete.getDestino();
        LocalDateTime fecha = paquete.getFechaRegistro();
        Date fechainicio = Date.from(fecha.atZone(ZoneId.systemDefault()).toInstant());
        fecha = paquete.getFecha_fin();
        Date fechafin = null;
        if(fecha!=null)
            fechafin = Date.from(fecha.atZone(ZoneId.systemDefault()).toInstant());
        int tiempomaximo = paquete.getMaximaDuracion();
        int idcliente = paquete.getIdcliente();
        int idpersona = paquete.getIdpersona();
        int tiempoestimado = paquete.getTiempo_estimado();
        int idestado = paquete.getId_estado();
        
        
        entidad.Paquete paqueteRetorno;
        PaqueteControlador pc = new PaqueteControlador();
        AeropuertoControlador ac = new AeropuertoControlador();
        ClienteControlador cc = new ClienteControlador();
        PersonaControlador pcc = new PersonaControlador();
        EstadoControlador ec = new EstadoControlador();
        
        if (id==-1){ //registrar paquete
            entidad.Aeropuerto aeropuertoOrigen = ac.obtener_Aeropuerto(idorigen);
            entidad.Aeropuerto aeropuertoDestino = ac.obtener_Aeropuerto(iddestino);
            entidad.Persona persona = pcc.obtener_Persona(idpersona);
            entidad.Cliente cliente = cc.obtener_cliente(idcliente);
            entidad.Estado estado = ec.devolverEstado(idestado);
            
            paqueteRetorno = new entidad.Paquete(codigounico, descripcion, fechainicio, aeropuertoOrigen, aeropuertoDestino, persona, estado, cliente);
            
            paqueteRetorno.setTiempomaximo(tiempomaximo);
            paqueteRetorno.setTiempoestimado(tiempoestimado);
            if(fechafin!=null) paqueteRetorno.setFechafin(fechafin);
            
            paqueteRetorno = pc.crear(paqueteRetorno);
                       
        }else{
            
            paqueteRetorno = pc.obtener_paquete(id);
                    
        }
      
        return paqueteRetorno;
    }
    
    /*convertir Plan de Vuelo*/
    public static clases.PlanVuelo to_PlanVueloClass(entidad.Plandevuelo planvuelo){
        int id = planvuelo.getIdplan();
        //inicio
        Date hora = planvuelo.getHorainicio();
        LocalTime hora2 = LocalTime.of(hora.getHours(), hora.getMinutes());
        int horainicio = hora2.getHour(); //asi en clase.
        //fin
        hora = planvuelo.getHorafin();
        hora2 = LocalTime.of(hora.getHours(), hora.getMinutes());
        int horafin = hora2.getHour(); //asi en clase. 
        
        int capaviones = planvuelo.getCapaviones(); //no considerado
        clases.Aeropuerto aeropuertopartida = to_AeropuertoClass(planvuelo.getIdaeropuertoinicio());
        clases.Aeropuerto aeropuertofin = to_AeropuertoClass(planvuelo.getIdaeropuertofin());
        
        int distancia = planvuelo.getDistancia(); //sera duracion
        int capacidad = planvuelo.getCapacidad();
        int nropaquetes = planvuelo.getNropaquetes();
        
        
        clases.PlanVuelo planvueloRetorno = new PlanVuelo(aeropuertopartida, aeropuertofin, horafin, horafin);
        planvueloRetorno.setCapacidad(capacidad);
        planvueloRetorno.setCapacidadOcupada(nropaquetes);
        planvueloRetorno.setDuracion(distancia);
        planvueloRetorno.setId_base(id);
        
        
        return planvueloRetorno;                
    }
    
    public static entidad.Plandevuelo to_PlanVueloEntity(clases.PlanVuelo planvuelo){
        
        int id =planvuelo.getId_base();
        int hora = planvuelo.getHora_ini();
        Date horainicio = new Date(94,3, 25, hora, 0, 0);
        hora = planvuelo.getHora_fin();
        Date horafin = new Date(94,3, 25, hora, 0, 0);
        int capacidad = planvuelo.getCapacidad();
        int nropaquetes = planvuelo.getCapacidadOcupada();
        int capaviones = 0; //no usado
        int idaeropuertoinicio = planvuelo.getPartida().getId();
        int idaeropuertofin = planvuelo.getDestino().getId();
        int distancia = planvuelo.getDuracion();
        
        System.out.println("horainicio "+horainicio.toString());
        System.out.println("horafin "+horafin.toString());
        System.out.println("capacidad "+capacidad);
        System.out.println("nropaquetes "+nropaquetes);
        System.out.println("capaviones "+capaviones);
        System.out.println("idaeropuertoinicio "+idaeropuertoinicio);
        System.out.println("idaeropuertofin "+idaeropuertofin);
        System.out.println("distancia "+distancia);
        
        entidad.Plandevuelo plandevueloRetorno;
        PlandevueloControlador pvc = new PlandevueloControlador();
        AeropuertoControlador ac = new AeropuertoControlador();
                
        if(id==-1){ //registrar plan de vuelo
            
            entidad.Aeropuerto aeropuertoinicio = ac.obtener_Aeropuerto(idaeropuertoinicio);
            entidad.Aeropuerto aeropuertofin = ac.obtener_Aeropuerto(idaeropuertofin);
            
            System.out.println("aeropuerto inicio: "+aeropuertoinicio.getCodigo());
            System.out.println("aeropuerto fin: "+aeropuertofin.getCodigo());
                                    
            plandevueloRetorno = new entidad.Plandevuelo();
            plandevueloRetorno.setHorainicio(horainicio);
            plandevueloRetorno.setHorafin(horafin);
            plandevueloRetorno.setCapacidad(capacidad);
            plandevueloRetorno.setNropaquetes(nropaquetes);
            plandevueloRetorno.setCapaviones(capaviones);
            plandevueloRetorno.setIdaeropuertoinicio(aeropuertoinicio);
            plandevueloRetorno.setIdaeropuertofin(aeropuertofin);
            plandevueloRetorno.setDistancia(distancia); //duracion
            
            plandevueloRetorno = pvc.crear(plandevueloRetorno);
            planvuelo.setId_base(plandevueloRetorno.getIdplan());

        }else{ //ya existe
            plandevueloRetorno = pvc.obtener_plan(id);
        }     
        return plandevueloRetorno;
    }
    
    
    
}
