package com.durgam.guerra.repositorio;
import com.durgam.guerra.modelo.Gestionrequisito;
import java.util.List;
public interface RepositorioGestionRequisitoface {
    public List<Gestionrequisito> obtenerTodosGestionRequisito();
    void nuevoGestionRequisito(Gestionrequisito ap);
    Gestionrequisito encontrarGestionrequisitoPorId(int id);
    public void actualizarGestionrequisito(Gestionrequisito ap);
    void eliminarGestionrequisito(Gestionrequisito ap);
}
