/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author reyg6
 */
@WebFilter(filterName = "ReviewUser", urlPatterns = {"/AuthenticationCa"})
public class ReviewUser implements Filter {
    
        public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        /*
            
            User user = new User();
            BDUser bd = new BDUser();
            
            bd.setDataBase();
            bd.connectingBD();
            user = bd.reviewQueries();
        
            String review = user.getPasswordE();
                
          **/  
        String password = request.getParameter("password");
        String review = "password";
        
        HttpServletResponse resp = (HttpServletResponse) response;
        
        boolean validation = true;
        if(validation == password.equals(review)){
            chain.doFilter(request, response);
        }else{
            resp.sendRedirect("AuthenticationPage.jsp");
        }
    }

    public void destroy() {        
    }

    public void init(FilterConfig filterConfig) {        
       
    }
    
}
