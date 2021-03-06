/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pedago
 */
@WebServlet(name = "Controle", urlPatterns = {"/Controle"})
public class Controle extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = ((HttpServletRequest)request).getSession(true);
            
            String joueurCree = request.getParameter("joueurCree");
            String joueurs = request.getParameter("joueurs"); 
            String playerName = (String) session.getAttribute("playerName");  
            int max = 100;
            int min = 0;
            int alea = min + (int)(Math.random() * ((max - min) + 1));
            session.setAttribute("alea",alea);
           
            String bas = "bas";
            String haut = "haut";
            int testNum = 0;
            
            if (playerName==null){
                playerName = request.getParameter("playerName");
                session.setAttribute("playerName", playerName);
                request.getRequestDispatcher("View/PageDeco.jsp").forward(request, response);
            }       
            else {
                session.setAttribute("playerName", playerName);
                 
                alea = (int) session.getAttribute("alea");
                String action = request.getParameter("action");
                session.setAttribute("alea", alea);
                session.setAttribute("testNum", testNum);
                getServletContext().setAttribute("testNum", testNum);
                if ("Deviner".equals(action)){
                
                    int guess = Integer.parseInt(request.getParameter("guess"));
                    session.setAttribute("guess", guess);
                    if (guess==alea) {request.getRequestDispatcher("View/PageGagne.jsp").forward(request, response);}
                    else {if (guess<alea) {session.setAttribute("hautbas", bas);
                                           session.setAttribute("testNum", testNum);
                                           testNum=testNum+1;}
                          else {session.setAttribute("hautbas", haut);
                                session.setAttribute("testNum", testNum);
                                testNum=testNum+1;}}
                }

                request.getRequestDispatcher("View/PageCo.jsp").forward(request, response);
            } 
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
