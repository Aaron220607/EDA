import graphsDS_ESI_UCLM_v2.*;

import java.io.*;

public class Migracion {
    public void cargar(String ficheroEscalas, String ficheroVuelos) throws IOException {
        Graph<Escala,Tramo> g = new TreeMapGraph<Escala, Tramo>();
        try{
            FicheroSecuencial<Escala> ficheroEscala = new FicheroSecuencial<>(ficheroEscalas,",");

        }catch (Exception e){
            throw new IOException("No se ha encontrado los ficheros");
        }

    }
}
