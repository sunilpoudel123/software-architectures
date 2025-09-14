//package service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.oauth2.client.OAuth2ClientContext;
//import org.springframework.security.oauth2.client.OAuth2RestTemplate;
//import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
//import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//import java.util.Arrays;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Qualifier("oauth2ClientContext")oauth2ClientContext
//    @Autowired
//    private OAuth2ClientContext oauth2ClientContext;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/login", "/oauth2/callback").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .addFilterBefore(clientAuthenticationFilter(), BasicAuthenticationFilter.class);
//    }
//
//    private OAuth2ClientAuthenticationProcessingFilter clientAuthenticationFilter() {
//        AuthorizationCodeResourceDetails client = new AuthorizationCodeResourceDetails();
//        client.setClientId("client");
//        client.setClientSecret("secret");
//        client.setAccessTokenUri("http://localhost:8088/oauth/token");
//        client.setUserAuthorizationUri("http://localhost:8088/oauth/authorize");
//        client.setScope(Arrays.asList("openid", "profile", "email")); // Adjust scopes as needed
//
//        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(client, oauth2ClientContext);
//        OAuth2ClientAuthenticationProcessingFilter filter = new OAuth2ClientAuthenticationProcessingFilter("/oauth2/callback");
//        filter.setRestTemplate(restTemplate);
//        filter.setTokenServices(userInfoTokenServices());
//        return filter;
//    }
//
//    private UserInfoTokenServices userInfoTokenServices() {
//        UserInfoTokenServices tokenServices = new UserInfoTokenServices(
//                "http://localhost:8088/user",
//                "client"
//        );
//        tokenServices.setRestTemplate(new OAuth2RestTemplate(client(), oauth2ClientContext));
//        return tokenServices;
//    }
//
//    private AuthorizationCodeResourceDetails client() {
//        AuthorizationCodeResourceDetails client = new AuthorizationCodeResourceDetails();
//        client.setClientId("client");
//        client.setClientSecret("secret");
//        client.setAccessTokenUri("http://localhost:8088/oauth/token");
//        client.setUserAuthorizationUri("http://localhost:8088/oauth/authorize");
//        return client;
//    }
//}