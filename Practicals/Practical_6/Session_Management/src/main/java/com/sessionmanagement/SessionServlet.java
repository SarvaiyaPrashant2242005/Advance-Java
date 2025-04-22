package com.sessionmanagement;

import com.sessionmanagement.SessionCounterListener;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get or create session
        HttpSession session = request.getSession(true);

        // Store user name in session
        String userName = (String) session.getAttribute("userName");
        if (userName == null) {
            userName = "Guest_" + session.getId().substring(0, 5);
            session.setAttribute("userName", userName);
        }

        out.println("<html><body>");
        out.println("<h3>Session Tracking Example</h3>");
        out.println("<p>Session ID: " + session.getId() + "</p>");
        out.println("<p>Welcome, " + userName + "!</p>");
        out.println("<p>Active Sessions: " + SessionCounterListener.getActiveSessions() + "</p>");

        out.println("<br><a href='SessionServlet'>Refresh Page</a>");
        out.println("<br><a href='LogoutServlet'>Invalidate Session</a>");

        out.println("</body></html>");
    }
}
