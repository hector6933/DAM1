package Vista;

import Controlador.*;
import Modelo.*;
import Config.Conexion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class DemoConsola {

    private static final Scanner leer = new Scanner(System.in);

    private static final String ERROR = "Error en la conexión de la base de datos !";

    private static Integer idUsuarioActual = null;

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


        ArrayList<Cliente> clientes = ClienteController.verClientes();

        if (clientes == null) {

            System.out.println("No hay clientes que mostrar !");
            return;

        }

        for (Cliente e : clientes) {

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

                    System.out.println("Cliente con DNI " + dni + " borrado con éxito !!!");

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

        ArrayList<Vehiculo> vehiculos = VehiculoController.verVehiculos();

        if (vehiculos == null) {

            System.out.println("No hay vehículos que mostrar !");
            return;

        }

        for (Vehiculo e : vehiculos) {

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

        ArrayList<Empleado> empleados = EmpleadoController.verEmpleados();

        if (empleados == null) {

            System.out.println("No hay empleados que mostrar !");
            return;

        }

        for (Empleado e : empleados) {

            System.out.println(e);

        }

    }

    public static void borrarEmpleado() throws SQLException {

        do {

            Integer num = DataManager.pedirNumPersona("empleado");

            if (!DataManager.comprobarNumEmpleado(num)) {

                System.out.println("El número de empleado introducido NO está registrado en la base de datos !");

            } else {

                if (EmpleadoController.borrarEmpleado(num)) {

                    System.out.println("Empleado con número " + num + " borrado con éxito !!!");

                } else {

                    System.out.println("Error al borrar el empleado con número " + num);

                }

                return;

            }

        } while (true);


    }

    public static void insertarEmpleados(ArrayList<Empleado> empleados) throws SQLException {

        int rows = EmpleadoController.insertarEmpleados(empleados);

        System.out.println(rows + " empleados insertados !");


    }

    public static ArrayList<Empleado> crearEmpleados(String rol) throws SQLException {

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

            Integer idUsuario;
            if (rol.equalsIgnoreCase("admin")) {

                do {

                    System.out.println("¿Desea relacionar el empleado a un nuevo usuario o a uno existente?");
                    System.out.println("1 - Crear un nuevo usuario");
                    System.out.println("2 - Asignar el ID a uno existente");

                    int opt = DataManager.pedirEntero();

                    switch (opt) {

                        case 1:
                            Usuario user = crearUsuario();

                            insertarUsuario(user);

                            idUsuario = DataManager.devolverIdUsuario(user.getNombre());

                            break;
                        case 2:
                            do {

                                idUsuario = DataManager.pedirIdUsuario();

                                if (!DataManager.comprobarIdUsuario(idUsuario)) {

                                    System.out.println("El ID de ese usuario NO existe !");
                                    continue;

                                }

                                if (DataManager.comprobarIdUsuarioEmpleado(idUsuario)) {

                                    System.out.println("Ese usuario ya tiene un empleado asignado !!!");

                                } else {

                                    break;

                                }

                            } while (true);
                            break;
                        default:
                            System.out.println("Opción inválida !!!");
                            continue;

                    }

                    break;

                } while (true);

            } else {

                do {

                    idUsuario = DataManager.pedirIdUsuario();

                    if (!DataManager.comprobarIdUsuario(idUsuario)) {

                        System.out.println("El ID de ese usuario NO existe !");
                        continue;
                    }

                    if (DataManager.comprobarIdUsuarioEmpleado(idUsuario)) {

                        System.out.println("Ese usuario ya tiene un empleado asignado !!!");

                    } else {

                        break;

                    }

                } while (true);

            }

            empleados.add(new Empleado(nombre, apellidos, telefono, fecha, numGerente, numDep, idUsuario));

        } while (DataManager.continuarInsert("empleados"));

        return empleados;

    }

    public static void modificarEmpleado() throws SQLException {

        System.out.println("Selecciona el campo que quieres modificar");
        String campoMod = DataManager.pedirColumnaEmpleado();

        System.out.println("Introduce el nuevo valor a asignar");
        String nuevoValor = DataManager.pedirValorEmpleado(campoMod);

        System.out.println("Selecciona la columna para la condicion de modificación");
        String condicionColumna = DataManager.pedirColumnaEmpleadoCondicion();

        System.out.println("Introduce el valor de condición de la columna");
        String condicionValor = DataManager.pedirValorEmpleadoCondicion(condicionColumna);

        int rows = EmpleadoController.modificarEmpleados(campoMod, nuevoValor, condicionColumna, condicionValor);

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
                        insertarEmpleados(crearEmpleados(DataManager.devolverRolUsuario(idUsuarioActual)));
                        break;
                    case 3: // MODIFICAR EMPLEADOS
                        modificarEmpleado();
                        break;
                    case 4: // BORRAR EMPLEADOS
                        borrarEmpleado();
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

    // ---------------------- INICIO DEPARTAMENTO ---------------------------------

    public static void verDepartamentos() throws SQLException {

        ArrayList<Departamento> departamentos = DepartamentoController.verDepartamentos();

        if (departamentos == null) {

            System.out.println("No hay departamentos que mostrar !");
            return;

        }

        for (Departamento e : departamentos) {

            System.out.println(e);

        }

    }

    public static void borrarDepartamento() throws SQLException {

        do {

            Integer numDep = DataManager.pedirNumDep();

            if (!DataManager.comprobarNumDep(numDep)) {

                System.out.println("El número de departamento introducido NO está registrado en la base de datos !");

            } else {

                if (DepartamentoController.borrarDepartamento(numDep)) {

                    System.out.println("Departamento con número " + numDep + " borrado con éxito !!!");

                } else {

                    System.out.println("Error al borrar el departamento con número " + numDep);

                }

                return;

            }

        } while (true);

    }

    public static ArrayList<Departamento> crearDepartamentos() throws SQLException {

        ArrayList<Departamento> departamentos = new ArrayList<>();

        do {

            String nombre = DataManager.pedirNombre(2, 50);

            departamentos.add(new Departamento(nombre));

        } while (DataManager.continuarInsert());

        return departamentos;

    }

    public static void insertarDepartamentos(ArrayList<Departamento> departamentos) throws SQLException {

        int rows = DepartamentoController.insertarDepartamentos(departamentos);

        System.out.println(rows + " departamentos insertados !");


    }

    public static void modificarDepartamentos() throws SQLException {

        System.out.println("Selecciona el campo que quieres modificar");
        String campoMod = DataManager.pedirColumnaDepartamento();

        System.out.println("Introduce el nuevo valor a asignar");
        String nuevoValor = DataManager.pedirValorDepartamento(campoMod);

        System.out.println("Selecciona la columna para la condicion de modificación");
        String condicionColumna = DataManager.pedirColumnaDepartamentoCondicion();

        System.out.println("Introduce el valor de condición de la columna");
        String condicionValor = DataManager.pedirValorDepartamentoCondicion(condicionColumna);

        int rows = DepartamentoController.modificarDepartamento(campoMod,nuevoValor,condicionColumna,condicionValor);

        if (rows == 0) {

            System.out.println("No se ha actualizado ningún registro !");

        } else {

            System.out.println(rows + " registros actualizados correctamente !");

        }

    }

    public static void accionDepartamento() {

        do {

            int opt = DataManager.accion();

            try {

                switch (opt) {
                    case 1: // SELECT DEPARTAMENTOS
                        verDepartamentos();
                        break;
                    case 2: // INSERTAR DEPARTAMENTOS
                        insertarDepartamentos(crearDepartamentos());
                        break;
                    case 3: // MODIFICAR DEPARTAMENTOS
                        modificarDepartamentos();
                        break;
                    case 4: // BORRAR DEPARTAMENTOS
                        borrarDepartamento();
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

    // ---------------------- FIN DEPARTAMENTO ---------------------------------

    // ---------------------- INICIO USUARIO ------------------------------

    public static void verUsuarios() throws SQLException {

        ArrayList<Usuario> usuarios = UsuarioController.verUsuarios();

        if (usuarios == null) {

            System.out.println("No hay usuarios que mostrar !");
            return;

        }

        for (Usuario e : usuarios) {

            System.out.println(e);

        }

    }

    public static void borrarUsuario() throws SQLException {

        do {

            Integer id = DataManager.pedirIdUsuario();

            if (!DataManager.comprobarIdUsuario(id)) {

                System.out.println("El ID de usuario introducido NO está registrado en la base de datos !");

            } else {

                if (UsuarioController.borrarUsuario(id)) {

                    System.out.println("Usuario con id " + id + " borrado con éxito !!!");

                } else {

                    System.out.println("Error al borrar el usuario con id " + id);

                }

                return;

            }

        } while (true);

    }

    public static void insertarUsuarios(ArrayList<Usuario> usuarios) throws SQLException {

        int rows = UsuarioController.insertarUsuarios(usuarios);

        System.out.println(rows + " usuarios insertados !");

    }

    public static void insertarUsuario(Usuario usuario) throws SQLException {

        int rows = UsuarioController.insertarUsuario(usuario);

        if (rows == 0) {

            System.out.println("No se ha podido insertar el usuario !!!");

        } else {

            System.out.println("Usuario insertado correctamente !!!");

        }

    }

    public static Usuario crearUsuario() throws SQLException {

        String nombre;

        do {

            nombre = DataManager.pedirUsername(3, 20);

            if (DataManager.comprobarUsername(nombre)) {

                System.out.println("Ese nombre de usuario ya existe !");

            } else {

                break;

            }

        } while (true);

        String passwd = DataManager.pedirPasswd();

        String rol = DataManager.pedirRolUsuario();

        return new Usuario(nombre,passwd,rol);

    }

    public static ArrayList<Usuario> crearUsuarios() throws SQLException {

        ArrayList<Usuario> usuarios = new ArrayList<>();

        do {

            usuarios.add(crearUsuario());

        } while (DataManager.continuarInsert());

        return usuarios;

    }

    public static void modificarUsuario() throws SQLException {

        System.out.println("Selecciona el campo que quieres modificar");
        String campoMod = DataManager.pedirColumnaUsuario();

        System.out.println("Introduce el nuevo valor a asignar");
        String nuevoValor = DataManager.pedirValorUsuario(campoMod);

        System.out.println("Selecciona la columna para la condicion de modificación");
        String condicionColumna = DataManager.pedirColumnaUsuarioCondicion();

        System.out.println("Introduce el valor de condición de la columna");
        String condicionValor = DataManager.pedirValorUsuarioCondicion(condicionColumna);

        int rows = UsuarioController.modificarUsuario(campoMod,nuevoValor,condicionColumna,condicionValor);

        if (rows == 0) {

            System.out.println("No se ha actualizado ningún registro !");

        } else {

            System.out.println(rows + " registros actualizados correctamente !");

        }

    }

    public static void accionUsuario() {

        do {

            int opt = DataManager.accion();

            try {

                switch (opt) {
                    case 1: // SELECT USUARIOS
                        verUsuarios();
                        break;
                    case 2: // INSERTAR USUARIOS
                        insertarUsuarios(crearUsuarios());
                        break;
                    case 3: // MODIFICAR USUARIOS
                        modificarUsuario();
                        break;
                    case 4: // BORRAR USUARIOS
                        borrarUsuario();
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

    // ---------------------- FIN USUARIO ---------------------------------

    // ---------------------- INICIO LOGIN --------------------------------

    public static Integer login() {

        do {

            System.out.println("Introduzca las credenciales:");
            System.out.print("Usuario: ");
            String user = leer.nextLine();

            System.out.print("Contraseña: ");
            String passwd = leer.nextLine();

            if (!DataManager.comprobarCredencialesUsuario(user,passwd)) {

                System.out.println("Credenciales incorrectas !!!");
                continue;

            }

            try {

                Integer idUsuario = UsuarioController.getIdUsuario(user);

                if (idUsuario == null) {

                    throw new SQLException();

                } else {

                    return idUsuario;

                }

            } catch (SQLException e) {

                System.out.println("Error al obtener el usuario !!!");

            }


        } while (true);

    }

    // ---------------------- FIN LOGIN -----------------------------------

    // ---------------------- INICIO MENÚ -----------------------------------

    public static void menuEmpleado(){

        boolean salir;
        do {

            salir = false;
            System.out.println("--- ELIGE ---");
            System.out.println("1 - Cliente");
            System.out.println("2 - Vehículo");
            System.out.println("3 - Empleado");
            System.out.println("4 - Departamento");
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
                        try {

                            verEmpleados();

                        } catch (SQLException e) {

                            System.out.println("Error al mostrar los empleados !!!");

                        }
                        break;
                    case 4:
                        try {

                            verDepartamentos();

                        } catch (SQLException e) {

                            System.out.println("Errpr al mostrar los departamentos !!!");

                        }

                        break;
                    case 5:
                        accionUsuario();
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

    public static void menuGerente(){

        boolean salir;
        do {

            salir = false;
            System.out.println("--- ELIGE ---");
            System.out.println("1 - Cliente");
            System.out.println("2 - Vehículo");
            System.out.println("3 - Empleado");
            System.out.println("4 - Departamento");
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
                    case 4:
                        try {

                            verDepartamentos();

                        } catch (SQLException e) {

                            System.out.println("Errpr al mostrar los departamentos !!!");

                        }

                        break;
                    case 5:
                        accionUsuario();
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

    public static void menuAdmin(){

        boolean salir;
        do {

            salir = false;
            System.out.println("--- ELIGE ---");
            System.out.println("1 - Cliente");
            System.out.println("2 - Vehículo");
            System.out.println("3 - Empleado");
            System.out.println("4 - Departamento");
            System.out.println("5 - Usuario");
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
                    case 4:
                        accionDepartamento();
                        break;
                    case 5:
                        accionUsuario();
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

    public static void menu(String rol) {

        switch (rol.toLowerCase()) {

            case "admin":
                menuAdmin();
                break;
            case "gerente":
                menuGerente();
                break;
            case "empleado":
                menuEmpleado();
                break;
            default:
                System.out.println("Error con los roles del menú !!!");
                break;

        }

    }

    // ---------------------- FIN MENÚ ------------------------------------

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
            System.out.println("1 - Iniciar sesión");
            System.out.println("0 - SALIR");
            System.out.print("> ");

            try {

                int opt = Integer.parseInt(leer.nextLine());

                switch (opt) {

                    case 1:

                        idUsuarioActual = login();

                        String rol;
                        
                        try {

                            rol = DataManager.devolverRolUsuario(idUsuarioActual);

                            if (rol == null) {

                                throw new SQLException();

                            }

                        } catch (SQLException e) {

                            System.out.println("Error al obtener el rol del usuario !!!");
                            continue;

                        }

                        menu(rol);

                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción inválida !!!");
                        break;
                }

            } catch (RuntimeException e) {

                System.out.println("Introduce un número entero !!!");

            }

        } while (!salir);

        DataManager.leer.close();

    }

    public static Integer getIdUsuarioActual() {
        return idUsuarioActual;
    }
}