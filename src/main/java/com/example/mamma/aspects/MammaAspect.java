package com.example.mamma.aspects;

import com.example.mamma.annotations.Mamma;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
/**
 * Aspect that reacts to {@link Mamma} annotations.
 */
@Aspect
public class MammaAspect {

    @Before("@annotation(mamma)")
    public void announceMamma(JoinPoint joinPoint, Mamma mamma) {
        String mamaName = mamma.value();
        System.out.printf("%s's mama is %s!%n", joinPoint.getSignature().getName(), mamaName);
    }
}
