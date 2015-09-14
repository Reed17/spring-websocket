package net.gvvinblade.edu.springwebsocket.configuration.security.global;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(
        mode = AdviceMode.ASPECTJ,
        jsr250Enabled = true,
        prePostEnabled = true,
        securedEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
}
