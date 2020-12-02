/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import ups.edu.ec.modelo.Alumno;
import ups.edu.ec.modelo.CursoRec;

/**
 *
 * @author japch
 */
public class ControladorAlumno extends AbstracControlador<Alumno>{

    @Override
    public boolean validar(Alumno objeto) {
             return objeto.getNombreestudainte().equals(objeto.getNombreestudainte());
    }
    
}
