/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Avaliacaoamizade;
import Model.Avaliacaosaida;
import Model.Avaliacaohospedagem;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ricardo Junior
 */
public class AvaliacoesDAO {

    static public double getmedia(int userid) /* pegar media */ {
      int somanota = 0;
      int cont = 0;
      for (Avaliacaoamizade aux : AvaliacoesDAO.getamizade(userid)){ 
             somanota += aux.getNota();
             cont += 1;
      }
      for (Avaliacaohospedagem aux : AvaliacoesDAO.getanfitriao(userid)) {
             somanota += aux.getNotaAnfitriao() ;
             cont += 1;
      }
      for (Avaliacaohospedagem aux : AvaliacoesDAO.gethospede(userid) ) {
      somanota += aux.getNotaHospede() ;
      cont += 1;
      }
      for (Avaliacaosaida aux : AvaliacoesDAO.getrecsaida(userid) ) {
             somanota += aux.getNota() ;
             cont += 1;
         }
    
       float media = somanota/cont;
       return media;
    }

    
    static public List<Avaliacaoamizade> getamizade(int userid) /* pegar lista de recomendadocoes de amizade */ {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createSQLQuery("SELECT * FROM AVALIACAOAMIZADE WHERE AVALIADO_FK = :userid")
                .addEntity(Avaliacaoamizade.class);
        query.setInteger("userid", userid);
        List avaliacao = query.list();
        return avaliacao;
    }

    static public List<Avaliacaohospedagem> getanfitriao(int userid) /* pegar lista de recomendadocoes de qnd ele foi anfitriao */ {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createSQLQuery("SELECT * FROM AVALIACAOHOSPEDAGEM WHERE ANFITRIAO_FK = :userid")
                .addEntity(Avaliacaohospedagem.class);
        query.setInteger("userid", userid);
        List avaliacao = query.list();
        return avaliacao;
    }
    static public List<Avaliacaohospedagem> gethospede(int userid) /* pegar lista de recomendadocoes de qnd ele foi hospede */{
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createSQLQuery("SELECT * FROM AVALIACAOHOSPEDAGEM WHERE HOSPEDE_FK = :userid")
                .addEntity(Avaliacaohospedagem.class);
        query.setInteger("userid", userid);
        List avaliacao = query.list();
        return avaliacao;
    }
    
    static public List<Avaliacaosaida> getrecsaida(int userid) /* pegar lista de recomendadocoes de esporte 1 */{
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createSQLQuery("SELECT * FROM AVALIACAOSAIDA WHERE AVALIADO_FK = :userid")
                .addEntity(Avaliacaosaida.class);
        query.setInteger("userid", userid);
        List avaliacao = query.list();
        return avaliacao;
    }
    
}
