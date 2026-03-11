package probatinas;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DatabaseProoll2000_JSON {

    public static void esperar(int segundos){

        long mili = (long) segundos * 1000;

        try {

            Thread.sleep(mili);

        } catch (InterruptedException e) {

            System.out.println("Error en el tiempo de espera: " + e);

        }

    }

    public static Alumnos getAlumnosJson(){

        ObjectMapper mapper = new ObjectMapper();

        Alumnos alumnos = null;

        try {

            alumnos = mapper.readValue(new File("src/main/java/probatinas/alumnos.json"), Alumnos.class);

        } catch (IOException e) {

            System.out.println("Error al deserializar de JSON !!!: ");
            e.printStackTrace();

        }

        return alumnos;

    }

    public static void mostrarRegistros() {

        Alumnos alumnos = getAlumnosJson();

        System.out.println("Alumnos: ");
        alumnos.mostrarAlumnos();

    }

    public static void escribirRegistros(Alumnos alumnos) throws IOException {

        // SERIALIZAR ALUMNOS A JSON

        ObjectMapper mapper = new ObjectMapper();

        try {

            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/java/probatinas/alumnos.json"), alumnos);

        } catch (IOException e) {

            throw new IOException("Error al serializar a JSON");

        }

        System.out.println("Registros insertados correctamente !");

    }

    public static Alumnos devolverRegistros(String parametro){

        Alumnos alumnos = getAlumnosJson();

        if (alumnos == null) {

            System.out.println("No hay alumnos en el archivo !!!");

        }

       alumnos.setAlumnos(alumnos.buscarAlumnos(parametro));

        if (alumnos.getAlumnos().isEmpty()) {

            System.out.println("No hay coincidencias con la búsqueda !!!");

        } else {

            return alumnos;

        }

        return null;

    }

    public static void mostrarRegistros(String parametro) {

        Alumnos alumnos = getAlumnosJson();

        if (alumnos == null) {

            System.out.println("No hay alumnos en el archivo !!!");
            return;

        }

        ArrayList<Alumno> resultado = alumnos.buscarAlumnos(parametro);

        if (resultado.isEmpty()) {

            System.out.println("No hay coincidencias con la búsqueda !!!");

        } else {

            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Alumnos: ");
            for (Alumno e: resultado) {

                System.out.println(e);

            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        }

    }

    public static void verAlumnos(){

        Scanner leer = new Scanner(System.in);
        boolean salir = false;
        do {

            System.out.println("1 - Ver a todos");
            System.out.println("2 - Ver por parámetro");
            System.out.println("0 - SALIR");
            System.out.print("> ");

            try {

                int opt = Integer.parseInt(leer.nextLine());
                switch (opt) {

                    case 1:
                        System.out.println("----------------------------------------");
                        mostrarRegistros();
                        System.out.println("----------------------------------------");
                        break;
                    case 2:
                        System.out.println("Introduce un parámetro de búsqueda (Curso,DNI,Nombre,Edad,ID):");
                        System.out.print("> ");
                        String parametro = leer.nextLine();
                        mostrarRegistros(parametro);

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

                System.out.println("Introduce un número válido!!!");

            }

        } while (!salir);

    }

    public static String pedirDni(){

        Scanner leer = new Scanner(System.in);

        String dni = "";
        do {

            System.out.println("Introduce el DNI: ");
            System.out.print("> ");
            dni = leer.nextLine();

            if (!comprobarDni(dni)) {

                System.out.println("Formato dni incorrecto !!! ej: 12345678A");

            } else {

                return dni;

            }

        } while (true);

    }

    public static boolean comprobarDni(String input){

        return Pattern.matches("^\\d{8}[A-Z]$",input);

    }


    public static Date pedirFechaMatricula(){

        Scanner leer = new Scanner(System.in);

        Date fechaMatricula = null;

        do {

            System.out.println("Introduce la fecha de la matrícula formato dd/mm/yyyy: ");
            System.out.print("> ");
            String fechaMatriculaStr = leer.nextLine();

            if (!comprobarFecha(fechaMatriculaStr)) {

                System.out.println("Formato inválido !!!");

            } else {

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                try {

                    fechaMatricula = sdf.parse(fechaMatriculaStr);

                } catch (ParseException e) {

                    System.out.println("Error al parsear la fecha");

                }
                return fechaMatricula;

            }

        } while (true);


    }

    public static boolean comprobarFecha(String input){

        return Pattern.matches("([0-2][0-9]|[3][0-1])/(0[1-9]|1[0-2])/\\d+",input);

    }

    public static String fechaFormatoIngles(String fecha){

        return fecha.replaceAll("(\\d+)/(\\d+)/(\\d+)","$3/$2/$1");

    }

    public static String pedirCurso(){

        Scanner leer = new Scanner(System.in);

        String curso = "";

        do {

            System.out.println("Introduce el curso: ");
            System.out.print("> ");
            curso = leer.nextLine();

            if (!comprobarCurso(curso)) {

                System.out.println("Curso inválido ! Debe de estar entre los siguientes: SMR1, SMR2, DAM1 o DAM2");


            } else {

                return curso.toUpperCase();

            }

        } while (true);

    }

    public static boolean comprobarCurso(String curso){

        return curso.equalsIgnoreCase("SMR1") || curso.equalsIgnoreCase("SMR2") || curso.equalsIgnoreCase("DAM1") || curso.equalsIgnoreCase("DAM2");

    }

    public static int pedirEdad(){

        Scanner leer = new Scanner(System.in);
        int edad = 0;
        do {
            System.out.println("Introduce la edad: ");
            System.out.print("> ");
            try {

                edad = Integer.parseInt(leer.nextLine());

                if (edad < 0) {

                    System.out.println("La edad debe de ser un número positivo !!!");

                } else {

                    return edad;

                }

            } catch (NumberFormatException e) {

                System.out.println("La edad debe de ser un número entero !!!");

            }

        } while (true);

    }

    public static String pedirNombre(){

        Scanner leer = new Scanner(System.in);

        System.out.println("Introduce el nombre: ");
        System.out.print("> ");
        return leer.nextLine();

    }

    public static String pedirApellidos(){

        Scanner leer = new Scanner(System.in);

        System.out.println("Introduce los apellidos: ");
        System.out.print("> ");
        return leer.nextLine();

    }

    public static Alumnos crearAlumnos(){

        Scanner leer = new Scanner(System.in);

        Alumnos alumnos = new Alumnos();

        do {

            String nombre = pedirNombre();

            String apellidos = pedirApellidos();

            int edad = pedirEdad();

            String dni = pedirDni();

            Date fechaMatricula = pedirFechaMatricula();

            String curso = pedirCurso();

            alumnos.getAlumnos().add(new Alumno(nombre,apellidos,edad,dni,fechaMatricula,curso));

            boolean continuar = true;

            do {

                System.out.println("¿Continuar insertando alumnos? (S/N)");
                System.out.print("> ");
                String opt = leer.nextLine();

                if (opt.equalsIgnoreCase("N")) {

                    continuar = false;
                    break;

                } else if (opt.equalsIgnoreCase("S")) {

                    break;

                } else {

                    System.out.println("Opción inválida !!!");

                }

            } while (true);

            if (!continuar) {

                break;

            }


        } while (true);

        return alumnos;

    }

    public static void sumarIds(Alumnos alumnos, int id){

        for (Alumno e: alumnos.getAlumnos()) {

            e.setId("ID" + ++id);

        }

    }

    public static void addRegistros(Alumnos insertar) throws IOException {

        Alumnos alumnos = getAlumnosJson();

        int ultimoId = alumnos.devolverUltimoId();

        sumarIds(insertar,ultimoId);

        alumnos.getAlumnos().addAll(insertar.getAlumnos());

        // SERIALIZAR ALUMNOS A JSON

        ObjectMapper mapper = new ObjectMapper();

        try {

            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/java/probatinas/alumnos.json"), alumnos);

        } catch (IOException e) {

            throw new IOException("Error al serializar a JSON");

        }

        System.out.println("Registros insertados correctamente !");

    }

    public static void alterarAlumnos(Alumnos alumnos){

        Scanner leer = new Scanner(System.in);

        do {
            System.out.println("Escribe el campo que quieres alterar: ");
            System.out.println("Nombre, Apellidos, Edad, Dni, Curso");
            System.out.print("> ");
            String opt = leer.nextLine();

            if (opt.equalsIgnoreCase("nombre")) {

                String nombre = pedirNombre();
                for (Alumno e: alumnos.getAlumnos()) {

                    e.setNombre(nombre);

                }

            } else if (opt.equalsIgnoreCase("apellidos")) {

                String apellidos = pedirApellidos();
                for (Alumno e: alumnos.getAlumnos()) {

                    e.setApellidos(apellidos);

                }

            } else if (opt.equalsIgnoreCase("edad")) {

                int edad = pedirEdad();
                for (Alumno e: alumnos.getAlumnos()) {

                    e.setEdad(edad);

                }

            } else if (opt.equalsIgnoreCase("dni")) {

                String dni = pedirDni();
                for (Alumno e: alumnos.getAlumnos()) {

                    e.setDni(dni);

                }

            } else if (opt.equalsIgnoreCase("curso")) {

                String curso = pedirCurso();
                for (Alumno e: alumnos.getAlumnos()) {

                    e.setCurso(curso);

                }

            } else {

                System.out.println("Opción inválida !!!");
                continue;
            }

            break;

        } while (true);


        Alumnos alumnosJson = getAlumnosJson();
        int i = 0;
        for (Alumno e: alumnosJson.getAlumnos()) {

            for (Alumno f: alumnos.getAlumnos()) {

                if (e.getId().equals(f.getId())) {

                    alumnosJson.getAlumnos().set(i,f);

                }

            }

            i++;

        }

        try {

            escribirRegistros(alumnosJson);

        } catch (IOException e) {

            System.out.println("Error al insertar los registros !!!");

        }

    }

    public static Alumnos seleccionarRegistros(){

        Scanner leer = new Scanner(System.in);

        Alumnos alumnos = null;

        do {

            System.out.println("Selecciona los registros: ");
            System.out.println("Introduce un parámetro de búsqueda (Curso,DNI,Nombre,Edad,ID):");
            System.out.print("> ");
            String parametro = leer.nextLine();

            alumnos = devolverRegistros(parametro);

            if (alumnos == null) {

                continue;

            }

            System.out.println("Registros seleccionados: ");

            alumnos.mostrarAlumnos();

            boolean continuar = true;
            do {

                System.out.println("¿Continuar? (S/N)");
                String opt = leer.nextLine();

                if (opt.equalsIgnoreCase("S")) {

                    break;

                } else if (opt.equalsIgnoreCase("N")) {

                    continuar = false;
                    break;

                } else {

                    System.out.println("Opción inválida !");

                }

            } while (true);

            if (continuar) {

                break;

            }

        } while (true);

        return alumnos;

    }


    public static void modificarAlumnos(){

        Scanner leer = new Scanner(System.in);

        System.out.println("1 - Insertar registros");
        System.out.println("2 - Eliminar registros");
        System.out.println("3 - Alterar registros");
        System.out.print("> ");

        try {

            int opt = Integer.parseInt(leer.nextLine());

            switch (opt) {

                case 1:

                    try {

                        addRegistros(crearAlumnos());

                    } catch (IOException e) {

                        e.printStackTrace();

                    }

                    break;
                case 2:
                    break;
                case 3:
                    alterarAlumnos(seleccionarRegistros());
                    break;
                default:
                    System.out.println("Opción inválida !!!");
                    break;
            }

        } catch (NumberFormatException e) {

            System.out.println("Introduce un número !!!");

        }

    }

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean salir = false;
        System.out.println("¡ Bienvenido al DatabaseProll 2000 !");
        esperar(1);

        do {
            System.out.println("¿Qué desea hacer?");
            System.out.println("1 - Modificar alumnos");
            System.out.println("2 - Ver alumnos");
            System.out.println("0 - SALIR");
            System.out.print("> ");

            try {

                int opt = Integer.parseInt(leer.nextLine());

                switch (opt) {

                    case 1:
                        modificarAlumnos();
                        break;
                    case 2:
                        verAlumnos();
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

                System.out.println("Introduce un número como opción !");

            }

        } while (!salir);

        leer.close();

    }

}
