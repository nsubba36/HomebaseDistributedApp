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
import java.time.LocalDate;
import java.util.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.io.File;
import ValidationRules.*;
/**
 *
 * @author nishansubba
 */
@MultipartConfig
@WebServlet(urlPatterns = {"/ItemServlet"})
public class ItemServlet extends HttpServlet {

    @EJB
    private ItemFacadeLocal ItemSession;
    
    @EJB
    private LocationFacadeLocal LocationSession;
    
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
        List<Category> categories = CategorySession.findAll();
        List<Location> locations = LocationSession.findAll();
        
        request.setAttribute("categories", categories);
        request.setAttribute("locations", locations);
        
        request.getRequestDispatcher("/AddItem.jsp")
               .forward(request, response);
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
            System.out.println("***************** Add Item Servlet ******************");
            System.out.println("Date: " + request.getParameter("item-date"));
            System.out.println("Name: " + request.getParameter("item-name"));
            System.out.println("Location: " + request.getParameter("item-location"));
            System.out.println("Category: " + request.getParameter("item-category"));
            System.out.println("Cost $: " + request.getParameter("item-cost"));
            System.out.println("Quantity: " + request.getParameter("item-quantity"));
            System.out.println("Image URL: " + request.getParameter("item-image"));
            System.out.println("Note: " + request.getParameter("item-note"));
            System.out.println("******************************************************");

            String itemDate = request.getParameter("item-date");
            String itemName = request.getParameter("item-name");
            int itemCost = Integer.parseInt(request.getParameter("item-cost"));
            int itemQuantity = Integer.parseInt(request.getParameter("item-quantity"));
            try {
                HomeBaseFieldRules fieldRule = new HomeBaseFieldRules();
                java.util.Map<String, String> requiredFields = new java.util.HashMap<>();
                requiredFields.put("Item date", itemDate);
                requiredFields.put("Item name", itemName);
                fieldRule.testRequiredField(requiredFields);

                // test the date format and make sure its not set to future
                HomeBaseDateRules dateRule = new HomeBaseDateRules();
                dateRule.testItemDate(itemDate);

                HomeBasePriceRules priceRule = new HomeBasePriceRules();
                priceRule.testItemPrice(itemCost);

                HomeBaseQuantityRules quantityRule = new HomeBaseQuantityRules();
                quantityRule.testItemQuantity(itemQuantity);

                Item item = new Item();
                item.setDate(itemDate);
                item.setName(itemName);
                int locationId = Integer.parseInt(request.getParameter("item-location"));
                Location location = LocationSession.find(locationId);
                item.setLocationId(location);

                int categoryId = Integer.parseInt(request.getParameter("item-category"));
                Category category = CategorySession.find(categoryId);
                item.setCategoryId(category);

                item.setCost(itemCost);
                item.setQuantity(itemQuantity);
                item.setUrlPath(request.getParameter("item-image"));

                item.setNote(request.getParameter("item-note"));

                ItemSession.create(item);

                request.setAttribute("successMessage", "Item saved successfully!");

            } catch (Exception ex) {
                request.setAttribute("errorMessage", ex.getMessage());
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/AddItem.jsp");
            if (dispatcher != null) {
                dispatcher.forward(request, response);
            }
        }
        
        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("item-id"));
            
            Item item = ItemSession.find(id);
            
            if (item != null) {
                ItemSession.remove(item);
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
