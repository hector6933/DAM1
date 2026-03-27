package org.Controller;

import org.DAO.EstudianteDAO;
import org.Modelo.Estudiante;

import java.util.ArrayList;

public final class EstudianteController {

    private EstudianteController() {
    }

    public static ArrayList<Estudiante> verEstudiantes(){

        return EstudianteDAO.selectEstudiantes();

    }

    public static boolean insertarEstudiante(Estudiante e) {

        int resultado = EstudianteDAO.insertEstudiante(e);

        return resultado != 0;

    }

    public static boolean comprobarIdEstudiante(Integer id){

        for (Integer e: EstudianteDAO.devolverIdsEstudiante()) {

            if (e.equals(id)) {

                return true;

            }

        }

        return false;

    }

    // "UPDATE FROM estudiantes SET edad = ? WHERE ? = ?"
    public static Integer actualizarEdadEstudiantePorId(Integer id, Integer edad){

        return EstudianteDAO.updateEstudiantesEdadId(id,edad);

    }

    public static Integer actualizarEdadEstudiantePorNombre(String nombre, Integer edad){

        return EstudianteDAO.updateEstudiantesEdadNombre(nombre,edad);

    }

    public static Integer actualizarEdadEstudiantePorIdCurso(Integer idCurso, Integer edad){

        return EstudianteDAO.updateEstudiantesEdadCurso(idCurso,edad);

    }

    public static boolean eliminarEstudiante(Integer id){

        int resultado = EstudianteDAO.eliminarEstudiantePorId(id);

        return resultado != 0;

    }

}
