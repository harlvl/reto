package pe.entelgy.reto.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Configuration
@PropertySource("classpath:application.properties")
public class ReadProperties {
    @Autowired
    public Environment environment;

    public String getProperty(String enumProperty) {
        return environment.getProperty(enumProperty);
    }
}
