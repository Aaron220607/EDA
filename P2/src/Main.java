/*********************************************************************
* Class Name:Main
* Class description: clase que llama a motor de juego y asi simular la partida
***********************************************************************/

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
            case ACCION1_ROBAR:
                try {
                    motorJuego.robar();
                }catch (MazosVaciosException e){
                    System.out.println(e.getMessage());
                }
                break;
            case ACCION2_JUGAR:
                try{
                Carta cartaJugada = Carta.valueOf(jugada.getNombreCarta().toUpperCase());
                motorJuego.jugar(jugada.getJugador(),cartaJugada);
                }catch (IllegalArgumentException e){
                        System.out.println("La carta: " + jugada.getNombreCarta() + " no es válida");
                    }
                break;
            case ACCION3_DESCARTAR:
                try {
                    Carta cartaDescartada = Carta.valueOf(jugada.getNombreCarta().toUpperCase());
                    motorJuego.descartar(cartaDescartada);
                } catch (IllegalArgumentException e) {
                    System.out.println("La carta: " + jugada.getNombreCarta() + " no es válida");
                }
                break;
            case ACCION4_RESOLVER:
                System.out.println(motorJuego.resolver());
                break;
            default:
                System.out.println("La accion: " + jugada.getAccion() + " no se encuentra" +
                        "disponible");
        }
    }
}
