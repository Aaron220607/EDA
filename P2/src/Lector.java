/*********************************************************************
* Class Name:Lector
* Class description: interfaz usada para leer linea en el fichero secuencial
***********************************************************************/

import java.util.StringTokenizer;
public interface Lector <T>{
    public T leerLinea(StringTokenizer linea);
}