/*********************************************************************
* Class Name:MotorJuego
* Class description: clase que tiene toda la logica para la simulacion de juego
* Author/s name: ABA_BD2_01
***********************************************************************/

import java.util.Stack;
public class MotorJuego implements IMETODOS{
    private Stack<Carta> mazoRobo;          //pila del mazo de robo
    private Stack<Carta> mazoDescartes;     //pila del mazo de descartes
    private Stack<Efecto> mazoEfecto;       //pila del mazo de efectos
    public MotorJuego(){
        this.mazoRobo = new Stack<Carta>();
        this.mazoDescartes = new Stack<Carta>();
        this.mazoEfecto = new Stack<Efecto>();
        llenarMazo(mazoRobo);
    }


/*********************************************************************
* Method name:robar 
*
* Description of the Method: simula robar carta de la pila mazo de robo,
* para ello comprobando que el mazo este vacio, si es asi se comprueba que este vacio,
* si ocurren ambos casos salta una excepcion, llamamos al metodo de reciclaje para quitar una de robo mediante el pop de pilas
* Calling arguments:void
*********************************************************************/
    
    public void robar() throws MazosVaciosException {
        if (mazoRobo.isEmpty()) {
            if (mazoDescartes.isEmpty()) {
                throw new MazosVaciosException("Mazos de robo y de descartes vacios");
            }
            reciclaje(mazoRobo, mazoDescartes);
        }
        mazoRobo.pop();
    }
/*********************************************************************
* Method name:jugar
*
* Description of the Method: crea un objeto efecto y lo añade a la pila efecto mediante push
* Calling arguments:String jugador,Carta carta
*********************************************************************/    
    public void jugar(String jugador,Carta carta){
        Efecto efecto = new Efecto(jugador,carta);      //efecto de la carta
        mazoEfecto.push(efecto);
    }
/*********************************************************************
* Method name:descartar
*
* Description of the Method: descarta una carta a la pila de descartes mediante push
* Calling arguments:Carta carta
*********************************************************************/    

    public void descartar(Carta carta){
        mazoDescartes.push(carta);
    }

/*********************************************************************
* Method name:resolver
*
* Description of the Method: saca del mazo de efecto el efecto usando su 
* toString para obtener su informacion y descartar la carta
* Calling arguments:void
*********************************************************************/ 
    
    public String resolver(){
        String resolucion = "";     //Srting para devolver informacion
        while(!mazoEfecto.isEmpty()){
            Efecto resolverEfecto = mazoEfecto.pop();
            resolucion +=  resolverEfecto.toString();
            mazoDescartes.push(resolverEfecto.getCarta());
        }
        return resolucion;
    }

/*********************************************************************
* Method name:mostrarEstado
*
* Description of the Method: muestra el estado de los mazos en cada turno de la partida
* Calling arguments:void
*********************************************************************/ 

    public String mostrarEstado(){
        String estado = "";    //Srting para devolver informacion
        if(mazoEfecto.isEmpty() && mazoRobo.isEmpty() && mazoDescartes.isEmpty()){
            estado = " Todos los mazos estan vacios";

        }else{
            estado += "Mazo de robo: " + mazoRobo + "\n";
            estado += "Mazo de descartes: " + mazoDescartes + "\n";
            estado += "Pila de efectos: " + mazoEfecto + "\n";
        }
        return estado;

    }

/*********************************************************************
* Method name:llenarMazo
*
* Description of the Method: guarda los diferentes tipos de cartas en un array y lo recorre 
* guardando las cartas en el mazo de robo
* Calling arguments:Stack<Carta> mazoRobo
*********************************************************************/
    
    private  void llenarMazo(Stack<Carta> mazoRobo){
        Carta[] cartas = Carta.values();    //vector de cartas
        for(int i=0;i<cartas.length;i++){
            mazoRobo.push(cartas[i]);
        }

    }

/*********************************************************************
* Method name:reciclaje
*
* Description of the Method: mientras que el mazo de descartes no este vacio saca una carta del mazo
*de descartes y hace push al mazo de robo
* Calling arguments:Stack<Carta> mazoRobo,Stack<Carta> mazoDescartes
*********************************************************************/

    private  void reciclaje(Stack<Carta> mazoRobo,Stack<Carta> mazoDescartes){
        while(!mazoDescartes.isEmpty()){
            Carta cambio =  mazoDescartes.pop();    //variable para intercambiar las cartas de mazo
            mazoRobo.push(cambio);
        }
    }

}
