import java.util.Scanner;
import java.lang.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Dia15 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        //alfred
        System.out.print("Escribe la base: ");
        double base1 = sc.nextInt();
        System.out.print("Escribe la altura: ");
        double altura1 = sc.nextInt();
        System.out.println("El resultado es " + base1*altura1);
        //andrew
        // Pedir base y altura y calcular area de rectangulo
        System.out.println("Dime la base y altura del rectangulo");
        double base = sc.nextInt();
        double altura = sc.nextInt();
        System.out.println("El are del rectangulo es " + (base * altura));

        //Calcular raiz cuadrada
        System.out.println("Dime el numero del cual desees saber su raiz cuadrada");
        int raizdnum = sc.nextInt();
        System.out.println("La raiz de " + raizdnum + " es " + (Math.cbrt(raizdnum)));


        // Pedir nombre y saludar
        System.out.println("Dime tu nombre");
        String NombreUsuario = sc.next();
        System.out.println("Hola, " + NombreUsuario + ", Bienvenido a Java");


        //Pedir edad y informar si es mayor de edad
        System.out.println("Dime tu edad");
        int edad = sc.nextInt();
        if (edad >= 18) {
            System.out.println("Eres mayor de edad");
        } else {
            System.out.println("Eres menor de edad");
        }

        sc.close();
    }
}