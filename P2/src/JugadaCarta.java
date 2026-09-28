import java.util.StringTokenizer;

public class JugadaCarta implements Lector<JugadaCarta>{
    private String Jugador;
    private String accion;
    private String nombreCarta;

    public JugadaCarta leerLinea(StringTokenizer linea){
        Jugador = linea.nextToken();
        accion = linea.nextToken();
        nombreCarta = linea.nextToken();
        return this;
    }
}
