import java.time.LocalDate;

public class demoPersona {

    public static void main() {

        Personas gente = new Personas();

        Persona hector = new Persona(LocalDate.parse("2007-09-03"),"Héctor");
        Persona pablo = new Persona(LocalDate.parse("2007-01-20"),"Pablo");
        Persona alonso = new Persona(LocalDate.parse("2000-05-06"),"Alonso");
        Persona andres = new Persona(LocalDate.parse("2007-12-21"),"Andrés");
        Persona iker = new Persona(LocalDate.parse("2007-09-03"),"Iker");

        gente.lasPersonas.add(hector);
        gente.lasPersonas.add(pablo);
        gente.lasPersonas.add(alonso);
        gente.lasPersonas.add(andres);
        gente.lasPersonas.add(iker);


        System.out.println(andres.calcularEdad());

        System.out.println("La persona con mayor edad es: " + gente.getPersonaMayorEdad());



    }

}
