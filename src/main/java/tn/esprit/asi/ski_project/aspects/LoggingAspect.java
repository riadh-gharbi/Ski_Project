package tn.esprit.asi.ski_project.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
//Component is the biggest stereotype (it has the broadest semantics) and serves as a generic stereotype for any Spring-managed component.
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(public void tn.esprit.asi.ski_project.services.*.*(..))")
    public void inMethod(JoinPoint joinPoint)
    {
        log.info("In method: "+joinPoint.getSignature().getName());
    }
    @After("execution(public void tn.esprit.asi.ski_project.services.*.*(..))")
    public void outMethod(JoinPoint joinPoint)
    {
        log.info("Out method: "+joinPoint.getSignature().getName());
    }

}
