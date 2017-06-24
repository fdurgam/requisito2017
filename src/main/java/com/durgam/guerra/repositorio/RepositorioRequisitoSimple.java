package com.durgam.guerra.repositorio;

import com.durgam.guerra.modelo.Requisito;
import com.durgam.guerra.modelo.RequisitoSimple;
import java.util.List;

public interface RepositorioRequisitoSimple {
    public List<RequisitoSimple>  obtenerTodosRequisitosSimple();
    public void nuevoRequisitoSimple(RequisitoSimple requisito);
    public RequisitoSimple encontrarRequisitoSimplePorId(int id);
    public void eliminarRequisitoSimple(Requisito requisito);
    public void actualizarRequisitoSimple(RequisitoSimple requisitoactual);  
}
