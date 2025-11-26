import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
public class ArrayListPrueba {

    public static void main(String[] args) {

        ArrayList<Integer> miArray = new ArrayList<Integer>();

        LocalDate fecha = LocalDate.now();
        LocalTime hora = LocalTime.now();
        System.out.println(fecha);
        System.out.println(hora);



        System.out.println(LocalDate.now().getMonth());

        LocalTime t1 = LocalTime.of(15, 25, 35);
        System.out.println(t1);
        LocalTime t2 = LocalTime.parse("06:30:00");
        System.out.println(t2);


    }


}
