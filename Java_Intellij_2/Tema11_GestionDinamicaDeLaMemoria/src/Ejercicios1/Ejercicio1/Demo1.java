package Ejercicios1.Ejercicio1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.ChronoPeriod;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo1 {

    public static boolean encontrarPais(String pais, String linea) {

        return linea.contains(pais);

    }

    public static void main(String[] args) {

        ArrayList<Registro> registros = new ArrayList<>();

        try (BufferedReader leerBufer = new BufferedReader(new FileReader("carpeta2/Ej1/Data.csv"))){

            String linea;

            boolean primera = true;
            while ((linea = leerBufer.readLine()) != null) {

                if (!primera) {

                    String[] campos = linea.split(",");
                    String[] fechaYHora = campos[9].split(" ");
                    String[] fecha = fechaYHora[0].split("-");
                    String[] hora = fechaYHora[1].split(":");

                    LocalDate date = LocalDate.of(Integer.parseInt(fecha[0]),Integer.parseInt(fecha[1]),Integer.parseInt(fecha[2]));
                    LocalTime time = LocalTime.of(Integer.parseInt(hora[0]),Integer.parseInt(hora[1]),Integer.parseInt(hora[2]));

                    registros.add(new Registro(Integer.parseInt(campos[0]),campos[1],campos[2],campos[3],campos[4],campos[5],campos[6],campos[7],campos[8],LocalDateTime.of(date,time)));

//                    for (String e: campos) {
//
//                        System.out.print(e + "|");
//
//                    }
//                    System.out.println();
                }

                primera = false;

            }

        } catch (FileNotFoundException e) {

            System.out.println("El archivo NO existe !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }

        System.out.println("---------------------------------------");

        System.out.println("REGISTROS DEL PAÍS DE FRANCIA:");

        registros.stream().filter(registro -> registro.getPais().equalsIgnoreCase("FR")).forEach(System.out::println);

        System.out.println("---------------------------------------");

        System.out.println("REGISTROS CON EMAIL DE YAHOO ORDENADOS POR NOMBRE:");
        registros.stream().sorted(Comparator.comparing(Registro::getNombre)).filter(registro -> registro.getEmail().contains("yahoo")).forEach(System.out::println);

        System.out.println("---------------------------------------");

        System.out.println("Los registros con el último login entre noviembre de 2015 y enero de 2017 ambos incluidos ordenados por fecha de manera descendente.");

        registros.stream().sorted(Comparator.comparing(Registro::getLast_login).reversed()).filter(registro -> registro.getLast_login().isAfter(LocalDateTime.of(2015,11,1,0,0)) && registro.getLast_login().isBefore(LocalDateTime.of(2017,1,1,0,0))).forEach(System.out::println);

        System.out.println("---------------------------------------");

        System.out.println("Los nombres y apellidos de los registros cuyo nombre (first_name) empiecen por ‘A’ ordenados por fecha (descendente) del último inicio de sesión (last_login).");

        registros.stream().sorted(Comparator.comparing(Registro::getLast_login).reversed()).filter(registro -> registro.getNombre().startsWith("A")).forEach(System.out::println);



    }

}
