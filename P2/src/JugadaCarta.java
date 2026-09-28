import java.util.StringTokenizer;

public class JugadaCarta implements Lector<JugadaCarta>{
    private String jugador;
    private String accion;
    private String nombreCarta;

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
