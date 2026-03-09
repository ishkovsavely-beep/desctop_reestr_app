package com.example.reestr_fx;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StageInitializer implements ApplicationListener<JavaFxApplication.StageReadyEvent> {

    private final FxWeaver fxWeaver;

    @Autowired
    public StageInitializer(FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    @Override
    public void onApplicationEvent(JavaFxApplication.StageReadyEvent event) {
        Stage stage = event.getStage();
        // Загружаем контроллер и представление через FxWeaver
        Parent root = fxWeaver.loadView(TestWindowController.class); // Ваш контроллер
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("JavaFX + Spring Boot");
        stage.show();
    }
}
