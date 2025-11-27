public class DemoPersonas {

    public static void main(String[] args) {

        Personas p1 = new Personas();
        Personas p2 = new Personas("Alonso",80.0,170.25,18,"18445617J");

        System.out.println(p1);
        System.out.println(p2);

        p2.setAltura(190.0);
        p2.setEdad(89);

        Estudiante e1 = new Estudiante("Héctor", 70.0, 170.0, 18, "123456G", 123, 2, 8);
        Estudiante e2 = new Estudiante("Borja", 62.0, 180.0, 20, "6767676767R", 321, 6, 9);

        Profesor pro1 = new Profesor("Juanma", 68.5, 180.0, 45, "33333333G", 1200.0, true);
        Profesor pro2 = new Profesor("Ángel", 98.0, 180.0, 36, "1241251235A", 1500.0, true);

        pro2.setEsCabron(false);

        System.out.println(pro1);
        System.out.println(e1);

    }

}
