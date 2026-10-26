import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa la lista electoral de un partido en una circunscripcion
 * determinada.
 * 
 */
public class ListaElectoral {
    private static final int VOTOS_ESCANO = 30000;

    private String partido;
    private String circunscripcion;
    private int votosPartido;
    private List<Candidato> candidatos;

    public ListaElectoral(String partido, String circunscripcion) {
        this.partido = partido;
        this.circunscripcion = circunscripcion;
        this.votosPartido = 0;
        this.candidatos = new ArrayList<>();
    }

/*********************************************************************
* Method name:agregarCandidato
*
* Description of the Method: permite añadir un candidato mediante el add de listas
* Calling arguments:Candidato candidato
*********************************************************************/

    public void agregarCandidato(Candidato candidato) {
        candidatos.add(candidato);
    }

    public String getPartido() {
        return partido;
    }

    public String getCircunscripcion() {
        return circunscripcion;
    }

    public int getVotosPartido() {
        return votosPartido;
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public int getNumHombres() {
        int count = 0;
        for (Candidato c : candidatos) {
            if (c.getGenero() == Genero.H) {
                count++;
            }
        }
        return count;
    }

    public int getNumMujeres() {
        int count = 0;
        for (Candidato c : candidatos) {
            if (c.getGenero() == Genero.M) {
                count++;
            }
        }
        return count;
    }

    public double getPorcentajeHombres() {
        double res = 0;
        if (candidatos.isEmpty()) {
            res = 0;
        } else {
            res = (double) getNumHombres() / candidatos.size() * 100.0;
        }
        return res;
    }

    public double getPorcentajeMujeres() {
        double res = 0;
        if (candidatos.isEmpty()) {
            res = 0;
        } else {
            res = (double) getNumMujeres() / candidatos.size() * 100.0;
        }
        return res;
    }

    public void setVotosPartido(int votosPartido) {
        this.votosPartido = votosPartido;
    }
/*********************************************************************
* Method name:cumpleParidad
*
* Description of the Method: comprueba que los porcentajes de hombres y mujeres estan entre el 40% y el 60%
* Calling arguments:void
*********************************************************************/
    public boolean cumpleParidad() {
        boolean paridad = false;
        double  mujeresPorcentaje = getPorcentajeMujeres();
        double hombrePorcentaje = getPorcentajeHombres();
            if((40<= mujeresPorcentaje && mujeresPorcentaje<=60) && (40<= hombrePorcentaje && hombrePorcentaje<=60)) {
            paridad = true;
        }
        return paridad;
    }

/*********************************************************************
* Method name:calcularEscanos
*
* Description of the Method: calcula los escaños de cada partido
* Calling arguments:void
*********************************************************************/
    
    public int calcularEscanos() {
        int escaños = (getVotosPartido()/VOTOS_ESCANO);
        return escaños;
    }

/*********************************************************************
* Method name:getCandidatosElectos
*
* Description of the Method: crea una lista de candidatos electos recorriendola en funcion
* de los escaños obtenidos y del tamaño de la lista de candidatos añadiendo a la lista los electos por orden de indice
* Calling arguments:void
*********************************************************************/
    
    public List<Candidato> getCandidatosElectos() {
        List<Candidato> candidatosElectos = new ArrayList<>();  //lista de candidatos electos
        int k = calcularEscanos();
            for (int i = 0; i< k && i<candidatos.size(); i++) {
                candidatosElectos.add(candidatos.get(i));
            }
        return candidatosElectos;
    }

    public void mostrarListaCandidatos() {
        System.out.println("Lista electoral de " + partido + " en " + circunscripcion + ":");
        for (Candidato c : candidatos) {
            System.out.println("   " + c.getPosicion() + " " + c.getNombre() + " (" + c.getGenero() + ")");
        }
        System.out.println();
    }
}
