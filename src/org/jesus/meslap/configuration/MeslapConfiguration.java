package org.jesus.meslap.configuration;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.jesus.meslap.util.MeslapUtils;
import org.jesus.meslap.util.PagingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

@Configuration
public class MeslapConfiguration {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	public static final String devConfigFileName = "META-INF/spring/config.properties";
	public static final String prodConfigFileName = "conf/conf.properties";
	
	@Value("${hibernate.connection.driver_class}")
	private String driverClassName;
	@Value("${hibernate.connection.url}")
	private String url;
	@Value("${hibernate.connection.username}")
	private String username;
	@Value("${hibernate.connection.password}")
	private String password;
	
	@Value("${jdbc.initialSize}")
	private int initialSize;
	@Value("${jdbc.maxActive}")
	private int maxActive;
	@Value("${jdbc.maxIdle}")
	private int maxIdle;
	@Value("${jdbc.maxWait}")
	private long maxWait;
	
	//for hibernate
	@Value("${hibernate.show_sql}")
	private String show_sql;
	@Value("${hibernate.format_sql}")
	private String format_sql;
	@Value("${hibernate.dialect}")
	private String dialect;
	@Value("${hibernate.hbm2ddl.auto}")
	private String hbm2ddl_auto;
	@Value("${hibernate.query.substitutions}")
	private String query_substitutions;
	@Value("${hibernate.cache.region.factory_class}")
	private String cache_region_factory_class;
	@Value("${hibernate.cache.use_second_level_cache}")
	private String use_second_level_cache;
	@Value("${hibernate.cache.use_query_cache}")
	private String use_query_cache;
	@Value("${hibernate.current_session_context_class}")
	private String current_session_context_class;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
      PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
      Resource[] properties = new Resource[] {new ClassPathResource(devConfigFileName)};
      pspc.setLocations(properties);
      return pspc;
	}
	
//	@Profile("development")
//    public static class DevelopmentConfig {
//        @Bean
//        public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//            PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
//            Resource[] properties = new Resource[] {new ClassPathResource(devConfigFileName)};
//            pspc.setLocations(properties);
//            return pspc;
//        }
//    }
//	
//	@Profile("production")
//    public static class ProductionConfig {
//        @Bean
//        public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//            PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
//            //Resource[] properties = new Resource[] {new ClassPathResource(devConfigFileName), new FileSystemResource(prodConfigFileName)};
//            Resource[] properties = new Resource[] {new ClassPathResource(devConfigFileName)};
//            pspc.setLocations(properties);
//            return pspc;
//        }
//    }
	
	
	@Bean(name = "dataSource", destroyMethod="close")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setInitialSize(initialSize);
		dataSource.setMaxActive(maxActive);
		dataSource.setMaxIdle(maxIdle);
		dataSource.setMaxWait(maxWait);
		return dataSource;
	}

	@Bean(name = "sessionFactory")
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(dataSource);
		factory.setPackagesToScan("org.jesus.meslap");
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", dialect);
		hibernateProperties.put("hibernate.hbm2ddl.auto", hbm2ddl_auto);
		hibernateProperties.put("hibernate.show_sql", show_sql);
		hibernateProperties.put("hibernate.format_sql", format_sql);
		//hibernateProperties.put("hibernate.query.substitutions", query_substitutions);
		//hibernateProperties.put("hibernate.cache.region.factory_class", cache_region_factory_class);
		//hibernateProperties.put("hibernate.cache.use_second_level_cache", use_second_level_cache);
		//hibernateProperties.put("hibernate.cache.use_query_cache", use_query_cache);
		//hibernateProperties.put("hibernate.current_session_context_class", current_session_context_class);
		factory.setHibernateProperties(hibernateProperties);
		return factory;
	}

	@Bean(name = "transactionManager")
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
	
	@Bean(name="meslapUtils")
	public MeslapUtils meslapUtils(){
		return new MeslapUtils();
	}
	
	@Bean(name="pagingUtil")
	public PagingUtil pagingUtil(){
		return new PagingUtil();
	}
}
