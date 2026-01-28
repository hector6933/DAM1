package probatinas;

public class demo1 {

    public static void main(String[] args) {

        OperacionesCadenas concatenar = (a,b) -> a+b;
        OperacionesCadenas xarAt = (a,b) -> String.valueOf(a.charAt(Integer.parseInt(b)));

        System.out.println(concatenar.hacer("hola ","que tal"));
        System.out.println(xarAt.hacer("hola","2"));

    }

}
