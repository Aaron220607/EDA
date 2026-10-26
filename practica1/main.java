package practica1;

import java.util.*;

public class main {

    public static void main(String[] args) {

        Stack<Carta> robo = new Stack<>();
        Stack<Carta> descarte = new Stack<>();
        Stack<Carta> efectos = new Stack<>();
        String[] jugadores=new String[];


        Mazos mazos = new Mazos(robo, descarte, efectos);

        robo_ini(robo);
        robar(jugador1, robo);
    }

    public static void robo_ini(Stack<Carta> robo) {

        robo.push(Carta.GOLPE_CRITICO);
        robo.push(Carta.RAYO_CONGELANTE);
        robo.push(Carta.BARRERA_DE_HIELO);
        robo.push(Carta.POCION_DE_VIDA);
        robo.push(Carta.CONTRAHECHIZO);
        robo.push(Carta.ESCUDO_MAGICO);
        robo.push(Carta.BOLA_DE_FUEGO);
    }
    public static  void robar(String[] jugador,Stack<Carta> robo){
        jugador=robo.pop();
        
    }
}