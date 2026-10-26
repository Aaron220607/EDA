/*********************************************************************
* Class Name:MotorJuego
* Class description: clase que tiene toda la logica para la simulacion de juego
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

    public void robar() throws MazosVaciosException {
        if (mazoRobo.isEmpty()) {
            if (mazoDescartes.isEmpty()) {
                throw new MazosVaciosException("Mazos de robo y de descartes vacios");
            }
            reciclaje(mazoRobo, mazoDescartes);
        }
        mazoRobo.pop();
    }
    public void jugar(String jugador,Carta carta){
        Efecto efecto = new Efecto(jugador,carta);      //efecto de la carta
        mazoEfecto.push(efecto);
    }
    public void descartar(Carta carta){
        mazoDescartes.push(carta);
    }
    public String resolver(){
        String resolucion = "";     //Srting para devolver informacion
        while(!mazoEfecto.isEmpty()){
            Efecto resolverEfecto = mazoEfecto.pop();
            resolucion +=  resolverEfecto.toString();
            mazoDescartes.push(resolverEfecto.getCarta());
        }
        return resolucion;
    }
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
    private  void llenarMazo(Stack<Carta> mazoRobo){
        Carta[] cartas = Carta.values();    //vector de cartas
        for(int i=0;i<cartas.length;i++){
            mazoRobo.push(cartas[i]);
        }

    }
    private  void reciclaje(Stack<Carta> mazoRobo,Stack<Carta> mazoDescartes){
        while(!mazoDescartes.isEmpty()){
            Carta cambio =  mazoDescartes.pop();    //variable para intercambiar las cartas de mazo
            mazoRobo.push(cambio);
        }
    }

}
