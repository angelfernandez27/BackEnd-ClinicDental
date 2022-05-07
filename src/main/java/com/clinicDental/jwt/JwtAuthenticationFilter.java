package com.clinicDental.jwt;

import com.clinicDental.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token=getJwtToRequest(request);


            try {
                if (StringUtils.hasText(token) && jwtTokenProvider.validatorToken(token)){
                    String username=jwtTokenProvider.getUsernameJwt(token);

                    UserDetails userDetails=customUserDetailsService.loadUserByUsername(username);
                    UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            filterChain.doFilter(request,response);


    }

    //Método para obtener el token
    //Bearer token de acceso: Bearer es un formato que nos permite la autorización de un usuario
    private String getJwtToRequest(HttpServletRequest request){
        //hago la petición al header authorization pd(en postman se ve bien)
        String bearerToken= request.getHeader("Authorization");
        //si tiene el texto de authorization BearerToken y si empieza con la palabra Bearer lo retorno
        if (bearerToken!= null && bearerToken.startsWith("Bearer ")){
            //con substring 7 elimino la palabra Bearer + el espacio para retornar  solo  el token
            return bearerToken.substring(7);
        }
        //si no tengo authorization retorno null
        return null;
    }
}
