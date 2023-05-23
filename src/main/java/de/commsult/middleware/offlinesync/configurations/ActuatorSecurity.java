package de.commsult.middleware.offlinesync.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(2)
public class ActuatorSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //@formatter:off
        http.antMatcher("/actuator/**").authorizeRequests().anyRequest().permitAll();
        //@formatter:on
    }

}
