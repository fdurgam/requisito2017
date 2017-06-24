/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.durgam.guerra.servicio;

import com.durgam.guerra.modelo.Gestionrequisito;
import java.util.List;

/**
 *
 * @author fernando
 */
public interface ServicioGestionRequisitoface {
      public List<Gestionrequisito> obtenerTodosGestionRequisito();
    void nuevoGestionRequisito(Gestionrequisito ap);
    Gestionrequisito encontrarGestionrequisitoPorId(int id);
    public void actualizarGestionrequisito(Gestionrequisito ap);
    void eliminarGestionrequisito(Gestionrequisito ap);
}
