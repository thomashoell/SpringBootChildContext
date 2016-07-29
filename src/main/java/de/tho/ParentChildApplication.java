package de.tho;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"de.tho"}, excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "de.tho.child.*"))
public class ParentChildApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParentChildApplication.class, args);
    }
}
