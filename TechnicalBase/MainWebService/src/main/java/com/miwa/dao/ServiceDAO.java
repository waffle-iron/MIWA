package com.miwa.dao;

import com.miwa.HibernateUtil;
import com.miwa.model.Service;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ServiceDAO {
    public Service AddService(Service service) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Integer id = (Integer)session.save(service);
        transaction.commit();
        service.setServiceid(id);
        session.close();
        return service;
    }

    public Service findByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        // TODO IS THIS USEFULL ?
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Service.class);
        criteria.add(Restrictions.eq("name", name));
        List<Service> services = criteria.list();
        session.close();

        if (services.isEmpty())
            return null;
        else
            return services.get(0);
    }
    public List<Service> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        // TODO IS THIS USEFULL ?
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Service.class);
        List<Service> services = criteria.list();

        session.close();
        return services;

    }
}
