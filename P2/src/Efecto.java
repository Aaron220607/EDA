public class Efecto {
    private Carta carta;
    private String jugador;
    public Efecto(String jugador,Carta carta){
        this.carta=carta;
        this.jugador=jugador;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }
    public String toString(){
        return "Jugador: " + jugador + " tipo de carta " + getCarta();
    }
}
