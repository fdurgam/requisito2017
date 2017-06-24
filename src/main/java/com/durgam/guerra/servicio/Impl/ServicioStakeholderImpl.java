/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.durgam.guerra.servicio.Impl;

import com.durgam.guerra.modelo.Stakeholder;
import com.durgam.guerra.repositorio.RepositorioGestionRequisitoface;
import com.durgam.guerra.repositorio.RepositorioStakeholder;
import com.durgam.guerra.servicio.ServicioStakeholder;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fernando
 */
@Service
public class ServicioStakeholderImpl implements ServicioStakeholder {
     @Autowired
    private RepositorioStakeholder repo;

    @Override
    public List<Stakeholder> obtenerTodosStakeholder() {
       return repo.obtenerTodosStakeholder();
    }

    @Override
    public void nuevoStakeholder(Stakeholder stakeholder) {
        repo.nuevoStakeholder(stakeholder);
    }

    @Override
    public Stakeholder encontrarStakeholderId(int id) {
        return repo.encontrarStakeholderId(id);
    }

    @Override
    public void actualizarStakeholder(Stakeholder stakeholderActual) {
        repo.actualizarStakeholder(stakeholderActual);
    }
}
