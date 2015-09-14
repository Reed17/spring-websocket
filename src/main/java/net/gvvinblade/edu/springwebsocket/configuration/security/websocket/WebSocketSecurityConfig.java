package net.gvvinblade.edu.springwebsocket.configuration.security.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;

@Configuration
public class WebSocketSecurityConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {

    protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
        messages
                .nullDestMatcher().authenticated()
                .simpDestMatchers("/app/**").hasRole("USER")
                .simpDestMatchers("/user/**").authenticated()
                .simpSubscribeDestMatchers("/topic/**", "/queue/**").hasRole("USER")
                .anyMessage().denyAll();
    }

}
