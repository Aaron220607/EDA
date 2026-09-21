import java.io.FileNotFoundException;

public class Main{
    public static void main(String[] args) {
        try {
            FicheroSecuencial<Satelite> fichero = new FicheroSecuencial<>("weather.csv", ",");
            Satelite lector = new Satelite();
            fichero.saltarLinea(); // Saltar la primera línea (cabecera)
            while (!fichero.finDelFichero()) {
                Satelite satelite = fichero.leerLinea(lector);
                System.out.println(satelite);
            }
            fichero.cerrarFichero();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado");
        }
    }
}