<%@ page import="edu.neumont.csc380.Driver" %>
<%--
  Created by IntelliJ IDEA.
  User: sgomez
  Date: 7/23/13
  Time: 7:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Restaurant Order</title>
    </head>

    <body>
         <%
             Driver menu = new Driver();
             menu.listRestaurantsWithMenu(response);
         %>

        <form method="POST" action="/PlaceOrder">
            <p>What would you like to order?</p>
            <input name="order" type="text"/>
            <input type="submit" value="Place Order"/>
        </form>
    </body>
</html>