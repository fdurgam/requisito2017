package com.durgam.guerra.modelo;
import java.util.HashSet;
import java.util.Set;
public class RequisitoEnProgreso extends EstadoRequisito implements java.io.Serializable {
private static RequisitoEnProgreso estado;
    public RequisitoEnProgreso() {
        super("EnProgreso");
        cargarEstadosSiguientes();
    }
    
    public static RequisitoEnProgreso getEstado() {
        if (estado == null) {
            estado = new RequisitoEnProgreso();
	}
        return estado;
 }
 
    private void cargarEstadosSiguientes() {
        Set<EstadoRequisito> Estsiguientes = new HashSet<EstadoRequisito>(0);
        Estsiguientes.add(RequisitoCerrado.getEstado());
        this.setSiguientes(Estsiguientes);
    }
}