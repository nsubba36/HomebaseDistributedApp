<%-- 
    Document   : index
    Created on : Feb 14, 2026, 10:27:39 AM
    Author     : nishansubba
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="id=edge">
        <title>Home</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <%@include file="Menu.jsp" %>
        <main>
            <h1>Dashboard</h1>
            
            <div class="dashboard">
                <div class="home-card">
                    <p class="card-title">Total Games</p>
                    <p class="value-container"><span class="card-value">900<span></p>
                </div>

                <div class="home-card">
                    <p class="card-title">Total Spend</p>
                    <p class="value-container">$<span class="card-value">900<span></p>
                </div>
                
                <div class="home-card">
                    <p class="card-title">Wishlist</p>
                    <div class="wishlist-card-container">
                        <p class="value-container">Items: <span class="card-value">900<span></p>
                        <p class="value-container">Cost: $<span class="card-value">900<span></p>
                    </div>
                </div>
                
                <div class="home-card">
                    <p class="card-title">Total Books</p>
                    <p class="value-container"><span class="card-value">60<span></p>
                </div>
                
                <div class="home-card">
                    <p class="card-title">Total Items</p>
                    <p class="value-container"><span class="card-value">120<span></p>
                </div>
            </div>
            
            
            
        </main>
        
    </body>
</html>
