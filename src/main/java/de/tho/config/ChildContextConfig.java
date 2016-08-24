package de.tho.config;

import de.tho.child.ChildContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Servlet;

/**
 * Created by Hoell on 07.07.2016.
 */
@Configuration
@ConditionalOnClass({Servlet.class, DispatcherServlet.class})
@ConditionalOnWebApplication
public class ChildContextConfig implements ApplicationContextAware {

    private final Logger logger = LoggerFactory.getLogger(ChildContextConfig.class);
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private void createChildContext_working() {
        logger.info("creating child context");
        final AnnotationConfigEmbeddedWebApplicationContext childContext = new AnnotationConfigEmbeddedWebApplicationContext();
        childContext.register(ChildContext.class);
        childContext.setId(this.applicationContext.getId() + ":child");
        childContext.refresh();
        childContext.setParent(this.applicationContext);
    }

    private void createChildContext_failing() {
        logger.info("creating child context");
        final AnnotationConfigEmbeddedWebApplicationContext childContext = new AnnotationConfigEmbeddedWebApplicationContext();
        childContext.setParent(this.applicationContext);
        childContext.setId(this.applicationContext.getId() + ":child");
        childContext.register(ChildContext.class);
        childContext.refresh();
    }

    @EventListener(ContextRefreshedEvent.class)
    public void parentContextRefreshed(ContextRefreshedEvent contextRefreshedEvent) {
        logger.info("parent context refreshed");
        // this works but I cannot autowire because the parent is set after refresh
        createChildContext_working();

        // this loops forever
//        createChildContext_failing();
    }
}
