public class pablada {

    public static void main(String[] args) {

        int[] array = { 1, 2, 3, 4, 5 };

        duplicateArray(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }

    private static void duplicateArray(int[] pablo) {
        for (int i = 0; i < pablo.length; i++) {
            pablo[i] *= 2;
        }
    }

}
