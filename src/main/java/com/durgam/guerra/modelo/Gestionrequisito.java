package com.durgam.guerra.modelo;
import java.util.HashSet;
import java.util.Set;

public class Gestionrequisito  implements java.io.Serializable {
    private Integer id;
    private String nombre;
    private String sistemaNombre;
    private Set<Proyecto> proyectos = new HashSet<Proyecto>(0);
private Integer version;
    public Set<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(Set<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }


    public Gestionrequisito() {
    }

    public Gestionrequisito(Integer id, String nombre, String sistemaNombre, int version) {
        this.id = id;
        this.nombre = nombre;
        this.sistemaNombre = sistemaNombre;
        this.version = version;
    }

    public Gestionrequisito(String nombre, String sistemaNombre) {
       this.nombre = nombre;
       this.sistemaNombre = sistemaNombre;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getSistemaNombre() {
        return this.sistemaNombre;
    }
    
    public void setSistemaNombre(String sistemaNombre) {
        this.sistemaNombre = sistemaNombre;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
    
}


