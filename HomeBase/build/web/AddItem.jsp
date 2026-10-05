<%-- 
    Document   : AddItem
    Created on : Feb 14, 2026, 9:59:29 AM
    Author     : nishansubba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="entity.*" %>
<%
List<Category> categories = (List<Category>) request.getAttribute("categories");
List<Location> locations = (List<Location>) request.getAttribute("locations");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="id=edge">
        <title>HomeBase | Add Item</title>
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
            <h1>Add Item</h1>
            <form method="POST" name="add-item" action="ItemServlet" enctype="multipart/form-data">
                <input type="hidden" name="action" value="post">        

                <fieldset>
                    <label for="item-date" class="required">Date</label>
                    <input type="date" name="item-date" id="item-date" placeholder="2025-05-21" required>
                </fieldset>

                <fieldset>
                    <label for="item-name" class="required">Name</label>
                    <input type="text" name="item-name" id="item-name" placeholder="God of War Ragnarok" required>
                </fieldset>

                <fieldset>
                    <label for="item-location" class="required">Location</label>
                    <select name="item-location" id="item-location" required>
                        <option value="" disabled selected>Select a choice</option>
                        <%
                            if (locations != null) {
                                for (Location location : locations) {
                                    %>
                                    <option value="<%= location.getLocationId() %>"><%= location.getName() %></option>
                                    <%
                                }
                            }
                        %>
                    </select>
                </fieldset>

                <fieldset>
                    <label for="item-category" class="required">Category</label>
                    <select name="item-category" id="item-category" required>
                        <option value="" disabled selected>Select a choice</option>
                        <%
                            if (categories != null) {
                                for (Category category : categories) {
                                    %>
                                    <option value="<%= category.getCategoryId() %>"><%= category.getName() %></option>
                                    <%
                                }
                            }
                        %>
                    </select>
                </fieldset>

                <fieldset>
                    <label for="item-cost" class="required">Cost</label>
                    <input type="number" name="item-cost" id="item-cost" placeholder="70" required>
                </fieldset>

                <fieldset>
                    <label for="item-quantity" class="required">Quantity</label>
                    <input type="number" name="item-quantity" id="item-quantity" placeholder="1" required>
                </fieldset>

                <fieldset>
                    <label for="item-note">Note</label>
                    <textarea
                        name="item-note" 
                        id="item-note"
                        placeholder="PS5 sequel to God Of War. I want to play this Saturday."></textarea>
                </fieldset>

                <fieldset class="file-container">
                    <label for="item-image">Upload Image</label>
                    <label for="item-image" class="file-btn">Choose File</label>
                    <span id="file-name">No file selected</span>
                    <input type="file" name="item-image" id="item-image">
                </fieldset>

                <div class="btn-group">
                    <input class="btn submit-btn" type="submit" value="Save">
                    <input class="btn reset-btn" type="reset" value="Cancel">
                </div>
            </form>
        </main>
        <script>
            const fileInput = document.getElementById("item-image");
            const fileNameSpan = document.getElementById("file-name");

            fileInput.addEventListener("change", function () {
                if (this.files.length > 0) {
                    fileNameSpan.textContent = this.files[0].name;
                } else {
                    fileNameSpan.textContent = "No file selected";
                }
            });
        </script>
    </body>
</html>
