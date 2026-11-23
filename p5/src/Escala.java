import graphsDS_ESI_UCLM_v2.*;

public class Escala {
    private int id;
    private String nombre;
    private String pais;
    private double latitud;
    private double longitud;
    private Rol rol;

    public Escala(String nombre, int id, String pais, double latitud, double longitud, Rol rol) {
        this.nombre = nombre;
        this.id = id;
        this.pais = pais;
        this.latitud = latitud;
        this.longitud = longitud;
        this.rol = rol;
    }
    public String getID(){
        return String.valueOf(this.id);
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}