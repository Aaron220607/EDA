import java.util.*;
import java.io.*;
/**
 * Class Name: FicheroSecuencial
 * Author/s name: Aaron, Alejandor,Borja
 * Class description: Clase que permite leer un fichero de manera secuencial
 */



public class FicheroSecuencial <T>{
    private Scanner nombreFichero;
    private String separador;
    /**
     * Constructor de la clase FicheroSecuencial
     */
    public FicheroSecuencial(String nombreFichero, String separador) throws FileNotFoundException{
        this.nombreFichero = new Scanner(new File(nombreFichero));
        this.separador = separador;
    }
    /**
     * Metodo que permite cerrar el fichero
     */
    public void cerrarFichero(){
        this.nombreFichero.close();
    }
    /**
     * Metodo que permite saltar una linea del fichero
     */
    public void saltarLinea(){
        this.nombreFichero.nextLine();
    }
    /**
     * Metodo que permite leer una linea del fichero
     */
    public T leerLinea(Lector<T> lector){
        StringTokenizer linea = new StringTokenizer(this.nombreFichero.nextLine(), this.separador);
        return lector.leerLinea(linea);
    }
    /**
     * Metodo que permite saber si se ha llegado al final del fichero
     */
    public boolean finDelFichero(){
        return !this.nombreFichero.hasNextLine();
    }
}