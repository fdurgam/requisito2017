package com.durgam.guerra.modelo;
import java.util.HashSet;
import java.util.Set;
public class RequisitoCompuesto extends Requisito  implements java.io.Serializable {
private Set<Requisito> requisitosSimple = new HashSet<Requisito>(0);
    public RequisitoCompuesto() {
    }

    public RequisitoCompuesto(String necesidad, String nombre, String prioridad, String riesgo) {
        super(necesidad, nombre, prioridad, riesgo);
    }

    public Set<Requisito> getRequisitosSimple() {
        return requisitosSimple;
    }

    public void setRequisitosSimple(Set<Requisito> requisitosSimple) {
        this.requisitosSimple = requisitosSimple;
    }
}


