import java.io.IOException;
import java.util.*;

import utils.SequentialFile;

/**
 * Programa principal para la gestion, verificacion y asignacion de candidaturas
 * electorales.
 * Author/s name: ABA_BD2_01
 * 
 */
public class GestionElectoral {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String rutaFichero = "candidaturas.csv";
        String separador = ";";
        List<Candidato> todosCandidatos = new ArrayList<>();
        ListaElectoral BBMadrid = new ListaElectoral("BB", "Madrid");
        ListaElectoral BBBarcelona = new ListaElectoral("BB", "Barcelona");
        ListaElectoral BSOEMadrid = new ListaElectoral("BSOE", "Madrid");
        ListaElectoral BSOEBarcelona = new ListaElectoral("BSOE", "Barcelona");

        // Lectura del fichero CSV
        System.out.println("==========================================================");
        System.out.println("  SISTEMA DE GESTION ELECTORAL - CURSO 2026/27 (S04)");
        System.out.println("==========================================================");
        System.out.println("Cargando candidaturas desde: " + rutaFichero + "...\n");
        procesarArchivoCSV(rutaFichero, separador, todosCandidatos);
        System.out.println("Se han cargado correctamente " + todosCandidatos.size() + " registros de candidatos.\n");
        // generar listas electorales
        generarListasElectorales(todosCandidatos, BBMadrid, BBBarcelona, BSOEMadrid, BSOEBarcelona);
        // mostrar listas electorales
        mostrarListasElectorales(BBMadrid, BBBarcelona, BSOEMadrid, BSOEBarcelona);
        // comprobar paridad en listas electorales y mostrar alertas
        verificarParidad(BBMadrid, BBBarcelona, BSOEMadrid, BSOEBarcelona);
        // obtener votos de cada candidatura
        obtenerVotos(BBMadrid, BBBarcelona, BSOEMadrid, BSOEBarcelona);
        // obtener escaños de cada partido en cada circunscripción
        obtenerEscanos(BBMadrid, BBBarcelona, BSOEMadrid, BSOEBarcelona);
        // mostrar candidatos electos
        mostrarCandidatosElectos(BBMadrid, BBBarcelona, BSOEMadrid, BSOEBarcelona);
    }

    private static void procesarArchivoCSV(String rutaFichero, String separador, List<Candidato> todosCandidatos) {
        try {
            SequentialFile<Candidato> sf = new SequentialFile<Candidato>(rutaFichero, separador);
            while (!sf.isEndOfFile()) {
                Candidato candidato = new Candidato();
                sf.read(candidato);
                todosCandidatos.add(candidato);
            }
            sf.close();
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

/*********************************************************************
* Method name:generarListasElectorales
*
* Description of the Method: recorre los candidatos creando un objeto candidato para sacarlo del array y compara a que partido pertenece
* y su circunscripcion añadiendolo a la lista correspondiente
* Calling arguments:List<Candidato> todosCandidatos, ListaElectoral bBMadrid,
* ListaElectoral bBBarcelona, ListaElectoral bSOEMadrid, ListaElectoral bSOEBarcelona
*********************************************************************/ 

    private static void generarListasElectorales(List<Candidato> todosCandidatos, ListaElectoral bBMadrid,
            ListaElectoral bBBarcelona, ListaElectoral bSOEMadrid, ListaElectoral bSOEBarcelona) {
        for (int i = 0; i < todosCandidatos.size(); i++) {
            Candidato cGenerico = todosCandidatos.get(i);       //candidato cualquiera
            if (cGenerico.getPartido().equalsIgnoreCase("BB")) {
                if (cGenerico.getCircunscripcion().equalsIgnoreCase("Madrid")) {
                    bBMadrid.agregarCandidato(cGenerico);
                } else {
                    bBBarcelona.agregarCandidato(cGenerico);
                }
            } else {
                if (cGenerico.getCircunscripcion().equalsIgnoreCase("Madrid")) {
                    bSOEMadrid.agregarCandidato(cGenerico);
                } else {
                    bSOEBarcelona.agregarCandidato(cGenerico);
                }
            }
        }
        Collections.sort(bBMadrid.getCandidatos());
        Collections.sort(bBBarcelona.getCandidatos());
        Collections.sort(bSOEMadrid.getCandidatos());
        Collections.sort(bSOEBarcelona.getCandidatos());
    }

    private static void mostrarListasElectorales(ListaElectoral bBMadrid, ListaElectoral bBBarcelona,
            ListaElectoral bSOEMadrid, ListaElectoral bSOEBarcelona) {
        System.out.println("----------------------------------------------------------");
        System.out.println("1. LISTADOS DE CANDIDATURAS");
        System.out.println("----------------------------------------------------------");
        bBMadrid.mostrarListaCandidatos();
        bSOEMadrid.mostrarListaCandidatos();
        bBBarcelona.mostrarListaCandidatos();
        bSOEBarcelona.mostrarListaCandidatos();
    }

/*********************************************************************
* Method name:verificarParidad
*
* Description of the Method: genera una lista para comparar la paridad de los
* candidatos, si un candidato no la cumple lo elimina de la lista
* Calling arguments:ListaElectoral BBMadrid, ListaElectoral BBBarcelona,
* ListaElectoral BSOEMadrid, ListaElectoral BSOEBarcelona
*********************************************************************/ 

    private static void verificarParidad(ListaElectoral BBMadrid, ListaElectoral BBBarcelona,
            ListaElectoral BSOEMadrid, ListaElectoral BSOEBarcelona) {
        System.out.println("----------------------------------------------------------");
        System.out.println("2. ALERTAS DE PARIDAD EN CANDIDATURAS");
        System.out.println("----------------------------------------------------------");
        List<ListaElectoral> noCumplenParidad = new ArrayList<>();          //lista para verificar paridad
        noCumplenParidad.add(BBBarcelona);
        noCumplenParidad.add(BBMadrid);
        noCumplenParidad.add(BSOEBarcelona);
        noCumplenParidad.add(BSOEMadrid);
        Iterator<ListaElectoral> paridad = noCumplenParidad.iterator();     //iterador para comparar paridad
        while (paridad.hasNext()){
            ListaElectoral l1 = paridad.next();
            if(l1.cumpleParidad()){
                paridad.remove();
            }
        }
        mostrarAlertasParidad(noCumplenParidad);
    }

/*********************************************************************
* Method name:mostrarAlertasParidad
*
* Description of the Method:recorre la lista de alertas e imprime por pantalla los datos del partido que no cumpla
* la paridad, mostrando los porcentages de cada genero
* Calling arguments:List<ListaElectoral> listasAlertas
*********************************************************************/

    private static void mostrarAlertasParidad(List<ListaElectoral> listasAlertas) {
        if (!listasAlertas.isEmpty()){
            for (ListaElectoral l : listasAlertas) {
                System.out.println(" El partido: " + l.getPartido() + " Con circunscripcion en " + l.getCircunscripcion());
                System.out.println(" No cumple la paridad pues sus candidatos son ");
                System.out.printf("%.2f", l.getPorcentajeHombres());
                System.out.println("% de hombres ");
                System.out.printf("%.2f", l.getPorcentajeMujeres());
                System.out.println("% de mujeres ");
            }
    }else {
            System.out.println("Todos los partidos cumplen la paridad");
        }
    }

    private static void obtenerVotos(ListaElectoral bBMadrid, ListaElectoral bBBarcelona, ListaElectoral bSOEMadrid,
            ListaElectoral bSOEBarcelona) {
        System.out.println("----------------------------------------------------------");
        System.out.println("3. RECUENTO DE VOTACIONES");
        System.out.println("----------------------------------------------------------");
        bBMadrid.setVotosPartido(leerNumeroVotos("BB", "Madrid"));
        bSOEMadrid.setVotosPartido(leerNumeroVotos("BSOE", "Madrid"));
        bBBarcelona.setVotosPartido(leerNumeroVotos("BB", "Barcelona"));
        bSOEBarcelona.setVotosPartido(leerNumeroVotos("BSOE", "Barcelona"));
    }

    private static void obtenerEscanos(ListaElectoral bBMadrid, ListaElectoral bBBarcelona, ListaElectoral bSOEMadrid,
            ListaElectoral bSOEBarcelona) {
        System.out.println("----------------------------------------------------------");
        System.out.println("4. RECUENTO DE ESCAÑOS");
        System.out.println("----------------------------------------------------------");
        System.out.println("BB en Madrid obtiene " + bBMadrid.calcularEscanos() + " escaños");
        System.out.println("BSOE en Madrid obtiene " + bSOEMadrid.calcularEscanos() + " escaños");
        System.out.println("BB en Barcelona obtiene " + bBBarcelona.calcularEscanos() + " escaños");
        System.out.println("BSOE en Barcelona obtiene " + bSOEBarcelona.calcularEscanos() + " escaños");
    }

    private static void mostrarCandidatosElectos(ListaElectoral bBMadrid, ListaElectoral bBBarcelona,
            ListaElectoral bSOEMadrid, ListaElectoral bSOEBarcelona) {
        System.out.println("----------------------------------------------------------");
        System.out.println("5. CANDIDATOS ELECTOS POR PARTIDO Y CIRCUNSCRIPCIÓN");
        System.out.println("----------------------------------------------------------");
        mostrarListaElectos("BB", "Madrid", bBMadrid.getCandidatosElectos());
        mostrarListaElectos("BSOE", "Madrid", bSOEMadrid.getCandidatosElectos());
        mostrarListaElectos("BB", "Barcelona", bBBarcelona.getCandidatosElectos());
        mostrarListaElectos("BSOE", "Barcelona", bSOEBarcelona.getCandidatosElectos());
    }

/*********************************************************************
* Method name:mostrarListaElectos
*
* Description of the Method: recorre la lista de electos e imprime la informacion por pantalla
* Calling arguments:String partido, String circunscripcion, List<Candidato> electos
*********************************************************************/

    private static void mostrarListaElectos(String partido, String circunscripcion, List<Candidato> electos) {
        System.out.println("---------------------------------------------------");
        System.out.println("   CANDIDATOS ELECTOS DE: "+partido+"   "+circunscripcion.toUpperCase());
        System.out.println("---------------------------------------------------");
        if(!electos.isEmpty()) {
            for (Candidato c : electos) {
                System.out.println(c.toString());
            }
        }else{
            System.out.println("ESTE PARTIDO NO TIENE ESCAÑOS POR LO QUE NO HAY ELECTOS");
        }
    }

    private static int leerNumeroVotos(String partido, String circunscripcion) {
        int numero = -1;
        boolean valido = false;
        do {
            System.out.print("Introduce los votos de " + partido + " en " + circunscripcion + "(>=0): ");
            try {
                numero = Integer.parseInt(sc.nextLine().trim());

                if (numero >= 0) {
                    valido = true;
                } else {
                    System.out.println("Error: el número no puede ser negativo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: introduce un entero válido dentro del rango de int.");
            }
        } while (!valido);
        return numero;
    }
}
