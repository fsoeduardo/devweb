/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author valmeida
 */
public class HibernateSessionFactory {
    static SessionFactory sessionFactory;
    
    public static Session getSession() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration()
                    .configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();
            sessionFactory = configuration.configure()
                    .buildSessionFactory(serviceRegistry);
        }
        return sessionFactory.openSession();
    }
}
