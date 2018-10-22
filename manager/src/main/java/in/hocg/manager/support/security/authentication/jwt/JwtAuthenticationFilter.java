package in.hocg.manager.support.security.authentication.jwt;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hocgin on 2018/10/21.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        
        if (!HttpMethod.POST.name().equals(request.getMethod())) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }
        
        String username = obtainUsername(request);
        String password = obtainPassword(request);
        
        if (username == null) {
            username = "";
        }
        
        if (password == null) {
            password = "";
        }
        
        username = username.trim();
        
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                username, password);
        
        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);
        
        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
