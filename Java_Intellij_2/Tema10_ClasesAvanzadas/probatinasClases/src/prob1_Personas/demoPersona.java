package prob1_Personas;

import java.util.Random;
import java.util.Scanner;

public class demoPersona {

    static Scanner leer = new Scanner(System.in);

    static Random random = new Random();

    public static void solicitarNumPersona(Personas e){

        do {
            try {

                System.out.println("Introduce el número de la persona");
                System.out.print("> ");
                int opcion = Integer.parseInt(leer.nextLine())-1;
                System.out.println(e.buscarPersonaPos(opcion).toString());
                break;
            } catch (Exception a) {

                System.out.println("Opción inválida !!!");

            }
        } while (true);

    }

    public static void solicitarNumPersona(Personas e, Personas f){

        do {
            try {

                System.out.println("Introduce el número de la persona");
                System.out.print("> ");
                int opcion = Integer.parseInt(leer.nextLine())-1;
                System.out.println(e.buscarPersonaPos(opcion).toString());
                System.out.println(f.buscarPersonaPos(opcion).toString());
                break;
            } catch (Exception a) {

                System.out.println("Opción inválida !!!");

            }
        } while (true);

    }

    public static void solicitarRandomPersona(Personas e){

        do {
            try {

                System.out.println("Introduce cuántas personas quieres");
                System.out.print("> ");
                int opcion = Integer.parseInt(leer.nextLine());

                System.out.println("--------------------------------");
                for (int i = 0; i < opcion; i++) {

                    System.out.println(e.getGrupoPersonas().get(random.nextInt(1,1001)).toString());

                }
                System.out.println("--------------------------------");

                break;
            } catch (Exception a) {

                System.out.println("Opción inválida !!!");

            }
        } while (true);

    }

    public static void solicitarRandomPersona(Personas e, Personas f){

        do {
            try {

                System.out.println("Introduce cuántas personas quieres");
                System.out.print("> ");
                int opcion = Integer.parseInt(leer.nextLine());
                System.out.println("--------------------------------");
                for (int i = 0; i < opcion; i++) {

                    if (i % 2 == 0) {

                        System.out.println(e.getGrupoPersonas().get(random.nextInt(1,1001)).toString());

                    } else {

                        System.out.println(f.getGrupoPersonas().get(random.nextInt(1,1001)).toString());

                    }

                }
                System.out.println("--------------------------------");

                break;
            } catch (Exception a) {

                System.out.println("Opción inválida !!!");

            }
        } while (true);

    }

    public static void main(String[] args) {

        Personas grupoA = new Personas();
        Personas grupoB = new Personas();

        for (int i = 1; i <= 1000000; i++) {

            grupoA.addPersona(new Persona(("Persona " + i),"A",random.nextInt(0,100),random.nextBoolean(),random.nextBoolean() ? 'H' : 'M'));

            grupoB.addPersona(new Persona(("Persona " + i),"B",random.nextInt(0,100),random.nextBoolean(),random.nextBoolean() ? 'H' : 'M'));

        }

        System.out.println("----------------------------------------");
        do {

            System.out.println("1 - Buscar una persona");
            System.out.println("2 - Edad media de los grupos");
            System.out.println("3 - Buscar personas random");
            System.out.println("0 - SALIR ");
            System.out.println("¿Que quieres hacer?");
            System.out.print("> ");
            try {

                int opcion = Integer.parseInt(leer.nextLine());
                if (opcion == 0) {

                    break;

                } else if (opcion == 1) {

                    do {
                        try {

                            System.out.println("1 - Grupo A");
                            System.out.println("2 - Grupo B");
                            System.out.println("3 - Los dos");
                            System.out.println("¿Que quieres hacer?");
                            System.out.print("> ");
                            int opcion2 = Integer.parseInt(leer.nextLine());
                            if (opcion2 == 1) {

                                solicitarNumPersona(grupoA);

                            } else if (opcion2 == 2) {

                                solicitarNumPersona(grupoB);

                            } else if (opcion2 == 3) {

                                solicitarNumPersona(grupoA,grupoB);

                            }
                            break;

                        } catch (Exception e) {

                            System.out.println("Opción inválida !!!");

                        }

                    } while (true);

                } else if (opcion == 2) {

                    System.out.println("------------------------------------");
                    System.out.println("Edad media del grupo A: " + grupoA.getEdadMedia());
                    System.out.println("Edad media del grupo B: " + grupoB.getEdadMedia());
                    System.out.println("------------------------------------");

                } else if (opcion == 3) {

                    do {
                        try {

                            System.out.println("1 - Grupo A");
                            System.out.println("2 - Grupo B");
                            System.out.println("3 - Los dos");
                            System.out.println("¿Que quieres hacer?");
                            System.out.print("> ");
                            int opcion2 = Integer.parseInt(leer.nextLine());
                            if (opcion2 == 1) {

                                solicitarRandomPersona(grupoA);

                            } else if (opcion2 == 2) {

                                solicitarRandomPersona(grupoB);

                            } else if (opcion2 == 3) {

                                solicitarRandomPersona(grupoA,grupoB);

                            }
                            break;

                        } catch (Exception e) {

                            System.out.println("Opción inválida !!!");

                        }

                    } while (true);

                }

            } catch (NumberFormatException e) {

                System.out.println("Opción inválida !!!");

            }

        } while (true);

        leer.close();
    }

}
