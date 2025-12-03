import java.time.LocalDate;

public class DemoPersonas {

    public static void main(String[] args) {

        Persona andres = new Persona("Andres",33,"1848288G",66.0,LocalDate.parse("2002-02-21"));
        Persona alonso = new Persona("alonso",500,"1848288G",20.0,LocalDate.parse("1990-12-20"));
        Persona pablo = new Persona("Andres",-5,"1848288G",12.0,LocalDate.parse("2007-12-20"));
        Subdito iker = new Subdito("Andres",-5,"1848288G",12.0,LocalDate.parse("2007-12-20"),"Puestisimo");

        Amigos amigos = new Amigos();

        amigos.amigos.add(andres);
        amigos.amigos.add(alonso);
        amigos.amigos.add(pablo);

        System.out.println(String.format("%.2f",amigos.calcularEdadMedia()));

        System.out.println(andres);

        System.out.println(andres.fechaAnios());

        System.out.println(iker);

    }

}
