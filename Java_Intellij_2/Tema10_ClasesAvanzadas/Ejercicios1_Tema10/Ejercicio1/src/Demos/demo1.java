package Demos;

import Clases.Empleado;
import Clases.Gerente;

public class demo1 {

    public static void main(String[] args) {

        Empleado empleado1 = new Empleado("Ricardo",1000.0);

        Gerente gerente1 = new Gerente("Alonso",2500.0,500.0);

        empleado1.mostrarInfo();
        gerente1.mostrarInfo();

    }

}
