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
import java.time.chrono.ChronoLocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo1 {

    public static void main(String[] args) {

        try (BufferedReader leerBufer = new BufferedReader(new FileReader("carpeta2/Ej1/Data.csv"))){

            String linea;

            boolean primera = true;
            while ((linea = leerBufer.readLine()) != null) {

                if (!primera) {

                    String[] campos = linea.split(",");
                    String[] fechaYHora = campos[9].split(" ");
                    LocalDate date = LocalDate.of(Integer.parseInt(fechaYHora[0].substring(0,4)),Integer.parseInt(fechaYHora[0].substring(5,7)),Integer.parseInt(fechaYHora[0].substring(8,10)));
                    LocalTime time = LocalTime.of(Integer.parseInt(fechaYHora[1].substring(0,2),Integer.parseInt(fechaYHora[1].substring(3,5),Integer.parseInt(fechaYHora[1].substring(6)));

                    // Registro registro = new Registro(campos[1],campos[2],campos[3],campos[4],campos[5],campos[6],campos[7],LocalDateTime.of(date,time));

                }
                primera = false;

            }

        } catch (FileNotFoundException e) {

            System.out.println("El archivo NO existe !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }

    }

}
