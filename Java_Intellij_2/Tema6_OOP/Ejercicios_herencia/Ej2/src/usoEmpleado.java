import java.util.ArrayList;

public class usoEmpleado {

    public static void main(String[] args) {

        ArrayList<Empleado>misEmpleados = new ArrayList<>();

        EmpleadoFijo Alonso = new EmpleadoFijo("Alonso",18.5);
        EmpleadoFijo Iker = new EmpleadoFijo("Iker",3.0);
        EmpleadoFijo Yo = new EmpleadoFijo("Yo",20.0);

        EmpleadoPorHoras Hector = new EmpleadoPorHoras("Hector",20,10.0);

        misEmpleados.add(Alonso);
        misEmpleados.add(Iker);
        misEmpleados.add(Yo);
        misEmpleados.add(Hector);

        Double total = 0.0;
        for (Empleado e : misEmpleados) {

            total += e.calcularSalario();

        }

        System.out.println("El salario total de los empleados es: " + total);

    }

}
