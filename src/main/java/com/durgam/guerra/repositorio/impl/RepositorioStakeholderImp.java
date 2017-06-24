package com.durgam.guerra.repositorio.impl;

import com.durgam.guerra.modelo.Stakeholder;
import com.durgam.guerra.repositorio.RepositorioStakeholder;
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
public class RepositorioStakeholderImp implements RepositorioStakeholder{
private SessionFactory sessionFactory;

    @Transactional       
    @Override
    public List<Stakeholder> obtenerTodosStakeholder() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Stakeholder";
        Query query = session.createQuery(hql);
        List<Stakeholder> stakeholder = query.list();
        return stakeholder;
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
    public void nuevoStakeholder(Stakeholder stakeholder) {
        Session session = getSessionFactory().getCurrentSession();
        session.save(stakeholder);
    }

    @Transactional
    @Override
    public Stakeholder encontrarStakeholderId(int id) {
        Session session = getSessionFactory().getCurrentSession();
        Query query = session.createQuery("FROM Stakeholder where id="+Integer.toString(id));
        Stakeholder stakeholder= (Stakeholder)query.uniqueResult();
        return stakeholder;
    }
    
    @Transactional
    @Override
    public void actualizarStakeholder(Stakeholder stakeholderActual) {
        Session session = getSessionFactory().getCurrentSession();
        int id = stakeholderActual.getId();
         Stakeholder stakeholder=(Stakeholder)session.get(Stakeholder.class, id, new LockOptions(LockMode.OPTIMISTIC));
       stakeholder.setVersion(stakeholder.getVersion()-1);
       stakeholder.setId(stakeholderActual.getId());
       stakeholder.setApellido(stakeholderActual.getApellido());
       stakeholder.setNombre(stakeholderActual.getNombre());
       stakeholder.setDni(stakeholderActual.getDni());
       stakeholder.setRol(stakeholderActual.getRol());
      stakeholder.setRequisitos(stakeholderActual.getRequisitos());
      
       // session.saveOrUpdate(stakeholderActual);
    }
}
