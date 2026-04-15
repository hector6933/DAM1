package Vista;

import Controlador.ClienteController;
import Controlador.EmpleadoController;
import Controlador.VehiculoController;
import Modelo.Cliente;
import Config.Conexion;
import Modelo.Empleado;
import Modelo.Vehiculo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class DemoConsola {

    private static final Scanner leer = new Scanner(System.in);

    private static final String ERROR = "Error en la conexión de la base de datos !";

    // ---------------------- INICIO CLIENTE ----------------------------------------
    public static void insertarClientes(ArrayList<Cliente> clientes) throws SQLException {

        int rows = ClienteController.insertarClientes(clientes);

        System.out.println(rows + " clientes insertados !");

    }


    public static ArrayList<Cliente> crearClientes() throws SQLException {

        ArrayList<Cliente> clientes = new ArrayList<>();

        do {

            String dni;

            do {

                dni = DataManager.pedirDni();

                if (DataManager.comprobarDni(dni)) {

                    break;

                } else {

                    System.out.println("Ya existe ese cliente con ese DNI !");

                }

            } while (true);

            String nombre = DataManager.pedirNombre();
            String apellidos = DataManager.pedirApellidos();
            String telefono = DataManager.pedirTelefono();

            clientes.add(new Cliente(dni, nombre, apellidos, telefono));

        } while (DataManager.continuarInsert());

        return clientes;

    }

    public static void verClientes() throws SQLException {


        ArrayList<String> clientes = ClienteController.verClientes();

        if (clientes == null) {

            System.out.println("No hay clientes que mostrar !");
            return;

        }

        for (String e : clientes) {

            System.out.println(e);

        }

    }

    public static void borrarCliente() throws SQLException {

        do {

            String dni = DataManager.pedirDni();

            if (DataManager.comprobarDni(dni)) {

                System.out.println("El dni introducido NO está registrado en la base de datos !");

            } else {

                if (ClienteController.borrarCliente(dni)) {

                    System.out.println("Cliente con DNI" + dni + " borrado con éxito !!!");

                } else {

                    System.out.println("Error al borrar el cliente con DNI " + dni);

                }

                return;

            }

        } while (true);

    }

    public static void modificarClientes() throws SQLException {

        System.out.println("Selecciona el campo que quieres modificar");
        String campoMod = DataManager.pedirColumnaCliente();

        System.out.println("Introduce el nuevo valor a asignar");
        String nuevoValor = DataManager.pedirValorCliente(campoMod);

        System.out.println("Selecciona la columna para la condicion de modificación");
        String condicionColumna = DataManager.pedirColumnaCliente();

        System.out.println("Introduce el valor de condición de la columna");
        String condicionValor = DataManager.pedirValorClienteCondicion(condicionColumna);

        int rows = ClienteController.modificarCliente(campoMod, nuevoValor, condicionColumna, condicionValor);

        if (rows == 0) {

            System.out.println("No se ha actualizado ningún registro !");

        } else {

            System.out.println(rows + " registros actualizados correctamente !");

        }

    }

    public static void accionCliente() {

        do {

            int opt = DataManager.accion();

            try {

                switch (opt) {
                    case 1: // SELECT CLIENTES
                        verClientes();
                        break;
                    case 2: // INSERTAR CLIENTES
                        insertarClientes(crearClientes());
                        break;
                    case 3: // MODIFICAR CLIENTES
                        modificarClientes();
                        break;
                    case 4: // BORRAR CLIENTES
                        borrarCliente();
                        break;
                    case 0:
                        return;

                }

            } catch (SQLException e) {

                System.out.println(ERROR);
                e.printStackTrace();

            }

        } while (true);

    }
    // ---------------------- FIN CLIENTE ----------------------------------------


    // ---------------------- INICIO VEHÍCULO ----------------------------------------

    public static void verVehiculos() throws SQLException {

        ArrayList<String> vehiculos = VehiculoController.verVehiculos();

        if (vehiculos == null) {

            System.out.println("No hay vehículos que mostrar !");
            return;

        }

        for (String e : vehiculos) {

            System.out.println(e);

        }


    }

    public static void insertarVehiculos(ArrayList<Vehiculo> vehiculos) throws SQLException {

        int rows = VehiculoController.insertarVehiculos(vehiculos);

        System.out.println(rows + " vehículos insertados !");

    }

    public static ArrayList<Vehiculo> crearVehiculos() throws SQLException {

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        do {

            String matricula;

            do {

                matricula = DataManager.pedirMatricula();

                if (DataManager.comprobarMatricula(matricula)) {

                    break;

                } else {

                    System.out.println("Esa matrícula ya está registrada en la base de datos !");

                }

            } while (true);

            String marca = DataManager.pedirMarca();

            String modelo = DataManager.pedirModelo();

            String tipoCombustible = DataManager.pedirTipoCombustible();

            Double precio = DataManager.pedirPrecio();

            String dniCliente;

            do {

                dniCliente = DataManager.pedirDni();

                if (!DataManager.comprobarDni(dniCliente)) {

                    break;

                } else {

                    System.out.println("No existe ningún cliente con ese DNI !");

                }

            } while (true);

            Integer numEmpleado;

            do {

                numEmpleado = DataManager.pedirNumPersona("empleado");

                if (DataManager.comprobarNumEmpleado(numEmpleado)) {

                    break;

                } else {

                    System.out.println("No existe ningún empleado con ese número !");

                }

            } while (true);

            vehiculos.add(new Vehiculo(matricula, marca, modelo, tipoCombustible, precio, dniCliente, numEmpleado));

        } while (DataManager.continuarInsert());

        return vehiculos;

    }

    public static void borrarVehiculo() throws SQLException {

        if (VehiculoController.borrarVehiculo(DataManager.pedirMatricula())) {

            System.out.println("Vehículo borrado correctamente !");

        } else {

            System.out.println("No se ha podido borrar el vehículo !!!");

        }

    }

    public static void modificarVehiculos() throws SQLException {

        System.out.println("Selecciona el campo que quieres modificar:");
        String columnaModificar = DataManager.pedirColumnaVehiculo();

        System.out.println("Introduce el nuevo valor a asignar:");
        String valorNuevo = DataManager.pedirValorVehiculo(columnaModificar);

        System.out.println("Selecciona la columna para la condicion de modificación:");
        String columnaCondicion = DataManager.pedirColumnaVehiculo();

        System.out.println("Introduce el valor de condición de la columna:");
        String valorCondicion = DataManager.pedirValorVehiculoCondicion(columnaCondicion);

        int rows = VehiculoController.modificarVehiculos(columnaModificar, valorNuevo, columnaCondicion, valorCondicion);

        if (rows == 0) {

            System.out.println("No se ha actualizado ningún registro !");

        } else {

            System.out.println(rows + " registros actualizados correctamente !");

        }

    }


    public static void accionVehiculo() {

        do {

            int opt = DataManager.accion();

            try {
                switch (opt) {
                    case 1: // SELECT VEHÍCULOS
                        verVehiculos();
                        break;
                    case 2: // INSERTAR VEHÍCULOS
                        insertarVehiculos(crearVehiculos());
                        break;
                    case 3: // MODIFICAR VEHÍCULOS
                        modificarVehiculos();
                        break;
                    case 4: // BORRAR VEHÍCULOS
                        borrarVehiculo();
                        break;
                    case 0:
                        return;

                }
            } catch (SQLException e) {

                System.out.println(ERROR);
                e.printStackTrace();

            }

        } while (true);

    }

    // ---------------------- FIN VEHÍCULO ----------------------------------------

    // ---------------------- INICIO EMPLEADO -------------------------------------

    public static void verEmpleados() throws SQLException {

        for (String e : EmpleadoController.verEmpleados()) {

            System.out.println(e);

        }

    }

    public static void borrarEmpleado(Integer numEmp) throws SQLException {

        if (EmpleadoController.borrarEmpleado(numEmp)) {

            System.out.println("Empleado con número " + numEmp + " borrado con éxito !");

        } else {

            System.out.printf("Error al borrar el empleado con número " + numEmp + " !");

        }

    }

    public static void insertarEmpleados(ArrayList<Empleado> empleados) throws SQLException {

        int rows = EmpleadoController.insertarEmpleados(empleados);

        System.out.println(rows + " empleados insertados !");


    }

    public static ArrayList<Empleado> crearEmpleados() throws SQLException {

        ArrayList<Empleado> empleados = new ArrayList<>();

        do {

            String nombre = DataManager.pedirNombre();

            String apellidos = DataManager.pedirApellidos();

            String telefono = DataManager.pedirTelefono();

            Date fecha = DataManager.pedirFecha("de nacimiento");

            Integer numGerente;

            do {

                numGerente = DataManager.pedirNumPersona("gerente");

                if (!DataManager.comprobarNumEmpleado(numGerente)) {

                    System.out.println("Ese número de empleado NO existe en la base de datos !");

                } else {

                    break;

                }

            } while (true);

            Integer numDep;

            do {

                numDep = DataManager.pedirNumDep();

                if (!DataManager.comprobarNumDep(numDep)) {

                    System.out.println("Ese número de departamento NO existe en la base de datos !");

                } else {

                    break;

                }

            } while (true);

            // PONER AQUÍ LA OPCIÓN DE CREAR UN USUARIO O AÑADIR EL EMPLEADO A UN USUARIO EXISTENTE (aunque me toca los cojones hacerlo)
            Integer idUsuario;

            do {

                idUsuario = DataManager.pedirIdUsuario();

                if (!DataManager.comprobarIdUsuario(idUsuario)) {

                    System.out.println("El ID de ese usuario NO existe !");

                } else {

                    break;

                }

            } while (true);

            empleados.add(new Empleado(nombre,apellidos,telefono,fecha,numGerente,numDep,idUsuario));


        } while (DataManager.continuarInsert());

        return empleados;

    }

    public static void modificarEmpleado() throws SQLException {

        System.out.println("Selecciona el campo que quieres modificar");
        String campoMod = DataManager.pedirColumnaEmpleado();

        System.out.println("Introduce el nuevo valor a asignar");
        String nuevoValor = DataManager.pedirValorEmpleado(campoMod);

        System.out.println("Selecciona la columna para la condicion de modificación");
        String condicionColumna = DataManager.pedirColumnaEmpleadoCondicion();;

        System.out.println("Introduce el valor de condición de la columna");
        String condicionValor = DataManager.pedirValorEmpleadoCondicion(condicionColumna);

        int rows = EmpleadoController.modificarEmpleados(campoMod,nuevoValor,condicionColumna,condicionValor);

        if (rows == 0) {

            System.out.println("No se ha actualizado ningún registro !");

        } else {

            System.out.println(rows + " registros actualizados correctamente !");

        }

    }

    public static void accionEmpleado() {

        do {

            int opt = DataManager.accion();

            try {
                switch (opt) {
                    case 1: // SELECT EMPLEADOS
                        verEmpleados();
                        break;
                    case 2: // INSERTAR EMPLEADOS
                        insertarEmpleados(crearEmpleados());
                        break;
                    case 3: // MODIFICAR EMPLEADOS
                        modificarEmpleado();
                        break;
                    case 4: // BORRAR EMPLEADOS

                        int num;

                        do {

                            num = DataManager.pedirNumPersona("empleado");

                            if (!DataManager.comprobarNumEmpleado(num)) {

                                System.out.println("Ese número de empleado NO existe en la base de datos !");

                            } else {

                                break;

                            }

                        } while (true);

                        borrarEmpleado(num);

                        break;
                    case 0:
                        return;

                }

            } catch (SQLException e) {

                System.out.println(ERROR);
                e.printStackTrace();

            }

        } while (true);

    }

    // ---------------------- FIN EMPLEADO ----------------------------------------

    public static void main(String[] args) {

        boolean salir;

        try (Connection conexion = Conexion.conexion()) {

            System.out.println("Conexión EXITOSA a la base de datos");

        } catch (SQLException e) {

            System.out.println("Error en la conexión con la base de datos !!!");
            e.printStackTrace();

        }

        do {

            salir = false;

            System.out.println("Bienvenido a la base de datos del Concesionario !");
            System.out.println("--- ELIGE ---");
            System.out.println("1 - Cliente");
            System.out.println("2 - Vehículo");
            System.out.println("3 - Empleado");
            System.out.println("0 - SALIR");
            System.out.print("> ");

            try {

                int opt = Integer.parseInt(leer.nextLine());

                switch (opt) {

                    case 1:
                        accionCliente();
                        break;
                    case 2:
                        accionVehiculo();
                        break;
                    case 3:
                        accionEmpleado();
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

        DataManager.leer.close();

    }

}