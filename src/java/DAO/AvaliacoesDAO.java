/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Avaliacaoamizade;
import Model.Avaliacaoesporte;
import Model.Avaliacaohospedagem;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ricardo Junior
 */
public class AvaliacoesDAO {
    
    static public List<Avaliacaoamizade> getamizade(int userid) /* pegar lista de recomendadocoes de amizade */ {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createSQLQuery("SELECT * FROM AVALIACAOAMIZADE WHERE USER_RECEBE = :userid")
                .addEntity(Avaliacaoamizade.class);
        query.setInteger("userid", userid);
        List avaliacao = query.list();
        return avaliacao;
    }

    static public List<Avaliacaohospedagem> gethospedeiro(int userid) /* pegar lista de recomendadocoes do hospedero */ {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createSQLQuery("SELECT * FROM AVALIACAOHOSPEDAGEM WHERE HOSPEDEIRO_ID = :userid")
                .addEntity(Avaliacaohospedagem.class);
        query.setInteger("userid", userid);
        List avaliacao = query.list();
        return avaliacao;
    }
    static public List<Avaliacaohospedagem> gethospedado(int userid) /* pegar lista de recomendadocoes do hospedado */{
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createSQLQuery("SELECT * FROM AVALIACAOHOSPEDAGEM WHERE HOSPEDADO_ID = :userid")
                .addEntity(Avaliacaohospedagem.class);
        query.setInteger("userid", userid);
        List avaliacao = query.list();
        return avaliacao;
    }
    
    static public List<Avaliacaoesporte> getesporte(int userid) /* pegar lista de recomendadocoes de esporte 1 */{
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createSQLQuery("SELECT * FROM AVALIACAOESPORTE WHERE USER_RECEBE = :userid")
                .addEntity(Avaliacaoesporte.class);
        query.setInteger("userid", userid);
        List avaliacao = query.list();
        return avaliacao;
    }
    
}
