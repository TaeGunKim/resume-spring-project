/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * Spring Web MVC Config 설정부분
 *
 * <pre>
 * <b>History:</b>
 * Author       Date        Description
 * ys.ko        2016.03.25  초기작성
 * </pre>
 *
 * author ys.ko
 * version 1.0, 2016.03.25 초기작성
 * see None
 */
package com.mycompany.myapp.web.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.mycompany.myapp.common.config.ExposablePropertyPlaceholderConfigurer;
import com.mycompany.myapp.web.aspect.LoggerAspect;
import com.mycompany.myapp.web.viewresolver.ExcelViewResolver;
import com.mycompany.myapp.web.viewresolver.JsonViewResolver;

@Configuration
@EnableWebMvc
@EnableCaching  // Enable Spring caching
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.mycompany.myapp"})
public class MvcConfigurer extends WebMvcConfigurerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(MvcConfigurer.class);

    /**
     * property placeholder config 설정
     * database password 암호화 적용
     * @return ExposablePropertyPlaceholderConfigurer
     */
    @Bean
    public ExposablePropertyPlaceholderConfigurer getExposablePropertyPlaceholderConfigurer() {

    	LOG.debug("getExposablePropertyPlaceholderConfigurer start");
    	ExposablePropertyPlaceholderConfigurer exposablePropertyPlaceholderConfigurer = new ExposablePropertyPlaceholderConfigurer();
        exposablePropertyPlaceholderConfigurer.setEncodingPatterns("*database.password");
        exposablePropertyPlaceholderConfigurer.setLocations(new ClassPathResource("config/application-config-prd.xml"));

        return exposablePropertyPlaceholderConfigurer;
    }

    @Bean
    public BeanNameViewResolver getBeanNameViewResolver() {

    	LOG.debug("getBeanNameViewResolver start");
        BeanNameViewResolver beanNameViewResolver = new BeanNameViewResolver();
        beanNameViewResolver.setOrder(0);
        return beanNameViewResolver;

    }

    /*
     * Configure ContentNegotiationManager
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.ignoreAcceptHeader(true).defaultContentType(
                MediaType.TEXT_HTML);
    }

    /*
     * Configure ContentNegotiatingViewResolver
     */
    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);

        // Define all possible view resolvers
        List<ViewResolver> resolvers = new ArrayList<ViewResolver>();

        //resolvers.add(jaxb2MarshallingXmlViewResolver());
        resolvers.add(jsonViewResolver());
        resolvers.add(jspViewResolver());
        resolvers.add(excelViewResolver());

        resolver.setViewResolvers(resolvers);
        return resolver;
    }

    /*
     * Configure View resolver to provide JSON output using JACKSON library to
     * convert object in JSON format.
     */
    @Bean
    public ViewResolver jsonViewResolver() {
        return new JsonViewResolver();
    }

    /*
     * Configure View resolver to provide XLS output using Apache POI library to
     * generate XLS output for an object content
     */
    @Bean
    public ViewResolver excelViewResolver() {
        return new ExcelViewResolver();
    }

    @Bean
    public UrlBasedViewResolver jspViewResolver() {

    	LOG.debug("jspViewResolver start");
        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
        urlBasedViewResolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
        urlBasedViewResolver.setPrefix("/WEB-INF/jsp/");
        urlBasedViewResolver.setSuffix(".jsp");
        urlBasedViewResolver.setRedirectHttp10Compatible(false);
        return urlBasedViewResolver;

    }

    @Bean
    public ReloadableResourceBundleMessageSource errorMessageSource() {
    	LOG.debug("ReloadableResourceBundleMessageSource start");
    	ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
    	bundleMessageSource.setDefaultEncoding("UTF-8");

    	bundleMessageSource.setBasename("classpath:/message/pamaErrorMessageBundle");
    	return bundleMessageSource;
    }

    @Bean
    public CacheManager cacheManager() {
        // configure and return an implementation of Spring's CacheManager SPI
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("default")));
        return cacheManager;
    }
    @Bean(name="loggerAspect")
    public LoggerAspect loggerAspect() {
    	LOG.debug("loggerAspect...");
    	LoggerAspect loggerAspect = new LoggerAspect();
    	return loggerAspect;
    }
	/**
	 * <welcome-file-list>
     * <welcome-file>index.html</welcome-file>
     * <welcome-file>index.jsp</welcome-file>
     * </welcome-file-list>
	 *
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addViewControllers(org.springframework.web.servlet.config.annotation.ViewControllerRegistry)
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		LOG.debug("addViewControllers...");
	    registry.addViewController("/").setViewName("forward:/index.html");
	    registry.addViewController("/").setViewName("forward:/index.jsp");
	}

}
