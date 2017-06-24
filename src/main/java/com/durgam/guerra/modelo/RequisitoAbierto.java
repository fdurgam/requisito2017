package com.durgam.guerra.modelo;
import java.util.HashSet;
import java.util.Set;
public class RequisitoAbierto extends EstadoRequisito implements java.io.Serializable {
private static RequisitoAbierto estado;
    public RequisitoAbierto() {
       super("Abierto");
       cargarEstadosSiguientes(); 
    }
    
    public static RequisitoAbierto getEstado() {
        if (estado == null) {
            estado = new RequisitoAbierto();
	}
        return estado;
 }

    private void cargarEstadosSiguientes() {
        Set<EstadoRequisito> Estsiguientes = new HashSet<EstadoRequisito>(0);
        Estsiguientes.add(RequisitoEnProgreso.getEstado());
        Estsiguientes.add(RequisitoCerrado.getEstado());
        this.setSiguientes(Estsiguientes);
    }
}


