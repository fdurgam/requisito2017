package com.durgam.guerra.repositorio;

import com.durgam.guerra.modelo.RequisitoCompuesto;
import java.util.List;

public interface RepositorioRequisitoCompuesto {
    public List<RequisitoCompuesto>  obtenerTodosRequisitosCompuesto();
    public void nuevoRequisitoCompuesto(RequisitoCompuesto requisito);
    public RequisitoCompuesto encontrarRequisitoCompuestoPorId(int id);
    public void eliminarRequisitoCompuesto(RequisitoCompuesto requisito);
    public void actualizarRequisitoCompuesto(RequisitoCompuesto requisitoactual); 
}
