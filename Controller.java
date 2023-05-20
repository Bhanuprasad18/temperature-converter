package com.internshala.firstapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public Label welcomeLabel;
    @FXML
    public ChoiceBox<String> choiceBox;
    @FXML
    public TextField textField;
    @FXML
    public Button button;

    private static final String C_TO_F = "Celsius to Fahrenheit";
    private static final String F_TO_C = "Fahrenheit to Celsius";

    private boolean isC_TO_F = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        choiceBox.getItems().add(C_TO_F );
        choiceBox.getItems().add(F_TO_C);
        choiceBox.setValue(C_TO_F);

        choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {

            if(t1.equals(C_TO_F)){
                isC_TO_F = true;
            }
            else{
                isC_TO_F = false;
            }

        });
        button.setOnAction(actionEvent -> {
            convert();
        });
    }

    private void convert() {
        float inputTemperature = 0.0f;
        try {
            inputTemperature = Float.parseFloat(textField.getText());
        }catch (Exception e){
            warnUser();
            return;
        }
        float newTemperature = 0.0f;

        if(isC_TO_F){
            newTemperature = (inputTemperature * 9 / 5) + 32;
        }
        else {
            newTemperature = (inputTemperature - 32) * 5 / 9 ;
        }

        display(newTemperature);
    }

    private void warnUser() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("wrong Input");
        alert.show();
    }

    private void display(float newTemperature) {
        String unit = isC_TO_F? "F" : "C" ;
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("result");
        alertDialog.setHeaderText("Your converted temperature is below");
        alertDialog.setContentText("The new temperature is: " + newTemperature +" "+ unit);
        alertDialog.show();
    }
}