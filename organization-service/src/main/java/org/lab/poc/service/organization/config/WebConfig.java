package org.lab.poc.service.organization.config;

import org.lab.poc.service.organization.model.Organization;
import org.lab.poc.service.organization.repository.OrganizationRepository;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebConfig {
    
    @Bean
    public OrganizationRepository repository() {
        OrganizationRepository repo = new OrganizationRepository();
        repo.add(new Organization("Microsoft", "Redmond, Washington, USA"));
		repo.add(new Organization("Oracle", "Redwood City, California, USA"));	

        return repo;
    }

	@Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }
}
