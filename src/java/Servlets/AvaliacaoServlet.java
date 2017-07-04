/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.HibernateSessionFactory;
import Model.Avaliacaohospedagem;
import Model.Hospedagem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ricardo Junior
 */
public class AvaliacaoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     
        Session session = HibernateSessionFactory.getSession();
        Transaction tcx = session.beginTransaction();

        
        Query query = session.createSQLQuery("SELECT * FROM AVALIACAOHOSPEDAGEM WHERE HOSPEDAGEM_FK = :id")
                .addEntity(Avaliacaohospedagem.class);
        query.setString("id", request.getParameter("hospedagem"));
        List returned_query = query.list();
  
        if (!returned_query.isEmpty()){
            Avaliacaohospedagem ah = (Avaliacaohospedagem) returned_query.get(0);
            if (request.getParameter("textoanfitriao") != null){
                ah.setAvaAnfitriaoText(request.getParameter("textoanfitriao"));
                ah.setNotaAnfitriao(Integer.parseInt(request.getParameter("notaanfitriao")));

            }
            if (request.getParameter("textohospede") != null){
                ah.setAvaHospedeText(request.getParameter("textohospede"));
                ah.setNotaHospede(Integer.parseInt(request.getParameter("notahospede")));

            }
            session.update(ah);
            session.flush();
            tcx.commit();
            response.sendRedirect("avaliacao.jsp");

        }
        else{
            
            Avaliacaohospedagem ah = new Avaliacaohospedagem();
            Query queryhospedagem = session.createSQLQuery("SELECT * FROM HOSPEDAGEM WHERE ID = :id")
                    .addEntity(Hospedagem.class);
            queryhospedagem.setString("id", request.getParameter("hospedagem"));
            List returned_query2 = queryhospedagem.list();
            
            Hospedagem h = (Hospedagem) returned_query2.get(0);
            
            Query cont = session.createSQLQuery("SELECT COUNT(ID) FROM AVALIACAOHOSPEDAGEM ");
            ah.setId(((int) cont.list().get(0)) + 1);
            ah.setHospedagemFk(h);
            ah.setAnfitriaoFk(h.getAnfitriaoId());
            ah.setHospedeFk(h.getSolicitanteId());

            if (request.getParameter("textoanfitriao") != null){
                ah.setAvaAnfitriaoText(request.getParameter("textoanfitriao"));
                ah.setNotaAnfitriao(Integer.parseInt(request.getParameter("notaanfitriao")));
            }

            if (request.getParameter("textohospede") != null){
                ah.setAvaHospedeText(request.getParameter("textohospede"));
                ah.setNotaHospede(Integer.parseInt(request.getParameter("notahospede")));

            }

            session.save(ah);
            session.flush();
            tcx.commit();
            response.sendRedirect("avaliacao.jsp");
        }
            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
