package com.durgam.guerra.repositorio;

import com.durgam.guerra.modelo.Stakeholder;
import java.util.List;

public interface RepositorioStakeholder {
    public List<Stakeholder> obtenerTodosStakeholder();
    void nuevoStakeholder(Stakeholder stakeholder);
    public Stakeholder encontrarStakeholderId(int id);
    public void actualizarStakeholder(Stakeholder stakeholderActual); 
}
