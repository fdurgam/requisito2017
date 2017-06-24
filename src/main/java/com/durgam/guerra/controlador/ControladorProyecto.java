package com.durgam.guerra.controlador;
import com.durgam.guerra.repositorio.RepositorioGestionRequisitoface;
import com.durgam.guerra.repositorio.RepositorioProyecto;
import com.durgam.guerra.modelo.Gestionrequisito;
import com.durgam.guerra.modelo.Proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ControladorProyecto {
@Autowired
    RepositorioProyecto repositorio;
@Autowired
    RepositorioGestionRequisitoface repositorioAp;
    @RequestMapping("/Proyecto")
    public String mostrarproyectos(Model model){
        model.addAttribute("datos",repositorio.obtenerTodosProyecto());    
        return "proyecto"; 
    }
    
    @RequestMapping(value="/Proyecto/eliminar/{id}",method = RequestMethod.GET)
    public String eliminarProyecto( @PathVariable("id") int id){
        Proyecto documento= repositorio.encontrarProyectoPorId(id);
        repositorio.eliminarProyecto(documento);
        return "redirect:/Proyecto";
    }
    
    @RequestMapping(value="/Proyecto/nuevo",method = RequestMethod.GET)
    public String nuevoProyecto(Model model){
        Proyecto proyecto=new Proyecto();       
        model.addAttribute("proyecto", proyecto);
        return "proyectoform";
    }
    
    @RequestMapping(value="/Proyecto/nuevo",method = RequestMethod.POST)
     public String guardaProyecto(@ModelAttribute("proyecto") Proyecto proyecto){
     repositorio.nuevoProyecto(proyecto);
     return "redirect:/Proyecto";
    }

    @RequestMapping(value="/Proyecto/update/{id}",method = RequestMethod.GET)
    public String updateProyecto(@PathVariable("id") int id, Model model){
        Proyecto proyecto = repositorio.encontrarProyectoId(id);
        model.addAttribute("aplicaciones", repositorioAp.obtenerTodosGestionRequisito());
        model.addAttribute("updateproyecto", proyecto); 
        return "proyectoUpdate";
    }
    
    
    @RequestMapping(value="/Proyecto/update/{id}",method = RequestMethod.POST)
    public String ActualizarProyecto(@PathVariable("id") int id, @ModelAttribute("updateproyecto") Proyecto proyectoActual){
      proyectoActual.setId(id);
      Gestionrequisito aplicacion = repositorioAp.encontrarGestionrequisitoPorId(proyectoActual.getAplicacion().getId());
      proyectoActual.setAplicacion(aplicacion);
      repositorio.actualizarProyecto(proyectoActual);
      return "redirect:/Proyecto";
    }
    
    @RequestMapping(value="/Proyectos/Requisitos/{id}",method = RequestMethod.GET)
    public String RequisitosProyecto(@PathVariable("id") int id,Model model ){
        Proyecto proyecto= repositorio.encontrarProyectoId(id);
        model.addAttribute("proyecto", proyecto);
        return "ProyectosRequisitos";
    }  
}
