package com.mycompany.myapp.web.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class SystemArchitecture {

	private static final Logger LOG = LoggerFactory.getLogger(SystemArchitecture.class);

	@Pointcut("execution(* *..service.*Service.*(..))")
    public void businessService() {
		LOG.debug("businessService ==============================");
	}

	@Before("businessService()")
	public void log() {
		LOG.debug("businessService llog==============================");
	}


	public void log1() {
		LOG.debug("businessService text==============================");
	}


}
