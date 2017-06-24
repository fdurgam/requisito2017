package com.durgam.guerra.controlador;
import com.durgam.guerra.repositorio.RepositorioGestionRequisitoface;
import com.durgam.guerra.repositorio.RepositorioRequisito;
import com.durgam.guerra.repositorio.RepositorioRequisitoCompuesto;
import com.durgam.guerra.repositorio.RepositorioStakeholder;
import com.durgam.guerra.modelo.Requisito;
import com.durgam.guerra.modelo.RequisitoCompuesto;
import com.durgam.guerra.modelo.RequisitoSimple;
import com.durgam.guerra.modelo.Stakeholder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Controlador_requisito_stakeholder {
    @Autowired
    RepositorioStakeholder repStakeholder;
    @Autowired
    RepositorioRequisito repRequisito;
    @Autowired
    RepositorioRequisitoCompuesto repCompuesto;
    @Autowired
    RepositorioGestionRequisitoface repAp;
    @RequestMapping("/Stakeholder_Requisito") 
    public String AsociarStakeholder_Requisito(Model model){
        Stakeholder s= new Stakeholder("nombre","apellido","rol", "dni");
        Requisito r = new Requisito("n","n","pr","ri");
        Set<Requisito> lista = new HashSet<Requisito>(); 
        lista.add(r);
        s.setRequisitos(lista);
        repStakeholder.nuevoStakeholder(s);
        return "stakeholder";
}
    
    @RequestMapping(value="/Stakeholder/Requisito/{id}",method = RequestMethod.GET) 
    public String Stakeholder_Requisito(@PathVariable("id") int id, Model model){
        Stakeholder stakeholder = repStakeholder.encontrarStakeholderId(id);     
        model.addAttribute("cantidad", stakeholder.getRequisitos().size());
        model.addAttribute("stakeholder", stakeholder);
        return "Stakeholder_Requisito";
   } 
   
       
    @RequestMapping("/Compuestos") 
    public String Compuestos(Model model){
        RequisitoCompuesto venta = new  RequisitoCompuesto("Venta","Maquinaria","Alta","Bajo");
        RequisitoSimple traslado = new  RequisitoSimple("Carreteo","Traslado","Media","Bajo");
        RequisitoSimple acondicionado = new  RequisitoSimple("Limpieza","Lavado","Media","Bajo");
        RequisitoSimple comerciar = new  RequisitoSimple("tranferir","CambioDominio","Media","Bajo");
        venta.getRequisitosSimple().add(traslado);
        traslado.getCompuesto().add(venta);
        venta.getRequisitosSimple().add(acondicionado);
        acondicionado.getCompuesto().add(venta);
        venta.getRequisitosSimple().add(comerciar);
        comerciar.getCompuesto().add(venta);
        repCompuesto.nuevoRequisitoCompuesto(venta);
        return null; 
     }
     
    
}
     