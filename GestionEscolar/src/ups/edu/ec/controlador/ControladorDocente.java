/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.util.Objects;
import ups.edu.ec.modelo.DocenteRec;

/**
 *
 * @author japch
 */
public class ControladorDocente extends AbstracControlador<DocenteRec> {

    @Override
    public boolean validar(DocenteRec objeto) {
        return !objeto.getNombreDocente().equals(objeto.getApellidoDocente());
    }
    
    
  
}
