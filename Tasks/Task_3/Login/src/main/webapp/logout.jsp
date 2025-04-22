<%
    session.invalidate();

    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for(Cookie c : cookies){
            if(c.getName().equals("user")){
                c.setMaxAge(0);
                response.addCookie(c);
            }
        }
    }

    response.sendRedirect("login.jsp");
%>
