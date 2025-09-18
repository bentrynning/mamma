package com.example.mamma.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation that prints your mama's name whenever the annotated method runs.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Mamma {

    /**
     * The name of your mama to be printed by the aspect.
     */
    String value();
}
