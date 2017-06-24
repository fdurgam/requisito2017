/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.durgam.guerra.servicio.Impl;

import com.durgam.guerra.modelo.Requisito;
import com.durgam.guerra.modelo.RequisitoSimple;
import com.durgam.guerra.repositorio.RepositorioGestionRequisitoface;
import com.durgam.guerra.repositorio.RepositorioRequisitoSimple;
import com.durgam.guerra.servicio.ServicioRequisitoSimple;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fernando
 */
@Service
public class ServicioRequisitoSimpleImpl implements  ServicioRequisitoSimple {
     @Autowired
    private RepositorioRequisitoSimple repo;

    @Override
    public List<RequisitoSimple> obtenerTodosRequisitosSimple() {
      return repo.obtenerTodosRequisitosSimple();
    }

    @Override
    public void nuevoRequisitoSimple(RequisitoSimple requisito) {
        repo.nuevoRequisitoSimple(requisito);
        
    }

    @Override
    public RequisitoSimple encontrarRequisitoSimplePorId(int id) {
       return repo.encontrarRequisitoSimplePorId(id);
    }

    @Override
    public void eliminarRequisitoSimple(Requisito requisito) {
        repo.eliminarRequisitoSimple(requisito);
    }

    @Override
    public void actualizarRequisitoSimple(RequisitoSimple requisitoactual) {
       repo.actualizarRequisitoSimple(requisitoactual);
    }
}
