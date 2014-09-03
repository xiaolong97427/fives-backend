package com.snj.framework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * We can now start creating spring-data-jpa repositories as they will be exposed as RESTful resources automatically
 * And we can still add custom configuration to the WebConfiguration class if needed.
 *  
 * @author syongwaiman2
 *
 */
@Configuration
public class SnjWebMvcConfig extends RepositoryRestMvcConfiguration  {

	
}
