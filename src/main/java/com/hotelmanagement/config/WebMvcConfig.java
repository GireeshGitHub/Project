package com.hotelmanagement.config;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.hotelmanagement.controller.City;
import com.hotelmanagement.controller.HotelForm;
import com.hotelmanagement.dao.HibernateUtil;
import com.hotelmanagement.dao.Hotel;
import com.hotelmanagement.dao.HotelBooking;
 
@Configuration
@PropertySource("application.properties")
@EnableWebMvc
@EnableTransactionManagement
public class WebMvcConfig extends WebMvcConfigurerAdapter{
 
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
 
    @Bean
    public InternalResourceViewResolver viewResolver() {
    	InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        /*resolver.setViewNames("*.jsp");*/
        return resolver;
    }
    
    @Bean
    public City city(){
    	return new City();
    }
    
    @Bean
    public HotelForm hotelForm(){
    	return new HotelForm();
    }
    
    @Value("${spring.datasource.url}")
	private String mysqldbUrl;
    
    @Value("${spring.datasource.username}")
    private String userName;
    
    @Value("${spring.datasource.password}")
    private String passWord;

    @Bean(name = "dataSource")
	public BasicDataSource dataSource() {

		BasicDataSource ds = new BasicDataSource();
	        ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl(mysqldbUrl);
		ds.setUsername(userName);
		ds.setPassword(passWord);
		return ds;
	}
    
    private Properties getHibernateProperties() {
        Properties prop = new Properties();
        prop.put("hibernate.show_sql", "true");
        prop.put("hibernate.dialect",
            "org.hibernate.dialect.MySQL5Dialect");
        return prop;
}
    
    @Bean(name = "sessionFactory")
    public SessionFactory sessionFactory() {
    	LocalSessionFactoryBuilder builder =
    			new LocalSessionFactoryBuilder(dataSource());
    	builder.addProperties(getHibernateProperties());
    	builder.addAnnotatedClass(Hotel.class);
    	builder.addAnnotatedClass(HotelBooking.class);

    	SessionFactory sf= builder.buildSessionFactory();
    	
    	return sf;
    }
    
   
}
