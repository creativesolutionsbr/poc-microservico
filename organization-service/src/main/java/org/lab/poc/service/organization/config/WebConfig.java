package org.lab.poc.service.organization.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.lab.poc.service.organization.model.Organization;
import org.lab.poc.service.organization.repository.OrganizationRepository;

@Configuration
public class WebConfig {
    
    @Bean
    public OrganizationRepository repository() {
        OrganizationRepository repo = new OrganizationRepository();
        repo.add(new Organization("Microsoft", "Redmond, Washington, USA"));
		repo.add(new Organization("Oracle", "Redwood City, California, USA"));	

        return repo;
    }
}
