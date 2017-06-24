package com.durgam.guerra.modelo;
import java.util.HashSet;
import java.util.Set;

public class Proyecto  implements java.io.Serializable {
    private Integer id;
    private String nombreProyecto;
    private String descripcionProyecto;
    private Gestionrequisito aplicacion;
    private Set<Requisito> requisitos = new HashSet<Requisito>(0);
   private Integer version;
    public Proyecto() {
    }

    public Proyecto(String nombreProyecto, String descripcionProyecto) {
       this.nombreProyecto = nombreProyecto;
       this.descripcionProyecto = descripcionProyecto;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombreProyecto() {
        return this.nombreProyecto;
    }
    
    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }
    public String getDescripcionProyecto() {
        return this.descripcionProyecto;
    }
    
    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

    public Gestionrequisito getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(Gestionrequisito aplicacion) {
        this.aplicacion = aplicacion;
    }

    public Set<Requisito> getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(Set<Requisito> requisitos) {
        this.requisitos = requisitos;
    }

    public Proyecto(Integer id, String nombreProyecto, String descripcionProyecto, Gestionrequisito aplicacion, int version) {
        this.id = id;
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.aplicacion = aplicacion;
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
    
}


