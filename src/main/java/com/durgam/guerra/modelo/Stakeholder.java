package com.durgam.guerra.modelo;
import java.util.HashSet;
import java.util.Set;

public class Stakeholder  implements java.io.Serializable {
    private Integer id;
    private String nombre;
    private String apellido;
    private String rol;
    private String dni;
   private Integer version;
    private Set<Requisito> requisitos = new HashSet<Requisito>(0);
    public Stakeholder() {
    }

    public Stakeholder(Integer id, String nombre, String apellido, String rol, String dni, int version) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.dni = dni;
        this.version = version;
    }

    
    public Stakeholder(String nombre, String apellido, String rol, String dni) {
       this.nombre = nombre;
       this.apellido = apellido;
       this.rol = rol;
       this.dni = dni;
    }

    public Set<Requisito> getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(Set<Requisito> requisitos) {
        this.requisitos = requisitos;
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
    
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getRol() {
        return this.rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

  
    
}