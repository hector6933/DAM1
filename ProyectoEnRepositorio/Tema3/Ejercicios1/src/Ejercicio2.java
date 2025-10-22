import java.util.Scanner;
public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        String opcion;
        System.out.println("Introduce un día de la semana");
        opcion = leer.next();
        leer.nextLine();

        switch (opcion.toUpperCase()) {

            case "LUNES":
                System.out.println("Actividad: Música");
                break;

            case "MARTES":
                System.out.println("Actividad: Natación");
                break;

            case "MIERCOLES":
                System.out.println("Actividad: Ingés");
                break;

            case "JUEVES":
                System.out.println("Actividad: Natación");
                break;

            case "VIERNES":
                System.out.println("Actividad: -");
                break;

            case "SABADO":
                System.out.println("Actividad: Deporte escolar");
                break;

            case "DOMINGO":
                System.out.println("Actividad: -");
                break;

            default:
                System.out.println("Opción inválida");
                break;

        }



    }

}
