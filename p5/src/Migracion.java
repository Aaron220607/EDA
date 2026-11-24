import graphsDS_ESI_UCLM_v2.*;

import java.io.*;
import java.util.Iterator;

public class Migracion {
    
    private Graph<Escala,Tramo> grafoVuelos;

        



    public void cargar(String ficheroEscalas, String ficheroVuelos) throws IOException {
        Graph<Escala,Tramo> g = new TreeMapGraph<Escala, Tramo>();
        FicheroSecuencial<Escala> ficheroEscala = new FicheroSecuencial<Escala>(ficheroEscalas,",");
        FicheroSecuencial<Tramo> ficheroTramo = new FicheroSecuencial<Tramo>(ficheroVuelos,",");
        try{
            ficheroEscala.saltarLinea();
            while(!ficheroEscala.finDelFichero()){
                Escala  escala = ficheroEscala.leerLinea(new LectorEscala());
                Vertex<Escala> v = g.insertVertex(escala);
            }
            }catch (Exception e) {
                
                throw new IOException("Error al cargar las escalas", e);
            }
        finally {
            ficheroEscala.cerrarFichero();
        }
        try{
            ficheroTramo.saltarLinea();
            while (!ficheroTramo.finDelFichero()) {
                Tramo tramo =ficheroTramo.leerLinea(new LectorTramo());
                Vertex<Escala> origen=g.getVertex(String.valueOf(tramo.getIdOrigen()));
                Vertex<Escala> destino=g.getVertex(String.valueOf(tramo.getIdDestino()));
                if (origen != null && destino != null && !g.areAdjacent(origen, destino)) {
                    Edge<Tramo> arista = g.insertEdge(origen, destino,tramo);
        
                }
                
            }
            }catch (Exception e) {
                
                throw new IOException("Error al cargar los tramos", e);
            }finally {
            ficheroTramo.cerrarFichero();
        }
        grafoVuelos=g;
    }
    public int getNumEscalas(){
        return grafoVuelos.getN();
    }
    public int getNumTramos(){
        return grafoVuelos.getM();
    }
    public double getDistanciaKm(){
        double suma = 0;
        double resultado = 0;
        Iterator<Edge<Tramo>> it = grafoVuelos.getEdges();
        while (it.hasNext()) {
            suma += it.next().getData().getDistanciaKm();
        }
        if (grafoVuelos.getM() == 0) {
            resultado = 0;
        } else {
            resultado = suma / grafoVuelos.getM();
        }
    return  resultado;
   }
}
