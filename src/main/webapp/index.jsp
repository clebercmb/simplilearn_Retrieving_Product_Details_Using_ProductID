<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1><%= "Product Search Parge" %></h1>
    <br/>

    <form action="SearchProductServlet" method="post">
        <label>
            Product Id: <input type="text" placeholder="Type Product Id" name="productId"/>
        </label>

        <input type="submit" value="Search"/>

    </form>


</body>
</html>