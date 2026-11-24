import java.io.IOException;
import java.util.*;
public class main {
    static final Scanner teclado=new Scanner(System.in);
    public static void main(String[] args) {

        Migracion vuelo = new Migracion();

        try {
            System.out.println("Iniciando carga de datos...");

            vuelo.cargar("p5\\escalas_migracion_aves.csv",
            "p5\\vuelos_migracion_aves.csv");

            System.out.println("Datos cargados correctamente.");
            System.out.println("Numero de Escalas: "+vuelo.getNumEscalas());
            System.out.println("Numero de tramos: "+vuelo.getNumTramos());
            System.out.printf("Distancia media en km: %.2f\n",vuelo.getDistanciaKm());
            
        } catch (IOException e) {
            System.out.println("Error al cargar los datos.");
        }
        shellComandos(vuelo);
    }
    public static void shellComandos(Migracion vuelos){
        boolean salir=false;
        char opcion;
        do{
        
            System.out.print("> ");
            opcion=teclado.next().charAt(0);
            salir=true;
        }while(!salir);
    }
}