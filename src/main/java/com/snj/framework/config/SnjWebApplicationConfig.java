package com.snj.framework.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration							//  required for any Java-based configuration in Spring
@ComponentScan("com.snj.framework")
@EnableTransactionManagement			// enables Spring’s annotation-driven transaction management capability
@EnableWebMvc
public class SnjWebApplicationConfig {

	// Maps resources path to webapp/resources
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry.addResourceHandler("/resources/**").addResourceLocations(
						"/resources/");
			}

			// Provides internationalization of messages
//			@Bean
//			public ResourceBundleMessageSource messageSource() {
//				ResourceBundleMessageSource source = new ResourceBundleMessageSource();
//				source.setBasename("messages");
//				return source;
//			}
			
//	/**
//	 * This data source will be injected to a Hibernate’s SessionFactory bean as below
//	 * 
//	 * @return
//	 */
//	@Bean(name = "dataSource")
//	public DataSource getDataSource() {
//	    BasicDataSource dataSource = new BasicDataSource();
//	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//	    dataSource.setUrl("jdbc:mysql://localhost:3306/usersdb");
//	    dataSource.setUsername("root");
//	    dataSource.setPassword("secret");
//	 
//	    return dataSource;
//	}
//	
//	/**
//	 * NOTE: For Java-based configuration, Spring provides the LocalSessionFactoryBuilder that facilitates the creation of Hibernate’s SessionFactory. For XML configuration, a 
//	 * LocalSessionFactoryBean is used instead
//	 * @param dataSource
//	 * @return
//	 */
//	@Autowired
//	@Bean(name = "sessionFactory")
//	public SessionFactory getSessionFactory(DataSource dataSource) {
//	 
//	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
//	 
//	    //sessionBuilder.addAnnotatedClasses(User.class, Object.class);
//	    //sessionBuilder.setProperty("hibernate.show_sql", "true");
//	    
//	    sessionBuilder.addProperties(getHibernateProperties());
//	    
//	    return sessionBuilder.buildSessionFactory();
//	}
//	
//	private Properties getHibernateProperties() {
//	    Properties properties = new Properties();
//	    properties.put("hibernate.show_sql", "true");
//	    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//	    return properties;
//	}
//	
//	@Autowired
//	@Bean(name = "transactionManager")
//	public HibernateTransactionManager getTransactionManager(
//	        SessionFactory sessionFactory) {
//	    HibernateTransactionManager transactionManager = new HibernateTransactionManager(
//	            sessionFactory);
//	 
//	    return transactionManager;
//	}
}
