package Demos;

import Clases.*;

import java.util.ArrayList;

public class demoAnimales {

    public static void main(String[] args) {

        ArrayList<Animal> misAnimales = new ArrayList<>();

        misAnimales.add(new Perro("Manuel"));
        misAnimales.add(new Perro("Jose Antonio"));

        misAnimales.add(new Gato("Kike"));
        misAnimales.add(new Gato("Abálos"));

        misAnimales.add(new Cabra("Lebron James"));
        misAnimales.add(new Cabra("hecprooll"));

        misAnimales.add(new MoscaCojonera("Iker"));
        misAnimales.add(new MoscaCojonera("Tete"));

        ((MoscaCojonera) misAnimales.getLast()).setMolesto(true);
        ((MoscaCojonera) misAnimales.get(6)).setVolador(true);

//        misAnimales.get(0).hacerSonido();
//        misAnimales.get(1).hacerSonido();
//        misAnimales.getLast().hacerSonido();

        for (Animal e : misAnimales) {

            System.out.print(e.getNombre() + ": ");
            e.hacerSonido();

        }

        System.out.println("------------------------------");
        System.out.println("El animal " + misAnimales.get(5).getNombre() + " hace el sonido: " + misAnimales.get(5).getSonidoAnimal());

    }

}
