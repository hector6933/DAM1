package org.Controller;

import org.DAO.CursoDAO;

import java.util.ArrayList;
import java.util.Objects;

public final class CursoController {

    private CursoController() {
    }

    public static boolean comprobarIdCurso(Integer id){

        ArrayList<Integer> ids = CursoDAO.devolverIds();

        for (Integer e: ids) {

            if (Objects.equals(e, id)) {

                return true;

            }

        }

        return false;

    }

    public static String devolverNombreCurso(Integer id) {

        return CursoDAO.devolverNombreCurso(id);

    }

}
