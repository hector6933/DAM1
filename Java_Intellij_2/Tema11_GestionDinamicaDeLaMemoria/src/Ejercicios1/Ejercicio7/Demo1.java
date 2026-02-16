package Ejercicios1.Ejercicio7;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class Demo1 {

    public static void main(String[] args) {

        ArrayList<String> list1 = new ArrayList<>(List.of("Ann", "Carol", "Mary", "Joe", "John", "Kevin", "Jack", "Jack", "Lucy", "Laura", "George", "Ann", "Johnny", "Charlie", "Hillary"));

        ArrayList<String> list2 = new ArrayList<>(List.of("Ann", "Martha", "Noel", "Mark", "Pamela", "Elisabeth", "Laura", "Jane", "Mildred", "Laura", "Rue", "Ann", "Jacob", "Sidney", "Sophia", "Tyler"));

        System.out.println("Lista de palabras que aparecen en las dos listas.");
        list1.stream().distinct().filter(list2::contains).forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------");

        System.out.println("Lista de palabras que aparecen en la primera lista, pero no en la segunda.");
        list1.stream().distinct().filter(palabras -> !list2.contains(palabras)).forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------");
        System.out.println("Lista de palabras que aparecen en la segunda lista, pero no en la primera.");
        list2.stream().distinct().filter(palabras -> !list1.contains(palabras)).forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------");
        System.out.println("Lista de palabras que aparecen en cualquiera de las dos listas:");
        ArrayList<String> list3 = new ArrayList<>(list1);
        list3.addAll(list2);
        list3.stream().distinct().forEach(System.out::println);




    }

}
