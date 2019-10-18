package com.kinbin.configuration;

import com.kinbin.core.model.kinbin.KinbinImpl;
import com.kinbin.core.service.GameService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan(basePackageClasses = GameService.class)
public class Config {

    @Bean
    public KinbinImpl getKinbin() {
        return new KinbinImpl();
    }

}
