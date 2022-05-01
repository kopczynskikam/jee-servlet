package pl.coderslab.java_ee_servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "newsletterServlet", value = "/newsletter")
public class newsletterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("newsletter")) {
                    getServletContext().getRequestDispatcher("/loremIpsum.jsp").forward(request, response);
                    return;
                }
            }
        }
        Cookie newsletterCookie = new Cookie("newsletter", "ok");
        newsletterCookie.setMaxAge(60 * 60 * 24);
        response.addCookie(newsletterCookie);
        getServletContext().getRequestDispatcher("/newsletter.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        if (!name.equals("") && !email.equals("")) {
            User newUser = new User();
            newUser.setName(name);
            newUser.setEmail(email);
            newUser = UserDAO.createUser(newUser);
        } else {
            getServletContext().getRequestDispatcher("/newsletter.jsp").forward(request, response);
        }
        response.sendRedirect("/newsletter");

    }
}
