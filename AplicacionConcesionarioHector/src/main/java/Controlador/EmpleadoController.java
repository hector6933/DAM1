package Controlador;

import DAO.EmpleadoDAO;

import java.util.ArrayList;

public final class EmpleadoController {

    public static ArrayList<Integer> verNums(){

        return EmpleadoDAO.selectNum();

    }

}
