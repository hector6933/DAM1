package prob2_Lamda;

public class demo {

    public static void mostrarOperacion(Double x, Double y, Operacion op){

        System.out.println(op.hacer(x,y));

    }

    public static void main(String[] args) {

        // Aquí me estoy creando un objeto de una interfaz
        // Y con el lamda le especifíco el return del método de la clase
        // Básicamente me estoy creando métodos en mitad del main a partir de una "plantilla"
        Operacion suma = (a,b) -> a+b;
        Operacion resta = (a,b) -> a-b;

        System.out.println(suma.hacer(1.0,2.0));

        mostrarOperacion(10.0,5.20,resta);

    }

}
