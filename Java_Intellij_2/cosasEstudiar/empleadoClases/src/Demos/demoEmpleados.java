package Demos;

import Clases.*;

import java.util.ArrayList;

public class demoEmpleados {

    public static void main(String[] args) {

        ArrayList<Empleado> misEmpleados = new ArrayList<>();
        Double total = (double) 0;

        misEmpleados.add(new EmpleadoPorHoras("ector",67,12.0));
        System.out.println("Salario de " + misEmpleados.get(0).getNombre() + ": " + misEmpleados.get(0).calcularSalario());

        misEmpleados.add(new EmpleadoFijo("pepe",3600.0,4));

        misEmpleados.add(new EmpleadoPorHoras("Pablo",67,0.5));
        System.out.println("Salario de " + misEmpleados.get(2).getNombre() + ": " + misEmpleados.get(2).calcularSalario());

        misEmpleados.add(new EmpleadoFijo("Pascual",2000.0,20));

        for (Empleado e : misEmpleados) {

            total += e.calcularSalario();

        }

        System.out.println("El salario total de todos mis empleados es de: " + total);



    }

}
