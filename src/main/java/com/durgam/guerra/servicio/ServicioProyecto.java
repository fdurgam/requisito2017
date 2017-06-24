/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.durgam.guerra.servicio;

import com.durgam.guerra.modelo.Proyecto;
import java.util.List;

/**
 *
 * @author fernando
 */
public interface ServicioProyecto {
    public List<Proyecto> obtenerTodosProyecto();
    public Proyecto encontrarProyectoPorId(int id);
    public void eliminarProyecto(Proyecto documento);
    public void nuevoProyecto(Proyecto proyecto);
    public Proyecto encontrarProyectoId(int id);
    public void actualizarProyecto(Proyecto proyectoactual);
}
