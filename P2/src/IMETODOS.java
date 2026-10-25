import java.util.Stack;

public interface IMETODOS{
    String ACCION1_ROBAR = "robar";
    String ACCION2_JUGAR = "jugar";
    String ACCION3_DESCARTAR = "descartar";
    String ACCION4_RESOLVER = "resolver";

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