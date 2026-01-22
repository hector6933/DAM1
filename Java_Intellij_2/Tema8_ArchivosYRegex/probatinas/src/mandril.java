import java.rmi.MarshalException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mandril {

    public static void main(String[] args) {

        String cadena = "1 2 3";

        Matcher matcher = Pattern.compile("(?:\\d)\\s(?:\\d)\\s(\\d)").matcher(cadena);

        while (matcher.find()){
            System.out.println(cadena.replaceAll("(?:\\d)\\s(?:\\d)\\s(\\d)", "$1"));
        }

    }

}
