package org.trinity.hihome.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.trinity.hihome.rest.util.TokenFilter;
import org.trinity.rest.security.AbstractPreAuthenticationFilter;

@Configuration
public class SecurityBeanConfiguration {

    @Bean
    public AbstractPreAuthenticationFilter getTokenFilter() {
        return new TokenFilter();
    }
}
