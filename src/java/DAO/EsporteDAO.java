/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Esporte;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ricardo Junior
 */
public class EsporteDAO {
        static public List<Esporte> getesportes() /* pegar lista de recomendadocoes de amizade */ {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createSQLQuery("SELECT * FROM ESPORTE")
                .addEntity(Esporte.class);
        List avaliacao = query.list();
        return avaliacao;
    }
}
