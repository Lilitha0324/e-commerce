import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class CheckoutServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session != null) {
            List<Product> cart = (List<Product>) session.getAttribute("cart");
            if (cart != null) {
                // Process order (in real app, save to DB, send email, etc.)
                cart.clear();
                session.setAttribute("cart", cart);
            }
        }

        // Send confirmation page
        response.setContentType("text/html");
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html><head><title>Order Confirmed</title></head><body>");
        response.getWriter().println("<h1>Thank you for your purchase!</h1>");
        response.getWriter().println("<p>Your order has been placed successfully.</p>");
        response.getWriter().println("<a href='index.html'>Back to Store</a>");
        response.getWriter().println("</body></html>");
    }
}
