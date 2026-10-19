
import java.util.*;

public class Main implements IDATOS{
    final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        Atraccion atraccion = new Atraccion();
        elegirValores(atraccion);
        System.out.println(atraccion.getVisitanteMasEspera() + " espero durante: "+atraccion.getHoraMaxima());
    }
    public static void elegirValores(Atraccion atraccion){
        String respuesta;
        int numeroLotes;
        int numeroStandard;
        int numeroFastPass;
        int tiempoEntreLote;
        boolean fallo = true;
        do {
            System.out.println("Desea introducir los valores Predifinido: Indroduzca si o no");
            respuesta = sc.nextLine().toLowerCase();
            switch (respuesta) {
                case "si":
                    System.out.println((atraccion.simular(NUMERO_LOTES, NUMERO_STANDART, NUMERO_FAST_PASS, TIEMPO_LOTE)));
                    fallo = false;
                    break;
                case "no":
                    System.out.println("Introduzca el numero de lotes: ");
                    numeroLotes = numeroCorrecto();
                    System.out.println("Introduzca el numero de standard: ");
                    numeroStandard = numeroCorrecto();
                    System.out.println("Introduzca el numero de fast pass:  ");
                    numeroFastPass = numeroCorrecto();
                    System.out.println("Introduzca el tiempo entre cada lote");
                    tiempoEntreLote = numeroCorrecto();
                    System.out.println((atraccion.simular(numeroLotes, numeroStandard, numeroFastPass, tiempoEntreLote)));
                    fallo = false;
                    break;
                default:
                    System.out.println("Introduzca si o no ");
                    sc.nextLine();
                    fallo = false;
                    break;


            }
        }while(fallo);
    }
    public static int numeroCorrecto(){
        boolean fallo = true;
        int numero = 0;
        do {
            try {
                numero = sc.nextInt();
                fallo = false;
            } catch (InputMismatchException e) {
                System.out.println("Error. Introduzca un entero positivo");
                fallo = true;
                sc.nextLine();

            }
            if(numero<0){
                System.out.println("El numero debe ser positivo");
                fallo = true;
            }
        }while(fallo);
        return numero;
    }
}