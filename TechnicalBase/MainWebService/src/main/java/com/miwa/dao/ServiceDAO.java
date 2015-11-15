package com.miwa.dao;


import com.miwa.HibernateUtil;
import com.miwa.model.Service;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ServiceDAO {
    public Integer AddService(Service service) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(service);
        transaction.commit();
        return null;
    }
    public List<Service> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Service.class);
        return criteria.list();

    }
}
