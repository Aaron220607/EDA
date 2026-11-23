import java.util.StringTokenizer;

public class LectorEscala implements Lector<Escala> {

    public Escala leerLinea(StringTokenizer linea) {
        int id = Integer.parseInt(linea.nextToken());
        String nombre = linea.nextToken();
        String pais = linea.nextToken();
        double lat = Double.parseDouble(linea.nextToken());
        double lon = Double.parseDouble(linea.nextToken());
        Rol rol = Rol.valueOf(linea.nextToken());
        return new Escala(id,nombre,pais,lat,lon,rol);
    }
}