package prob5_Reflexion;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class demo1 {

    public static void main(String[] args) {

        Persona persona1 = new Persona("Pepe",33);
        Persona persona2 = new Persona("Luis",67);
        Persona persona3 = new Persona("Juanma",100);
        try {

            // Obtengo el tipo de la clase persona en tiempo de ejecución
            // También se puede hacer con un objeto
            // Class<?> tipo = persona1.getClass();
            Class<?> tipo = Persona.class;

            // Obtener métodods
            // Obtengo el método mostrarInfo() de la clase persona en un objeto de tipo método
            Method metodo = tipo.getMethod("mostrarInfo");

            // Y ahora puedo usar los métodos en las personas que me cree en tiempo de ejecución
            System.out.println("--------------------------------");
            System.out.println("Personas: ");
            System.out.println(metodo.invoke(persona1));
            System.out.println(metodo.invoke(persona2));
            System.out.println(metodo.invoke(persona3));

            // Obtener atributos
            Field campo = tipo.getDeclaredField("nombre");
            // Hago el campo accesible
            campo.setAccessible(true);

            System.out.println("--------------------------------");
            System.out.println("Nombres: ");
            System.out.println("Campo nombre: " + campo.get(persona1));
            System.out.println("Campo nombre: " + campo.get(persona2));
            System.out.println("Campo nombre: " + campo.get(persona3));

        } catch (Exception e) {

            System.out.println("Error !");

        }


    }

}
