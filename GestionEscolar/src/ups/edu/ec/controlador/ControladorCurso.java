/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import ups.edu.ec.modelo.CursoRec;
import ups.edu.ec.modelo.DocenteRec;

/**
 *
 * @author japch
 */
public class ControladorCurso extends AbstracControlador<CursoRec> {

    @Override
    public boolean validar(CursoRec objeto) {
        return objeto.getNombreCurso().equals(objeto.getNombreCurso());
    }
    
}
