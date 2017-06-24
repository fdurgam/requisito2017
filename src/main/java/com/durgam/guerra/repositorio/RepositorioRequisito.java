package com.durgam.guerra.repositorio;

import com.durgam.guerra.modelo.Requisito;
import java.util.List;

public interface RepositorioRequisito {
   public List<Requisito> obtenerTodosRequisitos();
   public void nuevoRequisito(Requisito requisito);
   public Requisito encontrarRequisitoPorId(int id);
   public void eliminarRequisito(Requisito requisito);
   public void actualizarRequisito(Requisito requisitoactual);

    public void actualizarEstadoRequisito(Requisito requisito);
   }
