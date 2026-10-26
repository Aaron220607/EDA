/*********************************************************************
* Class Name:Asistente
* Class description: clase que representa a los asistentes de la atraccion
**********************************************************************/

public class Asistente implements Comparable <Asistente>{
    private static int contador = 0;
    private  int id;
    private Pase pase;
    private int horaLlegada;
    public Asistente(Pase pase, int horaLlegada){
        contador++;
        this.id = contador;
        this.pase = pase;
        this.horaLlegada=horaLlegada;
    }
    public Pase getPase(){
        return pase;
    }
    public int getHoraLlegada(){
        return horaLlegada;
    }

    public int getId() {
        return id;
    }
    public String toString(){
        return " Asistente con id: "+ id + " tipo de pase: " + pase
                + " hora de llegada - " + horaLlegada;
    }
    public  int compareTo (Asistente otro){
        int comparacion;
    int porPase = this.pase.compareTo(otro.getPase());
    if(porPase !=0){
        comparacion = porPase;
    }else{
        int porTiempo = this.horaLlegada - otro.horaLlegada;
        if ( porTiempo!=0){
            comparacion = porTiempo;
        }else{
            comparacion = this.id - otro.id;
        }
    }
    return comparacion;
    }
}
