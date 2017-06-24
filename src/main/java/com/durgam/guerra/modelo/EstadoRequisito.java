package com.durgam.guerra.modelo;
import java.util.HashSet;
import java.util.Set;

public class EstadoRequisito  implements java.io.Serializable {
    private Integer id;
    private String descripcionEstado;
    private Set<Requisito> requisitos = new HashSet<Requisito>(0);
    private Set<EstadoRequisito> siguientes = new HashSet<EstadoRequisito>(0);

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }

    public EstadoRequisito(String descripcionEstado) {
     
        this.descripcionEstado = descripcionEstado;
    }

    public Set<Requisito> getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(Set<Requisito> requisitos) {
        this.requisitos = requisitos;
    }

    public EstadoRequisito() {
    }

    public EstadoRequisito(Integer id, String descripcionEstado) {
        this.id = id;
        this.descripcionEstado = descripcionEstado;
    }

    public Set<EstadoRequisito> getSiguientes() {
        return siguientes;
    }

    public void setSiguientes(Set<EstadoRequisito> siguientes) {
        this.siguientes = siguientes;
    }

    
}


