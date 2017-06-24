package com.durgam.guerra.repositorio.impl;
import com.durgam.guerra.modelo.RequisitoCompuesto;
import com.durgam.guerra.repositorio.RepositorioRequisitoCompuesto;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RepositorioRequisitoCompuestoImp implements RepositorioRequisitoCompuesto {
  private SessionFactory sessionFactory;
  @Transactional  
  @Override
    public List<RequisitoCompuesto> obtenerTodosRequisitosCompuesto() {
       Session session = sessionFactory.getCurrentSession();
       String hql = "FROM RequisitoCompuesto";
       Query query = session.createQuery(hql);
       List<RequisitoCompuesto> requisitos = query.list();
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
    public void nuevoRequisitoCompuesto(RequisitoCompuesto requisito) {
      Session session = getSessionFactory().getCurrentSession();
      session.save(requisito);
    }

    @Transactional 
    @Override
    public RequisitoCompuesto encontrarRequisitoCompuestoPorId(int id) {
       Session session = getSessionFactory().getCurrentSession();    
       Query query = session.createQuery("FROM RequisitoCompuesto where id="+Integer.toString(id));
       RequisitoCompuesto requisito= (RequisitoCompuesto)query.uniqueResult();  
       return requisito;
    }

    @Transactional 
    @Override
    public void eliminarRequisitoCompuesto(RequisitoCompuesto requisito) {
      Session session = getSessionFactory().getCurrentSession();
      session.delete(requisito);
    }

    @Transactional
    @Override
    public void actualizarRequisitoCompuesto(RequisitoCompuesto requisitoactual) {
        Session session = getSessionFactory().getCurrentSession();
        session.saveOrUpdate(requisitoactual);
    }
 }

