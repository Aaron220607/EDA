import java.util.*;
/**
 * Class Name: FicheroSecuencial
 * Author/s name: Aaron, Alejandor,Borja
 * Class description: Satelite
 */
public class Satelite implements Lector<Satelite> {
    private String OBJECT_NAME;
    private String OBJECT_ID;
    private String EPOCH;
    private String MEAN_MOTION;
    private String ECCENTRICITY;
    private String INCLINATION;
    private String RA_OF_ASC_NODE;
    private String ARG_OF_PERICENTER;
    private String MEAN_ANOMALY;
    private String EPHEMERIS_TYPE;
    private String CLASSIFICATION_TYPE;
    private String NORAD_CAT_ID;
    private String ELEMENT_SET_NO;
    private String REV_AT_EPOCH;
    private String BSTAR;
    private String MEAN_MOTION_DOT;
    private String MEAN_MOTION_DDOT;

    public Satelite leerLinea(StringTokenizer linea) {
        OBJECT_NAME = linea.nextToken();
        OBJECT_ID = linea.nextToken();
        EPOCH = linea.nextToken();
        MEAN_MOTION = linea.nextToken();
        ECCENTRICITY = linea.nextToken();
        INCLINATION = linea.nextToken();
        RA_OF_ASC_NODE = linea.nextToken();
        ARG_OF_PERICENTER = linea.nextToken();
        MEAN_ANOMALY = linea.nextToken();
        EPHEMERIS_TYPE = linea.nextToken();
        CLASSIFICATION_TYPE = linea.nextToken();
        NORAD_CAT_ID = linea.nextToken();
        ELEMENT_SET_NO = linea.nextToken();
        REV_AT_EPOCH = linea.nextToken();
        BSTAR = linea.nextToken();
        MEAN_MOTION_DOT = linea.nextToken();
        MEAN_MOTION_DDOT = linea.nextToken();

        return this;
    }
    public double getRevAtEpoch() {
        return Double.parseDouble(REV_AT_EPOCH);
    }
    public String toString() {
        return "Satelite [OBJECT_NAME=" + OBJECT_NAME + ", OBJECT_ID=" + OBJECT_ID + ", EPOCH=" + EPOCH
                + ", MEAN_MOTION=" + MEAN_MOTION + ", ECCENTRICITY=" + ECCENTRICITY + ", INCLINATION=" + INCLINATION
                + ", RA_OF_ASC_NODE=" + RA_OF_ASC_NODE + ", ARG_OF_PERICENTER=" + ARG_OF_PERICENTER
                + ", MEAN_ANOMALY=" + MEAN_ANOMALY + ", EPHEMERIS_TYPE=" + EPHEMERIS_TYPE
                + ", CLASSIFICATION_TYPE=" + CLASSIFICATION_TYPE + ", NORAD_CAT_ID=" + NORAD_CAT_ID
                + ", ELEMENT_SET_NO=" + ELEMENT_SET_NO + ", REV_AT_EPOCH=" + REV_AT_EPOCH + ", BSTAR=" + BSTAR
                + ", MEAN_MOTION_DOT=" + MEAN_MOTION_DOT + ", MEAN_MOTION_DDOT=" + MEAN_MOTION_DDOT + "]";
    }
}