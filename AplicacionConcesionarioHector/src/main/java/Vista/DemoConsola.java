package Vista;

import Controlador.ClienteController;
import Modelo.Cliente;
import Modelo.Conexion;

import javax.print.DocFlavor;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DemoConsola {

    private static final Scanner leer = new Scanner(System.in);

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
                continue;

            }

            if (!comprobarDni(dni)) {

                System.out.println("Ese DNI ya está registrado en la base de datos !!!");

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

    public static void insertarClientes(ArrayList<Cliente> clientes){

        int rows = ClienteController.insertarClientes(clientes);

        System.out.println(rows + " clientes insertados !");

    }

    public static ArrayList<Cliente> crearClientes(){

        ArrayList<Cliente> clientes = new ArrayList<>();

        do {

            String dni = pedirDni();
            String nombre = pedirNombre();
            String apellidos = pedirApellidos();
            String telefono = pedirTelefono();

            clientes.add(new Cliente(dni, nombre, apellidos, telefono));

        } while (continuarInsert());

        return clientes;

    }

    public static void verClientes(){

        ArrayList<String> clientes = ClienteController.verClientes();

        if (clientes == null) {

            System.out.println("No hay clientes que mostrar !");
            return;

        }

        for (String e: clientes) {

            System.out.println(e);

        }


    }

    public static void accionCliente(){

        int opt = accion();

        switch (opt) {

            case 0:
                return;

            case 1:
                verClientes();
                break;
            case 2:
                insertarClientes(crearClientes());
                break;
            case 3:

                break;
            case 4:

                break;

        }

    }

    public static Integer accion(){

        do {

            System.out.println("¿Qué desea hacer?");
            System.out.println("1 - Seleccionar");
            System.out.println("2 - Insertar");
            System.out.println("3 - Modificar");
            System.out.println("4 - Borrar");
            System.out.println("0 - SALIR");

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

    public static void main(String[] args) {

        boolean salir;
        do {

            try (Connection conexion = Conexion.conexion()) {

                System.out.println("Conexión EXITOSA a la base de datos");

            } catch (SQLException e) {

                System.out.println("Error en la conexión con la base de datos !!!");
                e.printStackTrace();


            }

            salir = false;

            System.out.println("Bienvenido a la base de datos del Concesionario !");
            System.out.println("--- ELIGE ---");
            System.out.println("1 - Cliente");
            System.out.println("0 - SALIR");
            System.out.print("> ");

            try {

                int opt = Integer.parseInt(leer.nextLine());

                switch (opt) {

                    case 1:
                        accionCliente();
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción inválida !!!");
                        break;

                }

            } catch (NumberFormatException e) {

                System.out.println("Introduce un número entero !");

            }


        } while (!salir);

    }

}
