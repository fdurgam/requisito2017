package com.durgam.guerra.repositorio;

import com.durgam.guerra.modelo.Proyecto;
import java.util.List;

public interface RepositorioProyecto {
    public List<Proyecto> obtenerTodosProyecto();
    public Proyecto encontrarProyectoPorId(int id);
    public void eliminarProyecto(Proyecto documento);
    public void nuevoProyecto(Proyecto proyecto);
    public Proyecto encontrarProyectoId(int id);
    public void actualizarProyecto(Proyecto proyectoactual);
}
