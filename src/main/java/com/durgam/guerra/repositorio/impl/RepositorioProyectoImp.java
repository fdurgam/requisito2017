package com.durgam.guerra.repositorio.impl;
import com.durgam.guerra.modelo.Proyecto;
import com.durgam.guerra.repositorio.RepositorioProyecto;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RepositorioProyectoImp implements RepositorioProyecto {
    private SessionFactory sessionFactory;
    @Transactional   
    @Override
    public List<Proyecto> obtenerTodosProyecto() {
       Session session = sessionFactory.getCurrentSession();
       String hql = "FROM Proyecto";
       Query query = session.createQuery(hql);
       List<Proyecto> documentos = query.list();
       return documentos;
    }
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    @Transactional  
    @Override
    public Proyecto encontrarProyectoPorId(int id) {
        Session session = getSessionFactory().getCurrentSession();  
        Query query = session.createQuery("FROM Proyecto where id="+Integer.toString(id));
        Proyecto documento= (Proyecto)query.uniqueResult();
        return documento;
    }
    
    @Transactional  
    @Override
    
    public void eliminarProyecto(Proyecto documento) {
       Session session = getSessionFactory().getCurrentSession();
       session.delete(documento); 
    }
    
    @Transactional  
    @Override
    public void nuevoProyecto(Proyecto proyecto) {
        Session session = getSessionFactory().getCurrentSession();
        session.saveOrUpdate(proyecto);
    }
    
    @Transactional  
    @Override
    public Proyecto encontrarProyectoId(int id) {
       Session session = getSessionFactory().getCurrentSession();  
       Query query = session.createQuery("FROM Proyecto where id="+Integer.toString(id));
       Proyecto proyecto= (Proyecto)query.uniqueResult(); 
       return proyecto;
    }
    
    @Transactional  
    @Override
    public void actualizarProyecto(Proyecto proyectoActual) {
        Session session = getSessionFactory().getCurrentSession();
         int id = proyectoActual.getId();
         Proyecto proyecto=(Proyecto)session.get(Proyecto.class, id, new LockOptions(LockMode.OPTIMISTIC));
       
        proyecto.setVersion(proyecto.getVersion()-1);
        proyecto.setId(proyectoActual.getId());
        
        
        proyecto.setNombreProyecto(proyectoActual.getNombreProyecto());
        proyecto.setDescripcionProyecto(proyectoActual.getDescripcionProyecto());
        proyecto.setAplicacion(proyectoActual.getAplicacion());
        proyecto.setRequisitos(proyectoActual.getRequisitos());
         //session.saveOrUpdate(proyectoActual);
    }
}
