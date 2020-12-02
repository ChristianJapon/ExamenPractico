/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author japch
 */
public class Alumno implements Serializable{
    private int id;
    private String nombreestudainte;
    private String curso;
    private String actividad;
    
 public Alumno(){
     
 }

    public Alumno(int id, String nombreestudainte, String curso, String actividad) {
        this.id = id;
        this.nombreestudainte = nombreestudainte;
        this.curso = curso;
        this.actividad = actividad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreestudainte() {
        return nombreestudainte;
    }

    public void setNombreestudainte(String nombreestudainte) {
        this.nombreestudainte = nombreestudainte;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Alumno other = (Alumno) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombreestudainte, other.nombreestudainte)) {
            return false;
        }
        if (!Objects.equals(this.curso, other.curso)) {
            return false;
        }
        if (!Objects.equals(this.actividad, other.actividad)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombreestudainte=" + nombreestudainte + ", curso=" + curso + ", actividad=" + actividad + '}';
    }
 
 
}
