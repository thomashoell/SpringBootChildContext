package de.tho;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Hoell on 07.07.2016.
 */
@Controller
@RequestMapping("beans")
public class ParentController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @RequestMapping("")
    @ResponseBody
    public String index(){
        StringBuilder beans = new StringBuilder();

        for (String bean : applicationContext.getBeanDefinitionNames()){
            beans
                    .append(bean)
                    .append("<br />");
        }

        return beans.toString();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
