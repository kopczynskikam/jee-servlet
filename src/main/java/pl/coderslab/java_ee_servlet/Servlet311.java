package pl.coderslab.java_ee_servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Servlet311", value = "/servlet311")
public class Servlet311 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String layoutLangauge = "pl";
        if(cookies!=null){
            for(Cookie cookie : cookies){
                if (cookie.getName().equals("language")){
                    layoutLangauge = cookie.getValue();
                }
            }
        }

        Map<String, String> lang = new HashMap<>();
        lang.put("en", "Hello");
        lang.put("pl", "Cześć");
        lang.put("de", "Hallo");
        lang.put("es", "Hola");
        lang.put("fr", "Salut");
        request.setAttribute("languageMap", lang);
        request.setAttribute("layoutLanguage", layoutLangauge);
        getServletContext().getRequestDispatcher("/servlet311.jsp").forward(request,response);
    }


}
