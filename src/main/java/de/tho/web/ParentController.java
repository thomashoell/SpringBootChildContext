package de.tho.web;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * Created by Hoell on 07.07.2016.
 */
@Controller
@RequestMapping("")
public class ParentController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @RequestMapping("")
    @ResponseBody
    public HttpEntity index(){
        return new HttpEntity(Arrays.asList(applicationContext.getBeanDefinitionNames()));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
