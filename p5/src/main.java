import java.io.IOException;

public class main {
    public static void main(String[] args) {

        Migracion vuelo = new Migracion();

        try {
            System.out.println("Iniciando carga de datos...");

            vuelo.cargar("escalas_migracion_aves.csv",
            "vuelos_migracion_aves.csv");

            System.out.println("Datos cargados correctamente.");
            System.out.println("Numero de Escalas: "+vuelo.getNumEscalas());
            System.out.println("Numero de tramos: "+vuelo.getNumTramos());
            System.out.printf("Distancia media en km: %.2f",vuelo.getDistanciaKm());
        } catch (IOException e) {
            System.out.println("Error al cargar los datos.");
        }
    }
}