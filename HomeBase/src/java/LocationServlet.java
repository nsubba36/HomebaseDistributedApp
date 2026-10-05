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
import java.util.List;
import session.*;
import javax.persistence.*;
import javax.transaction.*;
import javax.annotation.*;
import javax.enterprise.context.*;
import javax.ejb.*;
import ValidationRules.*;

/**
 *
 * @author nishansubba
 */
@WebServlet(urlPatterns = {"/LocationServlet"})
public class LocationServlet extends HttpServlet {
    
    @EJB
    private LocationFacadeLocal LocationSession;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


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
            System.out.println("************* Add Location Servlet ******************");
            System.out.println("Location Name: " + request.getParameter("location-name"));
            System.out.println("Note: " + request.getParameter("location-note"));
            System.out.println("******************************************************");

            String locationName = request.getParameter("location-name");
            String locationNote = request.getParameter("location-note");
                        try {
            List<String> usedLocationNames = LocationSession.getAllLocationNames();
                            HomeBaseNameRules nameRule = new HomeBaseNameRules();
                            nameRule.testUniqueNameForCategoryLocation(locationName.trim(), usedLocationNames);

            Location location = new Location();
            location.setName(locationName);
            location.setNote(locationNote);

            LocationSession.create(location);

            request.setAttribute("successMessage", "Location saved successfully!");
            } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/AddLocation.jsp");
            if (dispatcher != null) {
                dispatcher.forward(request, response);
            }
        }
        else if ("delete".equals(action)) {
        int id = Integer.parseInt(request.getParameter("location-id"));

        Location location = LocationSession.find(id);

        if (location != null) {
            LocationSession.remove(location);
        }

        response.sendRedirect("DashboardServlet");
        return;

        } else if ("update".equals(action)) {
            try {
                Integer locationId = Integer.valueOf(request.getParameter("location-id"));
                String locationName = request.getParameter("location-name");
                String locationNote = request.getParameter("location-note");

                Location location = LocationSession.find(locationId);

                if (location != null) {
                    List<String> usedLocationNames = LocationSession.getAllLocationNames();

                    if (location.getName() != null) {
                        usedLocationNames.removeIf(name -> name.equalsIgnoreCase(location.getName()));
                    }

                    HomeBaseNameRules nameRule = new HomeBaseNameRules();
                    nameRule.testUniqueNameForCategoryLocation(locationName.trim(), usedLocationNames);

                    location.setName(locationName);
                    location.setNote(locationNote);

                    LocationSession.edit(location);
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
