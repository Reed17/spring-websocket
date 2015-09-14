package net.gvvinblade.edu.springwebsocket.configuration.security.global;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Configuration
@EnableLoadTimeWeaving
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AspectJConfig {
}
