/*********************************************************************
* Class Name:Efecto
* Class description: Clase que representa el objeto de efecto
***********************************************************************/

public class Efecto {
    private Carta carta;  //una instancia de carta
    private String jugador;  //nombre del jugador q uso la carta
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
