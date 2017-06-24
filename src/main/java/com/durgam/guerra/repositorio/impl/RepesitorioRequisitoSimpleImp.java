package com.durgam.guerra.repositorio.impl;
import com.durgam.guerra.repositorio.RepositorioRequisitoSimple;
import com.durgam.guerra.modelo.Requisito;
import com.durgam.guerra.modelo.RequisitoCompuesto;
import com.durgam.guerra.modelo.RequisitoSimple;
import com.durgam.guerra.repositorio.RepositorioRequisitoSimple;
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
public class RepesitorioRequisitoSimpleImp implements RepositorioRequisitoSimple{
private SessionFactory sessionFactory;
   
@Transactional  
    @Override
    public List<RequisitoSimple> obtenerTodosRequisitosSimple() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM RequisitoSimple";
        Query query = session.createQuery(hql);
        List<RequisitoSimple> requisitos = query.list();
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
    public void nuevoRequisitoSimple(RequisitoSimple requisito) {
        Session session = getSessionFactory().getCurrentSession();
        session.save(requisito);
    }
    
    @Transactional
    @Override
    public RequisitoSimple encontrarRequisitoSimplePorId(int id) {
        Session session = getSessionFactory().getCurrentSession();
        Query query = session.createQuery("FROM RequisitoSimple where id="+Integer.toString(id));
        RequisitoSimple requisito= (RequisitoSimple)query.uniqueResult(); 
        return requisito;
    }
    
    @Transactional
    @Override
    public void eliminarRequisitoSimple(Requisito requisito) {
        Session session = getSessionFactory().getCurrentSession();
        session.delete(requisito);
    }
    
    @Transactional
    @Override
    public void actualizarRequisitoSimple(RequisitoSimple requisitoActual) {
       Session session = getSessionFactory().getCurrentSession();
  
         int id = requisitoActual.getId();
         RequisitoSimple requisito=(RequisitoSimple)session.get(Requisito.class, id, new LockOptions(LockMode.OPTIMISTIC));      
        requisito.setVersion(requisito.getVersion()-1);
        requisito.setId(requisitoActual.getId());
        requisito.setNecesidad(requisitoActual.getNecesidad());
        requisito.setNombre(requisitoActual.getNombre());
        requisito.setPrioridad(requisitoActual.getPrioridad());
        requisito.setRiesgo(requisitoActual.getRiesgo());
        requisito.setProyecto(requisitoActual.getProyecto());
        requisito.setStakeholders(requisitoActual.getStakeholders());       
//session.saveOrUpdate(requisitoactual);
    }
 
}
