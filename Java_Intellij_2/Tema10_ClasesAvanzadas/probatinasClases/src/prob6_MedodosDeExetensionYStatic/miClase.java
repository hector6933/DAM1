package prob6_MedodosDeExetensionYStatic;

public final class miClase {

    private miClase(){

    }

    public static String reverse(String cadena){

        StringBuilder temp = new StringBuilder(cadena);
        return temp.reverse().toString();

    }

}
