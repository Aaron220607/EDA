import java.io.IOException;

public class maine {
    public static void main(String[] args) {

        Migracion vuelo = new Migracion();

        try {
            System.out.println("Iniciando carga de datos...");

            vuelo.cargar("P5/escalas_migracion_aves.csv",
            "P5/vuelos_migracion_aves.csv");

            System.out.println("Datos cargados correctamente.");

        } catch (IOException e) {
            System.out.println("Error al cargar los datos.");
            e.printStackTrace();
        }
    }
}