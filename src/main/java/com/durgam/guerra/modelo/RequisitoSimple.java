package com.durgam.guerra.modelo;
public class RequisitoSimple extends Requisito implements java.io.Serializable {

    public RequisitoSimple() {
    }

    public RequisitoSimple( String necesidad, String nombre, String prioridad, String riesgo) {
        super(necesidad, nombre, prioridad, riesgo);
    }
}


