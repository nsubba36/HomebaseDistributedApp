<%-- 
    Document   : WishList
    Created on : Feb 14, 2026, 10:17:04 AM
    Author     : nishansubba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="id=edge">
        <title>JSP Page</title>
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
            <h1>Wishlist</h1>
            <form name="wishlist" action="WishListServlet" method="POST">
                <input type="hidden" name="action" value="post">        


                <fieldset>
                    <label for="wishlist-name" class="required">Name</label>
                    <input type="text" name="wishlist-name" id="wishlist-name" placeholder="PS5 Expedition 33" required>
                </fieldset>
                
                <fieldset>
                    <label for="wishlist-price">Price</label>
                    <input type="number" name="wishlist-price" id="wishlist-price" placeholder="70">
                </fieldset>
                
                <fieldset>
                    <label for="wishlist-note">Note</label>
                    <textarea type="text" name="wishlist-note" id="wishlist-note" placeholder="I want to buy, but its out of stock"></textarea>
                </fieldset>
                
                <div class="btn-group">
                    <input class="btn submit-btn" type="submit" value="Save">
                    <input class="btn reset-btn" type="reset" value="Cancel">
                </div>
            </form>
            
            
            
        </main>
        
        
    </body>
</html>
