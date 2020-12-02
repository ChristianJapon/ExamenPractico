/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;

/**
 *
 * @author japch
 */
public class CursoRec implements Serializable {
    
    
    
 private int id; 
 private String nombreCurso;
 private String nAlumnos;
 
 public CursoRec(){
 }

    public CursoRec(int id, String nombreCurso, String nAlumnos) {
        this.id = id;
        this.nombreCurso = nombreCurso;
        this.nAlumnos = nAlumnos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getnAlumnos() {
        return nAlumnos;
    }

    public void setnAlumnos(String nAlumnos) {
        this.nAlumnos = nAlumnos;
    }

    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", nombreCurso=" + nombreCurso + ", nAlumnos=" + nAlumnos + '}';
    }
   
 
 
}
