/*********************************************************************
* Class Name:JugadaCarta
* Class description: es la clase que relaciona al jugador y a la carta que esta usando
**********************************************************************
*/


import java.util.StringTokenizer;

public class JugadaCarta implements Lector<JugadaCarta>{
    private String jugador;     //nombre del jugador
    private String accion;      //nombre de accion
    private String nombreCarta; //nombre de la carta usada

    public JugadaCarta leerLinea(StringTokenizer linea){
        jugador = linea.nextToken();
        accion = linea.nextToken();
        if(linea.hasMoreTokens()){
            nombreCarta = linea.nextToken();
        } else{
            nombreCarta = null;
        }

        return this;
    }
    public String getJugador(){
        return jugador;
    }
    public String getNombreCarta(){
        return nombreCarta;
    }
    public String getAccion(){
        return accion;
    }
    public String toString(){
        return "El jugador: " + jugador + " uso la accion de: " + accion;
    }
}
