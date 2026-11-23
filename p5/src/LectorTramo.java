import java.util.StringTokenizer;


public class LectorTramo implements Lector<Tramo> {
        public Tramo leerLinea(StringTokenizer linea) {
        int idOrigen = Integer.parseInt(linea.nextToken());
        linea.nextToken();
        int idDestino = Integer.parseInt(linea.nextToken());
        linea.nextToken();
        double distanciaKm =Double.parseDouble(linea.nextToken());
        double probExito = Double.parseDouble(linea.nextToken());
        double probFracaso= Double.parseDouble(linea.nextToken());
        return new Tramo(idOrigen,idDestino,distanciaKm,probExito,probFracaso);
    }
}


