/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.durgam.guerra.servicio.Impl;

import com.durgam.guerra.modelo.RequisitoCompuesto;
import com.durgam.guerra.repositorio.RepositorioGestionRequisitoface;
import com.durgam.guerra.repositorio.RepositorioRequisitoCompuesto;
import com.durgam.guerra.servicio.ServicioRequisitoCompuesto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fernando
 */
@Service
public class ServicioRequisitoCompuestoImpl implements ServicioRequisitoCompuesto {
     @Autowired
    private RepositorioRequisitoCompuesto repo;

    @Override
    public List<RequisitoCompuesto> obtenerTodosRequisitosCompuesto() {
      return repo.obtenerTodosRequisitosCompuesto();
    }

    @Override
    public void nuevoRequisitoCompuesto(RequisitoCompuesto requisito) {
       repo.nuevoRequisitoCompuesto(requisito);
    }

    @Override
    public RequisitoCompuesto encontrarRequisitoCompuestoPorId(int id) {
        return repo.encontrarRequisitoCompuestoPorId(id);
    }

    @Override
    public void eliminarRequisitoCompuesto(RequisitoCompuesto requisito) {
       repo.eliminarRequisitoCompuesto(requisito);
    }

    @Override
    public void actualizarRequisitoCompuesto(RequisitoCompuesto requisitoactual) {
       repo.actualizarRequisitoCompuesto(requisitoactual);
    }

    @Override
    public void actualizarRequisitoCompuestoNuevoRequisito(RequisitoCompuesto requisito) {
       repo.actualizarRequisitoCompuestoNuevoRequisito(requisito);
    }
}
