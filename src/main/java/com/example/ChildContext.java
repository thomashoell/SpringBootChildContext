package com.example;

import org.springframework.boot.autoconfigure.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Hoell on 07.07.2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.example")
@Import({PropertyPlaceholderAutoConfiguration.class, EmbeddedServletContainerAutoConfiguration.class, DispatcherServletAutoConfiguration.class})
public class ChildContext {

    @Bean
    public ServerProperties serverProperties() {
        ServerProperties props = new ServerProperties();
        props.setPort(9091);
        return props;
    }
}
