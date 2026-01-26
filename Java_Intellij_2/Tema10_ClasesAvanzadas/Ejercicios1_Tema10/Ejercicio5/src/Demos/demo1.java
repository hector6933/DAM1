package Demos;

import Clases.Usuario;

public class demo1 {

    public static void main(String[] args) {

        // Usuario pablo = new Usuario("Maplo Piguel","pablada");
        Usuario hector = new Usuario("Cector Hriado","HolaHola123");

        if (hector.verificarPasswd("Holaquetal123")) {

            System.out.println("La contraseña coincide");

        } else {

            System.out.println("La constraseña NO coincide !!!");

        }

        hector.cambiarPasswd("Holaquetal123");

    }

}
