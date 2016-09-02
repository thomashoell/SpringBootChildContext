package de.tho.child;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by thomas@ad.hoell.internal on 02.09.16.
 */
@Configuration
public class ChildControllerConfig {

    @Value("${some.property}")
    private String someProperty;

    public String getSomeProperty() {
        return someProperty;
    }

    public void setSomeProperty(String someProperty) {
        this.someProperty = someProperty;
    }
}
