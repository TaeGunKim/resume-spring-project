package com.mycompany.myapp.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Configuration
@Aspect
public class LoggerAspect {

	@Pointcut("execution(public * com.pama..*service.*(..))")
	private void controllerMethod(){}

//	@Before("controllerMethod()")
//	public void beforeMethod(JoinPoint joinPoint) {
//		//      System.out.println("1111 getDeclaringTypeName " + joinPoint.getSignature().getDeclaringTypeName() );
//		//		System.out.println("starting " + joinPoint.getSignature().toLongString() );
//		//		System.out.println("getKind " + joinPoint.getKind().toString() );
//		//		System.out.println("getArgs " + joinPoint.getArgs().toString() );
//		//		System.out.println("getSourceLocation " + joinPoint.getSourceLocation().toString() );
//		//		System.out.println("getStaticPart " + joinPoint.getStaticPart().toString() );
//		//		System.out.println("getTarget " + joinPoint.getTarget().toString() );
//		//		System.out.println("getThis " + joinPoint.getThis().toString() );
//		//		System.out.println("toLongString " + joinPoint.toLongString() );
//		//    	System.out.println("1111 toString " + joinPoint.getSignature().toShortString() );
//		//    	System.out.println("1111 getName " + joinPoint.getSignature().getDeclaringType() );
//		//    	System.out.println("1111 getName " + joinPoint.getSignature().getName() );
//	}

	@Around("controllerMethod()")
	public Object aroundMethod(ProceedingJoinPoint  joinPoint) throws Throwable {
		//    	System.out.println("-------------------------------");
		//    	System.out.println("1111 getDeclaringTypeName " + joinPoint.getSignature().getDeclaringTypeName() );
		//    	System.out.println("1111 toString " + joinPoint.getSignature().toLongString() );
		//    	System.out.println("1111 toString " + joinPoint.getSignature().toShortString() );
		//    	System.out.println("1111 getName " + joinPoint.getSignature().getDeclaringType() );
		//    	System.out.println("1111 getName " + joinPoint.getSignature().getName() );

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object obj = joinPoint.proceed();
		stopWatch.stop();
		System.out.println(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()  + " : "  + stopWatch.getTotalTimeMillis() + " ms");

		return obj;

	}

//	@After("controllerMethod()")
//	public void afterMethod(JoinPoint joinPoint) {
//		//    	System.out.println("-------------------------------");
//		//      System.out.println("1111 getDeclaringTypeName " + joinPoint.getSignature().getDeclaringTypeName() );
//		//    	System.out.println("1111 toString " + joinPoint.getSignature().toLongString() );
//		//    	System.out.println("1111 toString " + joinPoint.getSignature().toShortString() );
//		//    	System.out.println("1111 getName " + joinPoint.getSignature().getDeclaringType() );
//		//    	System.out.println("1111 getName " + joinPoint.getSignature().getName() );
//	}

}
