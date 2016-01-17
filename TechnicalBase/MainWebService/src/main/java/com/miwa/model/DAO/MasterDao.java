package com.miwa.model.DAO;

import com.miwa.model.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public abstract class MasterDao<T> {


    protected Session start() {
        return HibernateUtils.getSessionFactory().openSession();
    }

    protected void stop(Session session) {
        session.close();
    }

    public void insertAndUpdate(T toInsertOrUpdate)
    {
        Session session = start();
        session.beginTransaction();
        session.saveOrUpdate(toInsertOrUpdate);
        session.getTransaction().commit();
        stop(session);
    }

    public void insert(T toInsert) {
        Session session = start();
        session.beginTransaction();
        session.save(toInsert);
        session.getTransaction().commit();
        stop(session);
    }

    public void update(T toUpdate)
    {
        Session session = start();
        session.beginTransaction();
        session.merge(toUpdate);
        session.getTransaction().commit();
        stop(session);
    }

    public void delete(T toDelete)
    {
        Session session = start();
        session.beginTransaction();
        session.delete(toDelete);
        session.getTransaction().commit();
        stop(session);
    }


    protected List<T> getAll(Class<T> type)
    {
        Session session = start();
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(type);
            List result = criteria.list();
            return (result != null) ? result : new ArrayList<>();
        } finally {
            stop(session);
        }
    }
}