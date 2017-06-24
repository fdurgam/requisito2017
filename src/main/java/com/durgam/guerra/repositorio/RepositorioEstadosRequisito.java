package com.durgam.guerra.repositorio;

import com.durgam.guerra.modelo.EstadoRequisito;
import java.util.List;
public interface RepositorioEstadosRequisito {
    public List<EstadoRequisito> obtenerTodosEstadosAbierto();
    void nuevoGestionRequisito(EstadoRequisito estado);
}
