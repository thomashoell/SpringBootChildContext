package de.tho.child;

import de.tho.business.DummyService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping
public class ChildController implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private final DummyService dummyService;
    private final ChildControllerConfig childControllerConfig;

    @Autowired
    public ChildController(DummyService dummyService, ChildControllerConfig childControllerConfig) {
        this.dummyService = dummyService;
        this.childControllerConfig = childControllerConfig;
    }

    @RequestMapping("")
    @ResponseBody
    public HttpEntity index() {
        return new HttpEntity(Arrays.asList(applicationContext.getBeanDefinitionNames()));
    }

    @RequestMapping("service")
    @ResponseBody
    public String service() {

        return dummyService.getMessage() + " " + childControllerConfig.getSomeProperty();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
