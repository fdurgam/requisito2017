package com.durgam.guerra.controlador;
import com.durgam.guerra.repositorio.RepositorioGestionRequisitoface;
import com.durgam.guerra.modelo.Gestionrequisito;
import com.durgam.guerra.modelo.Proyecto;
import com.durgam.guerra.modelo.Requisito;
import com.durgam.guerra.modelo.RequisitoAbierto;
import com.durgam.guerra.modelo.RequisitoCompuesto;
import com.durgam.guerra.modelo.RequisitoSimple;
import com.durgam.guerra.modelo.Stakeholder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControladorGestionRequisito {
   @Autowired
   private RepositorioGestionRequisitoface servicio;
   
    
    @RequestMapping("/Gestion")
    public String GestionRequisito(Model model){
        model.addAttribute("datos",servicio.obtenerTodosGestionRequisito());
        return "gestionRequisito"; 
    }
    
    @RequestMapping(value="/Gestion/nuevo",method = RequestMethod.GET)
    public String nuevoGestionrequisito(Model model){  
       Gestionrequisito gestion=new Gestionrequisito();       
       model.addAttribute("gestion", gestion);
       return "gestionRequisitoform";
    }
    
    @RequestMapping(value="/Gestion/nuevo",method = RequestMethod.POST)
    public String guardaGestionrequisito(@ModelAttribute("gestion") Gestionrequisito gestionNuevo){
        servicio.nuevoGestionRequisito(gestionNuevo);
        return "redirect:/Gestion";
    }
    
    @RequestMapping(value="/Gestion/update/{id}",method = RequestMethod.GET)
    public String updateGestion(@PathVariable("id") int id, Model model){
        Gestionrequisito gestion = servicio.encontrarGestionrequisitoPorId(id);
        model.addAttribute("updateGestion", gestion);
        return "gestionRequisitoUpdate";
    }

    @RequestMapping(value="/Gestion/update/{id}",method = RequestMethod.POST)
    public String ActualizarGestionrequisito(@PathVariable("id") int id, @ModelAttribute("updateGestion") Gestionrequisito gestionActual){
        servicio.actualizarGestionrequisito(gestionActual);
        return "redirect:/Gestion";
    }
   
    @RequestMapping(value="/Gestion/eliminar/{id}",method = RequestMethod.GET)
    public String eliminarGestionrequisito( @PathVariable("id") int id){
      Gestionrequisito ap = servicio.encontrarGestionrequisitoPorId(id);
      servicio.eliminarGestionrequisito(ap);
      return "redirect:/Gestion";
    }
    
    @RequestMapping(value="/Gestion/Proyectos/{id}")
    public String GestionProyectos( @PathVariable("id") int id, Model model){
     Gestionrequisito gestion = servicio.encontrarGestionrequisitoPorId(id);
     model.addAttribute("gestion", gestion);
     model.addAttribute("proyectos", gestion.getProyectos().size());
     return "GestionProyectos";
    }
     
    @RequestMapping("/CargarDatos")  
    public String componer(Model model){
        Gestionrequisito ap = new Gestionrequisito("Sistema","Requisito2017");
        Stakeholder analista= new Stakeholder("Martin","Palermo","Analista Junior", "25678987");
        Stakeholder  programador= new Stakeholder("Tito","Puente","Programador Junior", "25678907");
        Proyecto loop2017 = new Proyecto("Expansion","Linea Electrica Salta");
        Proyecto sislab = new Proyecto("Desarrollo","Sistema Stock");
        RequisitoCompuesto req1Loop2017 = new  RequisitoCompuesto("Compra","Vehiculo Traslado","Alta","Bajo");
        RequisitoCompuesto req2Loop2017 = new  RequisitoCompuesto("Contratacion","Server","Alta","Bajo");
        RequisitoSimple req3Loop2017 = new  RequisitoSimple("Extraccion","Agua","Media","Bajo");
        RequisitoSimple req1sislab = new  RequisitoSimple("Analizar","Requerimiento","Media","Bajo");
        Requisito requisito=new Requisito("Credito","Banco Macro","Alta","Medio");
        RequisitoAbierto estado = RequisitoAbierto.getEstado();
        requisito.setEstado(estado);
        req1Loop2017.getRequisitosSimple().add(requisito);
        requisito.getCompuesto().add(req2Loop2017);
        req1Loop2017.setEstado(estado);
        req2Loop2017.setEstado(estado);
        req3Loop2017.setEstado(estado);
        req1sislab.setEstado(estado);
        estado.getRequisitos().add(req1Loop2017);
        estado.getRequisitos().add(req2Loop2017);
        estado.getRequisitos().add(req3Loop2017);
        estado.getRequisitos().add(req1sislab);
        loop2017.getRequisitos().add(req1Loop2017);
        loop2017.getRequisitos().add(req2Loop2017);
        loop2017.getRequisitos().add(req3Loop2017);
        req1Loop2017.setProyecto(loop2017);
        req2Loop2017.setProyecto(loop2017);
        req3Loop2017.setProyecto(loop2017);
        sislab.getRequisitos().add(req1sislab);
        req1sislab.setProyecto(sislab);
        req1sislab.getStakeholders().add(analista);
        req1sislab.getStakeholders().add(programador);
        analista.getRequisitos().add(req1sislab);
        programador.getRequisitos().add(req1sislab);
        loop2017.setAplicacion(ap);
        sislab.setAplicacion(ap);
        ap.getProyectos().add(loop2017);  
        ap.getProyectos().add(sislab);  
        servicio.nuevoGestionRequisito(ap);
        return "redirect:/Gestion";
   } 
}
