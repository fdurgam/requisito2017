package com.durgam.guerra.repositorio.impl;
import com.durgam.guerra.modelo.Proyecto;
import com.durgam.guerra.modelo.Requisito;
import com.durgam.guerra.repositorio.RepositorioRequisito;
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
public class RepositorioRequisitoImp implements RepositorioRequisito {
private SessionFactory sessionFactory;
    @Transactional    
    @Override
    public List<Requisito> obtenerTodosRequisitos() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Requisito";
        Query query = session.createQuery(hql);
        List<Requisito> requisitos = query.list();
        return requisitos;
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
    public void nuevoRequisito(Requisito requisito) {
        Session session = getSessionFactory().getCurrentSession();
        session.save(requisito);
    }
    
    @Transactional
    @Override
    public Requisito encontrarRequisitoPorId(int id) {
        Session session = getSessionFactory().getCurrentSession();    
        Query query = session.createQuery("FROM Requisito where id="+Integer.toString(id));
        Requisito requisito= (Requisito)query.uniqueResult();
        return requisito;
    }
    
    @Transactional
    @Override
    public void eliminarRequisito(Requisito requisito) {
       Session session = getSessionFactory().getCurrentSession();
       session.delete(requisito); 
    }

    @Transactional
    @Override
    public void actualizarRequisito(Requisito requisitoActual) {
        Session session = getSessionFactory().getCurrentSession();
        
         int id = requisitoActual.getId();
         Requisito requisito=(Requisito)session.get(Requisito.class, id, new LockOptions(LockMode.OPTIMISTIC));
       
        requisito.setVersion(requisito.getVersion()-1);
        requisito.setId(requisitoActual.getId());
        requisito.setNecesidad(requisitoActual.getNecesidad());
        requisito.setNombre(requisitoActual.getNombre());
        requisito.setPrioridad(requisitoActual.getPrioridad());
       // requisito.setProyecto(requisitoActual.getProyecto());
        requisito.setRiesgo(requisitoActual.getRiesgo());
        requisito.setStakeholders(requisitoActual.getStakeholders());
        requisito.setCompuesto(requisitoActual.getCompuesto());
        //requisito.setEstado(requisitoActual.getEstado());
        
        
        
        
       // session.saveOrUpdate(requisitoactual);
    }
}