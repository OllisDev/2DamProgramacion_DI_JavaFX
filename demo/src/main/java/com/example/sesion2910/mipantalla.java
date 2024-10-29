package com.example.sesion2910;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class mipantalla extends Application{
     @Override
     // Esqueleto de JavaFX
    public void start(Stage stage) { // ciclo de vida: ststage, escenas (widgets o nodos)
        // aqui comienza la pantalla
        Label label = new Label("Hola"); // Etiqueta de texto

        TextField campoTexto = new TextField(); // Cadena de texto a rellenar

        Button boton = new Button("Aceptar"); // Botón
        Tooltip tooltip = new Tooltip("Mensajito que pongo que al botón"); // Tooltip(): descripción que le puedes dar a un botón
        boton.setTooltip(tooltip);

        DropShadow sombra = new DropShadow(); // DropShadow(): poner sombra a nuestro botón
        boton.setEffect(sombra);

        boton.setOnMouseEntered(e -> boton.setStyle("-fx-background-color:#ff0000;")); 
        boton.setOnMouseExited(e -> boton.setStyle("-fx-background-color:#fffff"));

        //setOnAction: accion principal del botón
        boton.setOnAction(e -> { // Expresion lambda: otra manera de crear una función
            String nombre = campoTexto.getText();
            System.out.println(nombre);
        }); 

        VBox layout = new VBox(10); // Layout vertical

        layout.getChildren().addAll(label, campoTexto, boton);

        // Crear escena

        Scene escena = new Scene(layout, 300, 200);  // Scene: lo que sucede en la aplicacion
        stage.setScene(escena);
        stage.setTitle("Mi pantalla");
        stage.show(); // Mostrar ventana

        
    }

    public static void main(String[] args) {
        launch(args); // Iniciar la aplicación
    }
}
