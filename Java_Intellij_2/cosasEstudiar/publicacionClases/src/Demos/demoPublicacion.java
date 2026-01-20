package Demos;

import Clases.Libro;
import Clases.Publicacion;
import Clases.Revista;

import java.util.ArrayList;

public class demoPublicacion {

    public static void main(String[] args) {

        ArrayList<Publicacion> misPublicaciones = new ArrayList<>();

        misPublicaciones.add(new Libro("Las bufas","yo",500));
        misPublicaciones.add(new Libro("Ser o no ser","Alguien",3));
        misPublicaciones.add(new Libro("Las aventuras de Pascual en SMR","El mismísimo Pascual",2000));

        misPublicaciones.add(new Revista("zipi y zape","zipi",20));
        misPublicaciones.add(new Revista("Como crecer una segunda polla","Pablo Miguel",67));
        misPublicaciones.add(new Revista("Ya no se me ocurren mas titulos","bro",33));

        for (Publicacion e : misPublicaciones) {

            System.out.println(e.mostrarInfo());

        }

    }

}
