package programacion.Java.Tema2;

public class StringCosas {
    
    public static void main(String[] args) {
     
        // Funciones de STRING
        String hola = "Hola,";
        // String adios = "Adios,";
        String mundo = new String("mundo!");
        String mensaje = new String(hola.toUpperCase() + mundo.toUpperCase()); // Convierte a mayusculas el String sumandole a cada caracter un determinado numero para que sea mayuscula en ASCII
        // Además este de arriba crea un nuevo espacio en la memoria y toUpperCase crea otro espacio en la memoria
        System.out.println(mensaje);
        

        // Comparacion de STRING
        // Para comparar un String se hace con la funcion equals, si se hace con == se compara si es el mismo tipo de objeto
        String ejemplo1 = "hola";
        String ejemplo2 = new String("hola");
        System.out.println("== -> " + (ejemplo1 == ejemplo2)); // Da false porque no es el mismo tipo de objeto
        System.out.println("Equals -> " + (ejemplo1.equals(ejemplo2))); // Da true porque el conetenido coincide
        System.out.println("Ejemplo 1 en mayusculas: " + ejemplo1.toUpperCase());

        // Diferentes formas de declarar String
        String hola1 = "Hola ";
        String hola2 = hola1;
        String hola3 = new String(hola2);
        hola3.toUpperCase(); // esto no hace nada ya que NO modifica hola3 sino que es una variable 
        String hola4 = hola1 + hola3;
        System.out.println(hola4.toUpperCase() + hola3);

        // Si le pones null a un objeto lo que haces es borrar a donde apunta en la memoria, pero no se borra exactamente de la memoria

    }

}
