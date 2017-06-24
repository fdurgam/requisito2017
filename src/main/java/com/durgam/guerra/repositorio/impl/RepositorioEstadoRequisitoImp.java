package com.durgam.guerra.repositorio.impl;
import com.durgam.guerra.modelo.EstadoRequisito;
import com.durgam.guerra.modelo.Stakeholder;
import com.durgam.guerra.repositorio.RepositorioEstadosRequisito;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RepositorioEstadoRequisitoImp implements RepositorioEstadosRequisito{
private SessionFactory sessionFactory;
    
    @Transactional    
    @Override
    public List<EstadoRequisito> obtenerTodosEstadosAbierto() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Estadorequisito";
        Query query = session.createQuery(hql);
        List<EstadoRequisito> estados = query.list();
        return estados;
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
    public void nuevoGestionRequisito(EstadoRequisito estado) {
       Session session = getSessionFactory().getCurrentSession();
       session.save(estado);
    }    
  @Transactional
    @Override
    public EstadoRequisito encontrarEstadoPorId(Integer id) {
        Session session = getSessionFactory().getCurrentSession();
        Query query = session.createQuery("FROM Estadorequisito where id="+Integer.toString(id));
        EstadoRequisito estadoRequisito= (EstadoRequisito)query.uniqueResult();
        return estadoRequisito; 
    }
}