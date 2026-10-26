/*********************************************************************
* Class Name:Main
* Class description: tiene la simulacion de los vagones y los asistentes mostrando los datos por pantalla
**********************************************************************/

import java.util.*;

public class Main implements IDATOS{
    final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        Atraccion atraccion = new Atraccion();      //la atraccion a simular
        elegirValores(atraccion);
        System.out.println("El visitante que mas espero fue: ");
        System.out.println(atraccion.getVisitanteMasEspera() + " espero durante: "+atraccion.getHoraMaxima());
    }
    public static void elegirValores(Atraccion atraccion){
        String respuesta;       //string de si o no para usar valores por defecto 
        int numeroLotes;        //cantidad de lotes
        int numeroStandard;     //asistentes en un lote
        int numeroFastPass;     //numero de fast pass en un lote
        int tiempoEntreLote;    //tiempo que tarda un lote
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
                    numeroLotes = introducirValor("Introduzca el numero de lotes: ");
                    numeroStandard = introducirValor("Introduzca el numero de standard: ");
                    numeroFastPass = introducirValor("Introduzca el numero de fast pass:  ");
                    tiempoEntreLote = introducirValor("Introduzca el tiempo entre cada lote");
                    System.out.println((atraccion.simular(numeroLotes, numeroStandard, numeroFastPass, tiempoEntreLote)));
                    fallo = false;
                    break;
                default:
                    System.out.println("Introduzca si o no ");
                    break;


            }
        }while(fallo);
    }
    public static int introducirValor(String mensaje){
        System.out.println(mensaje);
        int valor = numeroCorrecto();   //numero para los datos por pantalla
        return valor;
    }
    public static int numeroCorrecto(){
        boolean fallo = true;
        int numero = 0;
        do {
            try {
                numero = sc.nextInt();
                
                if(numero<0){
                System.out.println("El numero debe ser positivo");
                fallo = true;
            }else{
                fallo = false;
            }
            } catch (InputMismatchException e) {
                System.out.println("Error. Introduzca un entero positivo");
                fallo = true;
                sc.nextLine();

            }
            
        }while(fallo);
        return numero;
    }
}
// hola me llamo lin y soy chino