package com.durgam.guerra.controlador;
import com.durgam.guerra.repositorio.RepositorioProyecto;
import com.durgam.guerra.repositorio.RepositorioRequisitoSimple;
import com.durgam.guerra.modelo.EstadoRequisito;
import com.durgam.guerra.modelo.Proyecto;
import com.durgam.guerra.modelo.Requisito;
import com.durgam.guerra.modelo.RequisitoAbierto;
import com.durgam.guerra.modelo.RequisitoSimple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControladorRequisitoSimple {
    @Autowired
    RepositorioRequisitoSimple repositorio;
    @Autowired
    RepositorioProyecto repoProyecto;
    
    @RequestMapping("/RequisitoSimple")
    public String RequisitosSmple(Model model){
        model.addAttribute("datos",repositorio.obtenerTodosRequisitosSimple());       
        return "requisitoSimple"; 
        }
    
    @RequestMapping(value="/RequisitoSimple/nuevo",method = RequestMethod.GET)
    public String nuevoRequisito(Model model){
        RequisitoSimple requisito=new RequisitoSimple(); 
        RequisitoAbierto estado = RequisitoAbierto.getEstado();
        requisito.setEstado(estado);
        model.addAttribute("requisito", requisito);
        return "requisitoSimpleform";
    }
    
    @RequestMapping(value="/RequisitoSimple/nuevo",method = RequestMethod.POST)
    public String guardaProyecto(@ModelAttribute("requisito")RequisitoSimple requisito){
       EstadoRequisito estado = RequisitoAbierto.getEstado();
        requisito.setEstado(estado);
        repositorio.nuevoRequisitoSimple(requisito);
        return "redirect:/RequisitoSimple";
    }
   
    @RequestMapping(value="/RequisitoSimple/eliminar/{id}",method = RequestMethod.GET)
        public String eliminarRequisitosimple( @PathVariable("id") int id){
        RequisitoSimple requisito= repositorio.encontrarRequisitoSimplePorId(id);
        repositorio.eliminarRequisitoSimple(requisito);
        return "redirect:/RequisitoSimple";
    }
    
    @RequestMapping(value="/RequisitoSimple/update/{id}",method = RequestMethod.GET)
    public String updateRequisito(@PathVariable("id") int id, Model model){
        Requisito requisito = repositorio.encontrarRequisitoSimplePorId(id);
        model.addAttribute("proyectos", repoProyecto.obtenerTodosProyecto());
        model.addAttribute("updaterequisitosimple", requisito); 
        return "requisitoSimpleUpdate";
    }
    
    @RequestMapping(value="/RequisitoSimple/update/{id}",method = RequestMethod.POST)
    public String ActualizarRequisito(@PathVariable("id") int id, @ModelAttribute("updaterequisitosimple") RequisitoSimple requisitoActual){
        requisitoActual.setId(id);
        Proyecto proyecto= repoProyecto.encontrarProyectoId(requisitoActual.getProyecto().getId());
       requisitoActual.setProyecto(proyecto);
       // EstadoRequisito estado = RequisitoAbierto.getEstado();
        
        //requisitoActual.setEstado(estado);
        repositorio.actualizarRequisitoSimple(requisitoActual);
        return "redirect:/RequisitoSimple";
    }
}
