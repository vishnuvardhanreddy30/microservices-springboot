package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    @Value("${eureka.username}")
    String userName;

    @Value("${eureka.password}")
    String password;



}
