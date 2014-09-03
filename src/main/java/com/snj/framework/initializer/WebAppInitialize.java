package com.snj.framework.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.snj.framework.config.DatabaseConfig;
import com.snj.framework.config.SnjWebApplicationConfig;
import com.snj.framework.config.SnjWebMvcConfig;

/**
 * Since version 3.1 it has Servlet 3 API support, 
 * I won't use web.xml for configuring DispatcherServlet, rather I'll configure it programmatically.
 * 
 * @version 1.0
 * @author syongwaiman2
 *
 */
public class WebAppInitialize implements WebApplicationInitializer  {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		
		// ===================================
		// === servletContext <-- Listener ===
		// ===================================
		
		// 1 - implementation that looks for Spring configuration in classes annotated with @Configuration annotation
		AnnotationConfigWebApplicationContext rootCtx = new AnnotationConfigWebApplicationContext();
	    rootCtx.register(
	    		SnjWebApplicationConfig.class,
	    		DatabaseConfig.class,
	    		SnjWebMvcConfig.class
	        //JpaRepositoryConfig.class // Include JPA entities, Repositories
	       // MongoDbRepositoryConfig.class, // Include MongoDB document entities, Repositories
	       // GemfireRepositoryConfig.class	 // Inlucde Gemfire entities, Repositories
	    );
		
	    rootCtx.setServletContext(servletContext);
	    
	    // Spring Dispatcher Servlet dynamically to handle all requests coming through the application
	    Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(rootCtx));  
        servlet.addMapping("/");  
        servlet.setLoadOnStartup(1);  
        
//	    // 2 - ContextLoaderListener is added to ServletContext – the purpose of this is to 'glue' WebApplicationContext to the lifecycle of ServletContext.
//	    servletContext.addListener(new ContextLoaderListener(rootCtx));
//
//	    // =============================================
//	    // === servletContext <--- dispatcherServlet ===
//	    // =============================================
//	    
//	    // 3  -LOAD Spring Data Rest Context. could load directly the RepositoryRestMvcConfiguration , but we prefered to subclass it and override 
//	    
//	    // Create a dispatcherSerlet configuration
//	    AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
//	    webCtx.register(SnjWebMvcConfig.class);
//	    DispatcherServlet dispatcherServlet = new DispatcherServlet(webCtx);
//	    
//	    // Load this configuration into the servletContext 
//	    ServletRegistration.Dynamic reg = servletContext.addServlet("rest-exporter", dispatcherServlet);
//	    
//	    reg.setLoadOnStartup(1);
//	    reg.addMapping("/*");
//		
	}
	
}
