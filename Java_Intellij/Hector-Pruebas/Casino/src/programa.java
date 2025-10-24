import java.util.Scanner;
public class programa {

    static Scanner leer = new Scanner(System.in);
    public static void esperar(double seg) { // Funcion para esperar, en vez de poner este pedazo código todo el rato

        int mili = (int) (seg * 1000);

        try {

            Thread.sleep(mili);

        } catch (InterruptedException e) {

            System.out.println("Erro de espera");

        }

    }

    public static String getSaldo (double saldo) {

        if (saldo == Math.floor(saldo)) {

            return String.format("%.0f", saldo) + "€";

        } else {

            return String.format("%.2f",saldo) + "€";

        }

    }

    public static int ruletaRojoNegro() {

        int min = 0;
        int max = 100;

        int random = (int) (Math.random() * (max - min) + min);
        if (random >= 1 && random <= 49) {

            return 0;

        } else if (random >= 50 && random <= 100) {

            return 1;

        } else if (random == 0) {

            return 2;

        }

        return 69;

    }

    public static void ruleta(double saldo) {

        boolean salir = false;
        String opcion;
        System.out.println("-------------------------------");
        System.out.println("Demomento solo disponemos de una ruleta con rojo o negro");
        esperar(0.7);
        do {

            System.out.println("Apuesta:");
            System.out.println("1 - Rojo");
            System.out.println("2 - Negro");
            System.out.println("S - Salir");
            opcion = leer.next();
            leer.nextLine();

            int resultado = ruletaRojoNegro();

            switch (opcion) {

                case "1":

                    break;

                case "2":

                    break;
                case "S","s":
                    System.out.println("Saliendo...");
                    salir = true;
                    break;
            }
            System.out.println("-------------------------------");
        } while (!salir);


    }

    public static void main(String[] args) {


        boolean salir = false;
        double saldo = 1000;
        String opcion;

        System.out.println("♦ Hola y bienvenido al HecSino ♦");
        do {

            esperar(0.7);

            System.out.println("Dispone de un saldo de " + getSaldo(saldo));

            esperar(1);

            System.out.println("▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼");
            System.out.println("¿Qué desea hacer hoy?");
            System.out.println("1 - Ruleta");
            System.out.println("2 - BlackJack");
            System.out.println("3 - Bombas");
            System.out.println("4 - Gestión saldo");
            System.out.println("S - Salir");
            opcion = leer.next();
            leer.nextLine();

            switch (opcion) {

                case "1":
                    System.out.println("Ruleta");
                    break;

                case "2":
                    System.out.println("BlackJack");
                    break;

                case "3":
                    System.out.println("Bombas");
                    break;

                case "4":
                    System.out.println("Gestión saldo");
                    break;

                case "S","s":
                    System.out.println("¡ Hasta pronto !");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción NO válida");
                    break;
            }

            System.out.println("▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼");


        } while (!salir);

    }

}
