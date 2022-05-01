package pl.coderslab.java_ee_servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet312", value = "/servlet312")
public class Servlet312 extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("language", request.getParameter("language"));
        response.addCookie(cookie);
    }
}
