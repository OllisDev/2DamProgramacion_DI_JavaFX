package com.example.sesion0611.ProyectoJavaFX;


import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class OllisProject extends Application {
    @Override
    public void start(Stage MainWindow) {
        Label labelWelcome = new Label ("¡Bienvenido!");
        labelWelcome.setFont(new Font("Arial",20));
        labelWelcome.setAlignment(Pos.TOP_CENTER);


        Label labelOption = new Label("Elige una opción: ");
        labelOption.setFont(new Font("Arial", 12));
        labelOption.setAlignment(Pos.CENTER);

        Button btnOpenApp = new Button("Abrir aplicación");
        btnOpenApp.setFont(new Font("Arial", 12));

        btnOpenApp.setOnAction(e -> WindowOpenApp());

        Button btnOpenUbicationApp = new Button("Abrir ubicación de la aplicación");
        btnOpenApp.setFont(new Font("Arial", 12));

        VBox layout = new VBox(15);
        layout.getChildren().addAll(labelWelcome, labelOption, btnOpenApp, btnOpenUbicationApp);

        Scene scene = new Scene(layout, 300, 200);
        MainWindow.setScene(scene);
        MainWindow.setTitle("OllisProject");
        MainWindow.show();
    }

    private void WindowOpenApp() {
        Stage windowOpenApp = new Stage();
        windowOpenApp.initModality(Modality.APPLICATION_MODAL);
    

        Label labelPath = new Label("Ruta de la aplicación");
        labelPath.setFont(new Font("Arial", 12));

        TextField txtPath = new TextField();

        HBox layout = new HBox(15);
        layout.getChildren().addAll(labelPath, txtPath);

        Button btnAccept = new Button("Aceptar");
        btnAccept.setFont(new Font("Arial", 12));
        btnAccept.setOnAction(e -> abrirAplicacion(txtPath.getText()));

        Button btnCancel = new Button("Cancelar");
        btnCancel.setFont(new Font("Arial", 12));
        btnCancel.setOnAction(e -> windowOpenApp.close());

        HBox layout1 = new HBox(15);
        layout1.getChildren().addAll(btnAccept, btnCancel);

        VBox mainLayout = new VBox(15);
        mainLayout.getChildren().addAll(layout, layout1);

        Scene scene = new Scene (mainLayout, 400, 200);
        windowOpenApp.setScene(scene);
        windowOpenApp.setTitle("OllisProyect - Open App");
        windowOpenApp.showAndWait();
    }

    private void abrirAplicacion(String path) {
        try {
            ProcessBuilder pb = new ProcessBuilder(path);
            Process p = pb.start();
        } catch (IOException e) {
            error("Error al intentar abrir la aplicación", e.getMessage());
        }
    }

    private void error(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText("Se produjo un error");
        alert.setContentText(mensaje);
        alert.showAndWait();
}



    public static void main(String[] args) {
        launch(args);
    }
    
}
