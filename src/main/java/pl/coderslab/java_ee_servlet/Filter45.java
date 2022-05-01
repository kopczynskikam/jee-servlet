package pl.coderslab.java_ee_servlet;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@WebFilter(filterName = "Filter45", urlPatterns = "/*")
public class Filter45 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String queryDateTime = String.valueOf(LocalDateTime.now());
        if (request instanceof HttpServletRequest) {
            Map<String, String> allRequestParams = new LinkedHashMap<>();
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            String userAgent = httpServletRequest.getHeader("User-Agent");
            Enumeration<String> allHttpParameters = httpServletRequest.getParameterNames();
            while (allHttpParameters.hasMoreElements()) {
                String paramName = allHttpParameters.nextElement();
                String paramValue = httpServletRequest.getParameter(paramName);
                allRequestParams.put(paramName, paramValue);
            }
            long startTime = System.currentTimeMillis();
            chain.doFilter(request, response);
            long stopTime = System.currentTimeMillis();
            long queryTime = stopTime - startTime;

            Request newRequest = new Request();
            newRequest.setUserAgent(userAgent);
            newRequest.setQueryDateTime(queryDateTime);
            newRequest.setAllRequestParams(allRequestParams);
            newRequest.setQueryTime(queryTime);

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            RequestDAO.createRequest(newRequest);
        }
    }
}
