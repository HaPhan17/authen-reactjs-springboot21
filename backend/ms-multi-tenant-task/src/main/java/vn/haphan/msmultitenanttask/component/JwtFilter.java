package vn.haphan.msmultitenanttask.component;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import vn.haphan.msmultitenanttask.bean.TenantContext;
import vn.haphan.msmultitenanttask.config.JwtService;

import java.io.IOException;
import java.util.Collections;


/**
 * @author : Hà Phan
 * created date : 2/24/2026
 * project-name : ms-learn-spring40
 * package-name : vn.haphan.msmultitenanttask.component
 **/
@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtFilter(JwtService jwtService1) {
        this.jwtService = jwtService1;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            Claims claims = jwtService.extractClaims(token);

            TenantContext.setTenant(claims.get("tenantId", String.class));

            // set authorities
            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(
                            claims.get("sub"),
                            null,
                            Collections.emptyList()
                    );

            SecurityContextHolder.getContext().setAuthentication(authToken);

        }

        filterChain.doFilter(request, response);
        TenantContext.clear();
    }
}
