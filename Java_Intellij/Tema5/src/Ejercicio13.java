//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Ejercicio13 {
//
//    public static void main(String[] args) {
//
//        Scanner leer = new Scanner(System.in);
//
//        ArrayList<String> nombres = new ArrayList<>();
//
//        boolean correcto = false;
//        int cant = 0;
//        do {
//            System.out.println("¿Cuántos nombres quieres introducir?");
//            System.out.print("> ");
//            try {
//
//                cant = Integer.parseInt(leer.nextLine());
//                correcto = true;
//
//            } catch (NumberFormatException e) {
//
//                System.out.println("Cantidad inválida !!!");
//
//            }
//        } while (!correcto);
//
//        for (int i = 0; i < cant; i++) {
//
//            System.out.println("Introduce el nombre " +  i+1 + ":");
//            System.out.print("> ");
//            nombres.add(leer.next());
//            leer.nextLine();
//
//        }
//        // String[] nombresA =  (String[]) nombres.toArray();
//        // Arrays.sort(nombresA);
//
//        leer.close();
//
//    }
//
//}
