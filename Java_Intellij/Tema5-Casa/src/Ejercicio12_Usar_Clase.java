import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio12_Usar_Clase {

    public static void main() {

        int longitud = 100;
        int[] miArray = new int[longitud];
        int[] amongus = {10,2,3,432,5,6,7,8,99,1};
        int[] skibidi = {25,1,10,8,2,6};

        Ejercicio12_ClaseIntArray.createRandom(20,50,miArray,longitud);

        Ejercicio12_ClaseIntArray.showArray(miArray);

        System.out.println();
        System.out.println(Ejercicio12_ClaseIntArray.find(amongus,2, 2));
        System.out.println(Ejercicio12_ClaseIntArray.arrayMin(amongus));
        System.out.println(Ejercicio12_ClaseIntArray.arrayMax(amongus));
        System.out.println(Ejercicio12_ClaseIntArray.arraySum(skibidi));
        System.out.println(Ejercicio12_ClaseIntArray.arrayAvg(skibidi));

        ArrayList<Integer> informacionArray = new ArrayList<>();

        informacionArray = Ejercicio12_ClaseIntArray.arrayToListInfo(skibidi);
 

    }

}