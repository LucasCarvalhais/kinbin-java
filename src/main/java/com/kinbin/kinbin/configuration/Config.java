package com.kinbin.kinbin.configuration;

import com.kinbin.kinbin.core.model.Kinbin;
import com.kinbin.kinbin.core.service.Game;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan(basePackageClasses = Game.class)
public class Config {

    @Bean
    public Kinbin getKinbin() {
        return new Kinbin();
    }

}
