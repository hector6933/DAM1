package prob4_SobrecargaDeOperadores;

public class demo1 {

    public static void main(String[] args) {

        Punto miPunto1 = new Punto(20.0,10.0);
        System.out.println("Punto 1:");
        miPunto1.mostrarPos();
        Punto miPunto2 = new Punto(15.0,30.0);
        System.out.println("Punto 2:");
        miPunto2.mostrarPos();

        Punto miPunto3 = miPunto1.sumarPuntos(miPunto2);
        System.out.println("Punto 3:");
        miPunto3.mostrarPos();

    }

}
