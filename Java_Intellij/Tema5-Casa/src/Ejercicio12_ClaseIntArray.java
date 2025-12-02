import java.util.ArrayList;
public class Ejercicio12_ClaseIntArray {

    public Ejercicio12_ClaseIntArray() {

    }

    public static void createRandom(int min, int max, int[] array, int capacidad) {

        for (int i = 0; i < capacidad; i++) {

            array[i] = (int) (Math.random() * (max - min + 1)) + min;

        }

    }

    public static void createRandom(int min, int max,ArrayList<Integer> array , int capacidad) { // Random para ArrayList

        for (int i = 0; i < capacidad; i++) {

            array.add((int) (Math.random() * (max - min + 1)) + min);

        }

    }

    public static void showArray(int[] array) {

        for (int numeros : array) {

            System.out.print(numeros + " ");

        }

    }

    public static int find(int[] array, int buscar) {

        for (int i = 0; i < array.length; i++) {

            if (array[i] == buscar) {

                return i;

            }
        }
        return -1;
    }

    public static int find(int[] array, int buscar, int indice) {

        for (int i = indice; i < array.length; i++) {

            if (array[i] == buscar) {

                return i;

            }

        }

        return -1;

    }

    public static int arrayMin(int[] array) {

        int min = array[0];

        for (int numeros : array) {

            if (numeros < min) {

                min = numeros;

            }

        }
        return min;
    }

    public static int arrayMax(int[] array) {

        int max = array[1];

        for (int numeros : array) {

            if (numeros > max) {

                max = numeros;

            }

        }

        return max;

    }

    public static int arraySum(int[] array) {

        int total = 0;
        for (int numeros : array) {

            total+=numeros;

        }
        return total;
    }

    public static int arrayAvg(int[] array) {

        int total = 0;
        for (int numeros : array) {

            total+=numeros;

        }

        return total/array.length;

    }

    public static int[] arrayInfo(int[] array) {

        int[] info = new int[4];
        int max = array[0];
        int min = array[0];
        int total = 0;

        for (int numeros : array) {

            total+=numeros;
            if (numeros < min) {

                min = numeros;

            }

            if (numeros > max) {

                max = numeros;

            }

        }

        info[0] = total;
        info[1] = total/array.length;
        info[2] = min;
        info[3] = max;

        return info;

    }

    public static ArrayList<Integer> arrayToListInfo(int[] array) {

        ArrayList<Integer> info = new ArrayList<>();
        int max = array[0];
        int min = array[0];
        int total = 0;

        for (int numeros : array) {

            total+=numeros;
            if (numeros < min) {

                min = numeros;

            }

            if (numeros > max) {

                max = numeros;

            }

        }

        info.set(0, total);
        info.set(1, total / array.length);
        info.set(2, min);
        info.set(3, max);

        return info;

    }
}
