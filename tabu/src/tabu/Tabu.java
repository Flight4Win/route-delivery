/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabu;

/**
 *
 * @author CAlvaC
 */
public class Tabu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    /**
     * @Entrada: solucionInicial: Lista inicial de solución
     * @Salida: mejorSolucion: La mejor solución encontrada
     */
    public void algoritmo(){
        //Copiar primera solucion So = S* = S' = S"        
        //Crear lista tabu        
        //Crear lista de candidatos
        
        //Mientras no se cumpla criterio de parada, Hacer
            //Por cada vecino Sn en los vecindarios de S', Hacer
                //Si NO es candidato, entonces siguiente vecino
                //Si es tabú, entonces ir al siguiente vecino, excepto si cumple criterio de aspiración
                    //Si Sn es factible y f1(Sn) <= f2(s'), entonces S" = Sn
                    //Su Sn es infactible y f2(Sn) <= f2(s'), entonces S" = Sn
            //Fin por cada
        //Aceptar el movimiento haciendo S' = S"
        //Actualizar lista de candidatos
        //Actualizar lista tabú incorporando a la lista el movimiento que generó S'
        //Actualizar penalidades
        //Si S' es factible y f1(S'S) <= f1(S*), entonces S* = S'
    }
    
    /**
     * @Entrada: MatrizDist: Matriz de distancias reales
     * @Salida: SolInicial: Rutas iniciales
     */
    public void solucionInicial(){
        //Calcular ángulos de los clientes y ordenar de manera no decreciente
        //Ordenar los aviones de acuerdo con su capacidad de manera no ascendente
        //Seleecionar primer vehículo
        
        //Mientras exista demanda no stisfecha, hacer
        
            //SI capacidadActual + DemandaPaquete < CapacidadAvion entonces
                //Asignar paquete al avion
            //CapacidadActual = capacidadActual + DemandaPaquete
            //Actualizar CapacidadActual y longitud de la ruta actual            
            //Marcar demanda como satisfecha
            
            //SINO
                //Seleccionar siguiente vehículo
            //FIN SI
        //Fin Mientras
            //Secuencias rutas iniciales usando VMC(vecino más cercano)
    }
    
}
