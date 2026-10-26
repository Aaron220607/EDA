/*********************************************************************
* Class Name:Atraccion
* Class description: clase que representa a la atraccion y sus vagones
**********************************************************************/

import java.util.PriorityQueue;
public class Atraccion implements IDATOS{
    private PriorityQueue<Asistente> colaAtraccion;     //cola con prioridad que ordena los asistente
    private int tiempo;                                 //variable que simula la duracion de la atraccion
    private String visitanteMasEspera;                  //visitante que mas espera
    private int horaMaxima;                             //tiempo maximo que a esperado un visitante
    private String informacion;                         //guarda y devuelve la informacion del asistente

    public Atraccion() {
        this.colaAtraccion = new PriorityQueue<Asistente>();
        this.tiempo=0;
        this.visitanteMasEspera = "";
        this.horaMaxima=-1;
        this.informacion="";
    }
    void generarVisitantes(int N, int E, int F, int L) {
        int horaLlegada = N * L;

        for (int j = 0; j < E; j++) {
            Asistente AStandar = new Asistente(Pase.STANDARD, horaLlegada);         //un asistente standar
            colaAtraccion.offer(AStandar);
        }

        for (int j = 0; j < F; j++) {
            Asistente AFast = new Asistente(Pase.FAST_PASS, horaLlegada);           //un asistente con fast pass
            colaAtraccion.offer(AFast);
        }

        Asistente AVip = new Asistente(Pase.VIP, horaLlegada);                      //un asistente con vip pass
        colaAtraccion.offer(AVip);
    }
    void montarAtraccion() {
            for (int i = 0; i < 5 && !colaAtraccion.isEmpty(); i++) {
                Asistente fuera = colaAtraccion.poll();                             //asistente que sale de la atraccion  
                int esperaAsistente = (tiempo - fuera.getHoraLlegada());
                setInformacion(fuera.toString());
                setInformacion("\n");
                if (horaMaxima < esperaAsistente) {
                    visitanteMasEspera = fuera.toString();
                    horaMaxima = esperaAsistente;
                }
            }
            tiempo += TIEMPO_ATRACCION;
    }
    public String simular(int n, int e, int f, int l) {
        int siguienteLote = 0;                                                      //contador de los lotes
        while (siguienteLote < n || !colaAtraccion.isEmpty()) {
            while (siguienteLote < n &&
                    siguienteLote * l <= tiempo) {
                setInformacion("\n--- Lote " + siguienteLote + " (llegada " + (siguienteLote * l) + ") ---\n");
                generarVisitantes(siguienteLote, e, f, l);
                siguienteLote++;
            }

            // Si hay visitantes, comienza un recorrido
            if (!colaAtraccion.isEmpty()) {
                setInformacion("\nRecorrido en el instante " + tiempo + ":\n");
                montarAtraccion();
            } else if (siguienteLote < n) {
                // Avanzar hasta la llegada del siguiente lote
                tiempo = siguienteLote * l;
            }
        }
        return getInformacion();
    }
public String getVisitanteMasEspera(){
        return  visitanteMasEspera;
}
public int getHoraMaxima(){
        return horaMaxima;
}
public void setInformacion(String informacion){
        this.informacion +=informacion;
}
public String getInformacion(){
        return this.informacion;
}
}