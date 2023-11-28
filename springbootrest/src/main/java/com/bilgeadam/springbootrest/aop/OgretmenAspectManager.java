package com.bilgeadam.springbootrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Profile(value="test")
public class OgretmenAspectManager {


//	@Pointcut(value = "execution(public * *(..))")
	// içinde ogretmen kelimesi geçen sınıfları yakaladım
//	@Pointcut(value = "execution(* com.bilgeadam.springbootrest.*.Ogretmen*.*(..))")
	// sadece ogretmencontroller
//	@Pointcut(value = "execution(* com.bilgeadam.springbootrest.controller.OgretmenController.*(..))")
	// kendi projemde hepsini yakalamak istersek
	@Pointcut(value = "execution(public * com.bilgeadam.springbootrest..*(..))")
//	@Pointcut(value = "execution(* org.springframework.web.servlet..*(..))")
	private void ogretmenpointcut()
	{
		System.err.println("==> all methods");
	}
 
	// yukarıdaki metodun adı
	@Before(value = "ogretmenpointcut()")
	public void beforeogrenciPointcut(JoinPoint point)
	{
		System.err.println("==> before ogretmenpointcut " + point.getSignature());
	}
 
	@After("ogretmenpointcut()")
	public void afterogretmenPointcut(JoinPoint point)
	{
		System.err.println("==> after ogretmenpointcut " + point.getSignature());
	}
 
	// hem öncesi hem sonrası
	@Around(value = "ogretmenpointcut()")
	public Object aroundOgretmenPointcut(ProceedingJoinPoint point) throws Throwable
	{
		System.err.println("==> around ogretmenpointcut");
		long startTime = System.currentTimeMillis();
		Object object = point.proceed();
		long endtime = System.currentTimeMillis();
		System.err.println(("Class Name: " + point.getSignature().getDeclaringTypeName() + ". Method Name: " + point.getSignature().getName() + ". Time taken for Execution is : " + (endtime - startTime) + "ms"));
		System.err.println("==> around ogretmenpointcut 2");
		return object;
	}
	
}
