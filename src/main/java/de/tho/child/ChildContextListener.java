package de.tho.child;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

/**
 * Created by thomas@ad.hoell.internal on 24.08.16.
 */
@Configuration
public class ChildContextListener {

    private final Logger logger = LoggerFactory.getLogger(ChildContextListener.class);

    @EventListener(ContextRefreshedEvent.class)
    public void childContextRefreshed(ContextRefreshedEvent contextRefreshedEvent){
        logger.info("child context refreshed");
    }
}
