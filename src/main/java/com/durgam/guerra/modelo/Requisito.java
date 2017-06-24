package com.durgam.guerra.modelo;
import java.util.HashSet;
import java.util.Set;

public class Requisito  implements java.io.Serializable {
    private Integer id;
    private String necesidad;
    private String nombre;
    private String prioridad;
    private String riesgo;
    private Proyecto proyecto;
    private Integer version;
    private Set<RequisitoCompuesto> compuesto = new HashSet<RequisitoCompuesto>(0);
    private EstadoRequisito estado;
    private Set<Stakeholder> stakeholders = new HashSet<Stakeholder>(0);
   
    public Requisito() {
    }

    public Set<Stakeholder> getStakeholders() {
        return stakeholders;
    }

    public void setStakeholders(Set<Stakeholder> stakeholders) {
        this.stakeholders = stakeholders;
    }

    public Requisito(Integer id, String necesidad, String nombre, String prioridad, String riesgo, Proyecto proyecto, int version, EstadoRequisito estado) {
        this.id = id;
        this.necesidad = necesidad;
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.riesgo = riesgo;
        this.proyecto = proyecto;
        this.version = version;
        this.estado = estado;
    }

    public Requisito(Integer id, String necesidad, String nombre, String prioridad, String riesgo, Proyecto proyecto, EstadoRequisito estado) {
        this.id = id;
        this.necesidad = necesidad;
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.riesgo = riesgo;
        this.proyecto = proyecto;
        this.estado = estado;
    }

    public Requisito(String necesidad, String nombre, String prioridad, String riesgo) {
       this.necesidad = necesidad;
       this.nombre = nombre;
       this.prioridad = prioridad;
       this.riesgo = riesgo;
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNecesidad() {
        return necesidad;
    }

    public void setNecesidad(String necesidad) {
        this.necesidad = necesidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public EstadoRequisito getEstado() {
        return estado;
    }

    public void setEstado(EstadoRequisito estado) {
       
        this.estado = estado;
    }

    public Set<RequisitoCompuesto> getCompuesto() {
        return compuesto;
    }

    public void setCompuesto(Set<RequisitoCompuesto> compuesto) {
        this.compuesto = compuesto;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
    
}


