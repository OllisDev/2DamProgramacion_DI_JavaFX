package com.example.sesion2910;



import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class mipantalla extends Application{
     @Override
     // Esqueleto de JavaFX
    public void start(Stage stage) { // ciclo de vida: ststage, escenas (widgets o nodos)
        // aqui comienza la pantalla
        Label label = new Label("Hola"); // Etiqueta de texto

        TextField campoTexto = new TextField(); // Cadena de texto a rellenar
        
    }

    public static void main(String[] args) {
        launch(args); // Iniciar la aplicación
    }
}
