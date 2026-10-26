package practica1;

import java.util.*;

public class Mazos {
    private  Stack<Carta> robo = new Stack<>();
    private Stack<Carta> descarte =new Stack<>();
    private Stack<Carta> efectos =new Stack<>();


    public Mazos(Stack<Carta> robo,Stack<Carta> descarte,Stack<Carta> efectos){
        this.robo=robo;
        this.descarte=descarte;
        this.efectos=efectos;
    }

    public void setDescarte(Stack<Carta> descarte) {
        this.descarte = descarte;
    }
    public void setEfectos(Stack<Carta> efectos) {
        this.efectos = efectos;
    }
    public void setRobo(Stack<Carta> robo) {
        this.robo = robo;
    }
    public Stack<Carta> getDescarte() {
        return descarte;
    }
    public Stack<Carta> getEfectos() {
        return efectos;
    }
    public Stack<Carta> getRobo() {
        return robo;
    }
}
