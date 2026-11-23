public class Tramo {
    private  int idOrigen;
    private int idDestino;
    private  double distanciaKm;
    private  double probExito;
    private  double probFracaso;

    public Tramo(int idOrigen, int idDestino, double distanciaKm, double probExito,double probFracaso ) {
        this.idOrigen = idOrigen;
        this.idDestino = idDestino;
        this.distanciaKm = distanciaKm;
        this.probExito = probExito;
        this.probFracaso = probFracaso;
    }

    public double getDistanciaKm() { return distanciaKm; }

    public double getProbExito() { return probExito; }

    public int getIdOrigen() {
        return idOrigen;
    }

    public int getIdDestino() {
        return idDestino;
    }
}
