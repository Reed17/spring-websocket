package net.gvvinblade.edu.springwebsocket.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import net.gvvinblade.edu.springwebsocket.configuration.security.global.AspectJConfig;
import net.gvvinblade.edu.springwebsocket.configuration.security.global.GlobalAuthenticationConfig;
import net.gvvinblade.edu.springwebsocket.configuration.security.global.MethodSecurityConfig;
import net.gvvinblade.edu.springwebsocket.configuration.security.web.WebSecurityConfig;

@Configuration
@Import({
        AspectJConfig.class
        , GlobalAuthenticationConfig.class
        , MethodSecurityConfig.class
        , WebSecurityConfig.class
})
public class GlobalSpringConfig {
}
