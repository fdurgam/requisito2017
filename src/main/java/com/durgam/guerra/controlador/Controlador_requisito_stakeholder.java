package com.durgam.guerra.controlador;
import com.durgam.guerra.repositorio.RepositorioStakeholder;
import com.durgam.guerra.modelo.Stakeholder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Controlador_requisito_stakeholder {
    @Autowired
    RepositorioStakeholder repStakeholder;
   
    @RequestMapping(value="/Stakeholder/Requisito/{id}",method = RequestMethod.GET) 
    public String Stakeholder_Requisito(@PathVariable("id") int id, Model model){
        Stakeholder stakeholder = repStakeholder.encontrarStakeholderId(id);     
        model.addAttribute("stakeholder", stakeholder);
        return "Stakeholder_Requisito";
   }  
} 