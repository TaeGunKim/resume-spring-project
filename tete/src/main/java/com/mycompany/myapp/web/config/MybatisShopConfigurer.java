

package com.mycompany.myapp.web.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import net.sf.log4jdbc.tools.Log4JdbcCustomFormatter;
import net.sf.log4jdbc.tools.LoggingType;

/**
 * Copyright 2020 by kimtg ALL right reserved.

 * <pre>
 * @author kimtg
 * @date 2020. 5. 11. 오전 10:07:17
 * @description
 * </pre>
 */
@Configuration
@EnableTransactionManagement
@MapperScan(
        basePackages="com.mycompany.myapp.shopcomponent.*.dao",
        sqlSessionFactoryRef="shopSessionFactory"
        )
@ImportResource("classpath:spring/aop-context.xml")
public class MybatisShopConfigurer {

    private static final Logger LOG = LoggerFactory.getLogger(MybatisShopConfigurer.class);

    private @Value("${shop.database.driver}") String driver;
    private @Value("${shop.database.url}") String url;
    private @Value("${shop.database.user}") String username;
    private @Value("${shop.database.password}") String password;
    private @Value("${shop.database.pool.min.size}") int minSize;
    private @Value("${shop.database.pool.max.size}") int maxSize;


    @Bean(name="shopdataSource", destroyMethod="close")
    public DataSource getDataSource() {

        LOG.debug("driver ============ {}", driver);
        LOG.debug("username ============ {}", username);
        LOG.debug("password ============ {}", password);

        url += "?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
        DataSource ds = new DataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setInitialSize(minSize);
        ds.setMinIdle(minSize);
        ds.setMaxIdle(maxSize);
        ds.setMaxActive(maxSize);
        ds.setRemoveAbandoned(true);
        ds.setRemoveAbandonedTimeout(30);
        ds.setLogAbandoned(true);
        ds.setValidationQuery("select 1");
        ds.setTestOnBorrow(true);
        ds.setTimeBetweenEvictionRunsMillis(30000);

        return ds;

    }

    @Bean(name="shopdataSource")
    public Log4jdbcProxyDataSource getLog4jdbcProxyDataSource() {
        LOG.debug("getLog4jdbcProxyDataSource is {}");
        Log4jdbcProxyDataSource log4jdbc = new Log4jdbcProxyDataSource(getDataSource());
        Log4JdbcCustomFormatter lgg4JdbcCustomFormatter = new Log4JdbcCustomFormatter();
        lgg4JdbcCustomFormatter.setLoggingType(LoggingType.MULTI_LINE);
        lgg4JdbcCustomFormatter.setSqlPrefix("SQL:::");
        log4jdbc.setLogFormatter(lgg4JdbcCustomFormatter);
        LOG.debug("getLog4jdbcProxyDataSource is {}", log4jdbc.toString());
        return log4jdbc;

    }

    @Bean(name="transactionManager")
    public DataSourceTransactionManager getTransactionManager(DataSource shopdataSource) {
        LOG.debug("Creating DataSourceTransactionManager, dataSource = {}", shopdataSource);
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(shopdataSource);
        return transactionManager;
    }


    @Bean
    public SqlSessionFactoryBean shopSessionFactory(DataSource shopdataSource, ApplicationContext applicationContext) throws Exception {

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(shopdataSource);
        factoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis/mybatis-config.xml"));

        factoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/mappers/shop/**/*.xml"));

        return factoryBean;

    }

    @Bean
    public SqlSessionTemplate shopSqlSession(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
