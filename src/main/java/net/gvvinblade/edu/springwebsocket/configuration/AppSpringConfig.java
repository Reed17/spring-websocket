package net.gvvinblade.edu.springwebsocket.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.EnableScheduling;

import net.gvvinblade.edu.springwebsocket.configuration.security.websocket.WebSocketSecurityConfig;
import net.gvvinblade.edu.springwebsocket.configuration.web.WebMvcConfig;
import net.gvvinblade.edu.springwebsocket.configuration.websocket.WebSocketConfig;

@Configuration
@Import({
        WebMvcConfig.class
        , WebSocketConfig.class
        , WebSocketSecurityConfig.class
})
@ComponentScan(basePackages = {"net.gvvinblade.edu.springwebsocket.mvc"})
@PropertySource("classpath:spring.properties")
@EnableScheduling
public class AppSpringConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySources = new PropertySourcesPlaceholderConfigurer();
        Resource[] resources = new ClassPathResource[]{
                new ClassPathResource("spring.properties")};
        propertySources.setLocations(resources);
        propertySources.setIgnoreUnresolvablePlaceholders(true);
        return propertySources;
    }


    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("i18n/Messages");
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }


}
