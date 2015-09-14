package net.gvvinblade.edu.springwebsocket.configuration.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import net.gvvinblade.edu.springwebsocket.configuration.AppSpringConfig;
import net.gvvinblade.edu.springwebsocket.configuration.GlobalSpringConfig;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/*"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{GlobalSpringConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppSpringConfig.class};
    }
}
