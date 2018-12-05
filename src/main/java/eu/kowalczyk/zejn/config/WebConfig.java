package eu.kowalczyk.zejn.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

/**
 * Created by JKowalczyk on 2018-12-04.
 */
@Configuration
class WebConfig {


    @Bean
    public FilterRegistrationBean filterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(requestFilter());
        registration.addUrlPatterns("/*");
        registration.setName("requestFilter");
        return registration;
    }

    @Bean(name = "requestFilter")
    public javax.servlet.Filter requestFilter() {
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludeClientInfo(true);
        filter.setIncludePayload(false);
        return filter;
    }


}
