import java.util.Stack;

public interface IMETODOS{

    public default void llenarMazo(Stack mazoRobo){
        Carta[] cartas = Carta.values();
        for(int i=0;i<cartas.length;i++){
            mazoRobo.push(cartas[i]);
        }

    }
    public default void reciclaje(Stack mazoRobo,Stack mazoDescartes){
        while(mazoDescartes.empty()){
            Carta cambio = (Carta) mazoDescartes.pop();
            mazoRobo.push(cambio);
        }
    }
}