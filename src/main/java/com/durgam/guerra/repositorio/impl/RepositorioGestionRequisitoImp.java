package com.durgam.guerra.repositorio.impl;
import com.durgam.guerra.modelo.Gestionrequisito;
import com.durgam.guerra.modelo.Proyecto;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.durgam.guerra.repositorio.RepositorioGestionRequisitoface;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;

@Repository
public class RepositorioGestionRequisitoImp implements RepositorioGestionRequisitoface {
private SessionFactory sessionFactory;
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    @Transactional
    @Override
    public List<Gestionrequisito> obtenerTodosGestionRequisito() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Gestionrequisito";
        Query query = session.createQuery(hql);
        List<Gestionrequisito> gestion = query.list();
        return gestion;
    }

    @Transactional
    @Override
    public void nuevoGestionRequisito(Gestionrequisito ap) {
        Session session = getSessionFactory().getCurrentSession();
        session.save(ap);
    }

    @Transactional
    @Override
    public Gestionrequisito encontrarGestionrequisitoPorId(int id) {
        Session session = getSessionFactory().getCurrentSession();    
        Query query = session.createQuery("FROM Gestionrequisito where id="+Integer.toString(id));
        Gestionrequisito gestion= (Gestionrequisito)query.uniqueResult();
        return gestion;
    }
    
    @Transactional
    @Override
    public void actualizarGestionrequisito(Gestionrequisito ap) {
        Session session = getSessionFactory().getCurrentSession();
          int id = ap.getId();
         Gestionrequisito gestion=(Gestionrequisito)session.get(Gestionrequisito.class, id, new LockOptions(LockMode.OPTIMISTIC));
       
        gestion.setVersion(gestion.getVersion()-1);
        gestion.setId(ap.getId());
        gestion.setNombre(ap.getNombre());
        gestion.setProyectos(ap.getProyectos());
        gestion.setSistemaNombre(ap.getSistemaNombre());
        
    }
    
    @Transactional
    @Override
    public void eliminarGestionrequisito(Gestionrequisito ap) {
       Session session = getSessionFactory().getCurrentSession();
       session.delete(ap);
    }
}
