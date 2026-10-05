<%-- 
    Document   : AddLocation
    Created on : Feb 14, 2026, 10:01:02 AM
    Author     : nishansubba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="id=edge">
        <title>HomeBase | Add Location</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <%
            if (request.getAttribute("successMessage") != null) { %>
            <div class="toast-msg success-msg">
                <%= request.getAttribute("successMessage") %>
            </div>
        <% } %>
        
        <% if (request.getAttribute("errorMessage") != null) { %>
        <div class="toast-msg error-msg">
            <%= request.getAttribute("errorMessage") %>
        </div>
        <% } %>
        <%@include file="Menu.jsp" %>
        <main>
            <h1>Add Location</h1>
            <form method="POST" name="add-location" action="LocationServlet">
                <input type="hidden" name="action" value="post">        
                <fieldset>
                    <label for="location-name" class="required">Name</label>
                    <input type="text" name="location-name" id="location-name" placeholder="Basement Shelf" required>
                </fieldset>

                <fieldset>
                    <label for="location-note">Note</label>
                    <textarea type="text" name="location-note" id="location-note" placeholder="Next to the big bed"></textarea>
                </fieldset>
                
                <div class="btn-group">
                    <input class="btn submit-btn" type="submit" value="Save">
                    <input class="btn reset-btn" type="reset" value="Cancel">
                </div>
            </form>
            
            
        </main>
    </body>
</html>
