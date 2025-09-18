package com.example.mamma.autoconfigure;

import com.example.mamma.aspects.MammaAspect;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * Auto-configuration that registers the {@link MammaAspect} when Spring Boot is present.
 */
@AutoConfiguration
@ConditionalOnClass(MammaAspect.class)
public class MammaAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public MammaAspect mammaAspect() {
        return new MammaAspect();
    }
}
