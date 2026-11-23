import graphsDS_ESI_UCLM_v2.*;

import java.io.*;

public class Migracion {
    public void cargar(String ficheroEscalas, String ficheroVuelos) throws IOException {
        Graph<Escala,Tramo> g = new TreeMapGraph<Escala, Tramo>();
        FicheroSecuencial<Escala> ficheroEscala = new FicheroSecuencial<Escala>(ficheroEscalas,",");
        try{
            ficheroEscala.saltarLinea();
            while(!ficheroEscala.finDelFichero()){
                Escala  escala = ficheroEscala.leerLinea(new LectorEscala());
                Vertex<Escala> v = g.insertVertex(escala);
            }
        }catch (Exception e){
            throw new IOException("No se ha encontrado los ficheros");
        }
        finally {
            ficheroEscala.cerrarFichero();
        }

    }
}
