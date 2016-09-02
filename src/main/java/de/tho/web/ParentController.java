package de.tho.web;

import de.tho.child.ChildContext;
import org.springframework.beans.BeansException;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Created by Hoell on 07.07.2016.
 */
@RestController
@RequestMapping
public class ParentController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @GetMapping
    public HttpEntity index() {
        return new HttpEntity(Arrays.asList(applicationContext.getBeanDefinitionNames()));
    }

    @GetMapping("create")
    public void createChildContext() {
        final AnnotationConfigEmbeddedWebApplicationContext childContext = new AnnotationConfigEmbeddedWebApplicationContext();
        childContext.setParent(this.applicationContext);
        childContext.setId(this.applicationContext.getId() + ":child");
        childContext.register(ChildContext.class);
        childContext.refresh();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
