package com.durgam.guerra.controlador;
import com.durgam.guerra.modelo.Requisito;
import com.durgam.guerra.modelo.RequisitoCerrado;
import com.durgam.guerra.modelo.RequisitoEnProgreso;
import com.durgam.guerra.repositorio.RepositorioRequisito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControladorCambioEstados {
     @Autowired
   private RepositorioRequisito servicio;
    
    
    @RequestMapping(value="/Requisito/EnProgreso/{id}",method = RequestMethod.GET)
    public String CambioEstadoRequisitoEnProgreso(@PathVariable("id") int id, Model model){   
        Requisito requisito = servicio.encontrarRequisitoPorId(id);
        requisito.setEstado(RequisitoEnProgreso.getEstado());
        servicio.actualizarEstadoRequisito(requisito);
        return "redirect:/Requisito/Estados/"+id;
     }
    
    @RequestMapping(value="/Requisito/Cerrado/{id}",method = RequestMethod.GET)
    public String CambioEstadoRequisitoCerrado(@PathVariable("id") int id, Model model){
        Requisito requisito = servicio.encontrarRequisitoPorId(id);
        requisito.setEstado(RequisitoCerrado.getEstado());
        servicio.actualizarEstadoRequisito(requisito);
        return "redirect:/Requisito/Estados/"+id;
     }    
    }
    

