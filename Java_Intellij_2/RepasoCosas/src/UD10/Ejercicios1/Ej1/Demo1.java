package UD10.Ejercicios1.Ej1;

public class Demo1 {

    static void main() {

        Empleado empleado0 = new Empleado("Pascual", 2000.0);
        Empleado empleado1 = new Empleado("Pascual2", 3000.0);
        Empleado empleado2 = new Empleado("Pascual3", 4000.0);
        Empleado empleado3 = new Empleado("Pascual4", 5000.0);

        Gerente gerente0 = new Gerente("Juanma1", 6000.0, 20.0);
        Gerente gerente1 = new Gerente("Juanma1", 6000.0, 20.0);
        Gerente gerente2 = new Gerente("Juanma1", 6000.0, 20.0);
        Gerente gerente3 = new Gerente("Juanma1", 6000.0, 20.0);
        Gerente gerente4 = new Gerente("Juanma1", 6000.0, 20.0);

        empleado0.mostrarInfo();
        empleado1.mostrarInfo();
        empleado2.mostrarInfo();
        empleado3.mostrarInfo();

        gerente0.mostrarInfo();
        gerente1.mostrarInfo();
        gerente2.mostrarInfo();
        gerente3.mostrarInfo();
        gerente4.mostrarInfo();

    }

}
