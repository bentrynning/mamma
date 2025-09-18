package com.example.mamma.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Activates the {@code @Mamma} aspect in a classic Spring application.
 * <p>
 * Users can place this annotation on a {@code @Configuration} class to
 * register the {@link MammaConfiguration} that exposes the {@code MammaAspect}
 * bean.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MammaConfiguration.class)
public @interface EnableMamma {
}
