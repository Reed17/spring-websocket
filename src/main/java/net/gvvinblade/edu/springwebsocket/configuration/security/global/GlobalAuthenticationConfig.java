package net.gvvinblade.edu.springwebsocket.configuration.security.global;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

@Configuration
@EnableGlobalAuthentication
public class GlobalAuthenticationConfig extends GlobalAuthenticationConfigurerAdapter {

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("ravan").password("ravan1234").roles("USER")
                .and()
                .withUser("ram").password("ram123").roles("ADMIN");
    }
}
