import java.lang.reflect.Array;
import java.util.ArrayList;

public class Empresa {

    private ArrayList<Empleado> empleados;

    public Empresa() {
        empleados = new ArrayList<>();
    }

    public Empresa(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void mostrarEmpleados() {

        for (Empleado e : empleados) {

            System.out.println(e.toString());

        }

    }

    public Double salarioPromedio() {

        double total = 0;
        for (Empleado e : empleados) {

            total += e.getSalario();

        }

        return total;

    }

    public Empleado mayorAntiguedad() {

        Empleado temporal = empleados.getFirst();

        for (Empleado e : empleados) {

            if (temporal.getAntiguedad() > e.getAntiguedad()) {

                temporal = e;

            }

        }

        return temporal;

    }

    public ArrayList<Empleado> buscarEmpleados(String busqueda) {

        ArrayList<Empleado> resutlado = new ArrayList<>();

        for (Empleado e : empleados) {

            if (e.getNombre().equalsIgnoreCase(busqueda) || e.getPuesto().equalsIgnoreCase(busqueda)) {

                resutlado.add(e);

            }

        }

        return resutlado;
    }

}
