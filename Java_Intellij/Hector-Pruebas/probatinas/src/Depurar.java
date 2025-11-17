import java.util.Scanner;
public class Depurar {
    public static void main(String[] args){
        int sum = 0, inputNum;
        int counter;
        int mean;
        Scanner NumScanner = new Scanner(System.in);
        Scanner charScanner = new Scanner(System.in);
        System.out.println("Ingresa el número total de términos que quieres que calcule la media");
                counter = NumScanner.nextInt();
        System.out.println("Por favor ingresa " + counter + " números:");
        for(int x = 0; x<counter ;x++){
            inputNum = NumScanner.nextInt();
            sum = sum + inputNum;
            System.out.println();
        }
        mean = sum / counter;
        System.out.println("La media de " + counter + " los números que ingresaste es " + mean);
    }
}