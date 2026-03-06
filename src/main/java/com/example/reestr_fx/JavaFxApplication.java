package com.example.reestr_fx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;


public class JavaFxApplication extends Application {
    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        // Создаем Spring контекст, передавая ему главный класс конфигурации
        applicationContext = new SpringApplicationBuilder(JavaFxSpringApp.class).run();
    }

    @Override
    public void start(Stage stage) {
        // Публикуем событие о том, что Stage готов. Кто-то (слушатель) его поймает и настроит.
        applicationContext.publishEvent(new StageReadyEvent(stage));
    }

    @Override
    public void stop() {
        // Закрываем Spring контекст и выходим из JavaFX
        applicationContext.close();
        Platform.exit();
    }

    // Внутренний класс-событие, которое будет нести в себе Stage
    public static class StageReadyEvent extends ApplicationEvent {
        public StageReadyEvent(Stage stage) {
            super(stage);
        }
        public Stage getStage() {
            return ((Stage) getSource());
        }
    }
}