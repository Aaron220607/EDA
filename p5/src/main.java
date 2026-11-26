import java.io.IOException;
import java.util.*;
public class main {
    static final Scanner teclado=new Scanner(System.in);
    public static void main(String[] args) {

        Migracion vuelo = new Migracion();

        try {
            System.out.println("Iniciando carga de datos...");

            vuelo.cargar("./data/escalas_migracion_aves.csv",
            "./data/vuelos_migracion_aves.csv");

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
        String opcion;
        double distancia;
        do{
        
            System.out.print("> ");
            opcion=teclado.nextLine();
            List <String> listaOpciones = new LinkedList<String>(Arrays.asList(opcion.split(" ")));
            switch (listaOpciones.getFirst()) {
                case "c":
                    try {
                        listaOpciones.removeFirst();
                        vuelos.CreargrafoConecto(Double.parseDouble(listaOpciones.getFirst()));
                        System.out.print("negra ");
                    }catch (NumberFormatException e){
                        System.out.printf("Error %s debe ser un numero\n",listaOpciones.getFirst());
                        listaOpciones.removeFirst();
                    }
                    break;
                case "v":

                    break;
                case "s":
                    salir=true;
                    break;

                default:
                    System.out.println("opcion invalida ");
                    break;
            }

            
        }while(!salir);
    }
}