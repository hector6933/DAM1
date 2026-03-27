package org.Vista;

import org.Controller.CursoController;
import org.Controller.EstudianteController;
import org.Modelo.Conexion;
import org.Modelo.Estudiante;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo1 {

    private static final Scanner leer = new Scanner(System.in);

    public static Integer pedirIdEstudiante() {

        do {

            System.out.println("Introduce el ID del estudiante ");
            System.out.print("> ");

            try {

                int id = Integer.parseInt(leer.nextLine());

                if (id < 0) {

                    throw new NumberFormatException();

                } else {

                    if (!EstudianteController.comprobarIdEstudiante(id)) {

                        System.out.println("Ese ID de estudiante NO existe !!!");

                    } else {

                        return id;

                    }

                }

            } catch (NumberFormatException e) {

                System.out.println("Introduce un número entero positivo !!!");

            }

        } while (true);

    }

    public static String pedirNombreEstudiante() {

        System.out.println("Introduce el nombre del estudiante ");
        System.out.print("> ");
        return leer.nextLine();

    }

    public static Integer pedirEdadEstudiante() {

        do {

            System.out.println("Introduce la edad del estudiante ");
            System.out.print("> ");

            try {

                int edad = Integer.parseInt(leer.nextLine());

                if (edad < 0) {

                    throw new NumberFormatException();

                } else {

                    return edad;

                }

            } catch (NumberFormatException e) {

                System.out.println("Introduce un número entero positivo");

            }

        } while (true);

    }

    public static Integer pedirIdCursoEstudiante() {

        do {

            System.out.println("Introduce el id del curso del estudiante ");
            System.out.print("> ");

            try {

                int idCurso = Integer.parseInt(leer.nextLine());

                if (idCurso < 0) {

                    throw new NumberFormatException();

                } else {

                    if (!CursoController.comprobarIdCurso(idCurso)) {

                        System.out.println("Ese ID de curso NO existe en la academia !!!");

                    } else {

                        return idCurso;

                    }

                }

            } catch (NumberFormatException e) {

                System.out.println("Introduce un número entero positivo !!!");

            }

        } while (true);

    }


    public static void insertarEstudiante() {

        String nombre = pedirNombreEstudiante();
        int edad = pedirEdadEstudiante();
        int curso = pedirIdCursoEstudiante();

        if (EstudianteController.insertarEstudiante(new Estudiante(nombre, edad, curso))) {

            System.out.println("Estudiante insertado correcatmente !");

        } else {

            System.out.println("No se ha podido insertar al estudiante !!!");

        }

        System.out.println("--------------------------");

    }


    public static void verEstudiantes() {

        ArrayList<Estudiante> estudiantes = EstudianteController.verEstudiantes();

        if (estudiantes.isEmpty()) {

            System.out.println("No hay estudiantes en la academia !!!!");

        } else {

            System.out.println("----------------------Estudiantes de la academia----------------------");

            for (Estudiante e : estudiantes) {

                String curso = CursoController.devolverNombreCurso(e.getCurso());

                if (curso == null || curso.isEmpty()) {

                    curso = "Sin curso";

                }

                System.out.println(e.getNombre() + " | " + curso);

            }

            System.out.println("-----------------------------------------------------------------------");

        }

    }

    public static void actualizarEdadEstudiante() {

        boolean salir;
        boolean correcto;
        int resultado;

        do {

            resultado = 0;
            salir = true;
            correcto = false;

            System.out.println("Condicion para actualizar la edad: ");
            System.out.println("1 - Por id");
            System.out.println("2 - Nombre");
            System.out.println("3 - Curso");
            System.out.print("> ");

            try {

                int opt = Integer.parseInt(leer.nextLine());

                switch (opt) {

                    case 1:

                        resultado = EstudianteController.actualizarEdadEstudiantePorId(pedirIdEstudiante(),pedirEdadEstudiante());
                        correcto = true;

                        break;
                    case 2:

                        resultado = EstudianteController.actualizarEdadEstudiantePorNombre(pedirNombreEstudiante(),pedirEdadEstudiante());
                        correcto = true;

                        break;
                    case 3:

                        resultado = EstudianteController.actualizarEdadEstudiantePorIdCurso(pedirIdCursoEstudiante(),pedirEdadEstudiante());
                        correcto = true;

                        break;
                    default:

                        System.out.println("Opción inválida !!!");
                        salir = false;
                        break;

                }

                if (correcto) {

                    if (resultado == 0) {

                        System.out.println("No se ha actualizado ningún estudiante !!!");

                    } else {

                        System.out.println("Actualización exitosa !");
                        System.out.println("Número de estudiantes actualizados: " + resultado);

                    }

                }


            } catch (NumberFormatException e) {

                System.out.println("Introduce un número entero positivo !!!");
                salir = false;

            }

        } while (!salir);

    }

    public static void eliminarEstudiante(){

         if (EstudianteController.eliminarEstudiante(pedirIdEstudiante())) {

             System.out.println("Estudiante eliminado correctamente !");

         } else {

             System.out.println("Error al eliminar el estudiante !!!");

         }

    }


    public static void main(String[] args) {

        ////////////////// Menú /////////////////
        boolean salir = false;

        do {

            try (Connection conexion = Conexion.conexion()) {

                System.out.println("Conexión exsitosa con la base de datos !");

            } catch (SQLException e) {

                System.out.println("Error al conectarse a la base de datos !!!");
                e.printStackTrace();

            }

            System.out.println("---------ELIGE------------");
            System.out.println("1 - Ver estudiantes ");
            System.out.println("2 - Insertar estudiante ");
            System.out.println("3 - Actualizar edad");
            System.out.println("4 - Elimiar estudiante");
            System.out.println("5 - SALIR");
            System.out.print("> ");

            boolean correcto = false;
            do {

                try {

                    int opt = Integer.parseInt(leer.nextLine());

                    switch (opt) {

                        case 1:
                            verEstudiantes();
                            break;
                        case 2:
                            insertarEstudiante();
                            break;
                        case 3:
                            actualizarEdadEstudiante();
                            break;
                        case 4:
                            eliminarEstudiante();
                            break;
                        case 5:
                            System.out.println("Saliendo...");
                            salir = true;
                            break;
                        default:
                            System.out.println("Opción inválida !!!");
                            break;

                    }

                    break;

                } catch (NumberFormatException e) {

                    System.out.println("Introduce un número entero positivo !!!");

                }

            } while (true);


        } while (!salir);

        leer.close();
    }

}
