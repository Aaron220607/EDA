import java.util.Stack;
public class MotorJuego implements IMETODOS{
    private Stack<Carta> mazoRobo;
    private Stack<Carta> mazoDescartes;
    private Stack<Efecto> mazoEfecto;
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
        Efecto efecto = new Efecto(jugador,carta);
        mazoEfecto.push(efecto);
    }
    public void descartar(Carta carta){
        mazoDescartes.push(carta);
    }
    public String resolver(){
        String resolucion = "";
        while(!mazoEfecto.isEmpty()){
            Efecto resolverEfecto = mazoEfecto.pop();
            resolucion +=  resolverEfecto.toString();
            mazoDescartes.push(resolverEfecto.getCarta());
        }
        return resolucion;
    }
    public String mostrarEstado(){
        String estado = "";
        if(mazoEfecto.isEmpty() && mazoRobo.isEmpty() && mazoDescartes.isEmpty()){
            estado = " Todos los mazos estan vacios";

        }else{
            estado += "Mazo de robo: " + mazoRobo + "\n";
            estado += "Mazo de descartes: " + mazoDescartes + "\n";
            estado += "Pila de efectos: " + mazoEfecto + "\n";
        }
        return estado;

    }

}
