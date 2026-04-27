package tiendaLibros.Vista;

import java.util.regex.Pattern;

public final class DataManager {

    private DataManager(){
    }

    public static boolean continuar(String custom){

        do {

            System.out.println("¿Desea continuar " + custom +" ? (S/N)");
            System.out.print("> ");
            String opt = Main.leer.nextLine();

            if (opt.equalsIgnoreCase("S")) {

                return true;

            } else if (opt.equalsIgnoreCase("N")) {

                return false;

            } else {

                System.out.println("¡¡¡ Opción inválida !!!");

            }

        } while (true);

    }

    public static boolean comprobarNombreAutor(String nombre){

        return Pattern.matches("^[A-Za-z áéíóúÁÉÍÓÚÑñ]{3,100}$",nombre);

    }

    public static String pedirNombre(){

        System.out.println("Introduce el nombre");
        System.out.print("> ");
        return Main.leer.nextLine();

    }

    public static boolean comprobarPaisAutor(String pais){

        return Pattern.matches("^[A-Za-z áéíóúÁÉÍÓÚÑñ]{3,50}$",pais);

    }

    public static String pedirPais(){

        System.out.println("Introduce el país");
        System.out.print("> ");
        return Main.leer.nextLine();

    }

}
