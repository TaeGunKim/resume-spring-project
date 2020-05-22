/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * Servlet 3.1 web.xml의 설정부분
 *
 * <pre>
 * <b>History:</b>
 * Author       Date        Description
 * ys.ko        2016.03.25  초기작성
 * </pre>
 *
 * @author ys.ko
 * @version 1.0, 2016.03.25 초기작성
 * @see None
 */
package com.mycompany.myapp.web.config;

import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import com.mycompany.myapp.common.filter.PamaSiteMeshFilter;

/**
 * @author 영수
 *
 */
public class WebInitializer extends AbstractDispatcherServletInitializer {

	private static final Logger LOG = LoggerFactory.getLogger(WebInitializer.class);

	/* (non-Javadoc)
	 * @see org.springframework.web.WebApplicationInitializer#onStartup(javax.servlet.ServletContext)
	 */
	public void onStartup(ServletContext servletContext) throws ServletException {

		LOG.debug("WebInitializer onStartup...");

		super.onStartup(servletContext);

        // Encoding
        FilterRegistration.Dynamic fr = servletContext.addFilter("encodingFilter",
        	      new CharacterEncodingFilter());
        fr.setInitParameter("encoding", "UTF-8");
        fr.setInitParameter("forceEncoding", "true");
        fr.addMappingForUrlPatterns(null, true, "/*");

//        // Security
        FilterRegistration.Dynamic springSecurityFilterChain =
                servletContext.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
        springSecurityFilterChain.addMappingForUrlPatterns(null, false, "/*");

        // Sitemesh
        FilterRegistration.Dynamic sitemesh =
                servletContext.addFilter("sitemesh", PamaSiteMeshFilter.class);
        sitemesh.addMappingForUrlPatterns(null, false, "*.do");
        //20170707 kimtg 기존 이관된 데이터 안에 이미지들을 보이기 위한 설정
        //usr/local/wp-content 이관하여 심볼릭 링크 처리함
        sitemesh.addMappingForUrlPatterns(null, false, "*.jpg");
        sitemesh.addMappingForUrlPatterns(null, false, "*.gif");
        sitemesh.addMappingForUrlPatterns(null, false, "*.png");

	}

    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.scan(ClassUtils.getPackageName(getClass()));
        return context;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "*.do", "*.json", "*.xlsx", "*.xls", "*.image" };
    }

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }

    /*
     * 파일업로드 관련 MultipartConfig
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(getMultipartConfigElement());
    }

    private MultipartConfigElement getMultipartConfigElement() {
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement( "", 1024*1024*10, 1024*1024*10*5, 1024*1024);
        return multipartConfigElement;
    }
}
