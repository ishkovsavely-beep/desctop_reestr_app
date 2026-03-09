package com.example.reestr_fx;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Controller;

@Controller
@FxmlView("/com/example/reestr_fx/Test scene.fxml")
public class TestWindowController {

    // Связываем элементы из FXML по их fx:id
    // ВАЖНО: В FXML у элементов НЕТ fx:id, поэтому сначала добавим их
    // Я покажу, как это должно выглядеть ПОСЛЕ добавления ID

    @FXML
    private Button actionButton;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private CheckBox checkBox;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    public void initialize() {
        // Этот метод вызывается автоматически после загрузки FXML
        System.out.println("Контроллер TestWindow инициализирован");

        // Настраиваем ChoiceBox (выпадающий список)
        setupChoiceBox();

        // Добавляем обработчики событий
        setupEventHandlers();
    }

    private void setupChoiceBox() {
        // Добавляем элементы в выпадающий список
        choiceBox.getItems().addAll("Первый вариант", "Второй вариант", "Третий вариант");

        // Устанавливаем значение по умолчанию
        choiceBox.setValue("Первый вариант");

        // Добавляем слушатель изменений
        choiceBox.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    System.out.println("Выбран: " + newValue);
                }
        );
    }

    private void setupEventHandlers() {
        // Обработчик для кнопки
        if (actionButton != null) {
            actionButton.setOnAction(event -> {
                System.out.println("Кнопка нажата!");
                handleButtonClick();
            });
        }

        // Обработчик для ColorPicker
        if (colorPicker != null) {
            colorPicker.setOnAction(event -> {
                Color selectedColor = colorPicker.getValue();
                System.out.println("Выбран цвет: " + selectedColor);
            });
        }

        // Обработчик для CheckBox
        if (checkBox != null) {
            checkBox.selectedProperty().addListener(
                    (observable, oldValue, newValue) -> {
                        System.out.println("CheckBox изменен: " + newValue);
                    }
            );
        }
    }

    @FXML
    private void handleButtonClick() {
        System.out.println("Метод handleButtonClick вызван");

        // Пример взаимодействия с элементами
        if (checkBox.isSelected()) {
            System.out.println("CheckBox отмечен");
        }

        String selectedChoice = choiceBox.getValue();
        System.out.println("Текущий выбор: " + selectedChoice);
    }
}