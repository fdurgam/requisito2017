/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.durgam.guerra.servicio;

import com.durgam.guerra.modelo.Requisito;
import com.durgam.guerra.modelo.RequisitoSimple;
import java.util.List;

/**
 *
 * @author fernando
 */
public interface ServicioRequisitoSimple {
    public List<RequisitoSimple>  obtenerTodosRequisitosSimple();
    public void nuevoRequisitoSimple(RequisitoSimple requisito);
    public RequisitoSimple encontrarRequisitoSimplePorId(int id);
    public void eliminarRequisitoSimple(Requisito requisito);
    public void actualizarRequisitoSimple(RequisitoSimple requisitoactual);  
}
