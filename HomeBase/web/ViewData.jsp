<%-- 
    Document   : ViewData
    Created on : Mar 1, 2026, 12:27:58 AM
    Author     : nishansubba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="entity.*" %>
<%
List<Category> categories = (List<Category>) request.getAttribute("categories");
List<Item> items = (List<Item>) request.getAttribute("items");
List<Location> locations = (List<Location>) request.getAttribute("locations");
List<Wishlist> wishlists = (List<Wishlist>) request.getAttribute("wishlists");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="id=edge">
        <title>HomeBase | ViewData</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <%@include file="Menu.jsp" %>

        <main>
 
            <div class="table-container">
                <h1>Categories</h1>
                <table>
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Note</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            if (categories != null && !categories.isEmpty()) {
                                for (Category category : categories) {
                        %>
                                    <tr>
                                        <td><%= category.getCategoryId() %></td>
                                        <td><%= category.getName() %></td>
                                        <td><%= category.getNote() %></td>
                                        <td>
                                            <input 
                                                class="btn submit-btn"
                                                type="button"
                                                value="Edit"
                                                data-id="<%= category.getCategoryId() %>"
                                                data-name="<%= category.getName() == null ? "" : category.getName() %>"
                                                data-note="<%= category.getNote() == null ? "" : category.getNote() %>"
                                                onclick="openCategoryModalFromButton(this)">
                                        </td>
                                        <td>
                                            <form action="CategoryServlet" method="POST">
                                                <input type="hidden" name="action" value="delete">
                                                <input type="hidden" name="category-id" value="<%= category.getCategoryId() %>">
                                                <input class="btn reset-btn" type="submit" value="Delete">
                                            </form>
                                        </td>
                                    </tr>
                        <%
                                }
                            } else {
                        %>
                                <tr>
                                    <td colspan="9">No category loaded</td>
                                </tr>
                        <%
                            }
                        %>
                        
                    </tbody>
                    
                </table>
                        
                        
                <h1>Locations</h1>
                <table>
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Note</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            if (locations != null && !locations.isEmpty()) {
                                for (Location location : locations) {
                        %>
                                    <tr>
                                        <td><%= location.getLocationId() %></td>
                                        <td><%= location.getName() %></td>
                                        <td><%= location.getNote() %></td>
                                        <td>
                                            <input 
                                                class="btn submit-btn"
                                                type="button"
                                                value="Edit"
                                                data-id="<%= location.getLocationId() %>"
                                                data-name="<%= location.getName() == null ? "" : location.getName() %>"
                                                data-note="<%= location.getNote() == null ? "" : location.getNote() %>"
                                                onclick="openLocationModalFromButton(this)">
                                        </td>
                                        <td>
                                            <form action="LocationServlet" method="POST">
                                                <input type="hidden" name="action" value="delete">
                                                <input type="hidden" name="location-id" value="<%= location.getLocationId() %>">
                                                <input class="btn reset-btn" type="submit" value="Delete">
                                            </form>
                                        </td>
                                    </tr>
                        <%
                                }
                            } else {
                        %>
                                <tr>
                                    <td colspan="9">No category loaded</td>
                                </tr>
                        <%
                            }
                        %>
                        
                    </tbody>
                    
                </table>        
                
                        
                 <h1>Items</h1>
                <table>
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Date</th>
                            <th>Name</th>
                            <th>Location</th>
                            <th>Category</th>
                            <th>Cost</th>
                            <th>Quantity</th>
                            <th>Image Path</th>
                            <th>Note</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            if (items != null && !items.isEmpty()) {
                                for (Item item : items) {
                        %>
                                    <tr>
                                        <td><%= item.getItemId() %></td>
                                        <td><%= item.getDate() %></td>
                                        <td><%= item.getName() %></td>
                                        <td><%= item.getLocationId() != null ? item.getLocationId().getName() : "" %></td>
                                        <td><%= item.getCategoryId() != null ? item.getCategoryId().getName() : "" %></td>
                                        <td><%= item.getCost() %></td>
                                        <td><%= item.getQuantity() %></td>
                                        <td>
                                            <%= item.getUrlPath() %>
                                        </td>
                                        <td><%= item.getNote() %></td>
                                        <td>
                                            <input class="btn submit-btn" type="button" value="Edit">
                                        </td>
                                        <td>
                                            <form action="ItemServlet" method="POST">
                                                <input type="hidden" name="action" value="delete">
                                                <input type="hidden" name="item-id" value="<%= item.getItemId() %>">
                                                <input class="btn reset-btn" type="submit" value="Delete">
                                            </form>
                                        </td>
                                    </tr>
                        <%
                                }
                            } else {
                        %>
                                <tr>
                                    <td colspan="9">No Items loaded</td>
                                </tr>
                        <%
                            }
                        %>
                        
                    </tbody>
                    
                </table>
                        
                <h1>Wishlists</h1>
                <table>
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Price ($)</th>
                            <th>Note</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            if (wishlists != null && !wishlists.isEmpty()) {
                                for (Wishlist wishlist : wishlists) {
                        %>
                                    <tr>
                                        <td><%= wishlist.getWishlistId() %></td>
                                        <td><%= wishlist.getName() %></td>
                                        <td><%= wishlist.getPrice() %></td>
                                        <td><%= wishlist.getNote() %></td>
                                        <td>
                                            <input class="btn submit-btn" type="button" value="Edit">
                                        </td>
                                        <td>
                                            <form action="WishListServlet" method="POST">
                                                <input type="hidden" name="action" value="delete">
                                                <input type="hidden" name="wishlist-id" value="<%= wishlist.getWishlistId() %>">
                                                <input class="btn reset-btn" type="submit" value="Delete">
                                            </form>
                                        </td>
                                    </tr>
                        <%
                                }
                            } else {
                        %>
                                <tr>
                                    <td colspan="9">No wishlist loaded</td>
                                </tr>
                        <%
                            }
                        %>
                        
                    </tbody>
                    
                </table>
            </div>
            
        </main>
        <div id="locationEditModal" class="modal">
            <div class="modal-content">
                <span class="close" onclick="closeLocationModal()">&times;</span>
                <h2>Edit Location</h2>

                <form action="LocationServlet" method="POST">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" id="edit-location-id" name="location-id">

                    <label for="edit-location-id-display">Location ID</label>
                    <input type="text" id="edit-location-id-display" disabled>

                    <label for="edit-location-name">Name</label>
                    <input type="text" id="edit-location-name" name="location-name" required>

                    <label for="edit-location-note">Note</label>
                    <textarea id="edit-location-note" name="location-note" rows="4"></textarea>

                    <div class="modal-actions">
                        <input class="btn submit-btn" type="submit" value="Save Changes">
                        <input class="btn reset-btn" type="button" value="Cancel" onclick="closeLocationModal()">
                    </div>
                </form>
            </div>
        </div>
                        
        <div id="categoryEditModal" class="modal">
            <div class="modal-content">
                <span class="close" onclick="closeCategoryModal()">&times;</span>
                <h2>Edit Category</h2>

                <form action="CategoryServlet" method="POST">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" id="edit-category-id" name="category-id">

                    <label for="edit-category-id-display">Category ID</label>
                    <input type="text" id="edit-category-id-display" disabled>

                    <label for="edit-category-name">Name</label>
                    <input type="text" id="edit-category-name" name="category-name" required>

                    <label for="edit-category-note">Note</label>
                    <textarea id="edit-category-note" name="category-note" rows="4"></textarea>

                    <div class="modal-actions">
                        <input class="btn submit-btn" type="submit" value="Save Changes">
                        <input class="btn reset-btn" type="button" value="Cancel" onclick="closeCategoryModal()">
                    </div>
                </form>
            </div>
        </div>         
                        
                        
       <script>
            function openLocationModalFromButton(button) {
                document.getElementById("edit-location-id").value = button.dataset.id;
                document.getElementById("edit-location-id-display").value = button.dataset.id;
                document.getElementById("edit-location-name").value = button.dataset.name;
                document.getElementById("edit-location-note").value = button.dataset.note;
                document.getElementById("locationEditModal").style.display = "block";
            }

            function closeLocationModal() {
                document.getElementById("locationEditModal").style.display = "none";
            }

            window.addEventListener("click", function(event) {
                const modal = document.getElementById("locationEditModal");
                if (event.target === modal) {
                    closeLocationModal();
                }
            });
        </script>
        
        
        <script>
            function openCategoryModalFromButton(button) {
                document.getElementById("edit-category-id").value = button.dataset.id;
                document.getElementById("edit-category-id-display").value = button.dataset.id;
                document.getElementById("edit-category-name").value = button.dataset.name;
                document.getElementById("edit-category-note").value = button.dataset.note;
                document.getElementById("categoryEditModal").style.display = "block";
            }

            function closeCategoryModal() {
                document.getElementById("categoryEditModal").style.display = "none";
            }

            window.addEventListener("click", function(event) {
                const modal = document.getElementById("categoryEditModal");
                if (event.target === modal) {
                    closeCategoryModal();
                }
            });
        </script>
    </body>
</html>
