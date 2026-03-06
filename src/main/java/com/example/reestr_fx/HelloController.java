package com.example.reestr_fx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("/com/example/reestr_fx/hello-view.fxml")  // Убедитесь, что путь к fxml правильный
public class HelloController {

    boolean flag = true;
    int truecount = 0;
    int falsecount = 0;
    @FXML
    private Label welcomeText;
    @FXML
    private Label anotherText;

    @FXML
    protected void HelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Spring Boot App!");
        if (flag) {
            anotherText.setText("Flag is true " + truecount);
            truecount++;
        } else {
            anotherText.setText("Flag is false " + falsecount);
            falsecount++;
        }
        flag = !flag;

    }
    @FXML
    protected void Hehe(){
        anotherText.setText("omg, i understand it");
    }
}