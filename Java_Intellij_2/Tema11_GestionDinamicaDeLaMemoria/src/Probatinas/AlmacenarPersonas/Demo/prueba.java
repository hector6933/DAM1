package Probatinas.AlmacenarPersonas.Demo;

import Probatinas.AlmacenarPersonas.Clases.Persona;

import java.io.*;
import java.lang.reflect.Field;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class prueba {

    public static String insertarRegistro(Object e, String ruta) {

        StringBuilder registro = new StringBuilder();

        Class<?> clase = e.getClass();
        Field[] fields = clase.getDeclaredFields();

        int iterador = 0;
        for (Field field : fields) {

            field.setAccessible(true);

            if (iterador == 0) {

                iterador++;
                continue;

            }

            try {

                if (iterador == 1) {

                    int id = Integer.parseInt(field.get(e).toString());
                    if (comprobarId(ruta, id)) {

                        registro.append(field.get(e)).append(";");

                    } else {

                        System.out.println("El ID " + id + " ya está registrado !!!");
                        return null;

                    }

                } else {

                    registro.append(field.get(e)).append(";");

                }

            } catch (IllegalAccessException ex) {

                System.out.println("Error al obtener el campo");

            } catch (IOException ex) {

                throw new RuntimeException(ex);

            }

            iterador++;

        }

        return registro.toString();
    }

    public static boolean comprobarId(String ruta, int id) throws IOException {

        try (BufferedReader leerBufer = new BufferedReader(new FileReader(ruta))) {

            String linea;

            while ((linea = leerBufer.readLine()) != null) {

                Matcher patronId = Pattern.compile(id + ";").matcher(linea);

                if (patronId.find()) {

                    return false;

                }

            }

        } catch (IOException e) {

            throw new IOException("Error en la lectura del archivo !!!");

        }

        return true;

    }

    public static boolean idValido(String campo) {

        return Pattern.matches("^\\d+$",campo);

    }

    public static boolean dniValido(String campo) {

        return Pattern.matches("^\\d{8}[A-Za-z]$",campo);

    }

    public static boolean nombreValido(String campo) {

        return Pattern.matches("^[A-Za-z áéíóúÁÉÍÓÚ]+$",campo);

    }

    public static boolean apellidoValido(String campo) {

        return Pattern.matches("^[A-Za-záéíóúÁÉÍÓÚ]+$",campo);

    }

    public static boolean edadValida(String campo) {

        // En realidad no me hace falta este regex, pero bueno por quedar bien
        if (!Pattern.matches("^\\d+$",campo)) {

            return false;

        }

        int edad = Integer.parseInt(campo);

        return edad >= 0;
    }

    public static boolean sexoValido(String campo) {

        return Pattern.matches("^[A-Za-z]+$",campo);

    }

    public static boolean registroValido(String linea){

        String[] campos = linea.split(";");

        return idValido(campos[0]) && dniValido(campos[1]) && nombreValido(campos[2]) && apellidoValido(campos[3]) && edadValida(campos[4])
                && sexoValido(campos[5]);

    }

    public static void main(String[] args) {

        ArrayList<Persona> personas = new ArrayList<>();

        String ruta = "probatinas/personas.txt";

        personas.add(new Persona("12345678R", "Pepe Pepe", "Martínez", 33, "Hombre", false));
        personas.add(new Persona("12313131S", "Loli", "González", 22, "Mujer", true));
        personas.add(new Persona("21313544G", "LOLO", "Imbécil", 12, "Hombre", true));
        personas.add(new Persona("98754352T", "L", "Tontopolla", 99, "Mujer", false));
        personas.add(new Persona("17231279R", "Josepe", "Pepe", 99, "Macho", true));


        try (BufferedWriter escribirBufer = new BufferedWriter(new FileWriter(ruta, true))) {

            for (Persona e : personas) {

                String registro = insertarRegistro(e,ruta);
                if (registro != null) {

                    if (registroValido(registro)) {

                        escribirBufer.write(registro);
                        escribirBufer.newLine();

                        System.out.println("Añadido correctamente a " + e.getNombre() + " al registro !");

                    } else {

                        System.out.println("Registro inválido !!!");

                    }

                }

            }

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }

    }

}
