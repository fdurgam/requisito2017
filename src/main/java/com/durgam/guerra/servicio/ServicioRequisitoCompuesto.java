/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.durgam.guerra.servicio;

import com.durgam.guerra.modelo.RequisitoCompuesto;
import java.util.List;

/**
 *
 * @author fernando
 */
public interface ServicioRequisitoCompuesto {
    public List<RequisitoCompuesto>  obtenerTodosRequisitosCompuesto();
    public void nuevoRequisitoCompuesto(RequisitoCompuesto requisito);
    public RequisitoCompuesto encontrarRequisitoCompuestoPorId(int id);
    public void eliminarRequisitoCompuesto(RequisitoCompuesto requisito);
    public void actualizarRequisitoCompuesto(RequisitoCompuesto requisitoactual); 

    public void actualizarRequisitoCompuestoNuevoRequisito(RequisitoCompuesto requisito);
}
