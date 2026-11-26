import graphsDS_ESI_UCLM_v2.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Migracion {
    
    private Graph<Escala,Tramo> grafoVuelos;
    private Graph<Escala,Tramo> grafoAdicional;
        



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
        grafoAdicional=null;
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

    public void CreargrafoConecto(double n) {

        Graph<Escala, Tramo> g = new TreeMapGraph<>();
        List<Vertex<Escala>> original = new ArrayList<>();
        Iterator<Vertex<Escala>> vertices = grafoVuelos.getVertices();
        while (vertices.hasNext()) {
            Vertex<Escala> vertex = vertices.next();
            original.add(vertex);
            g.insertVertex(vertex.getData());
        }
        for (int i = 0; i < original.size(); i++) {
            Vertex<Escala> v1 = original.get(i);
            for (int j = i + 1; j < original.size(); j++) {
                Vertex<Escala> v2 = original.get(j);
                    double distancia = calcularDistancia(
                        v1.getData(), v2.getData());
                    
                    if (distancia <= n) {
                        Tramo tramo = buscarTramo(grafoVuelos, v1, v2);
                        if (tramo == null || tramo.getProbExito()>=0.95) {
                            Tramo nuevoTramo = new Tramo(v1.getData().getId(), v2.getData().getId(), distancia);
                            g.insertEdge(g.getVertex(v1.getID()),g.getVertex(v2.getID()),nuevoTramo);
                            
                            
                        }
                    }
                }
            }

        grafoAdicional = g;
    }

    public double calcularDistancia(Escala e1, Escala e2) {
        double latm = Math.toRadians((e1.getLatitud() + e2.getLatitud()) / 2.0);
        double dLat = e2.getLatitud() - e1.getLatitud();
        double dLon = (e2.getLongitud() - e1.getLongitud()) * Math.cos(latm);
        return 111.32 * Math.sqrt(dLat * dLat + dLon * dLon);
    }

    public Tramo buscarTramo(Graph<Escala,Tramo> grafo, Vertex<Escala> origen, Vertex<Escala> destino) {
        Iterator<Edge<Tramo>> aristas = grafo.incidentEdges(origen);
        Tramo aristaBuscar=null;
        while (aristas.hasNext()) {
            Edge<Tramo> arista = aristas.next();
            if (grafo.opposite(origen, arista).getID() == destino.getID()) {
                aristaBuscar = arista.getData();
            }
        }
        return aristaBuscar;
    }
}
