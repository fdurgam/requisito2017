package com.durgam.guerra.controlador;
import com.durgam.guerra.repositorio.RepositorioStakeholder;
import com.durgam.guerra.modelo.Stakeholder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControladorStakeholder {
    @Autowired
    RepositorioStakeholder repositorio;
    
    @RequestMapping("/Stakeholder")
    public String mostrarStakeholder(Model model){
        model.addAttribute("datos",repositorio.obtenerTodosStakeholder());
        model.addAttribute("cantidad",1);
        return "stakeholder"; 
    }
    
    @RequestMapping(value="/Stakeholder/nuevo",method = RequestMethod.GET)
    public String nuevoStakeholder(Model model){  
        Stakeholder stakeholder=new Stakeholder();       
        model.addAttribute("stakeholder", stakeholder);
        return "stakeholderform";
    }
    
    @RequestMapping(value="/Stakeholder/nuevo",method = RequestMethod.POST)
    public String guardaStakeholder(@ModelAttribute("stakeholder") Stakeholder stakeholder){
        repositorio.nuevoStakeholder(stakeholder);
        return "redirect:/Stakeholder";
    }

    @RequestMapping(value="/Stakeholder/update/{id}",method = RequestMethod.GET)
    public String updateStakeholder(@PathVariable("id") int id, Model model){
        Stakeholder stakeholder = repositorio.encontrarStakeholderId(id);
        model.addAttribute("updatestakeholder", stakeholder);   
        return "stakeholderUpdate";
    }
    
    
    @RequestMapping(value="/Stakeholder/update/{id}",method = RequestMethod.POST)
    public String ActualizaStakeholder(@PathVariable("id") int id, @ModelAttribute("updatestakeholder") Stakeholder stakeholderActual){
        repositorio.actualizarStakeholder(stakeholderActual);
        return "redirect:/Stakeholder";
    }
}
