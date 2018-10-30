package exibition.config.log;

import exibition.domain.CustomLog;
import exibition.repository.CustomLogRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
class CustomBadCredential implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    @Autowired
    CustomLogRepositiry customLogRepositiry;


    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        WebAuthenticationDetails auth = (WebAuthenticationDetails)event.getAuthentication().getDetails();
        String userName = event.getAuthentication().getPrincipal().toString();
        String credentials = event.getAuthentication().getCredentials().toString();

        customLogRepositiry.save(new CustomLog(auth.getRemoteAddress(), userName,credentials, "","MALICIOUS USER"));
    }
}
