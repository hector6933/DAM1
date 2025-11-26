public class DemoPersonas {

    public static void main(String[] args) {

        Personas p1 = new Personas();
        Personas p2 = new Personas("Alonso",80.0,170.25,18,"18445617J");

        System.out.println(p1.toString());
        System.out.println(p2.toString());

        p2.setAltura(190.0);
        p2.setEdad(89);


    }

}
