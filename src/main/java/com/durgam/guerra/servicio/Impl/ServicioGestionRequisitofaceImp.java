/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.durgam.guerra.servicio.Impl;

import com.durgam.guerra.modelo.Gestionrequisito;
import com.durgam.guerra.repositorio.RepositorioGestionRequisitoface;
import com.durgam.guerra.servicio.ServicioGestionRequisitoface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fernando
 */
@Service
public class ServicioGestionRequisitofaceImp implements  ServicioGestionRequisitoface {
    @Autowired
    private RepositorioGestionRequisitoface repo;

    @Override
    public List<Gestionrequisito> obtenerTodosGestionRequisito() {
       return repo.obtenerTodosGestionRequisito();
    }

    @Override
    public void nuevoGestionRequisito(Gestionrequisito ap) {
      repo.nuevoGestionRequisito(ap);
    }

    @Override
    public Gestionrequisito encontrarGestionrequisitoPorId(int id) {
       return repo.encontrarGestionrequisitoPorId(id);
    }

    @Override
    public void actualizarGestionrequisito(Gestionrequisito ap) {
        repo.actualizarGestionrequisito(ap);
    }

    @Override
    public void eliminarGestionrequisito(Gestionrequisito ap) {
       repo.eliminarGestionrequisito(ap);
    }
}
