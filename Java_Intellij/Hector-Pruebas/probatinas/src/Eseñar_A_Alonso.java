import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Eseñar_A_Alonso {

    public static void main(String[] args) {

        ArrayList<Integer> bufas = new ArrayList<>();

        int[] cosa = {44,56,12,78,12,7,1,6,8,2,6,78,2,6,7,3,65,7,2,7};

        bufas.add(33);
        bufas.add(69);
        bufas.add(67);
        bufas.add(201);
        bufas.add(123);

        Collections.shuffle(bufas);

        Arrays.sort(cosa);

        System.out.println(Arrays.binarySearch(cosa,44));

        System.out.println(bufas);

    }

}
