package com.ecommerce;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.*;

public class CartServlet extends HttpServlet {
    private static final Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(1, "Product 1", 10.0));
        products.put(2, new Product(2, "Product 2", 20.0));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        HttpSession session = request.getSession();
        List<Product> cart = (List<Product>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }
        cart.add(products.get(productId));
        session.setAttribute("cart", cart);

        response.sendRedirect("cart.html");
    }
}
