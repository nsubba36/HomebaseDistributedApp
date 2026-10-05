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
import java.util.*;
import ValidationRules.*;

/**
 *
 * @author nishansubba
 */
@WebServlet(urlPatterns = {"/CategoryServlet"})
public class CategoryServlet extends HttpServlet {
    @EJB
    private CategoryFacadeLocal CategorySession;
    
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
        
        String action = request.getParameter("action");
        
        if ("post".equals(action)) {
            response.setContentType("text/html;charset=UTF-8");
            System.out.println("************* Add Category Servlet ******************");
            System.out.println("Category: " + request.getParameter("category-name"));
            System.out.println("Note: " + request.getParameter("category-note"));
            System.out.println("******************************************************");

        String categoryName = request.getParameter("category-name");
                    String categoryNote = request.getParameter("category-note");
        try {
            List<String> usedCategoryNames = CategorySession.getAllCategoryNames();
            HomeBaseNameRules nameRule = new HomeBaseNameRules();
            nameRule.testUniqueNameForCategoryLocation(categoryName.trim(), usedCategoryNames);

            Category category = new Category();
            category.setName(categoryName);
            category.setNote(categoryNote);

            CategorySession.create(category);

            request.setAttribute("successMessage", "Category saved successfully!");
        } catch (Exception ex) {
                    request.setAttribute("errorMessage", ex.getMessage());
        }


            RequestDispatcher dispatcher = request.getRequestDispatcher("/AddCategory.jsp");
            if (dispatcher != null) {
                dispatcher.forward(request, response);
            }
        }
        
        else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("category-id"));
            Category category = CategorySession.find(id);
            
           
            if (category != null) {
                CategorySession.remove(category);
            }


            response.sendRedirect("DashboardServlet");
            return;
        }
        else if ("update".equals(action)) {
            try {
                Integer categoryId = Integer.valueOf(request.getParameter("category-id"));
                String categoryName = request.getParameter("category-name");
                String categoryNote = request.getParameter("category-note");

                Category category = CategorySession.find(categoryId);

                if (category != null) {
                    List<String> usedCategoryNames = CategorySession.getAllCategoryNames();

                    if (category.getName() != null) {
                        usedCategoryNames.removeIf(name -> name.equalsIgnoreCase(category.getName()));
                    }

                    HomeBaseNameRules nameRule = new HomeBaseNameRules();
                    nameRule.testUniqueNameForCategoryLocation(categoryName.trim(), usedCategoryNames);

                    category.setName(categoryName);
                    category.setNote(categoryNote);

                    CategorySession.edit(category);
                }

                response.sendRedirect("DashboardServlet");
                return;

            } catch (Exception ex) {
                request.setAttribute("errorMessage", ex.getMessage());
                RequestDispatcher dispatcher = request.getRequestDispatcher("/DashboardServlet");
                if (dispatcher != null) {
                    dispatcher.forward(request, response);
                }
                return;
            }
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
