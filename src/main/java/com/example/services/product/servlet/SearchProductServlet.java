package com.example.services.product.servlet;

import com.example.services.product.to.Product;
import com.example.utils.DBFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SearchProductServlet", value = "/SearchProductServlet")
public class SearchProductServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int productId;
        try {
            productId = Integer.parseInt(request.getParameter("productId"));
        } catch (NumberFormatException e) {
            productId = -1;
        }
        System.out.println("SearchProductServlet.productId=" + productId);

        SessionFactory sessionFactory = DBFactory.getDBFactory().getSessionFactory();

        Session session = sessionFactory.openSession();

        Product product = session.get(Product.class, productId);
        System.out.println(product);

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        RequestDispatcher rd = null;

        if(product == null) {
            rd =request.getRequestDispatcher("index.jsp");
            rd.include(request, response);
            out.println("<h4 style='color:red'> Product not found </h4");
        } else {
            out.println("<h1>Product detail</h1>");
            out.println(product);
        }

        session.close();
        out.close();

    }
}
