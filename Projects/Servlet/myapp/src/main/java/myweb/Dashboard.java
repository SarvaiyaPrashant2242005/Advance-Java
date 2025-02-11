package myweb;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Dashboard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        serve(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        serve(req, resp);
    }
    void serve(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        ServletConfig config = getServletConfig();
        String pageName = config.getInitParameter("pagename");
        ServletContext context = getServletContext();
        String appName = context.getInitParameter("appname");
        out.print(appName+"<br/>");
        out.print(pageName+"<br/>");
//Using Cookies
//        Cookie[] cookies = req.getCookies();
//        String userName = "";
//        for(Cookie c:cookies){
//            if(c.getName().equals("uname")){
//                userName = c.getValue();
//            }
//        }
//        if(userName.equals("")){
//            resp.sendRedirect("login");
//        }
//        else{
//            out.print("Welcome <b>"+userName+"</b>");
//            out.println("</br>");
//            out.print("<a href='logout'><button>Logout</button></a>");
//        }

//Using HTTP Sessiom

        String userName = "";
        HttpSession session = req.getSession();
        userName = (String)session.getAttribute("unm");
        if(userName.equals("")){
            resp.sendRedirect("login");
        }
        else{
            out.print("Welcome <b>"+userName+"</b>");
            out.print("<br/>"+session.getId());
            out.print("<br/>"+session.getCreationTime());
            out.print("<br/>"+session.getLastAccessedTime());
            out.print("<br/>"+session.getMaxInactiveInterval());
            out.print("<a href='logout'>logout</a>");
        }

    }

}