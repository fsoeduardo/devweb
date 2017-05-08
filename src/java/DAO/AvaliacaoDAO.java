/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Avaliacaocomposta;
import model.Avaliacao;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ricardo Junior
 */
public class AvaliacaoDAO {
    
    static public List<Avaliacao> getamizade(int userid) /* pegar lista de recomendadocoes de amizade */ {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createSQLQuery("SELECT * FROM AVALIACAO WHERE USER_RECEBE = :userid and tipo = 1")
                .addEntity(Avaliacao.class);
        query.setInteger("userid", userid);
        List avaliacao = query.list();
        return avaliacao;
    }

    static public List<Avaliacaocomposta> gethospedero(int userid) /* pegar lista de recomendadocoes do hospedero */ {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createSQLQuery("SELECT * FROM AVALIACAOCOMPOSTA WHERE HOSPEDERO_ID = :userid and tipo = 2")
                .addEntity(Avaliacaocomposta.class);
        query.setInteger("userid", userid);
        List avaliacao = query.list();
        return avaliacao;
    }
    static public List<Avaliacaocomposta> gethospedado(int userid) /* pegar lista de recomendadocoes do hospedado */{
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createSQLQuery("SELECT * FROM AVALIACAOCOMPOSTA WHERE HOSPEDADO_ID = :userid and tipo = 2")
                .addEntity(Avaliacaocomposta.class);
        query.setInteger("userid", userid);
        List avaliacao = query.list();
        return avaliacao;
    }
    static public List<Avaliacaocomposta> getesporte(int userid) /* pegar lista de recomendadocoes de esporte 1 */{
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createSQLQuery("SELECT * FROM AVALIACAOCOMPOSTA WHERE (HOSPEDADO_ID = :userid or HOSPEDERO_ID = :userid) and tipo = 3")
                .addEntity(Avaliacaocomposta.class);
        query.setInteger("userid", userid);
        List avaliacao = query.list();
        return avaliacao;
    }

}

