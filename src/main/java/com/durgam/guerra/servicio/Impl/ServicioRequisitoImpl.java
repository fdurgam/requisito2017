/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.durgam.guerra.servicio.Impl;

import com.durgam.guerra.modelo.Requisito;
import com.durgam.guerra.repositorio.RepositorioGestionRequisitoface;
import com.durgam.guerra.repositorio.RepositorioRequisito;
import com.durgam.guerra.servicio.ServicioRequisito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fernando
 */
@Service
public class ServicioRequisitoImpl implements ServicioRequisito {
     @Autowired
    private RepositorioRequisito repo;

    @Override
    public List<Requisito> obtenerTodosRequisitos() {
       return repo.obtenerTodosRequisitos();
    }

    @Override
    public void nuevoRequisito(Requisito requisito) {
        repo.nuevoRequisito(requisito);
    }

    @Override
    public Requisito encontrarRequisitoPorId(int id) {
       return repo.encontrarRequisitoPorId(id);
    }

    @Override
    public void eliminarRequisito(Requisito requisito) {
      repo.eliminarRequisito(requisito);
    }

    @Override
    public void actualizarRequisito(Requisito requisitoactual) {
       repo.actualizarRequisito(requisitoactual);
    }

    @Override
    public void actualizarEstadoRequisito(Requisito requisito) {
        repo.actualizarEstadoRequisito(requisito);
    }
}
