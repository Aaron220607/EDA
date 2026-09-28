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
        if (mazoRobo.empty()) {
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

}
