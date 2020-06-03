package com.mycompany.myapp.web.config;

import java.util.Properties;

import javax.servlet.MultipartConfigElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@Configuration
public class ProcessorConfigurer {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessorConfigurer.class);

    private @Value("${mail.host}") String mailHost;
    private @Value("${mail.port}") Integer mailPort;
    private @Value("${mail.username}") String mailUsername;
    private @Value("${mail.password}") String mailPassword;
    private @Value("${mail.protocol}") String mailProtocol;
    private @Value("${mail.defaultEncoding}") String defaultEncoding;
    private @Value("${mail.defaultFromEmail}") String defaultFromEmail;
    private @Value("${mail.defaultFromName}") String defaultFromName;
    private @Value("${mail.smtp.auth}") String smtPauth;
    private @Value("${mail.smtp.starttls.enable}") String smtpQtarttls;
    private @Value("${mail.smtp.quitwait}") String smtpQuitwait;
    private @Value("${mail.debug}") String mailDebug;
    private @Value("${mail.from}") String mailFrom;

//    @Bean
//    public MultipartConfigElement multipartConfigElement() {
//        LOG.debug("multipartConfigElement start");
//        String location="/tmp";
//        int fileSizeThreshold=0;
//        long maxFileSize=5;       // 5 MB
//        long maxRequestSize=20971520;   // 20 MB
//        return new MultipartConfigElement(location, maxFileSize, maxRequestSize, fileSizeThreshold);
//    }

    @Bean(name = "multipartResolver")
    public StandardServletMultipartResolver resolver() {
        LOG.debug("resolver start");
        StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();
        return resolver;
    }

    @Bean(name= "javaMailSender")
    public JavaMailSender javaMailSender() {
        LOG.debug("javaMailSender start");
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(mailHost);
        javaMailSender.setPort(mailPort);
        javaMailSender.setUsername(mailUsername);
        javaMailSender.setPassword(mailPassword);
        javaMailSender.setProtocol(mailProtocol);
        javaMailSender.setDefaultEncoding(defaultEncoding);
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", smtPauth);
        properties.put("mail.smtp.starttls.enable", smtpQtarttls);
        properties.put("mail.smtp.quitwait", smtpQuitwait);
        properties.put("mail.debug", mailDebug);
        properties.put("mail.from", mailFrom);
        javaMailSender.setJavaMailProperties(properties);
        return javaMailSender;
    }

}
