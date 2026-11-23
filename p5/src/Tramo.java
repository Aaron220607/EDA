public class Tramo {

    private final double distanciaKm;
    private final double probExito;

    public Tramo(double distanciaKm, double probExito) {
        this.distanciaKm = distanciaKm;
        this.probExito = probExito;
    }


    public Tramo(double distanciaKm) {
        this(distanciaKm, Double.NaN);
    }


    public double getDistanciaKm() { return distanciaKm; }

    public double getProbExito() { return probExito; }
}
