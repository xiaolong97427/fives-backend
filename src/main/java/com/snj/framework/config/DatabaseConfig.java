package com.snj.framework.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
@EnableJpaRepositories(basePackages="com.snj.framework")
public class DatabaseConfig {

	private static final String PROPERTY_NAME_DATABASE_DRIVER   = "db.driver";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
    private static final String PROPERTY_NAME_DATABASE_URL      = "db.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
  
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
    private static final String PROPERTY_NAME_FORMAT_SQL = "format_sql";
    private static final String PROPERTY_NAME_DEFAULT_SCHEMA = "hibernate.default_schema";
    private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    
    @Resource
    private Environment env;
    
    @Bean
    public DataSource dataSource() {
     DriverManagerDataSource dataSource = new DriverManagerDataSource();
     dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
     dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
     dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
     dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
     return dataSource;
    }
     
    private Properties hibProperties() {
     Properties properties = new Properties();
     properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
     properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
     properties.put(PROPERTY_NAME_FORMAT_SQL, env.getRequiredProperty(PROPERTY_NAME_FORMAT_SQL));
     properties.put(PROPERTY_NAME_DEFAULT_SCHEMA, env.getRequiredProperty(PROPERTY_NAME_DEFAULT_SCHEMA));
     properties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));
     
     
     
     return properties; 
    }
     
    @Bean
    public HibernateTransactionManager transactionManager() {
     HibernateTransactionManager transactionManager = new HibernateTransactionManager();
     transactionManager.setSessionFactory(sessionFactory().getObject());
     return transactionManager;
    }
     
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
     LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
     sessionFactoryBean.setDataSource(dataSource());
     //sessionFactoryBean.setPackagesToScan(getClass().getPackage().getName());
     sessionFactoryBean.setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
     sessionFactoryBean.setHibernateProperties(hibProperties());
     return sessionFactoryBean;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
 
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
        entityManagerFactoryBean.setJpaProperties(hibProperties());
 
        return entityManagerFactoryBean;
    }
}
