package io.github.pradeeppk7.lab4rbacsecurity;

import jakarta.annotation.security.RolesAllowed;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

@WebServlet("/secure/admin")
@RolesAllowed({"ADMIN"})
public class SecureAdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        Principal principal = request.getUserPrincipal();
        String user = (principal != null) ? principal.getName() : "Not authenticated";

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Secure Admin</title></head><body>");
            out.println("<h1>/secure/admin</h1>");
            out.println("<p>Admin Access Granted</p>");
            out.println("<p>User: " + user + "</p>");
            out.println("<p>USER role: " + request.isUserInRole("USER") + "</p>");
            out.println("<p>ADMIN role: " + request.isUserInRole("ADMIN") + "</p>");
            out.println("</body></html>");
        }
    }
}