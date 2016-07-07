package de.tho;

import com.example.ChildContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Servlet;

/**
 * Created by Hoell on 07.07.2016.
 */
@Configuration
@ConditionalOnClass({Servlet.class, DispatcherServlet.class})
@ConditionalOnWebApplication
public class ChildContextConfig implements ApplicationContextAware, ApplicationListener<ContextRefreshedEvent> {

    private final Logger logger = LoggerFactory.getLogger(ChildContextConfig.class);
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private void createChildContext() {
        final AnnotationConfigEmbeddedWebApplicationContext childContext = new AnnotationConfigEmbeddedWebApplicationContext(ChildContext.class);
        childContext.setParent(this.applicationContext);
        childContext.setId(this.applicationContext.getId() + ":child");

//        childContext.register(
//                PropertyPlaceholderAutoConfiguration.class,
//                EmbeddedServletContainerAutoConfiguration.class,
//                DispatcherServletAutoConfiguration.class
//        );

//        childContext.refresh();
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        logger.info("creating child context");
        createChildContext();
    }
}
