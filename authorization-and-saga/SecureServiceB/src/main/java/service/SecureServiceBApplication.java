package service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

@SpringBootApplication
public class SecureServiceBApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecureServiceBApplication.class, args);
    }

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public OAuth2RestTemplate oAuth2RestTemplate(
            OAuth2ProtectedResourceDetails details,
            @Qualifier("oauth2ClientContext") OAuth2ClientContext oAuth2ClientContext) {
        return new OAuth2RestTemplate(details, oAuth2ClientContext);
    }

}
