public class aceleracion {

    public static void main(String[] args) {

        double v0 = 0.0; // Velocidad inicial
        double v = 100.0; // Velocidad final
        double t = 1.779; // Tiempo
        double a = 0; // Declaracion de la variable aceleracion

        a = (v-v0) / (t/3600);

        System.out.println("La aceleracion es de " + a + "km/h2");

    }

}
