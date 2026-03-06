package com.example.reestr_fx;

import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.spring.SpringFxWeaver;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FxWeaverConfig {

    @Bean
    public FxWeaver fxWeaver(ConfigurableApplicationContext applicationContext) {
        // Возвращаем SpringFxWeaver, который связывает JavaFX и Spring
        return new SpringFxWeaver(applicationContext);
    }
}