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
}
