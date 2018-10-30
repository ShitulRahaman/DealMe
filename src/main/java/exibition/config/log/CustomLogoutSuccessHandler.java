package exibition.config.log;

import exibition.domain.CustomLog;
import exibition.repository.CustomLogRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler {

    @Autowired
    CustomLogRepositiry customLogRepositiry;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        String userAgent = request.getHeader("User-Agent");
        customLogRepositiry.save(new CustomLog(request.getRemoteAddr(), authentication.getName(),"", userAgent,"LOGOUT"));
        super.onLogoutSuccess(request, response, authentication);
    }

}