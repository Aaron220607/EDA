import java.util.Stack;

public interface IMETODOS{
    String ACCION1 = "robar";
    String ACCION2 = "jugar";
    String ACCION3 = "descartar";
    String ACCION4 = "resolver";

    public default void llenarMazo(Stack mazoRobo){
        Carta[] cartas = Carta.values();
        for(int i=0;i<cartas.length;i++){
            mazoRobo.push(cartas[i]);
        }

    }
    public default void reciclaje(Stack mazoRobo,Stack mazoDescartes){
        while(!mazoDescartes.isEmpty()){
            Carta cambio = (Carta) mazoDescartes.pop();
            mazoRobo.push(cambio);
        }
    }
}