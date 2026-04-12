package Modelo;

import Controlador.ClienteController;
import Controlador.EmpleadoController;
import Controlador.VehiculoController;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class DataManager {

    public static Scanner leer = new Scanner(System.in);

    public static boolean validarDni(String dni){

        return Pattern.matches("^[0-9]{8}[A-Z]$",dni);

    }

    public static boolean comprobarDni(String dni){

        for (String e: ClienteController.verDnis()) {

            if (e.equalsIgnoreCase(dni)) {

                return false;

            }

        }

        return true;

    }

    public static String pedirDni(){

        do {

            System.out.println("Introduce el DNI:");
            System.out.print("> ");
            String dni = leer.nextLine();

            if (!validarDni(dni)) {

                System.out.println("Formato de DNI inválido !!! Ej: 67676767L");

            } else {

                return dni;

            }

        } while (true);

    }

    public static String pedirNombre(){

        System.out.println("Introduce el nombre:");
        System.out.print("> ");
        return leer.nextLine();

    }

    public static String pedirApellidos(){

        System.out.println("Introduce el/los apellido/s:");
        System.out.print("> ");
        return leer.nextLine();

    }

    public static boolean validartelefono(String telef){

        return Pattern.matches("[0-9]{9}",telef);

    }

    public static String pedirTelefono(){

        do {

            System.out.println("Introduce el teléfono:");
            System.out.print("> ");
            String telefono = leer.nextLine();

            if (!validartelefono(telefono)) {

                System.out.println("Formato de teléfono inválido !!! Ej: 676767676");

            } else {

                return telefono;

            }

        } while (true);

    }

    public static boolean continuarInsert(){

        do {

            System.out.println("¿Desea seguir insertando? (S/N)");
            System.out.print("> ");
            String opt = leer.nextLine();

            if (opt.equalsIgnoreCase("S")) {

                return true;

            } else if (opt.equalsIgnoreCase("N")) {

                return false;

            } else {

                System.out.println("Opción inválida !!!");

            }

        } while (true);

    }

    public static Integer accion(){

        do {

            System.out.println("¿Qué desea hacer?");
            System.out.println("1 - Seleccionar");
            System.out.println("2 - Insertar");
            System.out.println("3 - Modificar");
            System.out.println("4 - Borrar");
            System.out.println("0 - SALIR");
            System.out.print("> ");

            try {

                int opt = Integer.parseInt(leer.nextLine());

                switch (opt) {

                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    case 3:
                        return 3;
                    case 4:
                        return 4;
                    case 0:
                        System.out.println("Saliendo...");
                        return 0;
                    default:
                        System.out.println("Opción inválida !!!");
                        break;

                }

            } catch (NumberFormatException e) {

                System.out.println("Introduce un número entero !");

            }

        } while (true);

    }

    public static String pedirColumnaCliente(){

        do {

            System.out.println("1 - DNI");
            System.out.println("2 - Nombre");
            System.out.println("3 - Apellidos");
            System.out.println("4 - Teléfono");
            System.out.print("> ");

            try {

                int opt = Integer.parseInt(leer.nextLine());

                switch (opt) {

                    case 1:
                        return "dni";
                    case 2:
                        return "nombre";
                    case 3:
                        return "apellidos";
                    case 4:
                        return "telefono";
                    default:
                        System.out.println("Opción inválida !!!");
                        break;

                }

            } catch (NumberFormatException e) {

                System.out.println("Introduce un número !!!");

            }


        } while (true);

    }

    public static String pedirValorCliente(String columna) {

        return switch (columna.toLowerCase()) {
            case "dni" -> pedirDni();
            case "nombre" -> pedirNombre();
            case "apellidos" -> pedirApellidos();
            case "telefono" -> pedirTelefono();
            default -> "";
        };

    }

    public static boolean comprobarMatricula(String matricula){

        for (String e: VehiculoController.verMatricula()) {

            if (e.equalsIgnoreCase(matricula)) {

                return false;
            }

        }

        return true;

    }

    public static boolean validarMatricula(String matricula){

        return Pattern.matches("^[0-9]{4}-[BCDFGHJKLMNPQRSTVWXYZ]{3}$",matricula);

    }

    public static String pedirMatricula(){

        do {

            System.out.println("Introduce la matrícula del vehículo");
            System.out.print("> ");

            String matricula = leer.nextLine().toUpperCase();

            if (!validarMatricula(matricula)) {

                System.out.println("Formato de matrícula inválido ! Ej: 1234-BCD");

            } else {

                return matricula;

            }

        } while (true);

    }

    public static boolean validarMarca(String marca){

        ArrayList<String> marcas = new ArrayList<>(
                Arrays.asList(
                        "Toyota", "Volkswagen", "Ford", "Honda", "Chevrolet", "Nissan",
                        "Hyundai", "Kia", "Mercedes-Benz", "BMW", "Audi", "Peugeot",
                        "Renault", "Citroën", "Fiat", "Jeep", "Dodge", "Chrysler",
                        "Tesla", "Volvo", "Mazda", "Subaru", "Mitsubishi", "Suzuki",
                        "Lexus", "Infiniti", "Acura", "Porsche", "Ferrari", "Lamborghini",
                        "Bentley", "Rolls-Royce", "Aston Martin", "Jaguar", "Land Rover",
                        "Mini", "Alfa Romeo", "Maserati", "Bugatti", "McLaren",
                        "Pagani", "Koenigsegg", "Cupra", "SEAT", "Skoda", "Dacia",
                        "Opel", "Vauxhall", "Genesis", "Rivian", "Lucid Motors",
                        "BYD", "Geely", "Chery", "Great Wall", "Haval", "NIO",
                        "XPeng", "Polestar", "Saab"
                )
        );

        for (String e : marcas) {

            if (marca.equalsIgnoreCase(e)) {

                return true;

            }

        }

        return false;

    }


    public static String pedirMarca(){

        do {

            System.out.println("Introduce la marca del vehículo");
            System.out.print("> ");
            String marca = leer.nextLine();

            if (!validarMarca(marca)) {

                System.out.println("Esa marca NO se encuentra en la lista de marcas del concesionario");

            } else {

                return marca;

            }

        } while (true);

    }

    public static String pedirModelo(){

        System.out.println("Introduce el modelo:");
        System.out.print("> ");
        return leer.nextLine();

    }

    private static ArrayList<String> tipos = new ArrayList<>(Arrays.asList("Gasolina", "Diésel","GLP", "GNC", "Eléctrico", "Hidrógeno", "Biocombustibles"));

    public static boolean validarTipoCombustible(String input){

        for (String e: tipos) {

            if (e.equalsIgnoreCase(input)) {

                return true;

            }

        }

        return false;

    }

    public static String pedirTipoCombustible(){

        do {

            System.out.println("Introduce el tipo de combustible:");
            System.out.print("> ");
            String tipo = leer.nextLine();

            if (!validarTipoCombustible(tipo)) {

                System.out.println("Tipo de combustible incorrecto !");
                System.out.println("Opciones disponibles:");
                System.out.println(tipos);

            } else {

                return tipo;

            }

        } while (true);

    }

    public static Double pedirPrecio(){

        do {

            System.out.println("Introduce el precio:");
            System.out.print("> ");

            try {

                double precio = Double.parseDouble(leer.nextLine());

                if (precio < 0) {

                    System.out.println("El precio debe de ser un número positivo !!!");

                } else {

                    return precio;

                }

            } catch (NumberFormatException e) {

                System.out.println("Introduce un número decimal !!!");

            }

        } while (true);

    }

    public static boolean comprobarNumEmpleado(Integer num){

        for (Integer e: EmpleadoController.verNums()) {

            if (e.equals(num)) {

                return true;

            }

        }

        return false;

    }

    public static Integer pedirNumEmpleado(){

        do {

            System.out.println("Introduce el número del empleado:");
            System.out.print("> ");

            try {

                return Integer.parseInt(leer.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Introduce un número entero !!!");

            }

        } while (true);

    }

}
