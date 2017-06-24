package com.durgam.guerra.modelo;
import java.util.HashSet;
import java.util.Set;

public class RequisitoCerrado extends EstadoRequisito implements java.io.Serializable {
private static RequisitoCerrado estado;
    public RequisitoCerrado() {
        super("Cerrado");
        Set<EstadoRequisito> Estsiguientes = new HashSet<EstadoRequisito>(0);
        cargarEstadosSiguientes(); 
    }

    public static RequisitoCerrado getEstado() {
	if (estado == null) {
            estado = new RequisitoCerrado();
	}
        return estado;
 }
    
    private void cargarEstadosSiguientes() {
        Set<EstadoRequisito> Estsiguientes = new HashSet<EstadoRequisito>(0);
       
        this.setSiguientes(Estsiguientes);
    }
}