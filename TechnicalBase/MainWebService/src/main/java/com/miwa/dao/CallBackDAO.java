package com.miwa.dao;

import com.miwa.HibernateUtil;
import com.miwa.model.Callback;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CallBackDAO {
    public Integer insert(Callback service) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(service);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
    public List<Callback> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        // TODO IS THIS USEFULL ?
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Callback.class);
        List<Callback> callbacks = criteria.list();
        session.close();

        return callbacks;

    }
}
