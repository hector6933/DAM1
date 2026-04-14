package Vista;

import Controlador.*;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class DataManager {

    public static Scanner leer = new Scanner(System.in);

    public static boolean validarDni(String dni){

        return Pattern.matches("^[0-9]{8}[A-Z]$",dni);

    }

    public static boolean comprobarDni(String dni) throws SQLException {

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

    public static boolean valirdarNombre(String nom){

        return Pattern.matches("^[A-Za-zñÑáéíóúÁÉÍÓÚ ]{3,20}$",nom);

    }

    public static String pedirNombre(){

        do {

            System.out.println("Introduce el nombre:");
            System.out.print("> ");
            String nombre = leer.nextLine();

            if (!valirdarNombre(nombre)) {

                System.out.println("Formato incorrecto ! \nMínimo 3 y Máximo 20 letras del abecedario !");

            } else {

                return nombre;

            }


        } while (true);


    }

    public static boolean validarApellidos(String nom){

        return Pattern.matches("^[A-Za-zñÑáéíóúÁÉÍÓÚ ]{3,50}$",nom);

    }

    public static String pedirApellidos(){

        do {

            System.out.println("Introduce el/los apellido/s:");
            System.out.print("> ");
            String apellidos = leer.nextLine();

            if (!validarApellidos(apellidos)) {

                System.out.println("Formato incorrecto ! \nMínimo 3 y Máximo 50 letras del abecedario !");

            } else {

                return apellidos;

            }


        } while (true);

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

    public static String pedirValorCliente(String columna) throws SQLException {

        switch (columna) {

            case "dni":
                do {

                    String dni = DataManager.pedirDni();

                    if (DataManager.comprobarDni(dni)) {

                        break;

                    } else {

                        System.out.println("Ya existe ese cliente con ese DNI !");

                    }

                } while (true);
            case "nombre":
                return pedirNombre();
            case "apellidos":
                return pedirApellidos();
            case "telefono":
                return pedirTelefono();
            default:
                return "";

        }

    }

    public static String pedirValorClienteCondicion(String columna) throws SQLException {

        if (columna.equals("dni")) {
            do {

                String dni = DataManager.pedirDni();

                if (DataManager.comprobarDni(dni)) {

                    System.out.println("El dni introducido NO está registrado en la base de datos !");

                } else {

                    return dni;

                }

            } while (true);
        }
        return pedirValorCliente(columna);

    }

    public static boolean comprobarMatricula(String matricula) throws SQLException {

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

    public static boolean validarModelo(String modelo){

        return Pattern.matches("^\\w{2,15}$",modelo);

    }

    public static String pedirModelo(){

        do {

            System.out.println("Introduce el modelo:");
            System.out.print("> ");
            String modelo = leer.nextLine();

            if (!validarModelo(modelo)) {

                System.out.println("Formato incorrecto ! \nMínimo 2 y Máximo 15 letras del abecedario !");

            } else {

                return modelo;

            }

        } while (true);

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

    public static boolean validarPrecio(Double precio){

        return Pattern.matches("^[0-9]{1,10}$",precio.toString());

    }

    public static Double pedirPrecio(){

        do {

            System.out.println("Introduce el precio:");
            System.out.print("> ");

            try {

                double precio = Double.parseDouble(leer.nextLine());

                if (precio < 0) {

                    System.out.println("El precio debe de ser un número positivo !!!");
                    continue;

                }

                if (!validarPrecio(precio)) {

                    System.out.println("Formato incorrecto ! \nMínimo 1 y Máximo 10 dígitos ! ");
                    continue;

                }

                return precio;

            } catch (NumberFormatException e) {

                System.out.println("Introduce un número decimal !!!");

            }

        } while (true);

    }

    public static boolean comprobarNumEmpleado(Integer num) throws SQLException {

        for (Integer e: EmpleadoController.verNums()) {

            if (e.equals(num)) {

                return true;

            }

        }

        return false;

    }

    public static Integer pedirNumEmpleado(String persona){

        do {

            System.out.println("Introduce el número del " + persona + ":");
            System.out.print("> ");

            try {

                return Integer.parseInt(leer.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Introduce un número entero !!!");

            }

        } while (true);

    }

    public static String pedirColumnaVehiculo(){

        do {

            System.out.println("1 - Matrícula");
            System.out.println("2 - Marca");
            System.out.println("3 - Tipo Combustible");
            System.out.println("4 - Precio");
            System.out.println("5 - Dni cliente");
            System.out.println("6 - Numero empleado");
            System.out.print("> ");

            try {

                int opt = Integer.parseInt(leer.nextLine());

                switch (opt) {

                    case 1:
                        return "matricula";
                    case 2:
                        return "marca";
                    case 3:
                        return "tipoCombustible";
                    case 4:
                        return "precio";
                    case 5:
                        return "dni_cliente";
                    case 6:
                        return "numEmpleado";
                    default:
                        System.out.println("Opción inválida !!!");
                        break;

                }

            } catch (NumberFormatException e) {

                System.out.println("Introduce un número !!!");

            }

        } while (true);

    }

    public static String pedirValorVehiculo(String columna) throws SQLException {

        switch (columna) {

            case "matricula":

                do {

                    String matricula = pedirMatricula();

                    if (comprobarMatricula(matricula)) {

                        return matricula;

                    } else {

                        System.out.println("Esa matrícula ya está registrada en la base de datos !");

                    }

                } while (true);

            case "marca":
                return pedirMarca();

            case "modelo":
                return pedirModelo();

            case "tipoCombustible":
                return pedirTipoCombustible();

            case "precio":
                return pedirPrecio().toString();

            case "dni_cliente":
                do {

                    String dniCliente = DataManager.pedirDni();

                    if (!DataManager.comprobarDni(dniCliente)) {

                        return dniCliente;

                    } else {

                        System.out.println("No existe ningún cliente con ese DNI !");

                    }

                } while (true);

            case "numEmpleado":
                do {

                    Integer numEmpleado = DataManager.pedirNumEmpleado("empleado");

                    if (DataManager.comprobarNumEmpleado(numEmpleado)) {

                        return numEmpleado.toString();

                    } else {

                        System.out.println("No existe ningún empleado con ese número !");

                    }

                } while (true);

            default:
                return "";

        }

    }

    public static String pedirValorVehiculoCondicion(String columna) throws SQLException {

        if (columna.equals("matricula")) {

            do {

                String matricula = pedirMatricula();

                if (comprobarMatricula(matricula)) {

                    System.out.println("Esa matrícula NO está registrada en la base de datos !");

                } else {

                    return matricula;

                }

            } while (true);

        }

        return pedirValorVehiculo(columna);

    }

    public static boolean validarFecha(String fecha){

        return Pattern.matches("^(\\d{4})-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$",fecha);

    }

    public static Date pedirFecha(){

        do {

            System.out.println("Introduce la fecha (formato AAAA-MM-DD)");
            System.out.print("> ");
            String fecha = leer.nextLine();

            if (!validarFecha(fecha)) {

                System.out.println("Formato de fecha inválido ! Ej: 2025-04-15");

            } else {

                return Date.valueOf(fecha);

            }

        } while (true);

    }

    public static Date pedirFecha(String custom) {

        do {

            System.out.println("Introduce la fecha " + custom + " (formato AAAA-MM-DD)");
            System.out.print("> ");
            String fecha = leer.nextLine();

            if (!validarFecha(fecha)) {

                System.out.println("Formato de fecha inválido ! Ej: 2025-04-15");

            } else {

                return Date.valueOf(fecha);

            }

        } while (true);

    }

    public static boolean comprobarNumDep(Integer num) throws SQLException {

        for (Integer e: DepartamentoController.verNumDeps()) {

            if (e.equals(num)) {

                return true;

            }

        }

        return false;

    }

    public static Integer pedirNumDep(){

        do {

            System.out.println("Introduce el número del departamento:");
            System.out.print("> ");

            try {

                int num = Integer.parseInt(leer.nextLine());

                if (num < 0) {

                    System.out.println("Introduce un número mayor que 0 !");

                } else {

                    return num;

                }

            } catch (NumberFormatException e) {

                System.out.println("Introduce un número entero válido !!!");

            }

        } while (true);

    }

    public static boolean comprobarIdUsuario(Integer id) throws SQLException {

        for (Integer e: UsuarioController.verIdsUsuario()) {

            if (e.equals(id)) {

                return true;

            }

        }

        return false;

    }

    public static Integer pedirIdUsuario(){

        do {

            System.out.println("Introduce el ID del usuario:");
            System.out.print("> ");

            try {

                int id = Integer.parseInt(leer.nextLine());

                if (id < 0) {

                    System.out.println("Introduce un número mayor que 0 !");

                } else {

                    return id;

                }

            } catch (NumberFormatException e) {

                System.out.println("Introduce un número entero !!!");

            }

        } while (true);

    }

}