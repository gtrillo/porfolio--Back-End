
package com.portfolioGT.portfolioGT.segurity.jwk;

import com.portfolioGT.portfolioGT.segurity.service.UserDetailsImple;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtFilter extends OncePerRequestFilter{
      private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
      
      @Autowired
      JwtProvider provider;
      @Autowired
      UserDetailsImple userDetailsImple;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try
        {
            String token = getToken(request);
            if(token != null && provider.ValidarToken(token))
            {
                String nombreUsuario = provider.getNombreUsuarioFromToken(token);
                UserDetails userDetails = this.userDetailsImple.loadUserByUsername(nombreUsuario);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }catch(Exception e)
        {
              logger.error("Fallo en el metodo doFilterInternal");
        }
        filterChain.doFilter(request,response);
    }

    private String getToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer")){
        return header.replace("Bearer", "");
        }       
        return null;
    }
}
