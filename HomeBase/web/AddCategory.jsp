<%-- 
    Document   : AddCategory
    Created on : Feb 14, 2026, 10:01:20 AM
    Author     : nishansubba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="id=edge">
        <title>HomeBase | Add Category</title>
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
            <h1>Add Category</h1>
            <form method="POST" action="CategoryServlet" name="add-category">
                <input type="hidden" name="action" value="post">
                <fieldset>
                    <label for="category-name" class="required">Name</label>
                    <input type="text" name="category-name" id="category-name" placeholder="Games" required>
                </fieldset>
                
                <fieldset>
                    <label for="category-note">Note</label>
                    <textarea type="text" name="category-note" id="category-note" placeholder="PS5 Games"></textarea>
                </fieldset>

                <div class="btn-group">
                    <input class="btn submit-btn" type="submit" value="Save">
                    <input class="btn reset-btn" type="reset" value="Cancel">
                </div>
            </form>

            
        </main>
    </body>
</html>
