package mysessiontest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(urlPatterns = "/servlethone")
public class ServletHOne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        out.print("<form action='servlethtwo'>");
        out.print("<input type='text' name='txtVal'/>");
        out.print("<input type='submit' name='btnGo' value='Go'/>");
        out.print("</form>");
    }
}