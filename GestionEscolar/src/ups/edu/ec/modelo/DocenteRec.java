/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.Objects;
import ups.edu.ec.controlador.ControladorDocente;

/**
 *
 * @author japch
 */
public class DocenteRec implements Serializable{
    
 private int id; 
 private String nombreDocente;
 private String apellidoDocente;
 private String cedula;
 private String curso;


public DocenteRec(){
    
}

    public DocenteRec(int id, String nombreDocente, String apellidoDocente, String cedula, String curso) {
        this.id = id;
        this.nombreDocente = nombreDocente;
        this.apellidoDocente = apellidoDocente;
        this.cedula = cedula;
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public String getApellidoDocente() {
        return apellidoDocente;
    }

    public void setApellidoDocente(String apellidoDocente) {
        this.apellidoDocente = apellidoDocente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DocenteRec other = (DocenteRec) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nombreDocente, other.nombreDocente)) {
            return false;
        }
        if (!Objects.equals(this.apellidoDocente, other.apellidoDocente)) {
            return false;
        }
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        if (!Objects.equals(this.curso, other.curso)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Docente{" + "id=" + id + ", nombreDocente=" + nombreDocente + ", apellidoDocente=" + apellidoDocente + ", cedula=" + cedula + ", curso=" + curso + '}';
    }



}