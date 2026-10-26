/*********************************************************************
* Class Name:Asistente
* Class description: clase que representa a los asistentes de la atraccion
**********************************************************************/

public class Asistente implements Comparable <Asistente>{
    private static int contador = 0;    //variable que sirve como id auxiliar auto incrementativo de los asistentes
    private  int id;                    //id de los asistentes
    private Pase pase;                  //pase del asistente
    private int horaLlegada;            //hora de entrada a la cola
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
        int comparacion;                                        //comparador de prioridad
    int porPase = this.pase.compareTo(otro.getPase());          //comparadod de tipo de pase
    if(porPase !=0){
        comparacion = porPase;
    }else{
        int porTiempo = this.horaLlegada - otro.horaLlegada;    //comparador de tiempo 
        if ( porTiempo!=0){
            comparacion = porTiempo;
        }else{
            comparacion = this.id - otro.id;
        }
    }
    return comparacion;
    }
}
