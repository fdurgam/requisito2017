package com.durgam.guerra.controlador;
import com.durgam.guerra.repositorio.RepositorioProyecto;
import com.durgam.guerra.repositorio.RepositorioRequisitoCompuesto;
import com.durgam.guerra.modelo.EstadoRequisito;
import com.durgam.guerra.modelo.RequisitoAbierto;
import com.durgam.guerra.modelo.RequisitoCompuesto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControladorRequisitoCompuesto {
    @Autowired
    RepositorioRequisitoCompuesto repositorio;
    @Autowired
    RepositorioProyecto repoProyecto;
    @RequestMapping("/RequisitoCompuesto")
        public String RequisitosCompuesto(Model model){
        model.addAttribute("datos",repositorio.obtenerTodosRequisitosCompuesto());   
        return "requisitoCompuesto"; 
    }
    
    @RequestMapping(value="/RequisitoCompuesto/nuevo",method = RequestMethod.GET)
    public String nuevoRequisito(Model model){
        RequisitoCompuesto requisito=new RequisitoCompuesto();       
        model.addAttribute("requisito", requisito);
        return "requisitoCompuestoform";
    }
    
    @RequestMapping(value="/RequisitoCompuesto/nuevo",method = RequestMethod.POST)
     public String guardaRequisitoCompuesto(@ModelAttribute("requisito")RequisitoCompuesto requisito){      
     repositorio.nuevoRequisitoCompuesto(requisito);
     return "redirect:/RequisitoCompuesto";
    }
     
    @RequestMapping(value="/RequisitoCompuesto/eliminar/{id}",method = RequestMethod.GET)
    public String eliminarRequisitoCompuesto( @PathVariable("id") int id){
        RequisitoCompuesto requisito= repositorio.encontrarRequisitoCompuestoPorId(id);
        repositorio.eliminarRequisitoCompuesto(requisito);
        return "redirect:/RequisitoCompuesto";
    }
    
    @RequestMapping(value="/RequisitoCompuesto/update/{id}",method = RequestMethod.GET)
    public String updateRequisito(@PathVariable("id") int id, Model model){
       RequisitoCompuesto requisito = repositorio.encontrarRequisitoCompuestoPorId(id);
       model.addAttribute("proyectos", repoProyecto.obtenerTodosProyecto());
       model.addAttribute("updaterequisitocompuesto", requisito);
       return "requisitoCompuestoUpdate";
    }

    @RequestMapping(value="/RequisitoCompuesto/update/{id}",method = RequestMethod.POST)
    public String ActualizarRequisitoCompuesto(@PathVariable("id") int id, @ModelAttribute("updaterequisitocompuesto") RequisitoCompuesto requisitoActual){
        requisitoActual.setId(id);
        EstadoRequisito estado = RequisitoAbierto.getEstado();
        requisitoActual.setEstado(estado);
        repositorio.actualizarRequisitoCompuesto(requisitoActual);
        return "redirect:/RequisitoCompuesto";
    } 
}
