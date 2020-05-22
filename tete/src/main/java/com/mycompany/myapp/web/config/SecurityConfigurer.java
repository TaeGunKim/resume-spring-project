/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * Spring Security Config 설정부분
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.mycompany.myapp.common.component.oauth.Qauth2UserDetailsService;
import com.mycompany.myapp.common.component.password.MySqlOldPasswordEncoder;
import com.mycompany.myapp.common.component.web.PamaLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private Qauth2UserDetailsService userDetailService;

    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index.html", "/tag.txt", "/images/**", "/img/**", "/prod/**", "/css/**", "/js/**", "/fonts/**", "/favicon.ico");
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
            .authorizeRequests()
	            .antMatchers("/login/**").permitAll()
	            .antMatchers("/error/**").permitAll()
	            .antMatchers("/about/**").permitAll()
	            .antMatchers("/history/**").permitAll()
	            .antMatchers("/skills/**").permitAll()
	            .antMatchers("/").permitAll()
	            .antMatchers("/main.do").permitAll()
	            .antMatchers("/sideproject/**").permitAll()
	            .anyRequest().hasRole("USER")
                .and()
            .exceptionHandling()
                .accessDeniedPage("/login/loginFaile.do?authorization_error=true")
                .and()
            .csrf()
                .requireCsrfProtectionMatcher(new AntPathRequestMatcher("/oauth/authorize"))
                .disable()
            .logout()
            	.logoutUrl("/logout")
                //.logoutSuccessUrl("/main.do")
                .logoutSuccessHandler(new PamaLogoutSuccessHandler())
                .and()
            .formLogin()
            	.loginProcessingUrl("/login")
                .failureUrl("/login/loginFaile.do")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/login/loginOk.do")
                .loginPage("/login/loginForm.do");

        //http.exceptionHandling().accessDeniedPage("/common/accessDenied.do");
        // @formatter:on

        http
            .headers()
                .frameOptions().sameOrigin()
                .httpStrictTransportSecurity().disable();
    }

    /**
     * 패스
     * @return PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        //return new BCryptPasswordEncoder();
        return new MySqlOldPasswordEncoder();
    }
}

