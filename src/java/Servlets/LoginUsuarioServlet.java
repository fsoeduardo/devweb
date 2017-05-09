/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.HibernateSessionFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import model.Usuario_;
import model.Avaliacao;
import model.Avaliacaocomposta;
import model.Avaliacao_;
import model.Avaliacaocomposta_;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ricardo Junior
 */
public class LoginUsuarioServlet extends HttpServlet {

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
        
        Query query = session.createSQLQuery("SELECT * FROM USUARIO WHERE EMAIL = :email")
                .addEntity(Usuario.class);
        

        query.setString("email", request.getParameter("username"));
        List returned_query = query.list();
        
        if (!returned_query.isEmpty()) {
            Usuario user = (Usuario) returned_query.get(0);
            if (user.getSenha().compareTo(request.getParameter("password")) == 0) {
                request.getSession().setAttribute("usuario", user.getNome());                
                RequestDispatcher view = request.getRequestDispatcher("perfil.jsp");
                request.setAttribute("user", user);
                view.forward(request, response);
            }
        } 
        
        request.setAttribute("login_failed", true);
        RequestDispatcher view = request.getRequestDispatcher("login.jsp");
        view.forward(request, response);
        
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
