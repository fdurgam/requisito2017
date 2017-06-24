package com.durgam.guerra.controlador;
import com.durgam.guerra.repositorio.RepositorioProyecto;
import com.durgam.guerra.repositorio.RepositorioRequisito;
import com.durgam.guerra.modelo.EstadoRequisito;
import com.durgam.guerra.modelo.Proyecto;
import com.durgam.guerra.modelo.Requisito;
import com.durgam.guerra.modelo.RequisitoAbierto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControladorRequisito {
    @Autowired
    RepositorioRequisito repositorio;
    @Autowired
    RepositorioProyecto repoProyecto;
    @RequestMapping("/Requisito")
    public String Requisitos(Model model){
    model.addAttribute("datos",repositorio.obtenerTodosRequisitos());
    model.addAttribute("cantidad",repositorio.obtenerTodosRequisitos().size());        
    return "requisito"; 
    }
    
    @RequestMapping(value="/Requisito/nuevo",method = RequestMethod.GET)
    public String nuevoRequisito(Model model){
        Requisito requisito=new Requisito();       
        model.addAttribute("requisito", requisito);  
        return "requisitoform";
    }
    
    @RequestMapping(value="/Requisito/nuevo",method = RequestMethod.POST)
    public String guardaProyecto(@ModelAttribute("requisito")Requisito requisito){
        EstadoRequisito estado = RequisitoAbierto.getEstado();
        requisito.setEstado(estado);
        repositorio.nuevoRequisito(requisito);
        return "redirect:/Requisito";
    }
   
    @RequestMapping(value="/Requisito/eliminar/{id}",method = RequestMethod.GET)
    public String eliminarRequisito( @PathVariable("id") int id){
        Requisito requisito= repositorio.encontrarRequisitoPorId(id);
        repositorio.eliminarRequisito(requisito);
        return "redirect:/Requisito";
    }
    
    @RequestMapping(value="/Requisito/update/{id}",method = RequestMethod.GET)
    public String updateRequisito(@PathVariable("id") int id, Model model){
        Requisito requisito = repositorio.encontrarRequisitoPorId(id);  
        model.addAttribute("proyectos", repoProyecto.obtenerTodosProyecto());
        model.addAttribute("updaterequisito", requisito);
        return "requisitoUpdate";
    }
    
    @RequestMapping(value="/Requisito/update/{id}",method = RequestMethod.POST)
    public String ActualizarRequisito(@PathVariable("id") int id, @ModelAttribute("updaterequisito") Requisito requisitoActual){
      
        requisitoActual.setId(id);
        Proyecto proyecto= repoProyecto.encontrarProyectoId(requisitoActual.getProyecto().getId());
       requisitoActual.setProyecto(proyecto);
        //EstadoRequisito estado = RequisitoAbierto.getEstado();
        
        //requisitoActual.setEstado(estado);
        repositorio.actualizarRequisito(requisitoActual);
        return "redirect:/Requisito";
    }
   
    
    @RequestMapping(value="/Requisito/Estados/{id}",method = RequestMethod.GET)
    public String RequisitoEstados(@PathVariable("id") int id, Model model){
        Requisito requisito = repositorio.encontrarRequisitoPorId(id);
        model.addAttribute("requisito", requisito);
        model.addAttribute("siguientes",requisito.getEstado().getSiguientes());
        return "RequisitoEstados";
    }

}
