package mysessiontest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(urlPatterns = "/servlethtwo")
public class ServletHTwo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        String val = req.getParameter("txtVal");
        out.print("<a href='servleththree?txtVal="+val+"'>click me</a>");
        out.print("<form action='servleththree'>");
        out.print("<input type='text' name='txtNewVal'/>");
        out.print("<input type='submit' name='btnGo' value='Go'/>");
        out.print("</form>");
    }
}