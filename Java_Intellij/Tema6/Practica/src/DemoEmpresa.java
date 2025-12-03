import java.time.LocalDate;
import java.util.EmptyStackException;

public class DemoEmpresa {

    public static void main(String[] args) {

        Empresa pascualSL = new Empresa();

        Empleado e1 = new Empleado("Pepe","Pollez",LocalDate.of(2000,12,30),"1234567G",2000.0,"Capullo");
        Empleado e2 = new Empleado("Maplo","Pigel",LocalDate.of(1990,4,12),"563412G",6000.0,"Joputa");
        Empleado e3 = new Empleado("Mandrés","Está",LocalDate.of(2012,1,5),"9766532S",900.0,"Buena gente");

        pascualSL.getEmpleados().add(e1);
        pascualSL.getEmpleados().add(e2);
        pascualSL.getEmpleados().add(e3);

        pascualSL.mostrarEmpleados();

    }

}
