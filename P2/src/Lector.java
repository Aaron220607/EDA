/*********************************************************************
* Class Name:Lector
* Class description: interfaz usada para leer linea en el fichero secuencial
* Author/s name: ABA_BD2_01
***********************************************************************/

import java.util.StringTokenizer;
public interface Lector <T>{
    public T leerLinea(StringTokenizer linea);
}