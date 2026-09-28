import java.io.*;

public class Main implements IMETODOS{
    public static void main(String[] args) {
        MotorJuego motorJuego = new MotorJuego();
        try {
            FicheroSecuencial<JugadaCarta> fichero = new FicheroSecuencial<>("acciones.csv", ",");
            JugadaCarta lector = new JugadaCarta();
            while(!fichero.finDelFichero()){
                JugadaCarta jugada = fichero.leerLinea(lector);
                mecanicaJuego(motorJuego,jugada);
                System.out.println(motorJuego.mostrarEstado());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        }
    }
    public static void mecanicaJuego(MotorJuego motorJuego,JugadaCarta jugada){
        System.out.println(jugada.toString());
        String accion = jugada.getAccion().toLowerCase();
        switch (accion){
            case ACCION1:
                try {
                    motorJuego.robar();
                }catch (MazosVaciosException e){
                    System.out.println(e.getMessage());
                }
                break;
            case ACCION2:
                Carta cartaJugada = Carta.valueOf(jugada.getNombreCarta());
                motorJuego.jugar(jugada.getJugador(),cartaJugada);
                break;
            case ACCION3:
                Carta cartaDescartada = Carta.valueOf(jugada.getNombreCarta());
                motorJuego.descartar(cartaDescartada);
                break;
            case ACCION4:
                System.out.println(motorJuego.resolver());
                break;
            default:
                System.out.println("La accion: " + jugada.getAccion() + " no se encuentra" +
                        "disponible");
        }
    }
}
