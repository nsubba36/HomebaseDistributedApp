/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.*;
import javax.servlet.*;

import entity.*;
import session.*;
import javax.persistence.*;
import javax.transaction.*;
import javax.annotation.*;
import javax.enterprise.context.*;
import javax.ejb.*;
/**
 *
 * @author nishansubba
 */
@WebServlet(urlPatterns = {"/WishListServlet"})
public class WishListServlet extends HttpServlet {

    @EJB
    private WishlistFacadeLocal WishlistSession;
    
    
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
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        
        if ("post".equals(action)) {
            System.out.println("************* Add Wishlist Servlet *******************");
            System.out.println("Name: " + request.getParameter("wishlist-name"));
            System.out.println("Price $: " + request.getParameter("wishlist-price"));
            System.out.println("Note: " + request.getParameter("wishlist-note"));
            System.out.println("******************************************************");

            request.setAttribute("successMessage", "Wishlist saved successfully!");

            Wishlist wishlist = new Wishlist();
            wishlist.setName(request.getParameter("wishlist-name"));
            wishlist.setPrice(Integer.parseInt(request.getParameter("wishlist-price")));
            wishlist.setNote(request.getParameter("wishlist-note"));

            WishlistSession.create(wishlist);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WishList.jsp");
            if (dispatcher != null) {
                dispatcher.forward(request, response);
            }
        }
        
        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("wishlist-id"));
            
            Wishlist wishlist = WishlistSession.find(id);
            
            if (wishlist != null) {
                WishlistSession.remove(wishlist);
            }
            
            response.sendRedirect("DashboardServlet");
            return;
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
