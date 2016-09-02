package de.tho;


import de.tho.child.ChildContext;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"de.tho"}, excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "de.tho.child.*"))
public class ParentChildApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParentChildApplication.class, args);
        new SpringApplicationBuilder()
                .sources(ParentChildApplication.class)
                .child(ChildContext.class)
                .bannerMode(Banner.Mode.OFF)
                .run("--server.port=9091");

    }
}
