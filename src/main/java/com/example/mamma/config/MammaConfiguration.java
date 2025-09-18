package com.example.mamma.config;

import com.example.mamma.aspects.MammaAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Standard Spring configuration that exposes the {@link MammaAspect} bean.
 */
@Configuration
@EnableAspectJAutoProxy
public class MammaConfiguration {

    @Bean
    public MammaAspect mammaAspect() {
        return new MammaAspect();
    }
}
