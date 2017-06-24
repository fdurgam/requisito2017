/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.durgam.guerra.servicio;

import com.durgam.guerra.modelo.Requisito;
import java.util.List;

/**
 *
 * @author fernando
 */
public interface ServicioRequisito {
     public List<Requisito> obtenerTodosRequisitos();
   public void nuevoRequisito(Requisito requisito);
   public Requisito encontrarRequisitoPorId(int id);
   public void eliminarRequisito(Requisito requisito);
   public void actualizarRequisito(Requisito requisitoactual);

    public void actualizarEstadoRequisito(Requisito requisito);
}
