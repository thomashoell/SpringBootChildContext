package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Hoell on 07.07.2016.
 */
@Configuration
//@EnableWebMvc
@EnableAutoConfiguration
@ComponentScan("com.example")
@PropertySource("child-context.properties")
@Import({PropertyPlaceholderAutoConfiguration.class, EmbeddedServletContainerAutoConfiguration.class, DispatcherServletAutoConfiguration.class})
public class ChildContext {

    @Value("${server.port}")
    private Integer port;

    @Bean
    public ServerProperties serverProperties() {
        ServerProperties props = new ServerProperties();
        props.setPort(port);
        return props;
    }
}
