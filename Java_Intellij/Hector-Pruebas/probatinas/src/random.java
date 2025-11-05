public class random {

    public static void main(String[] args) {

        int max = 11;
        int min = 1;

        for (int i = 0; i < 15; i++) {

            int random = (int) (Math.random() * (max - min) + min);
            System.out.println(random);

        }
    }

}
