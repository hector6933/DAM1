import java.time.LocalDate;

public class Subdito extends Persona{

    private String puesto;

    public Subdito(String nombre, int edad, String dni, double altura, LocalDate fechaNaci, String puesto) {
        super(nombre, edad, dni, altura, fechaNaci);
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return super.toString() + "Subdito{" +
                "puesto='" + puesto + '\'' +
                '}';
    }
}
