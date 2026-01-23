public class probatina3 {

    public static void main(String[] args) {

        try {

            try {

                throw new NullPointerException("Objeto NULO");

            } catch (NullPointerException e) {

                throw new IllegalArgumentException("Cosa Incorrecta!",e);

            }

        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());

            System.out.println("Causa: " + e.getCause().getCause());

        }

    }

}
