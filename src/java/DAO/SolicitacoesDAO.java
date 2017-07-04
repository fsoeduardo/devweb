/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Hospedagem;
import Model.Hospedagemesporte;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ricardo Junior
 */
public class SolicitacoesDAO {
    static public List<Hospedagem> getsolicitacoes(int userid) {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createSQLQuery("SELECT * FROM HOSPEDAGEM WHERE ANFITRIAO_ID = :userid AND SITUACAO_ANFITRIAO IS NULL")
                .addEntity(Hospedagem.class);
        query.setInteger("userid", userid);
        List solicitacao = query.list();
        return solicitacao;
    }
    static public Hospedagemesporte gethospedagemesporte(int hospedagemid){
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createSQLQuery("SELECT * FROM HOSPEDAGEMESPORTE WHERE HOSPEDAGEM_FK = :hospedagemid")
                .addEntity(Hospedagemesporte.class);
        query.setInteger("hospedagemid", hospedagemid);
        List hospedagemesporte = query.list();
        return (Hospedagemesporte) hospedagemesporte.get(0);
    }
    static public List<Hospedagem> getpedidosaceitar(int userid) {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createSQLQuery("SELECT * FROM HOSPEDAGEM WHERE SOLICITANTE_ID = :userid AND SITUACAO_ANFITRIAO = TRUE AND CONFIRMACAO_SOLICITANTE IS NULL")
                .addEntity(Hospedagem.class);
        query.setInteger("userid", userid);
        List solicitacao = query.list();
        return solicitacao;
    }

    static public boolean existeconfirmado(int userid) {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createSQLQuery("SELECT * FROM HOSPEDAGEM WHERE SOLICITANTE_ID = :userid AND SITUACAO_ANFITRIAO = TRUE AND CONFIRMACAO_SOLICITANTE = TRUE  AND ( (EXISTS(SELECT * FROM AVALIACAOHOSPEDAGEM WHERE (HOSPEDAGEM_FK = HOSPEDAGEM.ID) AND ((AVA_ANFITRIAO_TEXT IS  NULL) OR (AVA_HOSPEDE_TEXT IS NULL)))) OR (NOT EXISTS(SELECT * FROM AVALIACAOHOSPEDAGEM WHERE (HOSPEDAGEM_FK = HOSPEDAGEM.ID) ) ))")
                .addEntity(Hospedagem.class);
        query.setInteger("userid", userid);
        return !query.list().isEmpty();
    }

    static public List<Hospedagem> getpedidosrecusados(int userid) {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createSQLQuery("SELECT * FROM HOSPEDAGEM WHERE SOLICITANTE_ID = :userid AND SITUACAO_ANFITRIAO = FALSE AND CONFIRMACAO_SOLICITANTE IS NULL")
                .addEntity(Hospedagem.class);
        query.setInteger("userid", userid);
        List solicitacao = query.list();
        return solicitacao;
    }
    static public List<Hospedagem> getpedidosespera(int userid) {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createSQLQuery("SELECT * FROM HOSPEDAGEM WHERE SOLICITANTE_ID = :userid AND SITUACAO_ANFITRIAO IS NULL AND CONFIRMACAO_SOLICITANTE IS NULL")
                .addEntity(Hospedagem.class);
        query.setInteger("userid", userid);
        List solicitacao = query.list();
        return solicitacao;
    }
    static public List<Hospedagem> gethospedagem(int userid){
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createSQLQuery("SELECT * FROM HOSPEDAGEM WHERE (SOLICITANTE_ID = :userid OR ANFITRIAO_ID = :userid) AND SITUACAO_ANFITRIAO = TRUE AND CONFIRMACAO_SOLICITANTE  = TRUE  AND ( (NOT EXISTS (SELECT * FROM AVALIACAOHOSPEDAGEM WHERE HOSPEDAGEM_FK = HOSPEDAGEM.ID)) OR ((SELECT AVA_ANFITRIAO_TEXT FROM AVALIACAOHOSPEDAGEM WHERE HOSPEDE_FK = HOSPEDAGEM.SOLICITANTE_ID AND HOSPEDAGEM_FK = HOSPEDAGEM.ID) IS NULL) OR ((SELECT AVA_HOSPEDE_TEXT FROM AVALIACAOHOSPEDAGEM WHERE ANFITRIAO_FK = HOSPEDAGEM.ANFITRIAO_ID AND HOSPEDAGEM_FK = HOSPEDAGEM.ID) IS NULL)) ")
                .addEntity(Hospedagem.class);
        query.setInteger("userid", userid);
        List solicitacao = query.list();
        return solicitacao;
    }
    
}
