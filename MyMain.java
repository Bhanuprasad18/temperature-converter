package com.internshala.firstapp;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new
                FXMLLoader(getClass().getResource("hello-view.fxml"));
        VBox rootNode = loader.load();
        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0,menuBar);
        Scene scene = new Scene(rootNode, 300, 275);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter");
        primaryStage.show();
    }
    //Creating Menu Bar
    private MenuBar createMenu(){
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        SeparatorMenuItem seprator = new SeparatorMenuItem();
        MenuItem quitMenuItem = new MenuItem("Quit");
        fileMenu.getItems().addAll(newMenuItem,seprator, quitMenuItem);
        newMenuItem.setOnAction(actionEvent -> System.out.println("new Project"));
        quitMenuItem.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });
        Menu helpMenu = new Menu("Help");
        MenuItem aboutUs = new MenuItem("About Us");
        helpMenu.getItems().addAll(aboutUs);

        aboutUs.setOnAction(actionEvent -> aboutApp());

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        return menuBar;
    }

    public static void aboutApp() {
        //Your Code
        Alert alertDialog =  new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("About us");
        alertDialog.setHeaderText("JavaFX");
        alertDialog.setContentText("Hello!! Welcome to My First Application.");
        alertDialog.show();
    }

    public static void main(String[] args) {
        launch();
    }
}