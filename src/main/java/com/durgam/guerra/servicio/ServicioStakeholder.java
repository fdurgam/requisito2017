/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.durgam.guerra.servicio;

import com.durgam.guerra.modelo.Stakeholder;
import java.util.List;

/**
 *
 * @author fernando
 */
public interface ServicioStakeholder {
    public List<Stakeholder> obtenerTodosStakeholder();
    void nuevoStakeholder(Stakeholder stakeholder);
    public Stakeholder encontrarStakeholderId(int id);
    public void actualizarStakeholder(Stakeholder stakeholderActual); 
}
