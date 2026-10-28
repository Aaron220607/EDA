/*********************************************************************
* Class Name:MazosVacios
* Class description: excepcion que evita que se mezclen los mazos de descarte y robo si ambos estan vacios
* Author/s name: ABA_BD2_01
***********************************************************************/

public class MazosVaciosException extends RuntimeException {
    public MazosVaciosException(String message) {

        super(message);
    }
}