package com.miwa.model.DAO;

import com.miwa.model.Domain.Service;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calu on 17/01/2016.
 */
public class ServiceDao extends MasterDao<Service> {

    public List<Service> getAll() {
        return super.getAll(Service.class);
    }

    public Service findByName(String name) {

        Session session = start();
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Service.class);
            criteria.add(Restrictions.eq("name", name));
            return (Service) criteria.uniqueResult();
        } finally {
            stop(session);
        }
    }
}
