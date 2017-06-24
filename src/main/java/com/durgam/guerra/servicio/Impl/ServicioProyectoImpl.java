/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.durgam.guerra.servicio.Impl;

import com.durgam.guerra.modelo.Proyecto;
import com.durgam.guerra.repositorio.RepositorioGestionRequisitoface;
import com.durgam.guerra.repositorio.RepositorioProyecto;
import com.durgam.guerra.servicio.ServicioProyecto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fernando
 */
@Service
public class ServicioProyectoImpl implements ServicioProyecto {
     @Autowired
    private RepositorioProyecto repo;

    @Override
    public List<Proyecto> obtenerTodosProyecto() {
      return repo.obtenerTodosProyecto();
    }

    @Override
    public Proyecto encontrarProyectoPorId(int id) {
       return repo.encontrarProyectoPorId(id);
    }

    @Override
    public void eliminarProyecto(Proyecto documento) {
       repo.eliminarProyecto(documento);
    }

    @Override
    public void nuevoProyecto(Proyecto proyecto) {
       repo.nuevoProyecto(proyecto);
    }

    @Override
    public Proyecto encontrarProyectoId(int id) {
        return repo.encontrarProyectoId(id);
    }

    @Override
    public void actualizarProyecto(Proyecto proyectoactual) {
       repo.actualizarProyecto(proyectoactual);
    }
}
