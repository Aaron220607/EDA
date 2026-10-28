/*********************************************************************
* Class Name:Efecto
* Class description: Clase que representa el objeto de efecto
* Author/s name: ABA_BD2_01
***********************************************************************/

public class Efecto {
    private Carta carta;  //una instancia de carta
    private String jugador;  //nombre del jugador que uso la carta

/*********************************************************************
* Method name:Efecto
*
* Description of the Method: Constructor de efecto
*
* Calling arguments: String jugador y Carta carta
son las variables que forman la clase.
*********************************************************************/

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
