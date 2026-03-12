package probatinas;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Demo3RegistrosAleatorios {

    static Random random = new Random();

    public static String generarNombre(int longitud){

        StringBuilder nombre = new StringBuilder();

        for (int n = 0; n < longitud; n++) {

            nombre.append((char) random.nextInt(97,123));

        }

        return nombre.toString();

    }

    public static String generarDni(){

        StringBuilder dni = new StringBuilder();

        for (int n = 0; n < 8; n++) {

            dni.append(random.nextInt(1,10));

        }

        char letra = (char) random.nextInt(65,91);

        return dni.toString() + letra;

    }

    public static Date generarFecha() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        int dia = random.nextInt(1,32);
        int mes = random.nextInt(1,13);
        int anio = random.nextInt(1900,2026);

        String fecha = dia + "/" + mes + "/" + anio;

        return sdf.parse(fecha);

    }

    public static String generarCurso(){

        int opt = random.nextInt(1,5);

        return switch (opt) {
            case 1 -> "SMR1";
            case 2 -> "SMR2";
            case 3 -> "DAM1";
            case 4 -> "DAM2";
            default -> null;
        };
    }

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        int num = 0;
        do {

            System.out.println("¿Cuántos registros quieres?");
            System.out.print("> ");
            try {

                num = Integer.parseInt(leer.nextLine());
                if (num < 0) {

                    System.out.println("Introduce un número positivo !!!");

                } else {

                    break;

                }

            } catch (NumberFormatException e) {

                System.out.println("Introduce un número entero !!!");

            }

        } while (true);

        Alumnos alumnos = new Alumnos();

        for (int i = 0; i < num; i++) {

            String nombre = generarNombre(7);

            String apellidos = generarNombre(7) + " " + generarNombre(7);

            int edad = random.nextInt(0,101);

            String dni = generarDni();

            Date fechaMatricula = null;
            try {

                fechaMatricula = generarFecha();

            } catch (ParseException e) {

                System.out.println("Error al generar la fecha");

            }

            String curso = generarCurso();

            alumnos.getAlumnos().add(new Alumno(nombre,apellidos,edad,dni,fechaMatricula,curso));

        }

        try {

            DatabaseProoll2000_JSON.addRegistros(alumnos);

        } catch (IOException e) {

            System.out.println("Error al añadir los registros !!!");
            e.printStackTrace();

        }

        System.out.println("Registros añadidos: ");
        for (Alumno e: alumnos.getAlumnos()) {

            System.out.println(e.toString());

        }


    }

}
