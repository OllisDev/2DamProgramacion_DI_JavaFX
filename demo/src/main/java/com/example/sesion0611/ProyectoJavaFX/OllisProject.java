package com.example.sesion0611.ProyectoJavaFX;


import java.io.File;
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
    public void start(Stage MainWindow) { // Ventana principal

        //Etiqueta de bienvenida
        Label labelWelcome = new Label ("¡Bienvenido!");
        labelWelcome.setFont(new Font("Arial",20)); // cambiar tamaño y fuente de letra mediante la función setFont()
        labelWelcome.setAlignment(Pos.TOP_CENTER);

        // Etiqueta de las opciones
        Label labelOption = new Label("Elige una opción: ");
        labelOption.setFont(new Font("Arial", 12)); 
        labelOption.setAlignment(Pos.CENTER);

        // Botón para abrir una nueva ventana para poder abrir una aplicación
        Button btnOpenApp = new Button("Abrir aplicación");
        btnOpenApp.setFont(new Font("Arial", 12));

        btnOpenApp.setOnAction(e -> WindowOpenApp()); // Evento que cuando pulsamos el botón nos abrá la ventana para abrir la ubicación de la aplicacióm

        Button btnOpenUbicationApp = new Button("Abrir ubicación de la aplicación");
        btnOpenUbicationApp.setFont(new Font("Arial", 12));
        btnOpenUbicationApp.setOnAction(e -> WindonOpenPathApp());

        // Layout principal de la ventana
        VBox layout = new VBox(15);
        layout.getChildren().addAll(labelWelcome, labelOption, btnOpenApp, btnOpenUbicationApp);

        // Configuración de la escena
        Scene scene = new Scene(layout, 300, 200);
        MainWindow.setScene(scene);
        MainWindow.setTitle("OllisProject");
        MainWindow.show();
    }

    // Metodo para poder abrir la venta de la ubicación de la aplicación
    private void WindowOpenApp() {
        Stage windowOpenApp = new Stage();
        windowOpenApp.initModality(Modality.APPLICATION_MODAL); // Ventana modal o emergente
    
        // Etiqueta para la ubicación de la aplicación
        Label labelPath = new Label("Ruta de la aplicación");
        labelPath.setFont(new Font("Arial", 12));
        
        // Campo de texto para que el usuario pueda poner la ruta de la ubicación de la aplicación
        TextField txtPath = new TextField();

        // Layout horizonal tanto de la etiqueta como el campo de texto
        HBox layout = new HBox(15);
        layout.getChildren().addAll(labelPath, txtPath);

        // Botón de aceptar para abrir la ubicación
        Button btnAccept = new Button("Aceptar");
        btnAccept.setFont(new Font("Arial", 12));
        btnAccept.setOnAction(e -> abrirAplicacion(txtPath.getText())); // Evento que al pulsar el boton de aceptar te abre la aplicación

        // Botón de cancelar para cerrar la ventana
        Button btnCancel = new Button("Cancelar");
        btnCancel.setFont(new Font("Arial", 12));
        btnCancel.setOnAction(e -> windowOpenApp.close()); // Evento que al pulsar el botón de cancelar te cierra mediante un close() la ventana
        
        // Layout horizontal de los botones de aceptar y cancelar
        HBox layout1 = new HBox(15);
        layout1.getChildren().addAll(btnAccept, btnCancel);

        // Layout principal de la ventana 
        VBox mainLayout = new VBox(15);
        mainLayout.getChildren().addAll(layout, layout1);

        // Configuración de la escena
        Scene scene = new Scene (mainLayout, 400, 200);
        windowOpenApp.setScene(scene);
        windowOpenApp.setTitle("OllisProyect - Open App");
        windowOpenApp.showAndWait();
    }

    // Metodo para poder abrir la aplicación especificada por el usuario
    private void abrirAplicacion(String path) {
        try {
            ProcessBuilder pb = new ProcessBuilder(path); // Usamos ProccesBuilder para crear un proceso que nos abra la aplicación
            Process p = pb.start(); // inciamos el proceso con la función start()
        } catch (IOException e) {
            // Mostramos una ventana emergente con un mensaje de error de que no se pudo abrir la aplicación
            error("Error al intentar abrir la aplicación", e.getMessage());
        }
    }

    // Metodo para mostrar un mensaje de error
    public void error(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.ERROR); //Alert: clase de la libreria de JavaFX que nos permite crear una ventana emergente para indicar alguna advertencia, error, etc
        alert.setTitle(titulo);
        alert.setHeaderText("Se produjo un error");
        alert.setContentText(mensaje);
        alert.showAndWait();
}

// Metodo para abrir la ventana de la selección de la ubicación de la aplicación
private void WindonOpenPathApp() {
    Stage windowOpenPathApp = new Stage();
    windowOpenPathApp.initModality(Modality.APPLICATION_MODAL); // Ventana modal o emergente

    // Etiqueta para el campo de la ubicación de la aplicación
    Label labelPath = new Label("Ubicación de la aplicación");
    labelPath.setFont(new Font("Arial", 12));

    // Campo de texto para que el usuario ingrese la ruta de la ubicación de la aplicación
    TextField txtPath = new TextField();

    // Layout horizontal de la etiqueta y del campo de texto
    HBox layout = new HBox(15);
    layout.getChildren().addAll(labelPath, txtPath);

    // Botón de aceptar para abrir la ubicación de la aplicación
    Button btnAccept = new Button("Aceptar");
    btnAccept.setFont(new Font("Arial",12 ));
    btnAccept.setOnAction(e -> abrirUbicacionApp(txtPath.getText())); // Evento que al pulsar el botón abre la ubicación de la aplicación

    // Botón de cancelar para cerrar la ventana
    Button btnCancel = new Button("Cancelar");
    btnCancel.setFont(new Font("Arial", 12));
    btnCancel.setOnAction(e -> windowOpenPathApp.close());

    // Layout horizontal de los botones de aceptar y cancelar
    HBox layout1 = new HBox(15);
    layout1.getChildren().addAll(btnAccept, btnCancel);

    // Layout principal de la ventana
    VBox mainLayout = new VBox(15);
    mainLayout.getChildren().addAll(layout, layout1);

    // Configuración de la escena
    Scene scene = new Scene(mainLayout, 400, 200);
    windowOpenPathApp.setScene(scene);
    windowOpenPathApp.setTitle("OllisProyect - Open Path App");
    windowOpenPathApp.showAndWait();
}
    // Metodo para abrir la ubicación especificada que ha puesto el usuario
    private void abrirUbicacionApp(String path) {
        File file = new File(path); 

        if(file.exists()) { // Verifica si existe el archivo o carpeta
            try {
                // Abrimos el explorador de archivos con ProccesBuilder para poner la ubicación del archivo o carpeta
                new ProcessBuilder("explorer.exe", "/select,", file.getAbsolutePath()).start();
            } catch (IOException e) {
                error("Error al intentar abrir la ruta de la aplicación", e.getMessage());
            }
        } else {
            error("Error", "La ruta ingresada no existe");
        }
    }

    public static void main(String[] args) {
        launch(args); // iniciar aplicación
    }
    
}
