/*********************************************************************
* Class Name:Main
* Class description: clase que llama a motor de juego y asi simular la partida
* Author/s name: ABA_BD2_01
***********************************************************************/

import java.io.*;

public class Main implements IMETODOS{
    public static void main(String[] args) {
        MotorJuego motorJuego = new MotorJuego();   //objeto motor q ejecuta la logica
        try {
            FicheroSecuencial<JugadaCarta> fichero = new FicheroSecuencial<>("acciones.csv", ",");  //fichero que contiene las acciones a realizar en la partida
            JugadaCarta lector = new JugadaCarta();  //lecctor de lineas del fichero
            while(!fichero.finDelFichero()){
                JugadaCarta jugada = fichero.leerLinea(lector); //accion jugada
                mecanicaJuego(motorJuego,jugada);
                System.out.println(motorJuego.mostrarEstado());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        }
    }

/*********************************************************************
* Method name:mecanicaJuego
*
* Description of the Method: lee la opcion del fichero y en funcion de esta se realiza una accion u otra mediante motorJuego
*
* Calling arguments: MotorJuego motorJuego,JugadaCarta jugada
*********************************************************************/

    public static void mecanicaJuego(MotorJuego motorJuego,JugadaCarta jugada){
        System.out.println(jugada.toString());
        String accion = jugada.getAccion().toLowerCase(); //tipo de accion valida
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
                Carta cartaJugada = Carta.valueOf(jugada.getNombreCarta().toUpperCase());  //carta usada
                motorJuego.jugar(jugada.getJugador(),cartaJugada);
                }catch (IllegalArgumentException e){
                        System.out.println("La carta: " + jugada.getNombreCarta() + " no es válida");
                    }
                break;
            case ACCION3_DESCARTAR:
                try {
                    Carta cartaDescartada = Carta.valueOf(jugada.getNombreCarta().toUpperCase()); //carta usada
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
