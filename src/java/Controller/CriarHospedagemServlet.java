/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.HibernateSessionFactory;
import Model.Esporte;
import Model.Hospedagem;
import Model.Hospedagemesporte;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Ricardo Junior
 */
public class CriarHospedagemServlet extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");

        Session session = HibernateSessionFactory.getSession();
        Transaction tcx = session.beginTransaction();

        Hospedagem h = new Hospedagem();

        Query cont = session.createSQLQuery("SELECT COUNT(ID) FROM HOSPEDAGEM ");
        h.setId(((int) cont.list().get(0)) + 1);

        h.setSolicitanteId((Usuario) request.getSession().getAttribute("logado"));

        h.setQtdHospedes(Integer.parseInt(request.getParameter("qtd_hospede")));

        Date data_inicio = new SimpleDateFormat("DD-MM-YYYY").parse(request.getParameter("data_inicio"));
        h.setDataInicio(data_inicio);

        Date data_termino = new SimpleDateFormat("DD-MM-YYYY").parse(request.getParameter("data_termino"));
        h.setDataTermino(data_termino);

        Query query = session.createSQLQuery("SELECT * FROM USUARIO WHERE ID = :id")
                .addEntity(Usuario.class);
        query.setString("id", request.getParameter("anfitriao")); 
        h.setAnfitriaoId((Usuario) query.list().get(0));                

        
        Query queryesporte = session.createSQLQuery("SELECT * FROM ESPORTE WHERE ID = :id")
                .addEntity(Esporte.class);
        queryesporte.setString("id", request.getParameter("esporte")); 
        Hospedagemesporte he = new Hospedagemesporte(h.getId(),((Esporte) queryesporte.list().get(0)).getId());
        he.setHospedagem(h);
        he.setEsporte((Esporte) queryesporte.list().get(0));
        he.setQtdEsportista(Integer.parseInt(request.getParameter("qtd_esportista")));
        
        session.saveOrUpdate(h);
        session.saveOrUpdate(he);
        tcx.commit();
        response.sendRedirect("solicitarhospedagem.jsp");

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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CriarHospedagemServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CriarHospedagemServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
