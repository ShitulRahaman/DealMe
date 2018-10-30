package exibition.config.log;

import exibition.domain.CustomLog;
import exibition.repository.CustomLogRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    CustomLogRepositiry customLogRepositiry;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws ServletException, IOException {

        String userAgent = request.getHeader("User-Agent");
        customLogRepositiry.save(new CustomLog(request.getRemoteAddr(), authentication.getName(),"", userAgent,"LOGIN"));
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
