package tn.esprit.asi.ski_project.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.List;

@Aspect
@Component
@Slf4j
public class PefromanceAspect {

    @Around("execution( * tn.esprit.asi.ski_project.services.*.add*(..))")
    public Object executionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
       Object o = proceedingJoinPoint.proceed();
       stopWatch.stop();
       log.info("Execution time of {} is  {}", proceedingJoinPoint.getSignature().getName(), stopWatch.getTotalTimeMillis());
       return o;
    }

    @Around("execution( * tn.esprit.asi.ski_project.services.*.add*(..))")
    public List<Object> executionTime2(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {

        List<Object> objectList = (List<Object>) proceedingJoinPoint.proceed();
        return objectList;
    }
}
